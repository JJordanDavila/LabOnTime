package pe.edu.upc.labontime.services;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.labontime.R;
import pe.edu.upc.labontime.beans.AnalisisPaciente;

public class AnalisisPacienteService {
    private List<AnalisisPaciente> listaAnalisisPaciente;
    public  List<AnalisisPaciente> getListaAnalisisPaciente(){return listaAnalisisPaciente;}


    public AnalisisPacienteService(Context context)
    {
        Resources res = context.getResources();
        listaAnalisisPaciente = new ArrayList<>();
        listaAnalisisPaciente.add(new AnalisisPaciente(res.getString(R.string.name_software),
                res.getString(R.string.title_software),
                res.getString(R.string.company_software),
                res.getString(R.string.bio_software),
                R.drawable.orina));
        listaAnalisisPaciente.add(new AnalisisPaciente(res.getString(R.string.name_hardware),
                res.getString(R.string.title_hardware),
                res.getString(R.string.company_hardware),
                res.getString(R.string.bio_hardware),
                R.drawable.heces));
        listaAnalisisPaciente.add(new AnalisisPaciente(res.getString(R.string.name_office),
                res.getString(R.string.title_office),
                res.getString(R.string.company_office),
                res.getString(R.string.bio_office),
                R.drawable.sangre));;
        listaAnalisisPaciente.add(new AnalisisPaciente(res.getString(R.string.name_estructura),
                res.getString(R.string.title_estructura),
                res.getString(R.string.company_estructura),
                res.getString(R.string.bio_esturctura),
                R.drawable.corazon));
    }



}
