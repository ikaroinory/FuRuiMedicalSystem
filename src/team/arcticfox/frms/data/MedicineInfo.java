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
    public int id;                       // Id.                      Type: Integer           Encode Type: None
    @JSONField(name = "Medicine Name", ordinal = 1)
    public String medicineName;          // MedicineName.            Type: String            Encode Type: None
    @JSONField(name = "Approval No", ordinal = 2)
    public String approvalNo;            // Approval No.             Type: String            Encode Type: None
    @JSONField(name = "Manufacturer", ordinal = 3)
    public String manufacturer;          // Manufacturer.            Type: String            Encode Type: None
    @JSONField(name = "Grade", ordinal = 4, serializeUsing = MedicineGradeSerializer.class, deserializeUsing = MedicineGradeSerializer.class)
    public MedicineGrade grade;          // Grade.                   Type: MedicineGrade     Encode Type: None
    @JSONField(name = "Type", ordinal = 5, serializeUsing = MedicineTypeSerializer.class, deserializeUsing = MedicineTypeSerializer.class)
    public MedicineType type;            // Type.                    Type: MedicineType      Encode Type: None
    @JSONField(name = "Specification", ordinal = 6)
    public String specification;         // Specification.           Type: String            Encode Type: None
    @JSONField(name = "For Sale", ordinal = 7)
    public boolean forSale;              // For Sale.                Type: Boolean           Encode Type: None
    @JSONField(name = "Price", ordinal = 8)
    public double price;                 // Price.                   Type: Double            Encode Type: None
    @JSONField(name = "Amount", ordinal = 9)
    public int amount;                   // Amount.                  Type: Integer           Encode Type: None
    @JSONField(name = "Putaway Time", ordinal = 10)
    public DateTime putawayTime;         // Putaway Time.            Type: DataTime          Encode Type: None
    @JSONField(name = "Image Name", ordinal = 11)
    public String imageName;             // Image Name.              Type: String            Encode Type: None


    public MedicineInfo() {
        this(0, null, null, null, MedicineGrade.UNKNOWN, MedicineType.UNKNOWN, null, false, 0, 0, null, null);
    }

    public MedicineInfo(int id, String medicineName, String approvalNo, String manufacturer, MedicineGrade grade, MedicineType type,
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

        int id;
        String medicineName;
        String approvalNo;
        String manufacturer;
        MedicineGrade grade;
        MedicineType type;
        String specification;
        boolean forSale;
        double price;
        int amount;
        DateTime putawayTime;
        String imageName;
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
