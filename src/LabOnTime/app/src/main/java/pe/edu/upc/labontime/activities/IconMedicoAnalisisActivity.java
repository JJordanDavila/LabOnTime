package pe.edu.upc.labontime.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import pe.edu.upc.labontime.LabUpApp;
import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.network.LabOnTimeService;

public class IconMedicoAnalisisActivity extends AppCompatActivity {

    TextView tipoAnalisisTextView;
    TextView nombrePacienteTextView;
    TextView nombreLaboratorioTextView;
    TextView nombreMedicoTextView;
    TextView motivoConsultaPacienteTextView;
    TextView resultadoAnalisisLaboratorioTextView;
    TextView diagnosticoMedicoEditText;
    AnalisisMedico analisisMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_medico_analisis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        analisisMedico= LabUpApp.getInstance().getCurrentAnalisisMedico();

        tipoAnalisisTextView = (TextView) findViewById(R.id.tipoAnalisisTextView);
        nombrePacienteTextView= (TextView) findViewById(R.id.nombrePacienteTextView);
        nombreLaboratorioTextView = (TextView) findViewById(R.id.nombreLaboratorioTextView);
        nombreMedicoTextView = (TextView) findViewById(R.id.nombreMedicoTextView);
        motivoConsultaPacienteTextView = (TextView) findViewById(R.id.motivoConsultaPacienteTextView);
        resultadoAnalisisLaboratorioTextView = (TextView) findViewById(R.id.motivoConsultaPacienteTextView);
        diagnosticoMedicoEditText = (TextView) findViewById(R.id.diagnosticoMedicoEditText);




        tipoAnalisisTextView.setText(analisisMedico.getTipo_analisis());
        nombrePacienteTextView.setText(analisisMedico.getNombres_paciente());
        nombreLaboratorioTextView.setText(analisisMedico.getNombre_laboratorio());
        nombreMedicoTextView.setText(analisisMedico.getNombres_doctor());
        motivoConsultaPacienteTextView.setText(analisisMedico.getMotivo_consulta_paciente());
        resultadoAnalisisLaboratorioTextView.setText(analisisMedico.getResultado_laboratorio());





    }

}
