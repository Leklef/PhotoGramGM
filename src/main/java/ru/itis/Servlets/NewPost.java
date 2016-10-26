package ru.itis.Servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import ru.itis.DataBase.DBWorker;
import ru.itis.SupportingFile.FileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.SQLException;
import java.io.*;

/**
 * Created by lenar on 17.10.16.
 */
@WebServlet("/NewPost")

public class NewPost extends HttpServlet {

    public static String localpath;
    public static String comment;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("authorized")!="ok"){
            resp.sendRedirect("/Login");
        }
        else {
            req.getRequestDispatcher("/jsp/NewPost.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        ServletFileUpload upload = new ServletFileUpload();
        HttpSession session = req.getSession();
        try {
            FileItemIterator itr = upload.getItemIterator(req);
            while (itr.hasNext()) {
                FileItemStream item = itr.next();
                InputStream is = item.openStream();
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    String value=new String(b);
                    resp.getWriter().println(fieldName + ":" + value + "</br>");
                    DBWorker.addNewPostDB(DBWorker.userId(String.valueOf(session.getAttribute("login")), String.valueOf(session.getAttribute("password"))), localpath, value);
                    resp.sendRedirect("/NewPost");
                } else {
                    String path = getServletContext().getRealPath("/");
                    if (FileUpload.processFile(path, item)) {
                    } else {
                        resp.getWriter().println("fail");
                    }
                }
            }
        } catch (FileUploadException fue) {
            fue.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
