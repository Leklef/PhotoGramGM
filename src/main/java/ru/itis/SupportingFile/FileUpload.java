package ru.itis.SupportingFile;

import org.apache.commons.fileupload.FileItemStream;
import ru.itis.Servlets.NewPost;
import ru.itis.Servlets.Setting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by lenar on 20.10.16.
 */
public class FileUpload {
    public static boolean processFile(String path, FileItemStream item){
        try {
            Random random = new Random();
            int r = random.nextInt();
            int ra = random.nextInt();
            File f = new File(path+File.separator+"images"+r);
            if(!f.exists()){
                f.mkdir();
            }
            NewPost.localpath = "/images"+r+"/"+ra+"image.jpg";
            Setting.userPhotopath = "/images"+r+"/"+ra+"image.jpg";
            File savedFile = new File(f.getAbsolutePath()+File.separator+ra+"image.jpg");
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
