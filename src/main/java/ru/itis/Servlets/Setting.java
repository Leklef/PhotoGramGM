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
 * Created by lenar on 05.12.16.
 */
@WebServlet("/settings")
public class Setting extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            String imageName = DBWorker.getUserPhoto(DBWorker.userId(String.valueOf(session.getAttribute("login"))));
            req.setAttribute("userPhoto", imageName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/jsp/Setting.jsp").forward(req,resp);
    }
}
