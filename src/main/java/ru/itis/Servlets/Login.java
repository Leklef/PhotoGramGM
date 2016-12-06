package ru.itis.Servlets;

import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.DataBase.DBWorker;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Created by lenar on 11.10.16.
 */
@WebServlet("/Login")
public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginField = req.getParameter("nickname");
        String passwordField = req.getParameter("password");

        if (!(loginField == null) & !(passwordField == null)) {
            passwordField = DigestUtils.md5Hex(passwordField);
            if (DBWorker.assertUser(loginField, passwordField)) {
                HttpSession session = req.getSession();
                session.setAttribute("authorized","ok");
                session.setAttribute("login",loginField);
                session.setAttribute("password",passwordField);
                try {
                    session.setAttribute("id", DBWorker.userId(loginField));
                    session.setAttribute("name", DBWorker.getUserName(loginField));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/user");
            } else {
                resp.sendRedirect("/Login");
            }
        }
        else {
            resp.sendRedirect("/Login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("authorized")!="ok"){
            req.getRequestDispatcher("/jsp/Login.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("/user");
        }
    }
}
