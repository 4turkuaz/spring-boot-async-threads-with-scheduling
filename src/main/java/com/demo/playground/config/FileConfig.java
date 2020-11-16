package com.demo.playground.config;

public class FileConfig {
    private static final String username = System.getProperty("user.name");
    public static final String INPUT_DIR = "/home/" + username + "/Desktop/fileDir";
    public static final String OUTPUT_DIR = "/home/" + username + "/Desktop/newFileDir";
}
