package ru.itis.Servlets;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.itis.DataBase.DBWorker;
import ru.itis.SupportingFile.FileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by lenar on 05.12.16.
 */
@WebServlet("/settings")
public class Setting extends HttpServlet{

    public static String userPhotopath = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("authorized")!="ok"){
            resp.sendRedirect("/Login");
        }
        else {
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
                    DBWorker.changeUserPhoto(userPhotopath, String.valueOf(DBWorker.userId(String.valueOf(session.getAttribute("login")))));
                    resp.sendRedirect("/user");
                } else {
                    String path = getServletContext().getRealPath("/");
                    if (FileUpload.processFile(path, item)) {
                        DBWorker.changeUserPhoto(userPhotopath, String.valueOf(DBWorker.userId(String.valueOf(session.getAttribute("login")))));
                        resp.sendRedirect("/settings");
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
