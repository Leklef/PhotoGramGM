package ru.itis.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lenar on 21.10.16.
 */
@WebServlet("/header")
public class Header extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("myprofile")!=null){
            resp.sendRedirect("/");
        }
        if (req.getParameter("exit") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect("/Login");
        }
    }
}
