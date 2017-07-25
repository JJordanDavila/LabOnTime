package pe.edu.upc.labontime.fragments.medico;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.Analysis;
import pe.edu.upc.labontime.models.ResponseBD01;
import pe.edu.upc.labontime.models.User;
import pe.edu.upc.labontime.network.LabOnTimeService;
import pe.edu.upc.labontime.services.LoginService;
import pe.edu.upc.labontime.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracionMedicoFragment extends Fragment {

    public static String TAG = "LabOnTimeApp";
    //List<AnalisisMedico> analisisMedicos;
    //User userEntity= new User();
    ResponseBD01 entityResponseBD01= new ResponseBD01();
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
    JSONObject jsonobjectUpdateMedico;
    JSONArray jsonarrayUpdateMedico;;
    ArrayList<String> analysislist;
    ArrayList<Analysis> analysis;


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
               //new HttpAsyncTask().execute(LabOnTimeService.UPDATE_DATOS_MEDICO);

                try{
                    //ActualizarMedico();
                    updateUsuarioMedico(idmedico,password,direccion,correo,telefono);
                }
                catch(Exception ex)
                {

                }

            }
        });



        return  myView;

    }

    //AQUI LLEGAN LOS PARAMETROS PARA HACER EL INSERT
    public  void updateUsuarioMedico(int idpaciente ,String password, String direccion, String correo, String telefono){

        LoginService loginService = ServiceGenerator.createService(LoginService.class);
        Call<ResponseBD01> call = loginService.getAccessToken(idpaciente, password, direccion, correo, telefono);


        call.enqueue(new Callback<ResponseBD01>() {

            @Override
            public void onResponse(Call<ResponseBD01> call, Response<ResponseBD01> response) {
//                     if (response.isSuccess()) {
                //WCB:Si el codigo es 200, actualizacion exitosa
                if (response.code() == 200) {
                    entityResponseBD01 = response.body();
                    // Toast.makeText(this,"entregado" , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBD01> call, Throwable t) {
                // something went completely south (like no internet connection)

                Log.d("Error", t.getMessage());
            }
        });

        /*
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
                    });*/



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

    public  void  ActualizarMedico()  throws UnsupportedEncodingException
    {

        String data = URLEncoder.encode("id", "UTF-8")
                + "=" + URLEncoder.encode(idmedico.toString(), "UTF-8");

        data += "&" + URLEncoder.encode("password", "UTF-8") + "="
                + URLEncoder.encode(password.toString(), "UTF-8");

        data += "&" + URLEncoder.encode("address", "UTF-8")
                + "=" + URLEncoder.encode(direccion.toString(), "UTF-8");

        data += "&" + URLEncoder.encode("email", "UTF-8")
                + "=" + URLEncoder.encode(correo.toString(), "UTF-8");

        data += "&" + URLEncoder.encode("phone", "UTF-8")
                + "=" + URLEncoder.encode(telefono.toString(), "UTF-8");

        String text = "";
        BufferedReader reader=null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL(LabOnTimeService.UPDATE_DATOS_MEDICO);

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();;
        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }


    }

}




