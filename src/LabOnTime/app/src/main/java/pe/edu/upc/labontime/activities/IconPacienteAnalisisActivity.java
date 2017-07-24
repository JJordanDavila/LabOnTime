package pe.edu.upc.labontime.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pe.edu.upc.labontime.R;

public class IconPacienteAnalisisActivity extends AppCompatActivity {

    Button grabarValoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_paciente_analisis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        grabarValoracion = (Button) findViewById(R.id.grabarValoracionButton);
        grabarValoracion.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            Toast.makeText(getApplicationContext(),
                    "Se envio su valoracion Gracias XD...",Toast.LENGTH_SHORT).show();

        }
        });

    }




}
