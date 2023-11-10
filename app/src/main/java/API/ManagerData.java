package API;

import com.google.gson.annotations.SerializedName;

public class ManagerData extends UserData {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @SerializedName("role")
    private String role;
}
