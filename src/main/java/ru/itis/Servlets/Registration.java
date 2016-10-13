package ru.itis.Servlets;

import ru.itis.DBWorker;
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
        String email = (String) req.getParameter("email");
        String name = (String) req.getParameter("name");
        String nickname = (String)req.getParameter("nickname");
        String password = (String) req.getParameter("password");
        if(DBWorker.usedNickname(nickname)){
            req.getRequestDispatcher("/jsp/Registration.jsp");
        }
        DBWorker.addInfoDB(email,name,nickname,password);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/Registration.jsp").forward(req,resp);
    }
}
