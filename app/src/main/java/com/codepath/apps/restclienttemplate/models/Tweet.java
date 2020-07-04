package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

//This is the tweet model
@Parcel
public class Tweet {

    public String body;
    public String createdAt;
    //Tweet ID
    public long id;
    //User who created the tweet
    public User user;

    // empty constructor needed by the Parceler library
    public Tweet() {
    }

    //Build the tweet using fields in Json Object
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet =new Tweet();
        tweet.body= jsonObject.getString("text");
        tweet.createdAt= jsonObject.getString("created_at");
        tweet.id= jsonObject.getLong("id");
        //Get user in a java format
        tweet.user= User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet>tweets = new ArrayList<>();
        for(int i=0; i<jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}
