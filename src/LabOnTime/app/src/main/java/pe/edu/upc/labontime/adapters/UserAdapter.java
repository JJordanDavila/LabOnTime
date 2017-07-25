package pe.edu.upc.labontime.adapters;

import java.util.List;

import pe.edu.upc.labontime.models.User;

/**
 * Created by hp on 15/07/2017.
 */

public class UserAdapter{

    public UserAdapter setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }
}
