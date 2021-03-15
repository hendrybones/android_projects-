package com.example.cosmestic;

public class DevelopersList {

    /*  String variable name to gate the name of the product and avatar_url to get the image of the product*/
    private  String login;
    private String avatar_url;

    /** Generate their getters **/

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }


    /** Generate constructors since we’ll be making use of them in the DevelopersAdapter class. **/
    public DevelopersList(String avatar_url, String login) {
        this.login= login;
        this.avatar_url = avatar_url;

    }


}
