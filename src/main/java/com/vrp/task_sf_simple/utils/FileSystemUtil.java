package com.vrp.task_sf_simple.utils;

import java.nio.file.FileSystems;

final public class FileSystemUtil {
    private FileSystemUtil() {
    }

    public static String getCurrentDirAbsolutePath() {
        String currentPath = "";
        return FileSystems.getDefault()
                .getPath(currentPath)
                .toAbsolutePath()
                .toString();
    }
}
