package com.rocqjones.intoverflown.crosscheck;

// TODO: 2.0 set Getters and Constructor

public class DevelopersList {

    /** String variables “login” to hold the developers name, “avatar_url” to hold the developers image url and “html_url” to
     * hold the developers github url. **/

    private String login;
    private String avatar_url;
    private String html_url;

    /** Generate their getters **/

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    /** Generate constructors since we’ll be making use of them in the DevelopersAdapter class. **/
    public DevelopersList(String login, String avatar_url, String html_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
    }

    // TODO: Then to bind the data that will be returned by the DevelopersList class to the RecyclerView, we’ll need an adapter.
}
