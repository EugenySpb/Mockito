package ru.netology.localization;

import ru.netology.entity.Country;

public class LocalizationServiceImpl implements LocalizationService {

    public String locale(Country country) {
        return switch (country) {
            case RUSSIA -> "Добро пожаловать";
            default -> "Welcome";
        };
    }
}