package com.vrp.task_sf_simple.configs;

public final class SystemProperties {
    public static final String BASE_URL = System.getProperty("HOST");
    public static final String USER_NAME = System.getProperty("USER");
    public static final String PASSWORD = System.getProperty("PWD");

    private SystemProperties() {
    }
}
