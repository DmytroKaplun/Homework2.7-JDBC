package org.example;

import org.example.util.DatabaseProperty;

import java.sql.*;

import static org.example.util.SqlReader.readSqlFile;

public class DatabasePopulateService {
    public static void main(String[] args) {
        DatabasePopulateService populateService = new DatabasePopulateService();
        populateService.executeSqlFile(DatabaseProperty.populateDb());
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
