package com.user.function.dao.daoimpl;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.user.function.dao.UserProfileDao;
import com.user.function.entities.UserProfile;
import com.user.function.mapper.UserProfileMapper;
import play.Logger;

/**
 * The type User profile dao.
 */
public final class UserProfileDaoImpl implements UserProfileDao {

    private Config config;

    /**
     * The Logger.
     */
    private final Logger.ALogger logger = Logger.of(this.getClass());

    private UserProfileMapper mapper;

    /**
     * Instantiates a new User profile dao.
     *
     * @param mapper the mapper
     * @param config the config
     */
    @Inject
    public UserProfileDaoImpl(UserProfileMapper mapper, Config config) {
        this.mapper = mapper;
        this.config = config;
    }

    @Override
    public UserProfile getUserProfileById(String userId) {
        logger.info("getUserProfileById begin");

        UserProfile user = mapper.getUserProfileById(userId);
        logger.info("getUserProfileById success");
        return user;
    }
}
