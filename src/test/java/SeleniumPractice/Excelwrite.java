package SeleniumPractice;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excelwrite {
    public  static void main(String[]args) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet= workbook.createSheet("TESTDATA");

        HSSFRow row1= sheet.createRow(0);
        HSSFRow row2= sheet.createRow(1);
        HSSFRow row3= sheet.createRow(2);

        row1.createCell(0).setCellValue("USERNAME");
        row1.createCell(1).setCellValue("PASSWORD");

        row2.createCell(0).setCellValue("SandeepK03");
        row2.createCell(1).setCellValue("MypasswordK03");

        row3.createCell(0).setCellValue("VK18");
        row3.createCell(1).setCellValue("MypasswordVK18");

        FileOutputStream test = new FileOutputStream("C:\\Users\\Dell\\Desktop\\Automation\\Excel\\DataUsernames.xls");
        workbook.write(test);
        workbook.close();
    }
}
