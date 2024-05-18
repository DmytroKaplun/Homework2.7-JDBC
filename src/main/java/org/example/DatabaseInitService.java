package org.example;

import org.example.util.DatabaseProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.util.SqlReader.readSqlFile;


public class DatabaseInitService {
    public static void main(String[] args) {
        DatabaseInitService initService = new DatabaseInitService();
        initService.executeSqlFile(DatabaseProperty.initDb());
    }

    public void executeSqlFile(String filePath) {
        String sqlQuery = readSqlFile(filePath);

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}