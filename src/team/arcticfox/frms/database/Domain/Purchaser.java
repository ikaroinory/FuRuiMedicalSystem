package team.arcticfox.frms.database.Domain;

public class Purchaser {
    private int quantity;
    private String medicine_name;

    public Purchaser() {
    }

    public Purchaser(int quantity, String medicine_name) {
        this.quantity = quantity;
        this.medicine_name = medicine_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

}
