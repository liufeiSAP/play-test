package com.user.login.utils;

import java.io.IOException;

public final class ModuleUtils {

    private ModuleUtils() {
    }

    /**
     * Gets module by json.
     *
     * @param moduleClass the module class
     * @param jsonString the json string
     * @return the module by json
     * @throws IOException the io exception
     */
    @SuppressWarnings("unchecked")
    public static Object getModuleByJson(Class moduleClass,
                                         String jsonString) throws IOException {
        if (moduleClass == null) {
            throw new IOException("No valid module found");
        }

        return JsonUtil.convertJsonToObject(jsonString, moduleClass);
    }
}
