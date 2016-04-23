package com.memorylayers.ml.model;

import java.util.Date;
import java.util.List;

/**
 * Created by ahmed.marzouk on 4/23/2016.
 */
public class Memory {
        // Private Members
        private String id;
        private String title;
        private String story;
        private User owner;
        private String memoryDate;
        private Date createDate;
        private List<String> Photos;
        private List<User> tagedPeople;

    // Encapsulate Fields ...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getMemoryDate() {
        return memoryDate;
    }

    public void setMemoryDate(String memoryDate) {
        this.memoryDate = memoryDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<String> getPhotos() {
        return Photos;
    }

    public void setPhotos(List<String> photos) {
        Photos = photos;
    }

    public List<User> getTagedPeople() {
        return tagedPeople;
    }

    public void setTagedPeople(List<User> tagedPeople) {
        this.tagedPeople = tagedPeople;
    }
}
