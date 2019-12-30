package com.user.login.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import play.Logger;
import play.libs.Json;
import play.twirl.api.Content;

/**
 * The type Json content.
 */
public final class JsonContent implements Content {

    private final Logger.ALogger log = Logger.of(this.getClass());
    private final JsonNode json;
    private final String contentType;

    /**
     * Instantiates a new Json content.
     *
     * @param content the content
     */
    public JsonContent(final String content) {
        contentType = "application/json";
        this.json = Json.parse(content);
    }

    @Override
    public String body() {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this.json);
        } catch (final IOException e) {
            log.error(e.getMessage());
        }
        return "";
    }

    @Override
    public String contentType() {
        return this.contentType;
    }
}
