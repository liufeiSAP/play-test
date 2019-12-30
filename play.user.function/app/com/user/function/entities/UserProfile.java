package com.user.function.entities;

import lombok.Data;

/**
 * The type User profile.
 */
@Data
public class UserProfile {
    private String firstName;
    private String lastName;
    private String fullName;

    /**
     * Instantiates a new User profile.
     */
    public UserProfile() {
    }
}
