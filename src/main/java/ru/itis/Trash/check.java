package ru.itis.Trash;

import java.sql.*;

/**
 * Created by lenar on 14.10.16.
 */
public class check {
    private static final String url = "jdbc:mysql://localhost:3306/loginsystem";
    private static final String user = "root";
    private static final String password = "root1234";

    private static Connection connection; //отвечает за подключение
    private static Statement statement; //отвечает за создание запроса
    private static ResultSet resultSet; //
    public static void main(String[] args) throws SQLException{

        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT nick,password\n" +
                "FROM users");

        String loginField = "mail";//req.getParameter("nickname");
        String passwordField = "mail";//req.getParameter("password");

        if (!(loginField == null) & !(passwordField == null)) {
            //if (DBWorker.assertUser(loginField, passwordField)) {
            while (resultSet.next()){
                System.out.println(resultSet.getString("nick"));
                System.out.println(resultSet.getString("password"));

                if (loginField.equals(resultSet.getString("nick"))){
                    if (passwordField.equals(resultSet.getString("password"))){
                        System.out.println("вошел");
                    }
                }
            }
//            } else {
//                String varTextB = "Не удалось войти в систему!";
//                System.out.println(varTextB);
//
//            }
        }
    }
}
