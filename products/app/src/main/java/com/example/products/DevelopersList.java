package com.example.products;

public class DevelopersList {
/** string  variable "login" to hold the product name and  avatar_url to the product image url**/

    private String login;
    private String avatar_url;

    /** Generate their getters **/
    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }
    /** Generate constructors since we’ll be making use of them in the DevelopersAdapter class. **/
    public DevelopersList(String login,String avatar_url){
        this.login=login;
        this.avatar_url=avatar_url;
    }

}
