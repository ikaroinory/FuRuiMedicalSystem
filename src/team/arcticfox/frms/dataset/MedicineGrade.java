package team.arcticfox.frms.dataset;

public enum MedicineGrade {
    UNKNOWN("未知"),

    RX("Rx"),

    OTCA("OTC-甲"),

    OTCB("OTC-乙");

    public final String label;

    MedicineGrade(String label) {
        this.label = label;
    }

    public static MedicineGrade parse(String label) {
        if (label.equals("Rx")) return RX;
        if (label.equals("OTC-甲")) return OTCA;
        if (label.equals("OTC-乙")) return OTCB;
        return UNKNOWN;
    }

    public String getLabel() {
        return label;
    }
}
