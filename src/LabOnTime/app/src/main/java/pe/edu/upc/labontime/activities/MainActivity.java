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

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText usuarioEditText;
    EditText passwordEditText;
    /*List<User> users= new ArrayList<User>();*/
    public static String TAG = "LabOnTimeApp";
    UserAdapter userAdapter;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<>();
        userAdapter = new UserAdapter(users);

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
                   .setPriority(Priority.MEDIUM)
                   .build()
                   .getAsObjectList(User.class, new ParsedRequestListener<List<User>>() {
                       @Override
                       public void onResponse(List<User> users) {
                           // do anything with response
                           Log.d(TAG, "userList size : " + users.size());
                           for (User user : users) {
                               Log.d(TAG, "id : " + user.getId());
                               Log.d(TAG, "firstname : " + user.getNames());
                               Log.d(TAG, "lastname : " + user.getLastnames());
                           }
                       }
                       @Override
                       public void onError(ANError anError) {
                           // handle error
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
