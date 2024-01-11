package com.media.socialmedia.Users;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Models {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String UserID;
    private String UserName;
    private String FirstName;
    private String LastName;
    private String ProfilePicture;

    public Models() {
    }

    public Models(String userID, String userName, String firstName, String lastName, String profilePicture) {
        UserID = userID;
        UserName = userName;
        FirstName = firstName;
        LastName = lastName;
        ProfilePicture = profilePicture;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "Models{" +
                "UserID=" + UserID +
                ", UserName='" + UserName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", ProfilePicture='" + ProfilePicture + '\'' +
                '}';
    }
}
