package pe.edu.upc.labontime.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.upc.labontime.LabUpApp;
import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.models.AnalisisPaciente;

public class IconPacienteAnalisisActivity extends AppCompatActivity {

    Button grabarValoracion;

    TextView tipoAnalisisPaTextView;
    TextView nombrePacientePaTextView;
    TextView nombreLaboratorioPaTextView;
    TextView nombreMedicoPaTextView;
    TextView motivoConsultaPaTextView;
    TextView resultadoAnalisisLabTextView;
    TextView diagnosticoMedicoPaEditText;
    AnalisisPaciente analisisPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_paciente_analisis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        analisisPaciente= LabUpApp.getInstance().getCurrentAnalisisPaciente();

        tipoAnalisisPaTextView = (TextView) findViewById(R.id.tipoAnalisisPaTextView);
        nombrePacientePaTextView= (TextView) findViewById(R.id.nombrePacientePaTextView);
        nombreLaboratorioPaTextView = (TextView) findViewById(R.id.nombreLaboratorioPaTextView);
        nombreMedicoPaTextView = (TextView) findViewById(R.id.nombreMedicoPaTextView);
        motivoConsultaPaTextView = (TextView) findViewById(R.id.motivoConsultaPaTextView);
        resultadoAnalisisLabTextView = (TextView) findViewById(R.id.resultadoAnalisisLabTextView);
        diagnosticoMedicoPaEditText = (TextView) findViewById(R.id.diagnosticoMedicoPaEditText);


        tipoAnalisisPaTextView.setText(analisisPaciente.getTipo_analisis());
        nombrePacientePaTextView.setText(analisisPaciente.getNombres_paciente());
        nombreLaboratorioPaTextView.setText(analisisPaciente.getNombre_laboratorio());
        nombreMedicoPaTextView.setText(analisisPaciente.getNombres_doctor());
        motivoConsultaPaTextView.setText(analisisPaciente.getMotivo_consulta_paciente());
        resultadoAnalisisLabTextView.setText(analisisPaciente.getResultado_laboratorio());
        diagnosticoMedicoPaEditText.setText(analisisPaciente.getTipo_analisis());


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
