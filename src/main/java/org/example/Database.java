package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.util.DatabaseProperty;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl(DatabaseProperty.getDbUrl());
        config.setUsername(DatabaseProperty.getDbUser());
        config.setPassword(DatabaseProperty.getDbPassword());
        ds = new HikariDataSource( config );
    }

    private Database() {
    }

    public Connection getConnection() throws SQLException {
            return ds.getConnection();
    }

    private static final class InstanceHolder {
        private static final Database instance = new Database();
    }

    public static Database getInstance() {
        return InstanceHolder.instance;
    }
}
