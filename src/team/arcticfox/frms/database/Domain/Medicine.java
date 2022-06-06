package team.arcticfox.frms.database.Domain;

public class Medicine {
    private int id;
    private String CAS;
    private String Formula;
    private String type;
    private int quantity;

    public Medicine() {
    }

    public Medicine(int id, String CAS, String formula, String type, int quantity) {
        this.id = id;
        this.CAS = CAS;
        Formula = formula;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCAS() {
        return CAS;
    }

    public void setCAS(String CAS) {
        this.CAS = CAS;
    }

    public String getFormula() {
        return Formula;
    }

    public void setFormula(String formula) {
        Formula = formula;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
