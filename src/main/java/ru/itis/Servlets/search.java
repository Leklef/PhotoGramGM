package ru.itis.Servlets;

import ru.itis.DataBase.DBWorker;
import ru.itis.SupportingFile.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by lenar on 03.11.16.
 */
@WebServlet("/search")
public class search extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("authorized")!="ok"){
            resp.sendRedirect("/Login");
        }
        else {
            String nickname = req.getParameter("search");
            LinkedList<UserModel> list = DBWorker.removeOwnUser(String.valueOf(session.getAttribute("login")),DBWorker.searchUsers(nickname));
            req.setAttribute("SearchList",list);
            req.setAttribute("count",list.size());
            req.getRequestDispatcher("/jsp/searchPage.jsp").forward(req,resp);
        }
    }
}
