package ru.netology.localization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    private LocalizationServiceImpl local;

    @BeforeEach
    public void init() {
        local = new LocalizationServiceImpl();
    }

    @Test
    void locale() {
        Country country = Country.RUSSIA;
        String expected = "Добро пожаловать";
        String result = local.locale(country);

        Assertions.assertEquals(expected, result);
    }
}