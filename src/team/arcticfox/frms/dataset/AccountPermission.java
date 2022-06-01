package team.arcticfox.frms.dataset;

public enum AccountPermission {
    NULL(-1, "Null"),       // Unknown. In development, developer can use NULL instead of null.
    OWNER(0, "Owner"),      // Owner.
    ADMIN(2, "Admin"),      // Admin.
    USER(5, "User");        // User, which is the most general permission level.

    final int id;               // Numeric encode.
    final String label;         // Character label.

    AccountPermission(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static AccountPermission parse(String label) {
        if (label.equals("Owner")) return OWNER;
        if (label.equals("Admin")) return ADMIN;
        if (label.equals("User")) return USER;
        return NULL;
    }

    @Override
    public String toString() {
        return label;
    }
}
