package com.vrp.task_sf_simple.configs;

public final class SystemProperties {
    private static final String NOT_DEFINED = "NotDefined";
    public static final String BASE_URL = System.getProperty("HOST", NOT_DEFINED);
    public static final String USER_NAME = System.getProperty("USER", NOT_DEFINED);
    public static final String PASSWORD = System.getProperty("PWD", NOT_DEFINED);

    private SystemProperties() {
    }
}
