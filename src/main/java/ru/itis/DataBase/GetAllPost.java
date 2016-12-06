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
        String URL = "jdbc:mysql://localhost:3306/PhotoGram";
        String USERNAME = "root";
        String PASSWORD = "root1234";
        posts = new LinkedList<Post>();
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT image FROM all_Post WHERE user_id="+id+";";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String img = rs.getString("image");
                String comment = getComment(DBWorker.getPostID(img));
                posts.add(new Post(img,comment));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static String getComment(String post_id){
        String URL = "jdbc:mysql://localhost:3306/PhotoGram";
        String USERNAME = "root";
        String PASSWORD = "root1234";
        Connection conn = null;
        Statement stmt = null;
        String comment = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            ResultSet rsComment = stmt.executeQuery("SELECT comment FROM users_comment WHERE post_id="+post_id+";");
            while (rsComment.next()){
                comment = rsComment.getString("comment");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }
}
