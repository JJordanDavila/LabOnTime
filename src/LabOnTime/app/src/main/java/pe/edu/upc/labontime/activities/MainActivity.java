package pe.edu.upc.labontime.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.adapters.UserAdapter;
import pe.edu.upc.labontime.beans.User;
import pe.edu.upc.labontime.network.LabOnTimeService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.Laboratory;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText usuarioEditText;
    EditText passwordEditText;
    /*List<User> users= new ArrayList<User>();*/
    public static String TAG = "LabOnTimeApp";
    UserAdapter userAdapter;
    List<User> users;

    List<User> listaUsers;

    User userEntity= new User();

    //para el asyntask
    JSONObject jsonobjectUsuario;
    JSONArray jsonarrayUsuario;
    ArrayList<String> usuariolist;
    ArrayList<Laboratory> usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<>();
        userAdapter = new UserAdapter(users);

        listaUsers=new List<User>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<User> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(User user) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends User> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends User> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public User get(int i) {
                return null;
            }

            @Override
            public User set(int i, User user) {
                return null;
            }

            @Override
            public void add(int i, User user) {

            }

            @Override
            public User remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<User> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<User> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<User> subList(int i, int i1) {
                return null;
            }
        };

        login();

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(MainActivity.this,PacienteActivity.class);
                startActivity(intent);*/
                /*login();*/
            }

        });

    }

    public void login() {


       /* usuarioEditText = (EditText) findViewById(R.id.usuarioEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);*/
       try {
           AndroidNetworking.get(LabOnTimeService.LOGIN_URL)
                   .addQueryParameter("user", "user01")
                   .addQueryParameter("password","12345678")
                   .setTag(TAG)
                   .setPriority(Priority.LOW)
                   .build()
                   .getAsJSONObject(new JSONObjectRequestListener() {
                       @Override
                       public void onResponse(JSONObject response) {

                           try {
                               userEntity=User.buildObject(response.getJSONObject("user"));
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }
                          /* try {
                               JSONObject userJsonObject= response.getJSONObject("user");
                               Iterator x = userJsonObject.keys();
                               JSONArray jsonArray = new JSONArray();

                               while (x.hasNext()){
                                   String key = (String) x.next();
                                   jsonArray.put(userJsonObject.get(key));
                               }

                               listaUsers = User.buildList(jsonArray);
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }*/
                          // Log.d(TAG, "Found Sources: " + String.valueOf(listaUsers.size()));
                           //sourcesAdapter.setSources(listaUsers);
                           //sourcesAdapter.notifyDataSetChanged();
                       }

                       @Override
                       public void onError(ANError anError) {

                       }
                   });
       }catch (Exception e){
           e.printStackTrace();
       }


        if (users.size()>0){
            if (usuarioEditText.getText().toString().equals("Paciente") &&
                    passwordEditText.getText().toString().equals("1234567")) {
                Toast.makeText(getApplicationContext(),
                        "Redirecting...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, PacienteActivity.class);
                startActivity(intent);
            } else if (usuarioEditText.getText().toString().equals("Medico") &&
                    passwordEditText.getText().toString().equals("1234567")) {
                Toast.makeText(getApplicationContext(),
                        "Redirecting...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MedicoActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(getApplicationContext(),
                        "Wrong Credentials...", Toast.LENGTH_SHORT).show();

                usuarioEditText.setVisibility(View.VISIBLE);
                usuarioEditText.setBackgroundColor(Color.RED);

            }
        }

    }

}
