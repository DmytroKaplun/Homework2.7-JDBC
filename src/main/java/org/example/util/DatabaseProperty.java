package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseProperty {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = Database.class.getResourceAsStream("/database.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDbUrl() {
        return PROPERTIES.getProperty("config.url");
    }

    public static String getDbUser() {
        return PROPERTIES.getProperty("config.user");
    }

    public static String getDbPassword() {
        return PROPERTIES.getProperty("config.password");
    }

    public static String findLongestProject() {
        return PROPERTIES.getProperty("sql.find_longest_project");
    }

    public static String findMaxProjectsClient() {
        return PROPERTIES.getProperty("sql.find_max_projects_client");
    }

    public static String findMaxSalaryWorker() {
        return PROPERTIES.getProperty("sql.find_max_salary_worker");
    }

    public static String findYoungestEldestWorkers() {
        return PROPERTIES.getProperty("sql.find_youngest_eldest_workers");
    }

    public static String printProjectPrices() {
        return PROPERTIES.getProperty("sql.print_project_prices");
    }

    public static String initDb() {
        return PROPERTIES.getProperty("sql.init_db");
    }

    public static String populateDb() {
        return PROPERTIES.getProperty("sql.populate_db");
    }
}
