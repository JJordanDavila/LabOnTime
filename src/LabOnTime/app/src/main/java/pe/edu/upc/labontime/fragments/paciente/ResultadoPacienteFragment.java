package pe.edu.upc.labontime.fragments.paciente;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.adapters.AnalisisPacienteAdapter;
import pe.edu.upc.labontime.models.AnalisisPaciente;
import pe.edu.upc.labontime.services.AnalisisPacienteService;


public class ResultadoPacienteFragment extends Fragment {

    List<AnalisisPaciente> analisisPaciente;
    RecyclerView.LayoutManager pacienteLayoutManager;
    RecyclerView pacienteRecyclerView;
    AnalisisPacienteAdapter pacienteAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_resultado_paciente, container, false);//este es el recyclerView
        View myView = inflater.inflate(R.layout.fragment_resultado_paciente,container,false); //este es el recyclerView
        Context context = myView.getContext();


        AnalisisPacienteService service = new AnalisisPacienteService(context);
        analisisPaciente = service.getListaAnalisisPaciente();
        pacienteLayoutManager = new LinearLayoutManager(context);
        pacienteAdapter = new AnalisisPacienteAdapter();
        pacienteAdapter.setAnalisispaciente(analisisPaciente);
        pacienteRecyclerView = (RecyclerView) myView.findViewById(R.id.pacienteRecyclerView);
        pacienteRecyclerView.setLayoutManager(pacienteLayoutManager);
        pacienteRecyclerView.setAdapter(pacienteAdapter);

        return  myView;
    }

}
