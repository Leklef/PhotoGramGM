package ru.itis.SupportingFile;

/**
 * Created by lenar on 30.10.16.
 */
public class Post {
    private String path;
    private String comment;
    public Post(String path, String comment){
        this.path=path;
        this.comment=comment;
    }

    public String getPath(){
        return path;
    }

    public String getComment(){
        return comment;
    }
}
