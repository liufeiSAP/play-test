package com.user.function.redis;

/**
 * The interface Redis proxy interface.
 */
public interface RedisProxyInterface {
    /**
     * Set string.
     *
     * @param key   the key
     * @param value the value
     * @return the string
     */
    String set(String key, String value);

    /**
     * Set string.
     *
     * @param key   the key
     * @param value the value
     * @param nxxx  the nxxx
     * @param expx  the expx
     * @param time  the time
     * @return the string
     */
    String set(final String key, final String value, final String nxxx, final String expx,
               final long time);

    /**
     * Close.
     */
    void close();

    /**
     * Exists boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean exists(String key);

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    String get(String key);
}
