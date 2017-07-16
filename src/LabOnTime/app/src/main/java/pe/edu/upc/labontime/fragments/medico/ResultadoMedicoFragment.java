package pe.edu.upc.labontime.fragments.medico;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.labontime.JSONfunctions;
import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.beans.Laboratory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoMedicoFragment extends Fragment {

    JSONObject jsonobject;
    JSONArray jsonarray;
    ProgressDialog mProgressDialog;
    ArrayList<String> laborarorylist;
    ArrayList<Laboratory> laboratoy;
    Spinner spinner ;
    String[] colors = new String[] {"azul", "amarillo", "verde"};
    private String URL_LISTA_LABORATORIO = "http://localhost:52708/api/Laboratorys/GetLaboratory/?filter=0";

    public ResultadoMedicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_resultado_medico,container,false);
        return myView;
        //return inflater.inflate(R.layout.fragment_resultado_medico, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new LllenarSpinnerLaboratorio().execute();
    }

    // Download JSON file AsyncTask
    private class LllenarSpinnerLaboratorio extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the WorldPopulation Class
            laboratoy = new ArrayList<Laboratory>();
            // Create an array to populate the spinner
            laborarorylist = new ArrayList<String>();
            // JSON file URL address
            jsonobject = JSONfunctions.getJSONfromURL("http://labontime.somee.com/api/Laboratorys/GetLaboratorys/?filter=0");

            try {
                // Locate the NodeList name
                jsonarray = jsonobject.getJSONArray("laboratory");
                for (int i = 0; i < jsonarray.length(); i++) {
                    jsonobject = jsonarray.getJSONObject(i);

                    Laboratory worldpop = new Laboratory();

                    worldpop.setId(jsonobject.optInt("id"));
                    worldpop.setName(jsonobject.optString("name"));
                    worldpop.setDescription(jsonobject.optString("description"));
                    laboratoy.add(worldpop);

                    // Populate spinner with country names
                    laborarorylist.add(jsonobject.optString("name"));

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
            spinner = (Spinner) getView().findViewById(R.id.spinLaboratorios);
            ArrayAdapter<String> spinnerArrayAdapter =
                    new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, laborarorylist);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerArrayAdapter);


        }
    }






}
