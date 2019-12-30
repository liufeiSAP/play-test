package com.user.function.dao;


import com.user.function.entities.UserProfile;

/**
 * The interface User profile dao.
 */
public interface UserProfileDao {

    /**
     * Gets user profile by id.
     *
     * @param userID the username
     * @return the user profile by id
     */
    UserProfile getUserProfileById(final String userID);
}
