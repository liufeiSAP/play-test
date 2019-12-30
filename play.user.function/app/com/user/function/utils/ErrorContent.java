package com.user.function.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * The type Error content.
 */
public class ErrorContent {

    @JsonProperty("error_code")
    private Integer error;

    @JsonProperty("error_message")
    private String errorMessage;

    /**
     * Instantiates a new Error content.
     *
     * @param error        the error
     * @param errorMessage the error message
     */
    public ErrorContent(Integer error, String errorMessage) {
        this.error = error;
        this.errorMessage = errorMessage;
    }

    /**
     * Generate json string string.
     *
     * @return the string
     */
    public String toString() {
        JsonNode jsonNode = Json.toJson(this);

        return jsonNode.toString();
    }
}
