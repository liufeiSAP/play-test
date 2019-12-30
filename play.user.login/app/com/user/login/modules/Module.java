package com.user.login.modules;

import com.google.inject.AbstractModule;
import com.user.login.dao.UserProfileDao;
import com.user.login.dao.daoimpl.UserProfileDaoImpl;
import com.user.login.dbpool.DbcpDataSourceFactory;
import com.user.login.redis.RedisConnector;
import com.user.login.redis.RedisUtil;
import com.user.login.service.UserProfileService;
import com.user.login.service.UserProfileServiceImpl;
import org.apache.ibatis.datasource.DataSourceFactory;
import play.libs.akka.AkkaGuiceSupport;

/**
 * The type Module.
 */
public final class Module extends AbstractModule implements AkkaGuiceSupport {
    /**
     * Instantiates a new Module.
     */
    public Module() {
    }

    @Override
    public void configure() {
        bind(RedisConnector.class).to(RedisUtil.class);
        bind(DataSourceFactory.class).to(DbcpDataSourceFactory.class);
        bind(UserProfileService.class).to(UserProfileServiceImpl.class);
        bind(UserProfileDao.class).to(UserProfileDaoImpl.class);
    }
}
