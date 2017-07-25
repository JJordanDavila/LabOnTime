package pe.edu.upc.labontime.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.adapters.UserAdapter;
import pe.edu.upc.labontime.models.User;
import pe.edu.upc.labontime.network.LabOnTimeService;
import org.json.JSONArray;
import org.json.JSONObject;

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

    User userEntity = new User();

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
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(MainActivity.this,PacienteActivity.class);
                startActivity(intent);*/
                login();
            }

        });

    }

    public void login() {


        usuarioEditText = (EditText) findViewById(R.id.usuarioEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        try {
            AndroidNetworking.get(LabOnTimeService.LOGIN_URL)
                    .addQueryParameter("user", usuarioEditText.getText().toString())
                    .addQueryParameter("password", passwordEditText.getText().toString())
                    .setTag(TAG)
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                               /*WCB:Consumo del servicio de login capturando parametros*/
                                userEntity = User.buildObject(response.getJSONObject("user"));

                                if (userEntity.getDescription().equals("Paciente")) {
                                    Toast.makeText(getApplicationContext(),
                                            "Redirecting...", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(MainActivity.this, PacienteActivity.class);
                                    startActivity(intent);
                                } else if (userEntity.getDescription().equals("Medico")) {
                                    Toast.makeText(getApplicationContext(),
                                            "Redirecting...", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(MainActivity.this, MedicoActivity.class);
                                    //WCB:Se envian los datos de la entidad User
                                    intent.putExtra("id", userEntity.getId());
                                    intent.putExtra("roles_id", userEntity.getRoles_id());
                                    intent.putExtra("description", userEntity.getDescription());
                                    intent.putExtra("persons_id", userEntity.getPersons_id());
                                    intent.putExtra("name", userEntity.getName());
                                    intent.putExtra("password", userEntity.getPassword());
                                    intent.putExtra("names", userEntity.getNames());
                                    intent.putExtra("lastnames", userEntity.getLastnames());
                                    intent.putExtra("address", userEntity.getAddress());
                                    intent.putExtra("phone", userEntity.getPhone());
                                    intent.putExtra("email", userEntity.getEmail());
                                    intent.putExtra("documentnumber", userEntity.getDocumentnumber());
                                    intent.putExtra("ruc", userEntity.getRuc());
                                    intent.putExtra("type", userEntity.getType());
                                    intent.putExtra("bussinessname", userEntity.getBussinessname());
                                    intent.putExtra("doctornumber", userEntity.getDoctornumber());
                                    intent.putExtra("speciality", userEntity.getSpeciality());

                                    startActivity(intent);

                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            "Wrong Credentials...", Toast.LENGTH_SHORT).show();

                                    usuarioEditText.setVisibility(View.VISIBLE);
                                    usuarioEditText.setBackgroundColor(Color.RED);
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
