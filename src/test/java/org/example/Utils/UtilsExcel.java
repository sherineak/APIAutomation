package org.example.Utils;
// Open that file input Stream
//understand the workbook
// Sheet
// column
//row
//cell (Column)
//Close the stream

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsExcel  {
// This will be used who  - Data provider of the TestNG
// Data in the Object [][] 2D object format

    // as creating static function below don't want to create instance of class above 'UtilsExcel'

    public static String FILE_NAME="src/test/resources/TD.xlsx";  // Right click -->  File form content root

    //static XSSFWorkbook book;  - it is not commonly used
    static Workbook book;  // Commonly used one
    static Sheet sheet;
    public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;
        // if working with may be there will be an issue so to save use try catch
        try{
            file = new FileInputStream(FILE_NAME);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);  // create means here read , here also need to handle error through exception or try catch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i = 0 ; i < sheet.getLastRowNum(); i++){
            for ( int j = 0 ; j <sheet.getRow(0).getLastCellNum();  j++){
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();  // I don't want first row as it is header

            }
        }
        return  data;
    }
    @DataProvider
    public Object[][] getData(){
        //In future I can write logic to Select which sheet I want to open.
        //Ask user which  sheet to open
        //sheet1 --> username & password for QA
        //sheet2 --> username & password for prod
        return getTestData("Sheet1");  // Give exact sheet name in the XLSX doc
        //return getTestData("Sheet1 - prod");
    }

}
