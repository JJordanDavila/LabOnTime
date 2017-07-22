package pe.edu.upc.labontime.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

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
import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.network.NewsApiService;

public class AnalisisMedicoActivity extends AppCompatActivity {


    List<AnalisisMedico> analisisMedicos;
    public static String TAG = "LabUpApp";
    RecyclerView analisisMedicoRecyclerView;
    AnalisisMedicoAdapter analisisMedicoAdapter;
    RecyclerView.LayoutManager analisisMedicoLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analisis_medico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        analisisMedicos = new ArrayList<>();
        analisisMedicoRecyclerView = (RecyclerView) findViewById(R.id.analisisMedicoRecyclerView);
        analisisMedicoAdapter = new AnalisisMedicoAdapter(analisisMedicos);
        analisisMedicoLayoutManager = new LinearLayoutManager(this);
        analisisMedicoRecyclerView.setAdapter(analisisMedicoAdapter);
        analisisMedicoRecyclerView.setLayoutManager(analisisMedicoLayoutManager);
        updateSources();

    }

    private void updateSources() {

        AndroidNetworking.get(NewsApiService.ANALISIS_PACIENTE_URL)
                .addPathParameter("laboratorio", "1")
                .addPathParameter("analisis", "1")
                .addPathParameter("paciente", "1")
                .addPathParameter("doctor", "1")
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            analisisMedicos = AnalisisMedico.build(response.getJSONArray("laboratoryAnalysis"));
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

    }

}
