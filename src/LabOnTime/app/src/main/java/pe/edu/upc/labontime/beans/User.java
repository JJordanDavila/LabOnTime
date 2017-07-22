package pe.edu.upc.labontime.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 15/07/2017.
 */

public class User {
    int id;
    int roles_id;
    int persons_id;
    String name;
    String password;
    Boolean active;

    public User() {
    }

    public User(int id, int roles_id, int persons_id, String name, String password, Boolean active) {
        this.id = id;
        this.roles_id = roles_id;
        this.persons_id = persons_id;
        this.name = name;
        this.password = password;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static User build(JSONObject jsonSource) {
        User user = new User();

        try {

            user.setId(jsonSource.getInt("id"));
            user.setRoles_id(jsonSource.getInt("roles_id"));
            user.setPersons_id(jsonSource.getInt("persons_id"));
            user.setName(jsonSource.getString("name"));
            user.setPassword(jsonSource.getString("password"));
            user.setActive(jsonSource.getBoolean("active"));

            return user;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<User> build(JSONArray jsonSources) {
        List<User> users = new ArrayList<>();
        int length = jsonSources.length();
        for(int i = 0; i < length; i++)
            try {
                users.add(User.build(jsonSources.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return users;
    }
}
