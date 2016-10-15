package ru.itis.Servlets;

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


/**
 * Created by lenar on 11.10.16.
 */
@WebServlet("/Login")
public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(200);
        String loginField = req.getParameter("nickname");
        String passwordField = req.getParameter("password");

        if (!(loginField == null) & !(passwordField == null)) {
            if (DBWorker.assertUser(loginField, passwordField)) {
                HttpSession session = req.getSession();
                session.setAttribute("authorized","ok");
                session.setAttribute("login",loginField);
                session.setAttribute("password",passwordField);
                resp.sendRedirect("/");
            } else {
                String varTextB = "Не удалось войти в систему!";
                req.setAttribute("textB", varTextB);
                resp.sendRedirect("/Login");
            }
        }
        else {
            resp.sendRedirect("/jsp/Login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/Login.jsp").forward(req,resp);
    }
}
