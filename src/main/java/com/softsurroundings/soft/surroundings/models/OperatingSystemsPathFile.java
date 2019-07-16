package com.softsurroundings.soft.surroundings.models;

public enum OperatingSystemsPathFile {

        PI("/home/pi/Documents/scanner-data/", "scanner-data.json"),
        WINDOWS("C:/scanner-data/", "checked-out.json");

        private String path;
        private String filename;

    OperatingSystemsPathFile(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
