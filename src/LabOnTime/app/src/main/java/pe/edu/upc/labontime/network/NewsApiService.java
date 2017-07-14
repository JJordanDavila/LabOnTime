package pe.edu.upc.labontime.network;

import pe.edu.upc.labontime.beans.AnalisisPaciente;

public class NewsApiService
{
    public static String ANALISIS_PACIENTE_URL = "AQUI VA URL PARA CONSUMIR ANALISIS PACIENTE";
    public static String PACIENTE_URL = "AQUI VA EL URL PARA CONSUMIR DATOS DEL PACIENTE";
    public static String LABORATORIO_URL = "AQUI VA EL URL PARA CONSUMIR DATOS DEL PACIENTE";

    private AnalisisPaciente currentAnalisisPaciente;

    public AnalisisPaciente getCurrentAnalisisPaciente() {
        return currentAnalisisPaciente;
    }

    public void setCurrentAnalisisPaciente(AnalisisPaciente currentAnalisisPaciente) {
        this.currentAnalisisPaciente = currentAnalisisPaciente;
    }
}
