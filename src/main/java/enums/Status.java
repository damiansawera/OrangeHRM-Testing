package enums;

public enum Status {
    ENABLED("Enabled"),
    DISABLED("Disabled");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
