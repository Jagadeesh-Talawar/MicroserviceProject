package com.auth.model;

public class JwtTokenResponse {
    private String token;
    private String type;
    private String validityUntil;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValidityUntil() {
        return validityUntil;
    }

    public void setValidityUntil(String validityUntil) {
        this.validityUntil = validityUntil;
    }

    @Override
    public String toString() {
        return "JwtTokenResponse{" +
                "token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", validityUntil='" + validityUntil + '\'' +
                '}';
    }
}
