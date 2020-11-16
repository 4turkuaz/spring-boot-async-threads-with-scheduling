package com.demo.playground.config;

public class FileConfig {
    private static final String username = System.getProperty("user.name");
    private static final String path = System.getProperty("user.dir");
    public static final String INPUT_DIR = "/home/" + username + path + "/fileDir";
    public static final String OUTPUT_DIR = "/home/" + username + path + "newFileDir";
}
