package service.Impl;

import model.Comment;
import service.CommentService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentServiceImpl implements CommentService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/qlbaiviet?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public CommentServiceImpl() {
    }

    @Override
    public void addUserComment(Comment comment) {
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("insert into Comment(content, accountId,postId) values (?,?,?)")) {

            preparedStatement.setString(1,comment.getContent());
            preparedStatement.setInt(2,comment.getAccountId());
            preparedStatement.setInt(3,comment.getPostId());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            printSQLException(e);
        }
    }
}
