// Apache POI 읽기
package study.library.apache_poi;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test11 {
  public static void main(String[] args) throws Exception {
    XSSFWorkbook workbook = new XSSFWorkbook("temp/test.xlsx");

    XSSFSheet sheet = workbook.getSheet("User data");

    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);
      System.out.printf("%s %s %s\n", row.getCell(0).getStringCellValue(),
          row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue());
    }

    System.out.println("엑셀 파일 READ 완료!");
  }
}
