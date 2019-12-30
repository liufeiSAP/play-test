package com.user.login.modules;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.Properties;

/**
 * The type My batis xml module.
 */
public final class MyBatisXmlModule extends org.mybatis.guice.XMLMyBatisModule {
    /**
     * Instantiates a new My batis xml module.
     */
    public MyBatisXmlModule() {
    }

    @Override
    protected void initialize() {
        Config config = ConfigFactory.load();
        Properties props = new Properties();
        props.setProperty("driver", config.getString("forecast.db.driver"));
        props.setProperty("url", config.getString("forecast.db.url"));
        props.setProperty("username", config.getString("forecast.db.user"));
        props.setProperty("password", config.getString("forecast.db.password"));

        props.setProperty("sslConnection",
            config.getString("forecast.db.sslConnection"));
        props.setProperty("sslTrustStoreLocation",
            config.getString("forecast.db.sslTrustStoreLocation"));
        props.setProperty("sslTrustStorePassword",
            config.getString("forecast.db.sslTrustStorePassword"));

        setEnvironmentId("default");

        addProperties(props);
    }
}

