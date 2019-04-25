package org.academiadecodigo.charlie.command;

public class UserLoginForm {
    private String email;
    private Integer password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }
}
