package pe.edu.upc.labontime.network;

import pe.edu.upc.labontime.models.AnalisisMedico;
import pe.edu.upc.labontime.models.AnalisisPaciente;

/**
 * Created by hp on 15/07/2017.
 */

public class LabOnTimeService {
     public static String LOGIN_URL = "http://labontime.somee.com/api/Login/ValidateUser";
     public static String ANALISIS_LABORATORIO_URL = "http://labontime.somee.com/api/LaboratoryAnalysis/GetLaboratoryAnalysis";
     public static String ANALISIS_PACIENTE_URL = "http://labontime.somee.com/api/PatientAnalysis/GetPatientAnalysis";
     public static String UPDATE_DATOS_MEDICO = "http://labontime.somee.com/api/Login/UpdateUser";


     private AnalisisMedico currentanalisisMedico;
     private AnalisisPaciente currentanalisisPaciente;


     public AnalisisMedico getCurrentAnalisisMedico() {
          return currentanalisisMedico;
     }

     public void setCurrentAnalisisMedico(AnalisisMedico currentanalisisMedico) {
          this.currentanalisisMedico = currentanalisisMedico;
     }

     public AnalisisPaciente getCurrentanalisisPaciente() {
          return currentanalisisPaciente;
     }

     public void setCurrentanalisisPaciente(AnalisisPaciente currentanalisisPaciente) {
          this.currentanalisisPaciente = currentanalisisPaciente;
     }
}
