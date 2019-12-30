package com.user.login.redis;

import redis.clients.jedis.Jedis;

public class RedisProxy implements RedisProxyInterface {
    private Jedis jedis;

    public RedisProxy(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public String set(String key, String value) {
        return this.jedis.set(key, value);
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        return jedis.set(key, value, nxxx, expx, time);
    }

    @Override
    public void close() {
        this.jedis.close();
    }

    @Override
    public boolean exists(String key) {
        return this.jedis.exists(key);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }
}
