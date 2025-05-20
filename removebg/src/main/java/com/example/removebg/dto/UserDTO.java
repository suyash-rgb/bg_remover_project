package com.example.removebg.dto;

import com.example.removebg.entity.UserEntity;

public class UserDTO {
    
    private String clerkId;
    private String email;
    private String firstName;
    private String lastName;
    private String photoUrl;
    private Integer credits;

    public UserDTO() {
    }

    public UserDTO(String clerkId, String email, String firstName, String lastName, String photoUrl, Integer credits) {
        this.clerkId = clerkId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
        this.credits = credits;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    //Builder Pattern (Manual Implementation)
    public static class Builder{
        private String clerkId;
        private String email;
        private String firstName;
        private String lastName;
        private String photoUrl;
        private Integer credits;

        public Builder clerkId(String clerkiId){
            this.clerkId=clerkId;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }

        public Builder photoUrl(String photoUrl){
            this.photoUrl=photoUrl;
            return this;
        }

        public Builder credits(Integer credits){
            this.credits=credits;
            return this;
        }

        public UserDTO build(){
            return new UserDTO(clerkId,email,firstName,lastName,photoUrl,credits);
        }
    }
    public static Builder builder(){
        return new Builder();
    }
}
