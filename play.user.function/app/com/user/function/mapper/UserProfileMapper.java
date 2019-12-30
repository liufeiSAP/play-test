
package com.user.function.mapper;

import com.user.function.entities.UserProfile;
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
