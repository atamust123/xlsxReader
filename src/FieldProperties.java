public class FieldProperties {

    private Boolean isDisabled;
    private Boolean isRequired;

    public FieldProperties(String fieldStatus) throws Exception { // I O F NULL
        switch (fieldStatus) {
            case "I": // DISABLED AREA
                this.isDisabled = true;
                this.isRequired = false;
            case "O": // REQUIRED AREA
                this.isDisabled = false;
                this.isRequired = true;
            case "F": // OPTIONAL AREA
                this.isDisabled = false;
                this.isRequired = false;
            case "NULL": // DO NOT ACCEPT VALUE
                this.isDisabled = true;
                this.isRequired = false;
                break;
            default:
                throw new Exception("Hatalı veri girişi");
        }
    }

}
