package ru.netology.sender;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.localization.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {
    @Spy
    GeoServiceImpl geo;
    @Spy
    LocalizationServiceImpl local;
    @InjectMocks
    MessageSenderImpl message;
    Map<String, String> headers = new HashMap<>();
    String expected;

    @Before
    public void init() {
        headers = new HashMap<>();
        message = new MessageSenderImpl(geo, local);
    }

    @Test
    void testSendRussianMessage() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        expected = "Добро пожаловать";
        when(geo.byIp(GeoServiceImpl.MOSCOW_IP)).thenReturn(new Location("Magadan", Country.RUSSIA, "Gagarina", 10));
        when(local.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Assertions.assertEquals(expected, message.send(headers));
    }
    @Test
    public void testSendEnglishMessage() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        expected = "Welcome";
        when(geo.byIp(GeoServiceImpl.NEW_YORK_IP)).thenReturn(new Location("New-York", Country.USA, "Wall", 3));
        when(local.locale(Country.USA)).thenReturn("Welcome");

        Assertions.assertEquals(expected, message.send(headers));
    }
}