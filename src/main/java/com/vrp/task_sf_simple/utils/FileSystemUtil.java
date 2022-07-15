package com.vrp.task_sf_simple.utils;

import java.nio.file.FileSystems;

public final class FileSystemUtil {
    private FileSystemUtil() {
    }

    public static String getCurrentDirAbsolutePath() {
        String currentRelativePath = "";
        return FileSystems.getDefault()
                .getPath(currentRelativePath)
                .toAbsolutePath()
                .toString();
    }
}
