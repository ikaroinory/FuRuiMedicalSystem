package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import team.arcticfox.frms.integration.json.JsonParser;
import team.arcticfox.frms.system.SystemEnvironment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineInfo implements JsonParser {
    @JSONField(name = "Id")
    private final int id;                       // Id.                      Type: Integer           Encode Type: None
    @JSONField(name = "Medicine Name")
    private final String medicineName;          // MedicineName.            Type: String            Encode Type: None
    @JSONField(name = "Approval No")
    private final String approvalNo;            // Approval No.             Type: String            Encode Type: None
    @JSONField(name = "Manufacturer")
    private final String manufacturer;          // Manufacturer.            Type: String            Encode Type: None
    @JSONField(name = "Grade")
    private final MedicineGrade grade;          // Grade.                   Type: MedicineGrade     Encode Type: None
    @JSONField(name = "Type")
    private final MedicineType type;            // Type.                    Type: MedicineType      Encode Type: None
    @JSONField(name = "Specification")
    private final String specification;         // Specification.           Type: String            Encode Type: None
    @JSONField(name = "For Sale")
    private final boolean forSale;              // For Sale.                Type: Boolean           Encode Type: None
    @JSONField(name = "Price")
    private final double price;                 // Price.                   Type: Double            Encode Type: None
    @JSONField(name = "Amount")
    private final int amount;                   // Amount.                  Type: Integer           Encode Type: None
    @JSONField(name = "Putaway Time")
    private final DateTime putawayTime;         // Putaway Time.            Type: DataTime          Encode Type: None
    @JSONField(name = "Image Name")
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
                id = rs.getInt(SystemEnvironment.COLUMN_ID);
                medicineName = rs.getString(SystemEnvironment.COLUMN_MEDICINE_NAME);
                approvalNo = rs.getString(SystemEnvironment.COLUMN_APPROVAL_NO);
                manufacturer = rs.getString(SystemEnvironment.COLUMN_MANUFACTURER);
                grade = MedicineGrade.parse(rs.getString(SystemEnvironment.COLUMN_GRADE));
                type = MedicineType.parse(rs.getString(SystemEnvironment.COLUMN_TYPE));
                specification = rs.getString(SystemEnvironment.COLUMN_SPECIFICATION);
                forSale = rs.getBoolean(SystemEnvironment.COLUMN_FOR_SALE);
                price = rs.getDouble(SystemEnvironment.COLUMN_PRICE);
                amount = rs.getInt(SystemEnvironment.COLUMN_AMOUNT);
                putawayTime = DateTime.parse(rs.getString(SystemEnvironment.COLUMN_PUTAWAY_TIME));
                imageName = rs.getString(SystemEnvironment.COLUMN_IMAGE_NAME);

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

    public JSONObject toJsonObject() {
        return JSONObject.parseObject(toString());
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
