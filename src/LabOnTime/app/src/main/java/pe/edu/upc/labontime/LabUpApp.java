package pe.edu.upc.labontime;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import pe.edu.upc.labontime.models.AnalisisPaciente;
import pe.edu.upc.labontime.network.NewsApiService;

public class LabUpApp extends Application {

    private NewsApiService newsApiService;
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
        newsApiService = new NewsApiService();
    }

    public AnalisisPaciente getCurrentSource(){
        return newsApiService.getCurrentAnalisisPaciente();
    }

    public LabUpApp setCurrentSource(AnalisisPaciente analisisPaciente){
        newsApiService.setCurrentAnalisisPaciente(analisisPaciente);
        return this;
    }

}
