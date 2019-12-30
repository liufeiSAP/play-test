package com.user.login.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * The utilities for Json Object.
 */
public final class JsonUtil {
    private JsonUtil() {
    }

    /**
     * Read Java objects from Json file.
     *
     * @param <T>        the type parameter
     * @param json       the json
     * @param modelClass the model class
     * @return model model
     * @throws IOException the io exception
     */
    public static <T> T convertJsonToObject(String json, Class<T> modelClass)
        throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Ignore properties which is not in corresponding Java Object.
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(json, modelClass);
    }
}
