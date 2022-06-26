package team.arcticfox.frms.data;

public enum AccountPermission {
    NULL(-1, "Null"),       // Unknown. In development, developer can use NULL instead of null.
    OWNER(0, "Owner"),      // Owner.
    ADMIN(2, "Admin"),      // Admin.
    CUSTOMER_SERVICE(4, "Customer Service"),
    USER(5, "User");        // User, which is the most general permission level.

    private final int id;
    private final String label;

    AccountPermission(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static AccountPermission parse(String label) {
        if (label.equals("Owner")) return OWNER;
        if (label.equals("Admin")) return ADMIN;
        if (label.equals("Customer Service")) return CUSTOMER_SERVICE;
        if (label.equals("User")) return USER;
        return NULL;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return label;
    }
}
