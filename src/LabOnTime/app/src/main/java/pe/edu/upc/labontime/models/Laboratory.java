package pe.edu.upc.labontime.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Laboratory {
    int id;
    String name;
    String description;
    Map<String, String> urlsToLogos;
    private List<String> sortBysAvailable;


    public Laboratory() {
    }

    public Laboratory(int id, String name, String description, Map<String, String> urlsToLogos, List<String> sortBysAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlsToLogos = urlsToLogos;
        this.sortBysAvailable = sortBysAvailable;
    }

    public int getId() {
        return id;
    }

    public Laboratory setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Laboratory setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Laboratory setDescription(String description) {
        this.description = description;
        return this;
    }

    public Map<String, String> getUrlsToLogos() {
        return urlsToLogos;
    }

    public Laboratory setUrlsToLogos(Map<String, String> urlsToLogos) {
        this.urlsToLogos = urlsToLogos;
        return this;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public Laboratory setSortBysAvailable(List<String> sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
        return this;
    }


    public static Laboratory build(JSONObject jsonLaboratory) {
        Laboratory laboratory = new Laboratory();
        List<String> sortBysAvailable = new ArrayList<>();
        Map<String, String> urlsToLogos = new HashMap<>();

        try {
            int length = jsonLaboratory.getJSONArray("sortBysAvailable").length();
            for(int i = 0; i < length; i++)
                sortBysAvailable.add(
                        jsonLaboratory.getJSONArray("sortBysAvailable").getString(i));
            laboratory.setId(jsonLaboratory.getInt("id"))
                    .setName(jsonLaboratory.getString("names"))
                    .setDescription(jsonLaboratory.getString("description"))
                    .setSortBysAvailable(sortBysAvailable);
            laboratory.setUrlsToLogos(urlsToLogos);
            return laboratory;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Laboratory> build(JSONArray jsonSources) {
        List<Laboratory> laboratories = new ArrayList<>();
        int length = jsonSources.length();
        for(int i = 0; i < length; i++)
            try {
                laboratories.add(Laboratory.build(jsonSources.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return laboratories;
    }



}
