package pe.edu.upc.labontime.fragments.paciente;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
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

import java.io.File;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.ResponseBD01;
import pe.edu.upc.labontime.models.User;
import pe.edu.upc.labontime.services.LoginService;
import pe.edu.upc.labontime.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConfiguracionPacienteFragment extends Fragment {

    EditText passwordPaEditText;
    EditText direccionPaEditText;
    EditText correoPaEditText;
    EditText telefonoPaEditText;
    Button actualizarDatosPaButton;

    private  static Integer idpaciente;
    private  static String password ;
    private  static String direccion ;
    private  static String correo ;
    private  static String telefono ;

    User entityUser = new User();
    ResponseBD01 entityResponseBD01= new ResponseBD01();


    //PARA LA CAMARA
    public  static  final  int CAM_REQUEST=1;
    ImageView cameraPaImageView;
    Button capturarFotoPaButton;
    Bitmap bmp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_configuracion_paciente, container, false);
        View myView = inflater.inflate(R.layout.fragment_configuracion_paciente,container,false);

        Bundle bundle = getActivity().getIntent().getExtras();
        //CAPUTARANDO EL ID DE LA PACIENTE
        entityUser.setId(bundle.getInt("id"));   //IDPACIENTE


        passwordPaEditText = (EditText) myView.findViewById(R.id.passwordPaEditText);
        direccionPaEditText = (EditText) myView.findViewById(R.id.direccionPaEditText);
        correoPaEditText = (EditText) myView.findViewById(R.id.correoPaEditText);
        telefonoPaEditText = (EditText) myView.findViewById(R.id.telefonoPaEditText);



        cameraPaImageView=(ImageView) myView.findViewById(R.id.cameraPaImageView);
        capturarFotoPaButton = (Button)myView.findViewById(R.id.capturarFotoPaButton);

        capturarFotoPaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id;
                id= view.getId();
                switch (id){
                    case R.id.capturarFotoPaButton:
                        Intent camera_intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(camera_intent,CAM_REQUEST);
                        //File file=getFile();
                        //camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                        break;
                }
            }
        });

        //METODO ONCLICK DEL BOTON ACTUALIZAR DATOS PACIENTE
        actualizarDatosPaButton = (Button)myView.findViewById(R.id.actualizarDatosPaButton);
        actualizarDatosPaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              idpaciente= 2;  //ESTE CAMPO ESTA EN DURO
              password = passwordPaEditText.getText().toString();
              direccion = direccionPaEditText.getText().toString();
              correo = correoPaEditText.getText().toString();
              telefono = telefonoPaEditText.getText().toString();

                try{
                    //ActualizarMedico();
                    updateUsuarioPacinente(idpaciente,password,direccion,correo,telefono);
                    Toast.makeText(getActivity(),"Se actualizaron los datos del paciente..!",Toast.LENGTH_SHORT).show();
                }
                catch(Exception ex)
                {

                }



            }
        });

        return  myView;
    }


    //AQUI LLEGAN LOS PARAMETROS PARA HACER EL INSERT
    public  void updateUsuarioPacinente(int id,String password, String direccion, String correo, String telefono){
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
        if(resultCode== Activity.RESULT_OK){
            Bundle ext=data.getExtras();
            bmp =(Bitmap)ext.get("data");
            cameraPaImageView.setImageBitmap(bmp);
        }

        //String path="sdcard/camera_app/cam_image.jpg";
        //cameraImageView.setImageDrawable(Drawable.createFromPath(path));

    }



}
