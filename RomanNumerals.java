public enum RomanNumerals {
    I(1, "I"),II(2, "II"),III(3, "III"),IV(4, "IV"),V(5, "V"),VI(6,"VI"),
    VII(7, "VII"),VIII(8, "VIII"),IX(9, "IX"),X(10, "X");
    private int value;
    private String stringValue;
    RomanNumerals(int value, String stringValue){
        this.value = value;
        this.stringValue = stringValue;
    }
    public int getValue(){
        return this.value;
    }
    public String getStringValue (){
        return this.stringValue;
    }
}
