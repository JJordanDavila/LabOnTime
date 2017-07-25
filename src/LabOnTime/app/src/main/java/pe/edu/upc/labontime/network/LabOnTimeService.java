package pe.edu.upc.labontime.network;

import pe.edu.upc.labontime.models.AnalisisMedico;

/**
 * Created by hp on 15/07/2017.
 */

public class LabOnTimeService {
     public static String LOGIN_URL = "http://labontime.somee.com/api/Login/ValidateUser";
     public static String ANALISIS_LABORATORIO_URL = "http://labontime.somee.com/api/LaboratoryAnalysis/GetLaboratoryAnalysis";
     public static String UPDATE_DATOS_MEDICO = "http://labontime.somee.com/api/Login/UpdateUser";

     private AnalisisMedico currentanalisisMedico;

     public AnalisisMedico getCurrentAnalisisMedico() {
          return currentanalisisMedico;
     }

     public void setCurrentSource(AnalisisMedico currentanalisisMedico) {
          this.currentanalisisMedico = currentanalisisMedico;
     }




}
