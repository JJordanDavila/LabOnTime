package pe.edu.upc.labontime.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnalisisPaciente {

    private Integer id_medical_analisis;
    private Integer id_request_analisis;
    private String resultado_laboratorio;
    private String status_medical_analisis;
    private String diagnostico_medico;
    private String motivo_consulta_paciente;
    private Integer id_laboratorio;
    private String nombre_laboratorio;
    private Integer id_analisis;
    private String tipo_analisis;
    private Integer id_paciente;
    private String nombres_paciente;
    private Integer id_doctor;
    private String nombres_doctor;

    public AnalisisPaciente() {
    }

    public AnalisisPaciente(Integer id_medical_analisis, Integer id_request_analisis, String resultado_laboratorio, String status_medical_analisis, String diagnostico_medico, String motivo_consulta_paciente, Integer id_laboratorio, String nombre_laboratorio, Integer id_analisis, String tipo_analisis, Integer id_paciente, String nombres_paciente, Integer id_doctor, String nombres_doctor) {
        this.id_medical_analisis = id_medical_analisis;
        this.id_request_analisis = id_request_analisis;
        this.resultado_laboratorio = resultado_laboratorio;
        this.status_medical_analisis = status_medical_analisis;
        this.diagnostico_medico = diagnostico_medico;
        this.motivo_consulta_paciente = motivo_consulta_paciente;
        this.id_laboratorio = id_laboratorio;
        this.nombre_laboratorio = nombre_laboratorio;
        this.id_analisis = id_analisis;
        this.tipo_analisis = tipo_analisis;
        this.id_paciente = id_paciente;
        this.nombres_paciente = nombres_paciente;
        this.id_doctor = id_doctor;
        this.nombres_doctor = nombres_doctor;
    }

    public Integer getId_medical_analisis() {
        return id_medical_analisis;
    }

    public AnalisisPaciente setId_medical_analisis(Integer id_medical_analisis) {
        this.id_medical_analisis = id_medical_analisis;
        return this;
    }

    public Integer getId_request_analisis() {
        return id_request_analisis;
    }

    public AnalisisPaciente setId_request_analisis(Integer id_request_analisis) {
        this.id_request_analisis = id_request_analisis;
        return this;
    }

    public String getResultado_laboratorio() {
        return resultado_laboratorio;
    }

    public AnalisisPaciente setResultado_laboratorio(String resultado_laboratorio) {
        this.resultado_laboratorio = resultado_laboratorio;
        return this;
    }

    public String getStatus_medical_analisis() {
        return status_medical_analisis;
    }

    public AnalisisPaciente setStatus_medical_analisis(String status_medical_analisis) {
        this.status_medical_analisis = status_medical_analisis;
        return this;
    }

    public String getDiagnostico_medico() {
        return diagnostico_medico;
    }

    public AnalisisPaciente setDiagnostico_medico(String diagnostico_medico) {
        this.diagnostico_medico = diagnostico_medico;
        return this;
    }

    public String getMotivo_consulta_paciente() {
        return motivo_consulta_paciente;
    }

    public AnalisisPaciente setMotivo_consulta_paciente(String motivo_consulta_paciente) {
        this.motivo_consulta_paciente = motivo_consulta_paciente;
        return this;
    }

    public Integer getId_laboratorio() {
        return id_laboratorio;
    }

    public AnalisisPaciente setId_laboratorio(Integer id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
        return this;
    }

    public String getNombre_laboratorio() {
        return nombre_laboratorio;
    }

    public AnalisisPaciente setNombre_laboratorio(String nombre_laboratorio) {
        this.nombre_laboratorio = nombre_laboratorio;
        return this;
    }

    public Integer getId_analisis() {
        return id_analisis;
    }

    public AnalisisPaciente setId_analisis(Integer id_analisis) {
        this.id_analisis = id_analisis;
        return this;
    }

    public String getTipo_analisis() {
        return tipo_analisis;
    }

    public AnalisisPaciente setTipo_analisis(String tipo_analisis) {
        this.tipo_analisis = tipo_analisis;
        return  this;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public AnalisisPaciente setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
        return this;
    }

    public String getNombres_paciente() {
        return nombres_paciente;
    }

    public AnalisisPaciente setNombres_paciente(String nombres_paciente) {
        this.nombres_paciente = nombres_paciente;
        return this;
    }

    public Integer getId_doctor() {
        return id_doctor;
    }

    public AnalisisPaciente setId_doctor(Integer id_doctor) {
        this.id_doctor = id_doctor;
        return this;
    }

    public String getNombres_doctor() {
        return nombres_doctor;
    }

    public AnalisisPaciente setNombres_doctor(String nombres_doctor) {
        this.nombres_doctor = nombres_doctor;
        return this;
    }

    public static AnalisisPaciente build(JSONObject jsonAnalisisMedico) {
        AnalisisPaciente analisisPaciente = new AnalisisPaciente();
        try {
            analisisPaciente.setId_medical_analisis(jsonAnalisisMedico.getInt("id_medical_analisis"));
            analisisPaciente.setId_request_analisis(jsonAnalisisMedico.getInt("id_request_analisis"));
            analisisPaciente.setResultado_laboratorio(jsonAnalisisMedico.getString("resultado_laboratorio"));
            analisisPaciente.setStatus_medical_analisis(jsonAnalisisMedico.getString("status_laboratorio"));
            analisisPaciente.setDiagnostico_medico(jsonAnalisisMedico.getString("diagnostico_medico"));
            analisisPaciente.setMotivo_consulta_paciente(jsonAnalisisMedico.getString("motivo_consulta_paciente"));
            analisisPaciente.setId_laboratorio(jsonAnalisisMedico.getInt("id_laboratorio"));
            analisisPaciente.setNombre_laboratorio(jsonAnalisisMedico.getString("nombre_laboratorio"));
            analisisPaciente.setId_analisis(jsonAnalisisMedico.getInt("id_analisis"));
            analisisPaciente.setTipo_analisis(jsonAnalisisMedico.getString("tipo_analisis"));
            analisisPaciente.setId_paciente(jsonAnalisisMedico.getInt("id_paciente"));
            analisisPaciente.setNombres_paciente(jsonAnalisisMedico.getString("nombres_paciente"));
            analisisPaciente.setId_doctor(jsonAnalisisMedico.getInt("id_doctor"));
            analisisPaciente.setNombres_doctor(jsonAnalisisMedico.getString("nombres_doctor"));
            return analisisPaciente;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AnalisisPaciente buildObject(JSONObject jsonAnalisisMedico) {
        AnalisisPaciente analisisPaciente = new AnalisisPaciente();
        try {
            int length = 1;
            for (int i = 0; i < length; i++) {
                analisisPaciente.setId_medical_analisis(jsonAnalisisMedico.getInt("id_medical_analisis"));
                analisisPaciente.setId_request_analisis(jsonAnalisisMedico.getInt("id_request_analisis"));
                analisisPaciente.setResultado_laboratorio(jsonAnalisisMedico.getString("resultado_laboratorio"));
                analisisPaciente.setStatus_medical_analisis(jsonAnalisisMedico.getString("status_laboratorio"));
                analisisPaciente.setDiagnostico_medico(jsonAnalisisMedico.getString("diagnostico_medico"));
                analisisPaciente.setMotivo_consulta_paciente(jsonAnalisisMedico.getString("motivo_consulta_paciente"));
                analisisPaciente.setId_laboratorio(jsonAnalisisMedico.getInt("id_laboratorio"));
                analisisPaciente.setNombre_laboratorio(jsonAnalisisMedico.getString("nombre_laboratorio"));
                analisisPaciente.setId_analisis(jsonAnalisisMedico.getInt("id_analisis"));
                analisisPaciente.setTipo_analisis(jsonAnalisisMedico.getString("tipo_analisis"));
                analisisPaciente.setId_paciente(jsonAnalisisMedico.getInt("id_paciente"));
                analisisPaciente.setNombres_paciente(jsonAnalisisMedico.getString("nombres_paciente"));
                analisisPaciente.setId_doctor(jsonAnalisisMedico.getInt("id_doctor"));
                analisisPaciente.setNombres_doctor(jsonAnalisisMedico.getString("nombres_doctor"));

            }
            return analisisPaciente;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static List<AnalisisPaciente> buildList(JSONArray jsonAnalisisPaciente) {
        List<AnalisisPaciente> analisisPacientes = new ArrayList<>();
        int length = jsonAnalisisPaciente.length();
        for(int i = 0; i < length; i++)
            try {
                analisisPacientes.add(AnalisisPaciente.build(jsonAnalisisPaciente.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return analisisPacientes;
    }


}
