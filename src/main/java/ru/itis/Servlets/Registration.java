package ru.itis.Servlets;

import ru.itis.DataBase.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        }else{
            req.getRequestDispatcher("/jsp/Registration.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/Registration.jsp").forward(req,resp);
    }
}
