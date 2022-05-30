package team.arcticfox.frms.dataset;

import team.arcticfox.frms.security.Base64;

enum MedicineType {
    RX, OTC, Medicine_Devices, MEDICINE_DEVICES, OTHERS
}

public class MedicineInfo {
    private String medicineName;                // medicineName.            Type: String            Encode Type: Base64
    private MedicineType type;                  // type.                    Type: MedicineType      Encode Type: None

    MedicineInfo(String _name, MedicineType _type) {
        medicineName = Base64.encode(_name);
        type = _type;
    }

    public void setMedicineName(String _name) {
        medicineName = Base64.encode(_name);
    }

    public void setType(MedicineType _type) {
        type = _type;
    }

    public String getMedicineName() {
        return Base64.decode(medicineName);
    }

    public MedicineType getType() {
        return type;
    }
}
