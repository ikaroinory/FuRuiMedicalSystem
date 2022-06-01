package team.arcticfox.frms.integration.message;

@Deprecated
public enum Title {
    INFORMATION("Information"),
    WARNING("Warning"),
    ERROR("Error");

    private final String title;

    Title(String title) {
        this.title = title;
    }
}
