package com.softsurroundings.soft.surroundings.services;

import java.io.*;

class DirectoryManager {


    private final static String _PATH_TO_DATA = "/home/pi/Documents/scanner-data/";

    private final static String _NAME_OF_DATA_FILE = "scanner-data.json";

    static File createIfNecessary() {

        File file = new File(_PATH_TO_DATA.concat(_NAME_OF_DATA_FILE));

        try {
            if (file.createNewFile())
                System.out.println("File is created!");
        } catch (IOException e) {
            System.out.println("Failed to created Directory");
        }

        return file;
    }

}
