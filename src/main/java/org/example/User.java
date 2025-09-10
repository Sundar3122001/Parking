package org.example;

public class User {
    private String userId;
    private String name;
    private boolean identityVerified;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.identityVerified = false;
    }

    public boolean verifyIdentity() {
        identityVerified = true; // Simulated verification
        return identityVerified;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }

}
