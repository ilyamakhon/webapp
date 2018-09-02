package by.makhon.webapp.bean;

import java.util.Objects;

public class Users {
    private Long userID;
    private String role;
    private String login;
    private String password;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userID, users.userID) &&
                Objects.equals(role, users.role) &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, role, login, password);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
