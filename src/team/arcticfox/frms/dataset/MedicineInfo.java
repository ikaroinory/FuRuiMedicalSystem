package team.arcticfox.frms.dataset;

import team.arcticfox.frms.program.environment.Constant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineInfo {
    private final int id;                        // Id.                      Type: Integer           Encode Type: None
    private final String medicineName;           // MedicineName.            Type: String            Encode Type: None
    private final String manufacturer;           // Manufacturer.            Type: String            Encode Type: None
    private final MedicineType type;             // type.                    Type: MedicineType      Encode Type: None
    private final boolean forSale;               // For Sale.                Type: Boolean           Encode Type: None
    private final double price;                  // Price.                   Type: Double            Encode Type: None
    private final int amount;                    // Amount.                  Type: Integer           Encode Type: None
    private final DateTime putawayTime;          // Putaway Time.            Type: DataTime          Encode Type: None

    MedicineInfo(int id, String medicineName, String manufacturer, MedicineType type,
                 boolean forSale, double price, int amount, DateTime putawayTime
    ) {
        this.id = id;
        this.medicineName = medicineName;
        this.manufacturer = manufacturer;
        this.type = type;
        this.forSale = forSale;
        this.price = price;
        this.amount = amount;
        this.putawayTime = putawayTime;
    }

    public static List<MedicineInfo> parse(ResultSet rs) {
        List<MedicineInfo> list = new ArrayList<>();

        int id = 0;
        String medicineName = "";
        String manufacturer = "";
        MedicineType type = MedicineType.UNKNOWN;
        boolean forSale = false;
        double price = 0;
        int amount = 0;
        DateTime putawayTime = null;
        try {
            while (rs.next()) {
                id = rs.getInt(Constant.COLUMNLABEL_ID);
                medicineName = rs.getString(Constant.COLUMNLABEL_MEDICINENAME);
                manufacturer = rs.getString(Constant.COLUMNLABEL_MANUFACTURER);
                type = MedicineType.prase(rs.getString(Constant.COLUMNLABEL_TYPE));
                forSale = rs.getBoolean(Constant.COLUMNLABEL_FORSALE);
                price = rs.getDouble(Constant.COLUMNLABEL_PRICE);
                amount = rs.getInt(Constant.COLUMNLABEL_AMOUNT);
                putawayTime = DateTime.parse(rs.getString(Constant.COLUMNLABEL_PUTAWAYTIME));

                list.add(new MedicineInfo(id, medicineName, manufacturer, type, forSale, price, amount, putawayTime));
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

    public String getManufacturer() {
        return manufacturer;
    }

    public MedicineType getType() {
        return type;
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

    public Object[] toObjectList() {
        return new Object[]{id, medicineName, manufacturer, type.getLabel(), price, amount};
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
