package com.example.removebg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String clerkId;

    @Column(unique=true, nullable = false)
    private String email;
    private String firstName;
    private String lastName;
    private Integer credits;
    private String photoUrl;

    @PrePersist
    public void prePersist(){
        if(credits==null){
            credits=100;
        }
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String clerkId, String email, String firstName, String lastName, Integer credits, String photoUrl) {
        this.id = id;
        this.clerkId = clerkId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.photoUrl = photoUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    //Builder Pattern (Manual Implementation)
    public static class Builder{
        private long id;
        private String clerkId;
        private String email;
        private String firstName;
        private String lastName;
        private Integer credits;
        private String photoUrl;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder clerkId(String clerkId){
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

        public Builder credits(Integer credits){
            this.credits=credits;
            return this;
        }

        public Builder photoUrl(String photoUrl){
            this.photoUrl=photoUrl;
            return this;
        }

        public UserEntity build(){
            return new UserEntity(id, clerkId, email, firstName, lastName, credits, photoUrl);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

}
