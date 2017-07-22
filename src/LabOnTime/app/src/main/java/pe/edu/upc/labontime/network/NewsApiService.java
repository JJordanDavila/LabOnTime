package pe.edu.upc.labontime.network;

import pe.edu.upc.labontime.models.AnalisisPaciente;

public class NewsApiService
{
    public static String ANALISIS_PACIENTE_URL = "http://labontimegqb.somee.com/api/LaboratoryAnalysis/GetLaboratoryAnalysis";
  /*  public static String PACIENTE_URL = "http://localhost:52708/api/Persons/GetPersons/?filter=0";
    public static String LABORATORIO_URL = "http://localhost:52708/api/Laboratorys/GetLaboratory/?filter=0";*/

    private AnalisisPaciente currentAnalisisPaciente;

    public AnalisisPaciente getCurrentAnalisisPaciente() {
        return currentAnalisisPaciente;
    }

    public void setCurrentAnalisisPaciente(AnalisisPaciente currentAnalisisPaciente) {
        this.currentAnalisisPaciente = currentAnalisisPaciente;
    }
}
