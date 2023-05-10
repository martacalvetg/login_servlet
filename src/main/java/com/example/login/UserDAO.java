package com.example.login;

import java.sql.*;

public class UserDAO {
    public static User getUser(String username, String password) {
        System.out.println("UserDAO ini");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        System.err.println("aaaaaaaa");
        try {
            System.err.println("username: " + username);
            System.err.println("password: " + password);
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement("SELECT id, username, password FROM user WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                System.err.println("dbUsername: " + dbUsername);
                System.err.println("dbPassword: " + dbPassword);
                if(username.equals(dbUsername) && password.equals(dbPassword)) {
                    user = new User(id, dbUsername, dbPassword);
                }
            }
            else {
                System.err.println("No lo encuentra");
            }
        } catch (SQLException ex) {
            System.err.println("SQLCODE: " + ex.getErrorCode());
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            DBManager.closeResultSet(resultSet);
            DBManager.closePreparedStatement(preparedStatement);
            DBManager.closeConnection(connection);
        }
        System.err.println("UserDAO FIN");

        return user;
    }
}
