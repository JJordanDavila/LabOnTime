package pe.edu.upc.labontime.fragments.medico;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.labontime.JSONfunctions;
import pe.edu.upc.labontime.LabUpApp;
import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.adapters.AnalisisMedicoAdapter;
import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.models.Analysis;
import pe.edu.upc.labontime.models.Laboratory;
import pe.edu.upc.labontime.models.Patient;
import pe.edu.upc.labontime.network.LabOnTimeService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoMedicoFragment extends Fragment{

    public static String TAG = "LabOnTimeApp";
    List<AnalisisMedico> analisisMedicos;

    JSONObject jsonobjectLaboratory;
    JSONArray  jsonarrayLaboratory;
    ArrayList<String> laborarorylist;
    ArrayList<Laboratory> laboratoy;
    Spinner spinnerLaboratorio ;

    JSONObject jsonobjectPaciente;
    JSONArray  jsonarrayPaciente;
    ArrayList<String> patientlist;
    ArrayList<Patient> patient;
    Spinner spinnerPaciente ;

    JSONObject jsonobjectAnalisis;
    JSONArray  jsonarrayAnalisis;
    ArrayList<String> analysislist;
    ArrayList<Analysis> analysis;
    Spinner spinnerAnalysis ;

    JSONObject jsonobjectAnalisisMedico;
    JSONArray  jsonarrayAnalisisMedico;
    ArrayList<String> analysisMedicolist;
    //ArrayList<AnalisisMedico> analisisMedico;
    AnalisisMedico analisisMedico;

    String imc_met;
    Button buscarResultadoLabButton;


    Spinner idSpinnerLaboratorio;




    RecyclerView analisisMedicoRecyclerView;
    AnalisisMedicoAdapter analisisMedicoAdapter;
    RecyclerView.LayoutManager analisisMedicoLayoutManager;

    public ResultadoMedicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_resultado_medico,container,false);


        analisisMedicos = new ArrayList<>();
        analisisMedicoRecyclerView = (RecyclerView) myView.findViewById(R.id.analisisMedicoRecyclerView);
        analisisMedicoAdapter = new AnalisisMedicoAdapter(analisisMedicos);
        analisisMedicoLayoutManager = new LinearLayoutManager(getContext());
        analisisMedicoRecyclerView.setAdapter(analisisMedicoAdapter);
        analisisMedicoRecyclerView.setLayoutManager(analisisMedicoLayoutManager);
       // analisisMedico = LabUpApp.getInstance().getCurrentAnalisisMedico();


        buscarResultadoLabButton = (Button) myView.findViewById(R.id.buscarResultadosLabButton);
        buscarResultadoLabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buscarAnalisisMedico();

            }

        });

        return  myView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new LllenarSpinnerLaboratorios().execute();
        new LllenarSpinnerAnalisis().execute();
        new LllenarSpinnerPacientes().execute();

    }

    // Download JSON file AsyncTask
    private class LllenarSpinnerLaboratorios extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the WorldPopulation Class
            laboratoy = new ArrayList<Laboratory>();
            // Create an array to populate the spinner
            laborarorylist = new ArrayList<String>();
            // JSON file URL address
            jsonobjectLaboratory = JSONfunctions.getJSONfromURL("http://labontime.somee.com/api/Laboratorys/GetLaboratorys/?filter=0");

            try {
                // Locate the NodeList name
                jsonarrayLaboratory = jsonobjectLaboratory.getJSONArray("laboratory");
                for (int i = 0; i < jsonarrayLaboratory.length(); i++) {
                    jsonobjectLaboratory = jsonarrayLaboratory.getJSONObject(i);

                    Laboratory worldpop = new Laboratory();

                    worldpop.setId(jsonobjectLaboratory.optInt("id"));
                    worldpop.setName(jsonobjectLaboratory.optString("name"));
                    worldpop.setDescription(jsonobjectLaboratory.optString("description"));
                    laboratoy.add(worldpop);

                    // Populate spinner with country names
                    laborarorylist.add(jsonobjectLaboratory.optString("name"));

                }
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the spinner in activity_main.xml
            spinnerLaboratorio = (Spinner) getView().findViewById(R.id.spinLaboratorios);
            ArrayAdapter<String> spinnerArrayAdapter =
                    new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, laborarorylist);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerLaboratorio.setAdapter(spinnerArrayAdapter);

            // Spinner on item click listener

            spinnerLaboratorio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> arg0,
                                                   View arg1, int position, long arg3) {

                            //idSpinnerLaboratorio= (TextView)


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub
                        }
                    });


        }
    }

    private class LllenarSpinnerAnalisis extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the WorldPopulation Class
            analysis = new ArrayList<Analysis>();
            // Create an array to populate the spinner
            analysislist = new ArrayList<String>();
            // JSON file URL address
            jsonobjectAnalisis = JSONfunctions.getJSONfromURL("http://labontime.somee.com/api/Analysis/GetAnalysis/?filter=0");

            try {
                // Locate the NodeList name
                jsonarrayAnalisis = jsonobjectAnalisis.getJSONArray("analysis");
                for (int i = 0; i < jsonarrayAnalisis.length(); i++) {
                    jsonobjectAnalisis = jsonarrayAnalisis.getJSONObject(i);

                    Analysis worldpop = new Analysis();

                    worldpop.setId(jsonobjectAnalisis.optInt("id"));
                    worldpop.setName(jsonobjectAnalisis.optString("name"));
                    analysis.add(worldpop);


                    // Populate spinner with country names
                    analysislist.add(jsonobjectAnalisis.optString("name"));

                }
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the spinner in activity_main.xml
            spinnerAnalysis = (Spinner) getView().findViewById(R.id.spin_Tipo_Analisis);
            ArrayAdapter<String> spinnerArrayAdapter =
                    new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, analysislist);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAnalysis.setAdapter(spinnerArrayAdapter);


        }
    }

    private class LllenarSpinnerPacientes extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the WorldPopulation Class
            patient = new ArrayList<Patient>();
            // Create an array to populate the spinner
            patientlist = new ArrayList<String>();
            // JSON file URL address
            jsonobjectPaciente = JSONfunctions.getJSONfromURL("http://labontime.somee.com/api/Patients/GetPatients/?filter=0");

            try {
                // Locate the NodeList name
                jsonarrayPaciente = jsonobjectPaciente.getJSONArray("patients");
                for (int i = 0; i < jsonarrayPaciente.length(); i++) {
                    jsonobjectPaciente = jsonarrayPaciente.getJSONObject(i);

                    Patient worldpop = new Patient();

                    worldpop.setId(jsonobjectPaciente.optInt("idPerson"));
                    worldpop.setNames(jsonobjectPaciente.optString("names"));
                    worldpop.setLastname(jsonobjectPaciente.optString("lastnames"));
                    patient.add(worldpop);


                    // Populate spinner with country names
                    patientlist.add(jsonobjectPaciente.optString("names")+" "+jsonobjectPaciente.optString("lastnames"));

                }
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the spinner in activity_main.xml
            spinnerPaciente = (Spinner) getView().findViewById(R.id.spin_Pacientes);
            ArrayAdapter<String> spinnerArrayAdapter =
                    new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, patientlist);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPaciente.setAdapter(spinnerArrayAdapter);


        }
    }

    private void buscarAnalisisMedico() {
        try {

            AndroidNetworking.get(LabOnTimeService.ANALISIS_LABORATORIO_URL)
                    .addQueryParameter("laboratorio","0")
                    .addQueryParameter("analisis"   ,"0")
                    .addQueryParameter("paciente"   ,"0")
                    .addQueryParameter("doctor"     ,"0")
                    .setTag(TAG)
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                analisisMedicos = AnalisisMedico.buildList(response.getJSONArray("laboratoryAnalysis"));
                                Log.d(TAG, "Found Analisis Medico: " + String.valueOf(analisisMedicos.size()));
                                analisisMedicoAdapter.setAnalisisMedicoAdapter(analisisMedicos);
                                analisisMedicoAdapter.notifyDataSetChanged();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    });


        } catch (Exception e)
        {
                e.printStackTrace();
        }

    }
}
