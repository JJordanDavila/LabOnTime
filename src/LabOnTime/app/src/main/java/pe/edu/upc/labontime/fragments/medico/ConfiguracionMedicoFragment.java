package pe.edu.upc.labontime.fragments.medico;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import pe.edu.upc.labontime.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracionMedicoFragment extends Fragment {

    EditText passwordMeEditText;
    EditText direccionMeEditText;
    EditText correoMeEditText;
    EditText telefonoMeEditText;
    Button actualizarDatosMeButton;

    //PARA LA CAMARA
    public  static  final  int CAM_REQUEST=1;
    ImageView cameraMeImageView;
    Button capturarFotoMeButton;
    Bitmap bmp;

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

                //NOTA:ESTA EN DURO EL ID DEL MEDICO...!!!
                updateUsuarioMedico(passwordMeEditText.getText().toString(),direccionMeEditText.getText().toString(),correoMeEditText.getText().toString(),telefonoMeEditText.getText().toString());

            }
        });



        return  myView;

    }

    //AQUI LLEGAN LOS PARAMETROS PARA HACER EL INSERT
    public  void updateUsuarioMedico(String password, String direccion, String correo, String telefono){
        //AGREGAR PARA QUE INSERTE METODO POST
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





}
