package com.actitime.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.actitime.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 40;

    public void swithToFrame(String framaName) {
        driver.switchTo().frame(framaName);
    }

    public static String TESTDATA_SHEET_PATH = "/Users/wakarahamed/ET/ActiTimeTestAutomation/BDD_Demo/src/main/java/com/actitime/qa/testdata/actitimeTestData.xlsx";
    static Workbook book;
    static Sheet sheet;
    static JavascriptExecutor js;

    TestUtil() {
        setNavigationGuardValues();
    }

    private void setNavigationGuardValues() {
    	
    	// sets the PAGE_LOAD_TIMEOUT and IMPLICIT_WAIT values based on the browser being used
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        switch(browserName.toLowerCase()) {
            
            case "firefox":
                PAGE_LOAD_TIMEOUT = 30;
                IMPLICIT_WAIT = 30;
                break;
            case "chrome":
                PAGE_LOAD_TIMEOUT = 60;
                IMPLICIT_WAIT = 60;
                break;
            case "safari":
                PAGE_LOAD_TIMEOUT = 45;
                IMPLICIT_WAIT = 45;
                break;
            default:
                PAGE_LOAD_TIMEOUT = 40;
                IMPLICIT_WAIT = 40;
                break;
        }
    }


    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue().trim();

            }
        }
        return data;
    }
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
