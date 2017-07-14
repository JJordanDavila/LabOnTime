package pe.edu.upc.labontime.beans;

import java.util.List;
import java.util.Map;

public class Doctor {
    int id;
    String names;
    String lastname;
    String address;
    String phone;
    String email;
    String documentnumber;
    Map<String, String> urlsToLogos;
    private List<String> sortBysAvailable;

    public Doctor() {
    }

    public Doctor(int id, String names, String lastname, String address, String phone, String email, String documentnumber, Map<String, String> urlsToLogos, List<String> sortBysAvailable) {
        this.id = id;
        this.names = names;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.documentnumber = documentnumber;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentnumber() {
        return documentnumber;
    }

    public void setDocumentnumber(String documentnumber) {
        this.documentnumber = documentnumber;
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
