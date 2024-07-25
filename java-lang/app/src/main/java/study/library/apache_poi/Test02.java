// Apache POI 라이브러리 사용법
package study.library.apache_poi;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test02 {
  public static void main(String[] args) throws Exception {
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("User data");


    List<Object[]> data = new ArrayList<>();
    data.add(new Object[] {"no", "name", "tel"});
    data.add(new Object[] {"1", "cookie", "010-1111-1111"});
    data.add(new Object[] {"2", "sickBBang", "010-2222-2222"});
    data.add(new Object[] {"3", "workingAnt", "010-3333-3333"});
    data.add(new Object[] {"4", "wow", "010-4444-4444"});

    int rownum = 0;

    for (int i = 0; i < data.size(); i++) {
      Object[] values = data.get(i);
      Row row = sheet.createRow(rownum++);

      for (int j = 0; j < values.length; j++) {
        row.createCell(j).setCellValue((String) values[j]);
      }
    }

    try (FileOutputStream out = new FileOutputStream("temp/test.xlsx")) {
      workbook.write(out);
    }

    System.out.println("엑셀 파일 생성 완료!");
  }
}
