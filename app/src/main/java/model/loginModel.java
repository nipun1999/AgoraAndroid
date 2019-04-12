package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class loginModel {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("token")
    @Expose
    private Token token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    private class Token {
        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("expiresOn")
        @Expose
        private String expiresOn;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getExpiresOn() {
            return expiresOn;
        }

        public void setExpiresOn(String expiresOn) {
            this.expiresOn = expiresOn;
        }

    }
}
