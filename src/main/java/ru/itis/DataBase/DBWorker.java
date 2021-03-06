package ru.itis.DataBase;

import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.SupportingFile.UserModel;

import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenar on 11.10.16.
 */
public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/PhotoGram";
    private  static final String USERNAME = "root";
    private  static final String PASSWORD = "root1234";

    private static Connection getConnection(){
        Properties connInfo = new Properties();
        connInfo.put("user","root");
        connInfo.put("password", "root1234");
        connInfo.put("useUnicode","true");
        connInfo.put("charSet","UTF-8");
        try{
            return DriverManager.getConnection(URL, connInfo);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getUserName(String nick) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement stmt = null;
        String name = null;
        conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        String sql = "SELECT name, username FROM userinfo";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            if(rs.getString("username").equals(nick)){
                name = rs.getString("name");
            }
        }
        return name;
    }

    public static int userId(String nick) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        int id = -1;

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "SELECT id,username FROM userinfo";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("username").equals(nick)) {
                id = rs.getInt("id");
            }
        }
        return id;
    }

    public static void deletePost(String path){
        Connection conn = null;
        Statement stmt = null;

        if(!path.equals("")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "DELETE FROM users_comment WHERE post_id='"+DBWorker.getPostID(path)+"'";
                String sql = "DELETE FROM all_Post WHERE image='"+path+"'";
                stmt = conn.createStatement();
                stmt.execute(query);
                stmt.execute(sql);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getName(String nick){
        Connection conn=null;
        Statement stmt = null;
        String name = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String query = "SELECT username, name from userinfo";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getString("username").equals(nick)){
                        name = rs.getString("name");
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static void changeUserPhoto(String path, String user_id){
        Connection conn = null;
        Statement stmt = null;

        if(!path.equals("")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String sql = "UPDATE userPhoto SET user_image = '"+path+"' WHERE user_id="+user_id+";";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void addNewPostDB(String path, int user_id){
        Connection conn = null;
        Statement stmt = null;
        if(!path.equals("")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String sql = "INSERT INTO all_Post(image,user_id) VALUES ('"+path+"','"+user_id+"')";
                stmt = conn.createStatement();
                stmt.execute(sql);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUserPhoto(int id){
        Connection conn=null;
        Statement stmt = null;
        String userPhoto = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String query = "SELECT user_id, user_image from userPhoto WHERE user_id="+id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                userPhoto = rs.getString("user_image");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userPhoto;
    }

    public static void addInfoDB(String email, String name, String nick, String password){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "call add_user('"+name+"','"+nick+"','"+email+"')";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            int id = DBWorker.userId(nick);
            stmt.executeUpdate("call add_password("+id+", '"+password+"')");
            sql = "call add_userPhoto("+id+")";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static boolean usedNickname(String loginField){
        Boolean used = false;
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username\n"+"FROM userinfo");
            while (rs.next()){
                if(loginField.equals(rs.getString("username"))){
                    used = true;
                }
            }
        }catch (SQLException selectedException){} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return used;
    }

    public static boolean assertUser(String loginField, String passwordField){
        Boolean correct = false;
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String query = "SELECT password from password_tables WHERE user_id="+DBWorker.userId(loginField);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("password").equals(passwordField))
                    correct = true;
                break;
                }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return correct;
    }
    public static LinkedList<UserModel> searchUsers(String nickname){
        Connection conn = null;
        Statement stmt = null;
        LinkedList<UserModel> list = new LinkedList<UserModel>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            String query = "SELECT id,username FROM userinfo WHERE username LIKE '"+nickname+"%';";//посмотреть здесь
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                list.add(new UserModel(rs.getString("username"),DBWorker.getUserPhoto(Integer.parseInt(rs.getString("id")))));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void newComment(String post_id, String comment, String id){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            //String sql = "INSERT INTO all_Post(image,user_id) VALUES ('"+path+"','"+user_id+"')";
            String query = "INSERT INTO users_comment" +
                    " VALUES ("+post_id+", '"+comment+"', "+id+");";
            stmt.execute(query);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static String getPostID(String localpath){
        Connection conn = null;
        Statement stmt = null;
        String comment = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            String query = "SELECT id FROM all_Post WHERE  image='"+localpath+"';";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                comment = rs.getString("id");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return comment;
    }

    public static void deleteUser(String id){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM userPhoto WHERE user_id="+id);
            stmt.executeUpdate("DELETE FROM users_comment WHERE user_id="+id);
            stmt.executeUpdate("DELETE FROM all_Post WHERE user_id="+id);
            stmt.executeUpdate("DELETE FROM password_tables WHERE user_id="+id);
            stmt.executeUpdate("DELETE FROM userinfo WHERE id="+id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<UserModel> removeOwnUser (String nick, LinkedList<UserModel> list){
        for (int i=0; i<list.size(); i++){
            if (list.get(i).getUsername().equals(nick)){
                list.remove(i);
            }
        }
        return list;
    }
}