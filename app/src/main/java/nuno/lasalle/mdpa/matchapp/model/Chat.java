package nuno.lasalle.mdpa.matchapp.model;

/**
 * Created by nunoreis on 21/02/2018.
 */

// Business model for Chat

public class Chat {

    // member variables for profile pic, name, date & content
    private String profilePicture, name, date, content;

    // public constructor for respective member variables
    public Chat(String profilePicture, String name, String date, String content) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.date = date;
        this.content = content;
    }

    // getters & setters for each variable
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() { return content; }

    public void setContent(String content) {
        this.content = content;
    }
}
