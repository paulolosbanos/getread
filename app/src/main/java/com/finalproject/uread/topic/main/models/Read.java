package com.finalproject.uread.topic.main.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by paulo.losbanos on 10/02/2017.
 */

public class Read implements Serializable{

    private String id;
    private String title;
    private String owner;
    private String condition;

    @SerializedName("owner-contact")
    private String ownerContact;



    public Read(String id, String name, String owner, String ownerContact, String condition) {
        this.id = id;
        this.title = name;
        this.owner = owner;
        this.ownerContact = ownerContact;
        this.condition = condition;
    }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
