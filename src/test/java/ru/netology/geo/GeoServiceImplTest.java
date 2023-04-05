package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    private GeoServiceImpl geoService;

    @BeforeEach
    public void init() {
        geoService = new GeoServiceImpl();
    }

    @Test
    void returnLocationMoscow() {
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Country expectedCountry = expected.getCountry();
        Country result = geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCountry();

        Assertions.assertEquals(expectedCountry, result);
    }

    @Test
    void returnLocationNewYorkIp() {
        Location expected = new Location("New-York", Country.USA, "Wall", 10);
        Country expectedCountry = expected.getCountry();
        Country result = geoService.byIp(GeoServiceImpl.NEW_YORK_IP).getCountry();

        Assertions.assertEquals(expectedCountry, result);
    }
}