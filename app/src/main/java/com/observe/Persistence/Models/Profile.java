package com.observe.Persistence.Models;

/**
 * Created by Owner on 1/16/2016.
 */
public class Profile {
    private int followers, following;
    private String aboutMe, professionTitle;

    public String getAboutMe(){
        return aboutMe;
    }

    public String getProfessionTitle(){
        return professionTitle;
    }

    public int getFollowers(){
        return followers;
    }

    public int getFollowing() {
        return following;

    }
}
