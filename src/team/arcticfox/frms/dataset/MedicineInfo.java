package team.arcticfox.frms.dataset;

import team.arcticfox.frms.program.environment.Constant;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static MedicineInfo parse(ResultSet rs) {
        int id = 0;
        String medicineName = "";
        String manufacturer = "";
        MedicineType type = MedicineType.NULL;
        boolean forSale = false;
        double price = 0;
        int amount = 0;
        DateTime putawayTime = null;
        try {
            id = rs.getInt(Constant.COLUMNLABEL_ID);
            medicineName = rs.getString(Constant.COLUMNLABEL_MEDICINENAME);
            manufacturer = rs.getString(Constant.COLUMNLABEL_MANUFACTURER);
            // type
            forSale = rs.getBoolean(Constant.COLUMNLABEL_FORSALE);
            price = rs.getDouble(Constant.COLUMNLABEL_PRICE);
            amount = rs.getInt(Constant.COLUMNLABEL_AMOUNT);
            putawayTime = DateTime.parse(rs.getString(Constant.COLUMNLABEL_PUTAWAYTIME));

        } catch (SQLException e) {
            // Do nothing.
        }
        return new MedicineInfo(id, medicineName, manufacturer, type, forSale, price, amount, putawayTime);
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
}
