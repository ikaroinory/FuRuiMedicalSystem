package team.arcticfox.frms.dataset;

import team.arcticfox.frms.program.environment.Constant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineInfo {
    private final int id;                       // Id.                      Type: Integer           Encode Type: None
    private final String medicineName;          // MedicineName.            Type: String            Encode Type: None
    private final String approvalNo;            // Approval No.             Type: String            Encode Type: None
    private final String manufacturer;          // Manufacturer.            Type: String            Encode Type: None
    private final MedicineGrade grade;          // Grade.                   Type: MedicineGrade     Encode Type: None
    private final MedicineType type;            // Type.                    Type: MedicineType      Encode Type: None
    private final String specification;         // Specification.           Type: String            Encode Type: None
    private final boolean forSale;              // For Sale.                Type: Boolean           Encode Type: None
    private final double price;                 // Price.                   Type: Double            Encode Type: None
    private final int amount;                   // Amount.                  Type: Integer           Encode Type: None
    private final DateTime putawayTime;         // Putaway Time.            Type: DataTime          Encode Type: None
    private final String imageName;             // Image Name.              Type: String            Encode Type: None

    MedicineInfo(int id, String medicineName, String approvalNo, String manufacturer, MedicineGrade grade, MedicineType type,
                 String specification, boolean forSale, double price, int amount, DateTime putawayTime, String imageName
    ) {
        this.id = id;
        this.medicineName = medicineName;
        this.approvalNo = approvalNo;
        this.manufacturer = manufacturer;
        this.grade = grade;
        this.type = type;
        this.specification = specification;
        this.forSale = forSale;
        this.price = price;
        this.amount = amount;
        this.putawayTime = putawayTime;
        this.imageName = imageName;
    }

    public static List<MedicineInfo> parse(ResultSet rs) {
        List<MedicineInfo> list = new ArrayList<>();

        int id = 0;
        String medicineName = "";
        String approvalNo = "";
        String manufacturer = "";
        MedicineGrade grade = MedicineGrade.UNKNOWN;
        MedicineType type = MedicineType.UNKNOWN;
        String specification = "";
        boolean forSale = false;
        double price = 0;
        int amount = 0;
        DateTime putawayTime = null;
        String imageName = "";
        try {
            while (rs.next()) {
                id = rs.getInt(Constant.COLUMNLABEL_ID);
                medicineName = rs.getString(Constant.COLUMNLABEL_MEDICINENAME);
                approvalNo = rs.getString(Constant.COLUMNLABEL_APPROVALNO);
                manufacturer = rs.getString(Constant.COLUMNLABEL_MANUFACTURER);
                grade = MedicineGrade.parse(rs.getString(Constant.COLUMNLABEL_GRADE));
                type = MedicineType.parse(rs.getString(Constant.COLUMNLABEL_TYPE));
                specification = rs.getString(Constant.COLUMNLABEL_SPECIFICATION);
                forSale = rs.getBoolean(Constant.COLUMNLABEL_FORSALE);
                price = rs.getDouble(Constant.COLUMNLABEL_PRICE);
                amount = rs.getInt(Constant.COLUMNLABEL_AMOUNT);
                putawayTime = DateTime.parse(rs.getString(Constant.COLUMNLABEL_PUTAWAYTIME));
                imageName = rs.getString(Constant.COLUMNLABEL_IMAGENAME);

                list.add(new MedicineInfo(id, medicineName, approvalNo, manufacturer, grade, type, specification, forSale, price, amount, putawayTime, imageName));
            }

        } catch (SQLException e) {
            // Do nothing.
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public MedicineGrade getGrade() {
        return grade;
    }

    public MedicineType getType() {
        return type;
    }

    public String getSpecification() {
        return specification;
    }

    public boolean isForSale() {
        return forSale;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public DateTime getPutawayTime() {
        return putawayTime;
    }

    public String getImageName() {
        return imageName;
    }

    public Object[] toObjectList() {
        return new Object[]{id, medicineName, approvalNo, manufacturer, type.getLabel(), price, amount};
    }

    @Override
    public String toString() {
        return "MedicineInfo{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", type=" + type +
                ", forSale=" + forSale +
                ", price=" + price +
                ", amount=" + amount +
                ", putawayTime=" + putawayTime +
                '}';
    }
}
