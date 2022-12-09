import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class XLSXReaderExample {

    public static ArrayList<RegimeField> iterateOverRow(XSSFSheet sheet) throws Exception {
        Iterator<Row> itr = sheet.iterator();
        ArrayList<String> regimeFields = new ArrayList<>();
        itr.next().forEach(regime -> regimeFields.add(regime.getStringCellValue())); // set regime fields

        ArrayList<RegimeField> regimes = new ArrayList<>();


        while (itr.hasNext()) {
            Row row = itr.next();
            if (row.getCell(0) == null) {
                break;
            }
            regimes.add(new RegimeField(row, regimeFields));
        }
        return regimes;
    }

    public static Map<String, FieldsByRegime> iterateOverColumn(XSSFSheet sheet) throws Exception {
        Iterator<Row> itr = sheet.iterator();
        ArrayList<String> regimeFields = new ArrayList<>();
        itr.next().forEach(regime -> regimeFields.add(regime.getStringCellValue())); // set regime fields
        int totalRegimes = regimeFields.size();
        Map<String, FieldsByRegime> regimes = new HashMap<>();
        for (int columnIndex = 1; columnIndex < totalRegimes; columnIndex++) {
            while (itr.hasNext()) {
                Row row = itr.next();
                Cell cell = CellUtil.getCell(row, columnIndex);



                regimes.get(regimeFields.get(columnIndex)) // get regime fields by regime
                        .getFieldPropertiesMap()
                        .put(row.getCell(0).getStringCellValue(), new FieldProperties(cell.getStringCellValue()));
            }
        }
        return regimes;

    }

    public static

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\aayyildiz\\Desktop\\regimeFields.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object

//            ArrayList<RegimeField> regimes = iterateOverRow(sheet);
            System.out.println(iterateOverColumn(sheet).entrySet());

//            regimes.forEach(regime -> System.out.println(regime.getFieldName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
