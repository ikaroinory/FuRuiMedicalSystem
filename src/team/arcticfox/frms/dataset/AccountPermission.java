package team.arcticfox.frms.dataset;

public enum AccountPermission {
    NULL(-1, "Null"),
    OWNER(0, "Owner"),
    ADMIN(2, "Admin"),
    USER(5, "User");

    int id;
    String label;

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
