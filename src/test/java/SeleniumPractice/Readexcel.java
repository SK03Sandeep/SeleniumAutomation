package SeleniumPractice;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Readexcel {

    public  static void main(String[]args) throws IOException {
        FileInputStream test= new FileInputStream("C:\\Users\\Dell\\Desktop\\Automation\\Excel\\DataUsernames.xls");
        HSSFWorkbook workbook= new HSSFWorkbook(test);
        HSSFSheet sheet= workbook.getSheetAt(0);

        int rows= sheet.getPhysicalNumberOfRows();
        for(int i=0;i<rows;i++)
        {
            int cells=sheet.getRow(i).getPhysicalNumberOfCells();
            for (int j=0;j<cells;j++)
            {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"|");
            }

            System.out.println();
        }
    }


}
