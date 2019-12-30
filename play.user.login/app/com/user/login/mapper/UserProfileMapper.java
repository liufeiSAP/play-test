
package com.user.login.mapper;

import com.user.login.entities.UserProfile;
import org.apache.ibatis.annotations.Param;

/**
 * The interface User profile mapper.
 */
public interface UserProfileMapper {
    /**
     * Gets user profile by id.
     *
     * @param userID the username
     * @return the user profile by id
     */
    UserProfile getUserProfileById(@Param("userID") final String userID);
}
