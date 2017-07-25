package pe.edu.upc.labontime.fragments.paciente;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.adapters.AnalisisMedicoAdapter;
import pe.edu.upc.labontime.adapters.AnalisisPacienteAdapter;
import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.models.AnalisisPaciente;
import pe.edu.upc.labontime.network.LabOnTimeService;
import pe.edu.upc.labontime.services.AnalisisPacienteService;


public class ResultadoPacienteFragment extends Fragment {

    public static String TAG = "LabOnTimeApp";
    List<AnalisisPaciente> analisisPacientes;

    RecyclerView analisisPacienteRecyclerView;
    AnalisisPacienteAdapter analisisPacienteAdapter;
    RecyclerView.LayoutManager analisisPacienteLayoutManager;

    Button buscarResultadoMedLabButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_resultado_paciente,container,false); //este es el recyclerView
        Context context = myView.getContext();


        analisisPacientes = new ArrayList<>();
        analisisPacienteRecyclerView = (RecyclerView) myView.findViewById(R.id.analisisPacienteRecyclerView);
        analisisPacienteAdapter = new AnalisisPacienteAdapter(analisisPacientes);
        analisisPacienteLayoutManager = new LinearLayoutManager(getContext());
        analisisPacienteRecyclerView.setAdapter(analisisPacienteAdapter);
        analisisPacienteRecyclerView.setLayoutManager(analisisPacienteLayoutManager);



        updateAnalisisPaciente();

        return  myView;
    }

    private void updateAnalisisPaciente() {
        try {

            AndroidNetworking.get(LabOnTimeService.ANALISIS_PACIENTE_URL)
                    .addQueryParameter("paciente"   ,"0")
                    .setTag(TAG)
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                analisisPacientes = AnalisisPaciente.buildList(response.getJSONArray("patientAnalysisModel"));
                                Log.d(TAG, "Found Analisis Paciente: " + String.valueOf(analisisPacientes.size()));
                                analisisPacienteAdapter.setAnalisisPacienteAdapter(analisisPacientes);
                                analisisPacienteAdapter.notifyDataSetChanged();

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
