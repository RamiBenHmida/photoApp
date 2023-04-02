package com.example.photoPlatform.DAO.model;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer nbOfLikes;
    private String imageUrl;
    private  boolean likeStatus;


    @ManyToOne
    public User user;

    public Photo() {}

    public Photo( Integer nbOfLikes) {
        this.nbOfLikes = nbOfLikes;
    }

    public Photo(long id, Integer nbOfLikes, String imageUrl, boolean likeStatus, User user) {
        this.id = id;
        this.nbOfLikes = nbOfLikes;
        this.imageUrl = imageUrl;
        this.likeStatus = likeStatus;
        this.user = user;
    }

    public Photo(long id, Integer nbOfLikes, String imageUrl, User user) {
        this.id = id;
        this.nbOfLikes = nbOfLikes;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public Photo(Integer nbOfLikes, String imageUrl, User user) {
        this.id = id;
        this.nbOfLikes = nbOfLikes;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNbOfLikes() {
        return nbOfLikes;
    }

    public void setNbOfLikes(Integer nbOfLikes) {
        this.nbOfLikes = nbOfLikes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", nbOfLikes=" + nbOfLikes +
                ", imageUrl='" + imageUrl + '\'' +
                ", likeStatus=" + likeStatus +
                ", user=" + user +
                '}';
    }
}

