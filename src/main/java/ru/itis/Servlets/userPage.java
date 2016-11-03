package ru.itis.Servlets;

import ru.itis.DataBase.GetAllPost;
import ru.itis.SupportingFile.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by lenar on 21.10.16.
 */
@WebServlet("/user")
public class userPage extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("UserName", session.getAttribute("name"));
        req.setAttribute("UserNickName", session.getAttribute("login"));
        LinkedList<Post> posts = GetAllPost.setAllPost(String.valueOf(session.getAttribute("id")));
        req.setAttribute("count",posts.size());
        req.setAttribute("posts",posts);
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
        if(req.getParameter("searchB")!=null){
            if(!(req.getParameter("search").length()<3)) {
                resp.sendRedirect("/search?search="+req.getParameter("search"));
            }
            else{
                resp.sendRedirect("/user");
            }
        }
    }
}
