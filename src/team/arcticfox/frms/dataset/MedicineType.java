package team.arcticfox.frms.dataset;

public enum MedicineType {
    //RX, OTC, Medicine_Devices, MEDICINE_DEVICES, OTHERS,
    UNKNOWN(-1, "Unknown"),
    WESTERN_MEDICINE(0, "Western Medicine"),
    TRADITIONAL_CHINESE_MEDICINE(1, "Traditional Chinese Medicine"),
    CHINESE_PATENT_MEDICINE(2, "Chinese Patent Medicine"),
    BIOLOGICAL_AGENTS(3, "Biological Agents");

    final private int id;
    final private String label;

    MedicineType(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static MedicineType prase(String label) {
        if (label.equals("Western Medicine")) return WESTERN_MEDICINE;
        if (label.equals("Traditional Chinese Medicine")) return TRADITIONAL_CHINESE_MEDICINE;
        if (label.equals("Chinese Patent Medicine")) return CHINESE_PATENT_MEDICINE;
        if (label.equals("Biological Agents")) return BIOLOGICAL_AGENTS;
        return UNKNOWN;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
