package com.erp.accounting.dto;

public class LoginResponse {
    private String token;
    private String username;
    private String email;
    private String tenantId;
    private String message;

    public LoginResponse() {}

    public LoginResponse(String token, String username, String email, String tenantId, String message) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.tenantId = tenantId;
        this.message = message;
    }

    public static LoginResponseBuilder builder() {
        return new LoginResponseBuilder();
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public static class LoginResponseBuilder {
        private String token;
        private String username;
        private String email;
        private String tenantId;
        private String message;

        public LoginResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public LoginResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public LoginResponseBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public LoginResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public LoginResponse build() {
            return new LoginResponse(token, username, email, tenantId, message);
        }
    }
}