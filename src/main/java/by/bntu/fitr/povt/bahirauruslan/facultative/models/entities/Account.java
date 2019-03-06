package by.bntu.fitr.povt.bahirauruslan.facultative.models.entities;

public class Account {
    private int id;
    private String login;
    private String hash;
    private String fullName;
    private Permission permission;
    private boolean isAvailable;

    public Account() {
    }

    public Account(int id, String login, String hash, String fullName, Permission permission, boolean isAvailable) {
        this.id = id;
        this.login = login;
        this.hash = hash;
        this.fullName = fullName;
        this.permission = permission;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (isAvailable != account.isAvailable) return false;
        if (!login.equals(account.login)) return false;
        if (!hash.equals(account.hash)) return false;
        if (!fullName.equals(account.fullName)) return false;
        return permission.equals(account.permission);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + hash.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + permission.hashCode();
        result = 31 * result + (isAvailable ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", hash='" + hash + '\'' +
                ", fullName='" + fullName + '\'' +
                ", permission=" + permission +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
