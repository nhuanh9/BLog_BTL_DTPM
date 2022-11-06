package service.Impl;

import model.Account;
import model.Post;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

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

    public UserServiceImpl() {
    }


    @Override
    public List<Post> findPostByAccountId(int id) {
        List<Post> listpost = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where accountId = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id1 = rs.getInt("id");
                int  accountId = rs.getInt("accountId");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int status = rs.getInt("status");
                String image = rs.getString("image");
                listpost.add(new Post(id1,accountId,title,content,status,image));
                return listpost;
            }
        } catch (SQLException e) {
//            printSQLException(e);
        }
        return null;
    }
}
