package pe.edu.upc.labontime.fragments.medico;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
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
    public  static  final  int REQUEST_CAPTURE=1;
    ImageView cameraImageView;
    Button capturarFotoButton;
    Intent intent;
    final  static int cons=0;
    Bitmap bmp;
    private File imageFile;

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

        cameraImageView=(ImageView) myView.findViewById(R.id.cameraImageView);
        capturarFotoButton = (Button)myView.findViewById(R.id.capturarFotoButton);

        capturarFotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // abrirCamera();

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


   public  void process(View view){
       Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       imageFile=new File(Environment
               .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
       Uri tempuri=Uri.fromFile(imageFile);
       intent.putExtra(MediaStore.EXTRA_OUTPUT,tempuri);
       intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
       startActivityForResult(intent,0);
   }

    public void abrirCamera(){
        intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getActivity();
        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {

        }
    }





}
