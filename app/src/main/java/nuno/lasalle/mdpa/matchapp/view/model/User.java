package nuno.lasalle.mdpa.matchapp.view.model;

/**
 * Created by nunoreis on 02/02/2018.
 */

public class User {

    public String firstName;
    public String lastName;
    public int age;
    public String location;
    public String work;
    public String education;
    public String description;
    public String gender;
    public String sexualPreference;
    public String favouriteSong;

    public User(
            String firstName,
            String lastName,
            int age,
            String location,
            String work,
            String education,
            String description,
            String gender,
            String sexualPreference,
            String favouriteSong
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.work = work;
        this.education = education;
        this.description = description;
        this.gender = gender;
        this.sexualPreference = sexualPreference;
        this.favouriteSong = favouriteSong;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getWork() {
        return work;
    }

    public String getEducation() {
        return education;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public String getSexualPreference() {
        return sexualPreference;
    }

    public String getFavouriteSong() {
        return favouriteSong;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSexualPreference(String sexualPreference) {
        this.sexualPreference = sexualPreference;
    }

    public void setFavouriteSong(String favouriteSong) {
        this.favouriteSong = favouriteSong;
    }
}
