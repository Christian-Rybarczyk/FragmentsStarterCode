package com.joshuahalvorson.fragmentstartcode;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SpaceImageRepository {
    public static final String GET_IMAGE_LIST_URL = "http://hubblesite.org/api/v3/images";
    public static final String GET_IMAGE_DETAILS_URL = "http://hubblesite.org/api/v3/image/";

    public static ArrayList<SpaceImageListItem> getSpaceImageListItems(){
        String result = NetworkAdapter.httpRequest(GET_IMAGE_LIST_URL);
        ArrayList<SpaceImageListItem> listItems = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(result);
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                listItems.add(new SpaceImageListItem(jsonObject));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listItems;
    }

    public static SpaceImageDetails getSpaceImageDetails(int id){
        String result = NetworkAdapter.httpRequest(GET_IMAGE_DETAILS_URL + id);
        try {
            JSONObject jsonObject = new JSONObject(result);
            return new SpaceImageDetails(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap getSpaceImageBitmap(String url){
        return NetworkAdapter.httpImageRequest(url);
    }

}
