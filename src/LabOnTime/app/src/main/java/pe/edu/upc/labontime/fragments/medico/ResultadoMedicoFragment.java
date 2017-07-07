package pe.edu.upc.labontime.fragments.medico;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.labontime.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoMedicoFragment extends Fragment {


    public ResultadoMedicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado_medico, container, false);
    }

}
