package service.Impl;

import model.Account;
import service.AccountService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbaiviet?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public AccountServiceImpl() {
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from account");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int role = rs.getInt(("role"));
                accounts.add(new Account(id, username, password, role));
            }
        } catch (SQLException e) {
        }
        return accounts;
    }

    @Override
    public Account checkLogin(String username, String password) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        Account account = new Account();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("select * from account where username = ? and password = ?");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                int role = rs.getInt("role");
                account = new Account(id, username1, password1, role);
                return account;
            }
        } catch (SQLException e) {
//            printSQLException(e);
        }
        return null;
    }

    public Account checkExistAccount(String username) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        Account account = new Account();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("select * from account where username = ?");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                int role = rs.getInt("role");
                account = new Account(id, username1, password1, role);
                return account;
            }
        } catch (SQLException e) {
//            printSQLException(e);
        }
        return null;
    }

    public void signUp(String username, String password) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        Account account = new Account();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("insert into account(username, password, role) values (?, ?, 1)");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
//            printSQLException(e);
        }
    }
}
