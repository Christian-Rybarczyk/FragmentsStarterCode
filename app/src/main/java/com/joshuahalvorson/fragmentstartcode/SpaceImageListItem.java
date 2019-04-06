package com.joshuahalvorson.fragmentstartcode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class SpaceImageListItem implements Serializable {
    private Integer id;
    private String name;
    private String newsName;
    private String collection;

    public SpaceImageListItem(Integer id, String name, String newsName, String collection) {
        this.id = id;
        this.name = name;
        this.newsName = newsName;
        this.collection = collection;
    }

    public SpaceImageListItem(JSONObject jsonObject){
        try {
            this.id = jsonObject.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.name = jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.newsName = jsonObject.getString("news_name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.collection = jsonObject.getString("collection");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

}
