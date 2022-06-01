package team.arcticfox.frms.dataset;

public enum MedicineType {
    //RX, OTC, Medicine_Devices, MEDICINE_DEVICES, OTHERS,
    UNKNOWN(-1, "未知"),
    WESTERN_MEDICINE(0, "西药"),
    TRADITIONAL_CHINESE_MEDICINE(1, "中药"),
    CHINESE_PATENT_MEDICINE(2, "中成药"),
    BIOLOGICAL_AGENTS(3, "生物制剂"),
    COMPOUND(4, "复方制剂");

    final private int id;
    final private String label;

    MedicineType(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static MedicineType prase(String label) {
        if (label.equals("西药")) return WESTERN_MEDICINE;
        if (label.equals("中药")) return TRADITIONAL_CHINESE_MEDICINE;
        if (label.equals("中成药")) return CHINESE_PATENT_MEDICINE;
        if (label.equals("生物制剂")) return BIOLOGICAL_AGENTS;
        if (label.equals("复方制剂")) return COMPOUND;
        return UNKNOWN;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
