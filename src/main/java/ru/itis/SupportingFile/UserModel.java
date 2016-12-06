package ru.itis.SupportingFile;

/**
 * Created by lenar on 06.12.16.
 */
public class UserModel {
    private String username;
    private String userPhoto;

    public UserModel(String username, String userPhoto){
        this.username = username;
        this.userPhoto = userPhoto;
    }

    public String getUsername(){
        return username;
    }

    public String getUserPhoto(){
        return userPhoto;
    }
}
