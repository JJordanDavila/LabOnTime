package pe.edu.upc.labontime.fragments.medico;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.models.User;
import pe.edu.upc.labontime.network.LabOnTimeService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracionMedicoFragment extends Fragment {

    public static String TAG = "LabOnTimeApp";
    //List<AnalisisMedico> analisisMedicos;
    //User userEntity= new User();

    EditText passwordMeEditText;
    EditText direccionMeEditText;
    EditText correoMeEditText;
    EditText telefonoMeEditText;
    Button actualizarDatosMeButton;
    JSONObject jsonObject = new JSONObject();

    //PARA LA CAMARA
    public  static  final  int CAM_REQUEST=1;
    ImageView cameraMeImageView;
    Button capturarFotoMeButton;
    Bitmap bmp;

    User user;

    private  static Integer idmedico;
    private  static String password ;
    private  static String direccion ;
    private  static String correo ;
    private  static String telefono ;


    public ConfiguracionMedicoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_configuracion_medico, container, false);
        View myView = inflater.inflate(R.layout.fragment_configuracion_medico,container,false);


        passwordMeEditText = (EditText) myView.findViewById(R.id.passwordMeEditText);
        direccionMeEditText = (EditText) myView.findViewById(R.id.direccionMeEditText);
        correoMeEditText = (EditText) myView.findViewById(R.id.correoMeEditText);
        telefonoMeEditText = (EditText) myView.findViewById(R.id.telefonoMeEditText);

        cameraMeImageView=(ImageView) myView.findViewById(R.id.cameraMeImageView);
        capturarFotoMeButton = (Button)myView.findViewById(R.id.capturarFotoMeButton);

        capturarFotoMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id;
                id= view.getId();
                switch (id){
                    case R.id.capturarFotoMeButton:
                        Intent camera_intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(camera_intent,CAM_REQUEST);
                        //File file=getFile();
                        //camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                        break;
                }
            }
        });




        //METODO ONCLICK DEL BOTON ACTUALIZAR DATOS MEDICO
        actualizarDatosMeButton = (Button)myView.findViewById(R.id.actualizarDatosMeButton);
        actualizarDatosMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                idmedico= 4;  //ESTE CAMPO ESTA EN DURO
                password = passwordMeEditText.getText().toString();
                direccion = direccionMeEditText.getText().toString();
                correo = correoMeEditText.getText().toString();
                telefono = telefonoMeEditText.getText().toString();

                //NOTA:ESTA EN DURO EL ID DEL MEDICO...!!!
                //updateUsuarioMedico(idmedico,password,direccion,correo,telefono);
                new HttpAsyncTask().execute(LabOnTimeService.UPDATE_DATOS_MEDICO);

            }
        });



        return  myView;

    }

    //AQUI LLEGAN LOS PARAMETROS PARA HACER EL INSERT
    public  void updateUsuarioMedico(int idpaciente ,String password, String direccion, String correo, String telefono){

       // User userEntity= new User();
            AndroidNetworking.post(LabOnTimeService.UPDATE_DATOS_MEDICO)
                    .addBodyParameter("id", "4")
                    .addBodyParameter("password", password)
                    .addBodyParameter("address", direccion)
                    .addBodyParameter("email", correo)
                    .addBodyParameter("phone", telefono)
                    .setTag(TAG)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                jsonObject = response.getJSONObject("responseBD");
                                Log.d(TAG, jsonObject.getString("estado").toString());
                                boolean estado = jsonObject.getBoolean("estado");
                                if(estado){

                                }else{
                                    String msj = jsonObject.getString("mensaje").toString();
                                }

                            }catch (JSONException e) {
                                e.printStackTrace();
                            }



                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    });



    }



    private File getFile(){
        File folder =new File("sdcard/camera_app");
        if(!folder.exists()){
            folder.mkdir();
        }
        File image_file =new File(folder,"cam_image.jpg");
        return  image_file;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==Activity.RESULT_OK){
            Bundle ext=data.getExtras();
            bmp =(Bitmap)ext.get("data");
            cameraMeImageView.setImageBitmap(bmp);
        }

        //String path="sdcard/camera_app/cam_image.jpg";
        //cameraImageView.setImageDrawable(Drawable.createFromPath(path));

    }



    public static String POST(String url, User user){
        InputStream inputStream = null;
        String result = "";
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", user.getId());
            jsonObject.accumulate("password", user.getPassword());
            jsonObject.accumulate("address", user.getAddress());
            jsonObject.accumulate("email", user.getEmail());
            jsonObject.accumulate("phone", user.getPhone());

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        // 11. return result
        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            user = new User();
            user.setId(4);
            user.setPassword(password);
            user.setAddress(direccion);
            user.setEmail(correo);
            user.setPhone(telefono);

            return POST(urls[0],user);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getActivity().getBaseContext(), "Data Sent!", Toast.LENGTH_LONG).show();
        }
    }


}
