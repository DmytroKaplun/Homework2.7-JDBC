package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.DbUtil.readSqlFile;


public class DatabaseInitService {
    public static void main(String[] args) {
        DatabaseInitService initService = new DatabaseInitService();
        initService.executeSqlFile(DatabaseProperty.initDb());
    }

    public void executeSqlFile(String filePath) {
        String sqlQuery = readSqlFile(filePath);
        Connection connection = Database.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}