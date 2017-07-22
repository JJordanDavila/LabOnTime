package pe.edu.upc.labontime.fragments.paciente;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pe.edu.upc.labontime.R;


public class ConfiguracionPacienteFragment extends Fragment {

    EditText passwordPaEditText;
    EditText direccionPaEditText;
    EditText correoPaEditText;
    EditText telefonoPaEditText;
    Button actualizarDatosPaButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_configuracion_paciente, container, false);
        View myView = inflater.inflate(R.layout.fragment_configuracion_paciente,container,false);

        passwordPaEditText = (EditText) myView.findViewById(R.id.passwordPaEditText);
        direccionPaEditText = (EditText) myView.findViewById(R.id.direccionPaEditText);
        correoPaEditText = (EditText) myView.findViewById(R.id.correoPaEditText);
        telefonoPaEditText = (EditText) myView.findViewById(R.id.telefonoPaEditText);

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

}
