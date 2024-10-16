package be.digitalycity.java.bxl_java24_stockmanagement.dl.enums;

public enum VAT {
    SIX(6),
    Twelve(12),
    TWENTY_ONE(21);

    public final int value;

    VAT(int value) {
        this.value = value;
    }
}
