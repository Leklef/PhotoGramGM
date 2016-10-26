package ru.itis.DataBase;

import java.sql.*;
import java.util.Properties;

/**
 * Created by lenar on 11.10.16.
 */
public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/loginsystem";
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

    public static int userId(String nick, String password) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        int id = -1;

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "SELECT id,nick,password FROM users";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            if(rs.getString("nick").equals(nick)){
                if(rs.getString("password").equals(password)) id=rs.getInt("id");
            }
        }
        return id;
    }

    public static void addNewPostDB(int id, String path, String comment){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO newPost(id,image,comment) VALUES ('"+id+"','"+ path +"', '"+comment+"')";
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addInfoDB(String email, String name, String nick, String password){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO users VALUES (DEFAULT, '"+ email +"', '"+ name +"', '"+
                    nick +"', '"+ password +"')";

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
            ResultSet rs = statement.executeQuery("SELECT nick\n"+"FROM users");
            while (rs.next()){
                if(loginField.equals(rs.getString("nick"))){
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
            String query = "SELECT nick, password from users";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getString("nick").equals(loginField)){
                    if(rs.getString("password").equals(passwordField))
                        correct = true;
                    break;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return correct;
    }
}