package com.jpaul.store;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("idRole")
    @Expose
    private int idRole;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("status")
    @Expose
    private boolean status;

    public User() {
    }

    public User(int id, String name, int idRole, String role, String password, boolean status) {
        this.id = id;
        this.name = name;
        this.idRole = idRole;
        this.role = role;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idRole=" + idRole +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
