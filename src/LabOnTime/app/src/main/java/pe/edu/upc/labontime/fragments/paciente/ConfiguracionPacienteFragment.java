package pe.edu.upc.labontime.fragments.paciente;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

import pe.edu.upc.labontime.R;


public class ConfiguracionPacienteFragment extends Fragment {

    EditText passwordPaEditText;
    EditText direccionPaEditText;
    EditText correoPaEditText;
    EditText telefonoPaEditText;
    Button actualizarDatosPaButton;

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

                //NOTA:ESTA EN DURO EL ID DEL PACIENTE...!!!
                updateUsuarioPacinente(2,passwordPaEditText.getText().toString(),direccionPaEditText.getText().toString(),correoPaEditText.getText().toString(),telefonoPaEditText.getText().toString());
            }
        });

        return  myView;
    }


    //AQUI LLEGAN LOS PARAMETROS PARA HACER EL INSERT
    public  void updateUsuarioPacinente(int id,String password, String direccion, String correo, String telefono){
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
        if(resultCode== Activity.RESULT_OK){
            Bundle ext=data.getExtras();
            bmp =(Bitmap)ext.get("data");
            cameraPaImageView.setImageBitmap(bmp);
        }

        //String path="sdcard/camera_app/cam_image.jpg";
        //cameraImageView.setImageDrawable(Drawable.createFromPath(path));

    }



}
