package nuno.lasalle.mdpa.matchapp.model;

/**
 * Created by nunoreis on 04/02/2018.
 */

public class User {

    private String profilePicture, name, location;
    private int age;

    public User(String profilePicture, String name, int age, String location) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.age = age;
        this.location = location;
    }


    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.name = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


