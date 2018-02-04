package nuno.lasalle.mdpa.matchapp.view;

import nuno.lasalle.mdpa.matchapp.model.User;

/**
 * Created by nunoreis on 04/02/2018.
 */

public class UserModel {

    private String firstName, lastName, location, profession, description;
    private int age;

    public UserModel(User user) {
        this.firstName = user.getFirstName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
