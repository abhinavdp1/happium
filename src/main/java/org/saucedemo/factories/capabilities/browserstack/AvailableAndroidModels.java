package org.saucedemo.factories.capabilities.browserstack;

import java.util.Random;

// Available android devices: https://www.browserstack.com/list-of-browsers-and-platforms/live
public enum AvailableAndroidModels {
    SAMSUNG("samsung"),
    GOOGLE("google"),
    ONE_PLUS("one-plus"),
    XIAOMI("xiaomi"),
//    VIVO("vivo"),
//    HUAWEI("huawei"),
//    OPPO("oppo"),
    MOTOROLA("motorola"),
    ;

    private final String value;

    AvailableAndroidModels(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AvailableAndroidModels getRandomModel() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}