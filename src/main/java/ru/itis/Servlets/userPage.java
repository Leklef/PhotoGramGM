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
@WebServlet("/")
public class userPage extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("UserName", session.getAttribute("name"));
        req.setAttribute("UserNickName", session.getAttribute("login"));
        if(session.getAttribute("authorized")!="ok"){
            resp.sendRedirect("/Login");
        }
        else {
            req.getRequestDispatcher("/jsp/userPage.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("exit") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect("/Login");
        }
        if (req.getParameter("addPhoto") != null) {
            resp.sendRedirect("/NewPost");
        }
    }
}
