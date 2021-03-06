package ru.itis.Servlets;

import ru.itis.DataBase.DBWorker;
import ru.itis.DataBase.GetAllPost;
import ru.itis.SupportingFile.Post;

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
 * Created by lenar on 04.11.16.
 */
@WebServlet("/friend")
public class Friend extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("authorized")=="ok"){
            String nick = req.getParameter("nickname");
            LinkedList<Post> posts = null;
            try {
                posts = GetAllPost.setAllPost(String.valueOf(DBWorker.userId(nick)));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            req.setAttribute("count",posts.size());
            try {
                req.setAttribute("userPhoto",DBWorker.getUserPhoto(DBWorker.userId(nick)));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            req.setAttribute("posts",posts);
            req.setAttribute("nick",nick);
            req.setAttribute("name", DBWorker.getName(nick));
            req.getRequestDispatcher("/jsp/Friend.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("/Login");
        }
    }
}
