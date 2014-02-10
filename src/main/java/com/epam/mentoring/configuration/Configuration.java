package com.epam.mentoring.configuration;


public class Configuration {

    private String address;
    private String letterTheme;
    private String letterContent;

    public Configuration(String[][] configurationData) {
        int index = 0;
        address = configurationData[index][0];
        letterTheme = configurationData[index][1];
        letterContent = configurationData[index][2];
    }

    public String getAddress() {
        return address;
    }

    public String getLetterTheme() {
        return letterTheme;
    }

    public String getLetterContent() {
        return letterContent;
    }

}
