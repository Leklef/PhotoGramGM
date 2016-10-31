package ru.itis.DataBase;

import ru.itis.SupportingFile.Post;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by lenar on 27.10.16.
 */
public class GetAllPost {
    public static LinkedList<Post> posts;

    public static LinkedList<Post> setAllPost(String id){
        String URL = "jdbc:mysql://localhost:3306/loginsystem";
        String USERNAME = "root";
        String PASSWORD = "root1234";
        posts = new LinkedList<Post>();
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT id,image, comment FROM newPost";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("id").equals(id)){
                    posts.add(new Post(rs.getString("image"),rs.getString("comment")));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
