package pe.edu.upc.labontime.beans;

import java.util.List;
import java.util.Map;

public class Laboratory {
    int id;
    String names;
    String description;
    Map<String, String> urlsToLogos;
    private List<String> sortBysAvailable;

    public Laboratory() {
    }

    public Laboratory(int id, String names, String description, Map<String, String> urlsToLogos, List<String> sortBysAvailable) {
        this.id = id;
        this.names = names;
        this.description = description;
        this.urlsToLogos = urlsToLogos;
        this.sortBysAvailable = sortBysAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getUrlsToLogos() {
        return urlsToLogos;
    }

    public void setUrlsToLogos(Map<String, String> urlsToLogos) {
        this.urlsToLogos = urlsToLogos;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public void setSortBysAvailable(List<String> sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
    }
}
