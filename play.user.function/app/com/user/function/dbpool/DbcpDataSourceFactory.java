package com.user.function.dbpool;

import com.google.inject.Singleton;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

@Singleton
public class DbcpDataSourceFactory implements DataSourceFactory {
    private BasicDataSource datasource = null;

    public DbcpDataSourceFactory() {
        this.datasource = new BasicDataSource();
    }

    @Override
    public void setProperties(Properties ps) {
        datasource.setDriverClassName(ps.getProperty("driver"));
        datasource.setUrl(ps.getProperty("url"));
        datasource.setUsername(ps.getProperty("username"));
        datasource.setPassword(ps.getProperty("password"));

        datasource.setInitialSize(Integer.parseInt(ps.getProperty("initialSize","8")));
        datasource.setMaxIdle(Integer.parseInt(ps.getProperty("poolMaximumIdleConnections","8")));
        datasource.setMaxTotal(Integer.parseInt(ps.getProperty("poolMaximumActiveConnections",
            "8")));
        datasource.setMaxWaitMillis(Integer.parseInt(ps.getProperty("poolTimeToWait","20000")));

        if (Boolean.parseBoolean(ps.getProperty("driver.sslConnection", "false"))) {
            String driverSslProperties = "sslConnection=true;sslTrustStoreLocation="
                + ps.getProperty("driver.sslTrustStoreLocation")
                + ";sslTrustStorePassword=" + ps.getProperty("driver.sslTrustStorePassword");

            datasource.setConnectionProperties(driverSslProperties);
        }

        datasource.setTestWhileIdle(Boolean.parseBoolean(ps.getProperty("testWhileIdle")));
        datasource.setValidationQueryTimeout(
            Integer.parseInt(ps.getProperty("validationQueryTimeout")));
        datasource.setValidationQuery(
            ps.getProperty("validationQuery"));
        datasource.setTimeBetweenEvictionRunsMillis(
            Long.parseLong(ps.getProperty("timeBetweenEvictionRunsMillis")));
        datasource.setNumTestsPerEvictionRun(
            Integer.parseInt(ps.getProperty("numTestsPerEvictionRun")));
        datasource.setRemoveAbandonedOnBorrow(
                Boolean.parseBoolean(ps.getProperty("removeAbandoned")));
        datasource.setRemoveAbandonedOnMaintenance(
                Boolean.parseBoolean(ps.getProperty("removeAbandoned")));
        datasource.setLogAbandoned(Boolean.parseBoolean(ps.getProperty("logAbandoned")));
        datasource.setRemoveAbandonedTimeout(
                Integer.parseInt(ps.getProperty("removeAbandonedTimeout")));

    }

    @Override
    public DataSource getDataSource() {
        return datasource;
    }
}