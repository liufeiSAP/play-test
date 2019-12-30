package com.user.login.redis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import play.Logger;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * The type Redis util.
 */

@Singleton
public class RedisUtil implements RedisConnector {

    final Logger.ALogger logger = Logger.of(this.getClass());

    private Config config;

    private int timeOut = 10000;
    private int maxTotal = 800;
    private int maxIdle = 500;
    private int maxWait = 10000;
    private boolean testOnBorrow = true;
    private JedisPool jedisPool = null;

    /**
     * Instantiates a new Redis util.
     */
    @Inject
    public RedisUtil(Config con) {
        this.config = con;
        String address = config.getString("forecasting.redis.host");
        int port = Integer.parseInt(config.getString("forecasting.redis.port"));
        int database = Integer.parseInt(config.getString("forecasting.redis.database"));
        boolean ssl = config.getBoolean("forecasting.redis.ssl");

        String pwd = "";
        if (config.hasPath("forecasting.redis.password")) {
            pwd = config.getString("forecasting.redis.password");
        }

        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMaxWaitMillis(maxWait);
            config.setTestOnBorrow(testOnBorrow);
            if ("".equals(pwd)) {
                jedisPool = new JedisPool(config, address, port, timeOut, ssl);
            } else {
                jedisPool = new JedisPool(config, address, port, timeOut, pwd, database, ssl);
            }

        } catch (Exception e) {
            logger.error("RedisUtil exception {} ", e);
        }
    }

    /**
     * Gets jedis.
     *
     * @return the jedis
     */
    public RedisProxyInterface getJedis() {
        if (jedisPool != null) {
            return new RedisProxy(jedisPool.getResource());
        }
        logger.error("can not get jedis!");
        return null;
    }
}

