package com.actitime.qa.util;
import com.actitime.qa.entities.UserCredential;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class UsersUtil {
    public static UserCredential getUserCredential() throws IOException, CsvValidationException {
        String projectDir = System.getProperty("user.dir");
        String dataFilePath = projectDir + "/src/main/java/com/actitime/qa/testdata/user_data.csv";

        CSVReader reader = new CSVReader(new FileReader(dataFilePath));
        String[] line;

        // Ignore header
        reader.readNext();

        // Read first user
        line = reader.readNext();
        reader.close();

        UserCredential userCredential = new UserCredential(line[0], line[1], line[2]);
        return  userCredential;
    }
}
