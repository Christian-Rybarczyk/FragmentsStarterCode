package com.joshuahalvorson.fragmentstartcode;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageFile {
     private String fileUrl;

    public ImageFile(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public ImageFile(JSONObject jsonObject){
        try {
            this.fileUrl = jsonObject.getString("file_url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
