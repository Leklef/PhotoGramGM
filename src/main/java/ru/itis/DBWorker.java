package ru.itis;

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

    public static void addInfoDB(String email, String name, String nick, String password){
        int id=0;
        try{

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection  con=DriverManager.getConnection
                    (URL,USERNAME,PASSWORD);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from users");
            while (resultSet.next()){
                id = resultSet.getInt(1)+1;
            }

            PreparedStatement ps=con.prepareStatement
                    ("insert into users values(?,?,?,?,?)");
            ps.setString(1, String.valueOf(id));
            ps.setString(2, email);
            ps.setString(3, name);
            ps.setString(4,nick);
            ps.setString(5, password);
            int i = ps.executeUpdate();

        } catch(SQLException selectedException){} catch (ClassNotFoundException e) {}
    }

    public static boolean usedNickname(String loginField){
        Boolean used = false;
        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nick\n"+"FROM users");
            while (rs.next()){
                if(loginField.equals(rs.getString("nickname"))){
                    used = true;
                }
            }
        }catch (SQLException selectedException){} catch (ClassNotFoundException e) {}
        return used;
    }

    public static boolean assertUser(String loginField, String passwordField){
        Boolean correct = false;
        Connection connection;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nick,password\n" +
                    "FROM users");
            while (rs.next()){
                if (loginField.equals(rs.getString("nickname"))){
                    if (passwordField.equals(rs.getString("password"))){
                        correct = true;
                    }
                    connection.close();
                }
            }
        }catch (SQLException selectException){} catch (ClassNotFoundException e) {}
        return correct;
    }
}