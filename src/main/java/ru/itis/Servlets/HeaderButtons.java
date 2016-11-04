package ru.itis.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenar on 26.10.16.
 */
@WebServlet("/header")
public class HeaderButtons extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("exit") != null) {
            req.getSession().invalidate();
            resp.sendRedirect("/Login");
        }

        if (req.getParameter("myProfile") != null){
            resp.sendRedirect("/user");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("exit") != null) {
            req.getSession().invalidate();
            resp.sendRedirect("/Login");
        }

        if (req.getParameter("myProfile") != null){
            resp.sendRedirect("/user");
        }
    }
}
