package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class utilsExcel {

    String path = "D:\\Technical_Assessment\\AutomationExcerciseDemo\\src\\test\\resources\\Book1.xlsx";

    @DataProvider(name = "validData")
    public Object[][] validData() throws IOException {
        return getFilteredData("valid");
    }

    @DataProvider(name = "invalidData")
    public Object[][] invalidData() throws IOException {
        return getFilteredData("invalid");
    }

    public Object[][] getFilteredData(String type) throws IOException {

        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCols = sheet.getRow(0).getLastCellNum();

        List<Object[]> filteredData = new ArrayList<>();

        for (int i = 1; i < noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row == null) continue;

            String rowType = row.getCell(3) != null ? row.getCell(3).toString().trim() : "";

            if (rowType.equalsIgnoreCase(type)) {

                Object[] rowData = new Object[noOfCols - 1]; 

                for (int j = 0; j < noOfCols - 1; j++) {
                    rowData[j] = row.getCell(j) != null ? row.getCell(j).toString() : "";
                }

                filteredData.add(rowData);
            }
        }

        workbook.close();
        fis.close();

        return filteredData.toArray(new Object[0][]);
    }
}