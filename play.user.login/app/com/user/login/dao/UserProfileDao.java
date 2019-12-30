package com.user.login.dao;


import com.user.login.entities.UserProfile;

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
