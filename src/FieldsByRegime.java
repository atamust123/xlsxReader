import org.apache.poi.ss.usermodel.Cell;

import java.util.HashMap;
import java.util.Map;

public class FieldsByRegime {

    private String regimeNo;

    /**
     * key: field name, value is Field properties
     */
    private Map<String, FieldProperties> fieldPropertiesMap = new HashMap<>();

    public FieldsByRegime(Cell cell, String regimeNo) {
        this.regimeNo = regimeNo;

    }

    public String getRegimeNo() {
        return regimeNo;
    }

    public void setRegimeNo(String regimeNo) {
        this.regimeNo = regimeNo;
    }

    public Map<String, FieldProperties> getFieldPropertiesMap() {
        return fieldPropertiesMap;
    }

    public void setFieldPropertiesMap(Map<String, FieldProperties> fieldPropertiesMap) {
        this.fieldPropertiesMap = fieldPropertiesMap;
    }
}
