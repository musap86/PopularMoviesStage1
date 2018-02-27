package com.udacity.and.popularmovies.utilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Musap Kahraman on 27.02.2018.
 */

public class JsonUtility {

    private static String[] sTitles;
    private static String[] sReleaseDates;
    private static String[] sAverageVotes;
    private static String[] sPlots;
    private static String[] sImagePaths;

    public static String getTitle(int index) {
        return sTitles[index];
    }

    public static String getReleaseDate(int index) {
        return sReleaseDates[index];
    }

    public static String getAverageVote(int index) {
        return sAverageVotes[index];
    }

    public static String getPlot(int index) {
        return sPlots[index];
    }

    public static String getImagePath(int index) {
        return sImagePaths[index];
    }

    public static String[] getImagePathsFromJson(String json) {
        String[] imagePaths = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.optJSONArray("results");
            imagePaths = new String[jsonArray.length()];
            sImagePaths = new String[jsonArray.length()];
            sTitles = new String[jsonArray.length()];
            sReleaseDates = new String[jsonArray.length()];
            sAverageVotes = new String[jsonArray.length()];
            sPlots = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject result = jsonArray.optJSONObject(i);
                sImagePaths[i] = imagePaths[i] = result.optString("poster_path");
                sTitles[i] = result.optString("title");
                sReleaseDates[i] = result.optString("release_date");
                sAverageVotes[i] = result.optString("vote_average");
                sPlots[i] = result.optString("overview");
            }
        } catch (JSONException e) {
            Log.e("JsonUtility", e.getMessage());
        }
        return imagePaths;
    }
}
