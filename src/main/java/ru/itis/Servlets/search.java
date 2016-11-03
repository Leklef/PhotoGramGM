package ru.itis.Servlets;

import ru.itis.DataBase.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by lenar on 03.11.16.
 */
@WebServlet("/search")
public class search extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("search");
        HttpSession session = req.getSession();
        LinkedList<String> list = DBWorker.searchUsers(nickname);
        list.remove((String)session.getAttribute("login"));
        req.setAttribute("SearchList",list);
        req.setAttribute("count",list.size());
        req.getRequestDispatcher("/jsp/searchPage.jsp").forward(req,resp);
    }
}
