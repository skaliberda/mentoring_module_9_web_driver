package com.epam.mentoring.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CvsDataProvider {

    private String csvFilePath = ".//src//test//resources//testData.csv";

    public String[][] loadData() {
        BufferedReader csvReader = null;
        String line = "", csvSeparator = ",";
        String[] allFile = new String[0];
        String[][] userData = new String[0][];
        int index = 0;
        allFile = readAllData(csvFilePath);
        userData = getArray(allFile, csvSeparator);
        for (int i = 0; i < allFile.length; i++) {
            String[] userInformation = allFile[i].split(csvSeparator);
            userData[index][0] = userInformation[0];
            userData[index][1] = userInformation[1];
            userData[index][2] = userInformation[2];
            index++;
        }
        return userData;
    }

    public String[] readAllData(String filePath) {
        String line = "";
        List<String> rows = new ArrayList<String>();
        String[] allData;
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(filePath));
            while ((line = csvReader.readLine()) != null) {
                rows.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        allData = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            allData[i] = rows.get(i).toString();
        }
        return allData;
    }

    private String[][] getArray(String[] dataArray, String separator) {
        String line = "";
        int sizeColumn = 0, sizeRow = 0;
        for (int i = 0; i < dataArray.length; i++) {
            String[] buffer = dataArray[i].split(separator);
            sizeColumn = (buffer.length);
            sizeRow++;
        }
        return new String[sizeRow][sizeColumn];
    }
}
