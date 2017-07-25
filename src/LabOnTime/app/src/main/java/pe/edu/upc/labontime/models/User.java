package pe.edu.upc.labontime.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 15/07/2017.
 */

public class User {
    int id;
    int roles_id;
    String description;
    int persons_id;
    String name;
    String password;
    String names;
    String lastnames;
    String address;
    String phone;
    String email;
    String documentnumber;
    String ruc;
    String type;
    String bussinessname;
    String doctornumber;
    String speciality;

    public User() {
    }

    public User(int id, int roles_id, String description, int persons_id, String name, String password, String names, String lastnames, String address, String phone, String email, String documentnumber, String ruc, String type, String bussinessname, String doctornumber, String speciality) {
        this.id = id;
        this.roles_id = roles_id;
        this.description = description;
        this.persons_id = persons_id;
        this.name = name;
        this.password = password;
        this.names = names;
        this.lastnames = lastnames;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.documentnumber = documentnumber;
        this.ruc = ruc;
        this.type = type;
        this.bussinessname = bussinessname;
        this.doctornumber = doctornumber;
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPersons_id() {
        return persons_id;
    }

    public void setPersons_id(int persons_id) {
        this.persons_id = persons_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBussinessname() {
        return bussinessname;
    }

    public void setBussinessname(String bussinessname) {
        this.bussinessname = bussinessname;
    }

    public String getDoctornumber() {
        return doctornumber;
    }

    public void setDoctornumber(String doctornumber) {
        this.doctornumber = doctornumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public static User build(JSONObject jsonSource) {
        User user = new User();
        try {
            user.setId(jsonSource.getInt("id"));
            user.setRoles_id(jsonSource.getInt("roles_id"));
            user.setDescription(jsonSource.getString("description"));
            user.setPersons_id(jsonSource.getInt("persons_id"));
            user.setName(jsonSource.getString("name"));
            user.setPassword(jsonSource.getString("password"));
            user.setNames(jsonSource.getString("names"));
            user.setLastnames(jsonSource.getString("lastnames"));
            user.setAddress(jsonSource.getString("address"));
            user.setPhone(jsonSource.getString("phone"));
            user.setEmail(jsonSource.getString("email"));
            user.setDocumentnumber(jsonSource.getString("documentnumber"));
            user.setRuc(jsonSource.getString("ruc"));
            user.setType(jsonSource.getString("type"));
            user.setBussinessname(jsonSource.getString("bussinessname"));
            user.setDoctornumber(jsonSource.getString("doctornumber"));
            user.setSpeciality(jsonSource.getString("speciality"));

            return user;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User buildObject(JSONObject jsonSource) {
        User user = new User();
        //List<String> sortBysAvailable = new ArrayList<>();
        try {
            int length = 1;
            for (int i = 0; i < length; i++) {
                user.setId(jsonSource.getInt("id"));
                user.setRoles_id(jsonSource.getInt("roles_id"));
                user.setDescription(jsonSource.getString("description"));
                user.setPersons_id(jsonSource.getInt("persons_id"));
                user.setName(jsonSource.getString("name"));
                user.setPassword(jsonSource.getString("password"));
                user.setNames(jsonSource.getString("names"));
                user.setLastnames(jsonSource.getString("lastnames"));
                user.setAddress(jsonSource.getString("address"));
                user.setPhone(jsonSource.getString("phone"));
                user.setEmail(jsonSource.getString("email"));
                user.setDocumentnumber(jsonSource.getString("documentnumber"));
                user.setRuc(jsonSource.getString("ruc"));
                user.setType(jsonSource.getString("type"));
                user.setBussinessname(jsonSource.getString("bussinessname"));
                user.setDoctornumber(jsonSource.getString("doctornumber"));
                user.setSpeciality(jsonSource.getString("speciality"));
            }
            //.setSortBysAvailable(sortBysAvailable);

            return user;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<User> buildList(JSONArray jsonSources) {
        List<User> users = new ArrayList<>();
        int length = jsonSources.length();
        for (int i = 0; i < length; i++)
            try {
                users.add(User.build(jsonSources.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return users;
    }
}
