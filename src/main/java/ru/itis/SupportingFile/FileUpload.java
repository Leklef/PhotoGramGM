package ru.itis.SupportingFile;

import org.apache.commons.fileupload.FileItemStream;
import ru.itis.Servlets.NewPost;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by lenar on 20.10.16.
 */
public class FileUpload {
    public static boolean processFile(String path, FileItemStream item){
        try {
            File f = new File(path+File.separator+"images");
            if(!f.exists()){
                f.mkdir();
            }
            NewPost.localpath = "/images/"+item.getName();
            File savedFile = new File(f.getAbsolutePath()+File.separator+item.getName());
            FileOutputStream fos = new FileOutputStream(savedFile);
            InputStream is = item.openStream();
            int x = 0;
            byte [] b = new byte[1024];
            while((x=is.read(b))!=-1){
                fos.write(b,0,x);
            }
            fos.flush();
            fos.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
