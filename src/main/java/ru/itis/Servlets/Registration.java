package ru.itis.Servlets;

import ru.itis.DataBase.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by lenar on 11.10.16.
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String nick = req.getParameter("nickname");
        String password = req.getParameter("password");
        if(!(DBWorker.usedNickname(nick))){
            DBWorker.addInfoDB(email,name,nick,password);
            try {
                req.getSession().setAttribute("id", DBWorker.userId(nick));
                req.getSession().setAttribute("name", name);
                req.getSession().setAttribute("login",nick);
                req.getSession().setAttribute("authorized","ok");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();}
            resp.sendRedirect("/user");
            }
        else{
            resp.sendRedirect("/Registration");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("authorized")!="ok"){
            req.getRequestDispatcher("/jsp/Registration.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("/user");
        }
    }
}
