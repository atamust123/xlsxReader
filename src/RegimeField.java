import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegimeField { // return the fieldName with a map of status on given regime
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Map<String, FieldProperties> getFieldOnRegime() {
        return fieldOnRegime;
    }

    public void setFieldOnRegime(Map<String, FieldProperties> fieldOnRegime) {
        this.fieldOnRegime = fieldOnRegime;
    }

    public static int counter = 1;
    private String fieldName;
    private Map<String, FieldProperties> fieldOnRegime = new HashMap<>();

    public RegimeField(Row row, ArrayList<String> regimeFields) throws Exception {
        Iterator<Cell> itr = row.cellIterator();
        this.fieldName = itr.next().getStringCellValue();
        int i = 1;
        while (itr.hasNext()) {
            String fieldStatus = itr.next().getStringCellValue();
            this.fieldOnRegime.put(regimeFields.get(i), new FieldProperties(fieldStatus));
            i++;
        }
    }
}
