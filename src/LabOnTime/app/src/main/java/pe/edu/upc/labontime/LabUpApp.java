package pe.edu.upc.labontime;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.models.AnalisisPaciente;
import pe.edu.upc.labontime.network.LabOnTimeService;

public class LabUpApp extends Application {

    private LabOnTimeService labOnTimeService;
    private static LabUpApp instance;

    public LabUpApp(){
        super();
        instance=this;
    }

    public static LabUpApp getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        labOnTimeService = new LabOnTimeService();
    }

    public AnalisisMedico getCurrentAnalisisMedico() {
        return labOnTimeService.getCurrentAnalisisMedico();
    }

    public LabUpApp setCurrentAnalisisMedico(AnalisisMedico analisisMedico) {
        labOnTimeService.setCurrentAnalisisMedico(analisisMedico);
        return this;
    }

    public AnalisisPaciente getCurrentAnalisisPaciente() {
        return labOnTimeService.getCurrentanalisisPaciente();
    }

    public LabUpApp setCurrentAnalisisPaciente(AnalisisPaciente analisisPaciente) {
        labOnTimeService.setCurrentanalisisPaciente(analisisPaciente);
        return this;
    }


}
