package com.joshuahalvorson.fragmentstartcode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SpaceImageDetails {
    private String name;
    private String description;
    private String credits;
    private String newsName;
    private String mission;
    private String collection;
    private List<ImageFile> imageFiles;

    public SpaceImageDetails(String name, String description, String credits, String newsName, String mission, String collection) {
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.newsName = newsName;
        this.mission = mission;
        this.collection = collection;
    }

    public SpaceImageDetails(JSONObject object) {
        try {
            this.name = object.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.description = object.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.credits = object.getString("credits");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.newsName = object.getString("news_name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.mission = object.getString("mission");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.collection = object.getString("collection");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            ArrayList<ImageFile> imageFiles = new ArrayList<>();
            JSONArray jsonArray = object.getJSONArray("image_files");
            for(int i = 0; i < jsonArray.length(); i++){
                imageFiles.add(new ImageFile(jsonArray.getJSONObject(i)));
            }
            this.imageFiles = imageFiles;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<ImageFile> getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(List<ImageFile> imageFiles) {
        this.imageFiles = imageFiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }


}
