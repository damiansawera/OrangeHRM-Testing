package enums;

public enum Roles {
    ADMIN("Admin"),
    ESS("ESS");

    private final String roleName;

    Roles(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
