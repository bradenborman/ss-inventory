package com.softsurroundings.soft.surroundings.services;

import com.softsurroundings.soft.surroundings.models.OperatingSystemsPathFile;

import java.io.*;

class DirectoryManager {


    static File createIfNecessary() {

        OperatingSystemsPathFile operatingSystems = getRunningSystem();

        File file = new File(operatingSystems.getPath().concat(operatingSystems.getFilename()));

        try {
            if (file.createNewFile())
                System.out.println("File is created!");

        } catch (IOException e) { System.out.println(String.format("Failed to created Directory\nVerify %s is a created directory.", operatingSystems.getPath())); }

        return file;
    }

    private static OperatingSystemsPathFile getRunningSystem() {
        return System.getProperty("os.name").toUpperCase().contains("WINDOWS") ?
                OperatingSystemsPathFile.WINDOWS : OperatingSystemsPathFile.PI;
    }

}
