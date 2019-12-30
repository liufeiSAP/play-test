package com.user.login.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.user.login.entities.UserProfile;
import com.user.login.redis.RedisConnector;
import com.user.login.service.UserProfileService;
import com.user.login.utils.ResultUtils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * The type Prepare controller.
 */
public class PrepareController extends Controller {
    @Inject
    private Config config;

    /**
     * The Redis util.
     */
    @Inject
    private RedisConnector redisUtil;

    private static final int PREPARE_ERROR_CODE = 701;

    /**
     * The Logger.
     */
    private final Logger.ALogger logger = Logger.of(this.getClass());

    @Inject
    private UserProfileService userProfileService;

    /**
     * Instantiates a new Prepare controller.
     */
    public PrepareController() {
    }

    /**
     * Prepare completion stage.
     *
     * @return the completion stage
     */
    public Result prepare() {
        JsonNode json = request().body().asJson().get("userId");
        if (json == null) {
            return ResultUtils.failure(PREPARE_ERROR_CODE,
                "get user profile Failed")
                .withHeader("Access-Control-Allow-Origin", "*");
        }
        String userId = json.asText();
        logger.info("prepare begin, userID is {}", userId);
        UserProfile userProfile = null;
        try {
            userProfile = userProfileService.loadUserProfile(userId);
            return ok(Json.toJson(userProfile)).withHeader("Access-Control-Allow-Origin", "*");
        } catch (Exception ex) {
            logger.error("prepare execption: {}", ex);
            return ResultUtils.failure(PREPARE_ERROR_CODE,
                "get user profile Failed")
                .withHeader("Access-Control-Allow-Origin", "*");
        }
    }
}
