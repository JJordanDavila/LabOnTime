package pe.edu.upc.labontime.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upc.labontime.network.ClearbitLogoService;

public class AnalisisMedico {

    int id_medical_analisis;
    int id_request_analisis;
    String  resultado_laboratorio;
    String status_laboratorio;
    String motivo_consulta_paciente;
    int id_laboratorio;
    String nombre_laboratorio;
    int id_analisis;
    String tipo_analisis;
    int id_paciente;
    String nombres_paciente;
    int id_doctor;
    String nombres_doctor;



    public AnalisisMedico() {
    }

    public AnalisisMedico(int id_medical_analisis,int id_request_analisis, String resultado_laboratorio, String status_laboratorio, String motivo_consulta_paciente, int id_laboratorio, String nombre_laboratorio, int id_analisis, String tipo_analisis, int id_paciente, String nombres_paciente, int id_doctor, String nombres_doctor, Map<String, String> urlsToLogos, List<String> sortBysAvailable, String url) {
        this.id_medical_analisis=id_medical_analisis;
        this.id_request_analisis = id_request_analisis;
        this.resultado_laboratorio = resultado_laboratorio;
        this.status_laboratorio = status_laboratorio;
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

    public int getId_request_analisis() {
        return id_request_analisis;
    }

    public AnalisisMedico setId_request_analisis(int id_request_analisis) {
        this.id_request_analisis = id_request_analisis;
        return  this;
    }

    public String getResultado_laboratorio() {
        return resultado_laboratorio;
    }

    public AnalisisMedico setResultado_laboratorio(String resultado_laboratorio) {
        this.resultado_laboratorio = resultado_laboratorio;
        return  this;
    }

    public String getStatus_laboratorio() {
        return status_laboratorio;
    }

    public AnalisisMedico setStatus_laboratorio(String status_laboratorio) {
        this.status_laboratorio = status_laboratorio;
        return  this;
    }

    public String getMotivo_consulta_paciente() {
        return motivo_consulta_paciente;
    }

    public AnalisisMedico setMotivo_consulta_paciente(String motivo_consulta_paciente) {
        this.motivo_consulta_paciente = motivo_consulta_paciente;
        return  this;
    }

    public int getId_laboratorio() {
        return id_laboratorio;
    }

    public AnalisisMedico setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
        return  this;
    }

    public String getNombre_laboratorio() {
        return nombre_laboratorio;
    }

    public AnalisisMedico setNombre_laboratorio(String nombre_laboratorio) {
        this.nombre_laboratorio = nombre_laboratorio;
        return  this;
    }

    public int getId_analisis() {
        return id_analisis;
    }

    public AnalisisMedico setId_analisis(int id_analisis) {
        this.id_analisis = id_analisis;
        return  this;
    }

    public String getTipo_analisis() {
        return tipo_analisis;
    }

    public AnalisisMedico setTipo_analisis(String tipo_analisis) {
        this.tipo_analisis = tipo_analisis;
        return  this;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public AnalisisMedico setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
        return  this;
    }

    public String getNombres_paciente() {
        return nombres_paciente;
    }

    public AnalisisMedico setNombres_paciente(String nombres_paciente) {
        this.nombres_paciente = nombres_paciente;
        return  this;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public AnalisisMedico setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
        return  this;
    }

    public String getNombres_doctor() {
        return nombres_doctor;
    }

    public AnalisisMedico setNombres_doctor(String nombres_doctor) {
        this.nombres_doctor = nombres_doctor;
        return  this;
    }

    public int getId_medical_analisis() {
        return id_medical_analisis;
    }

    public AnalisisMedico setId_medical_analisis(int id_medical_analisis) {
        this.id_medical_analisis = id_medical_analisis;
        return  this;
    }

    public static AnalisisMedico build(JSONObject jsonAnalisisMedico) {
        AnalisisMedico analisisMedico = new AnalisisMedico();
        try {
            analisisMedico.setId_medical_analisis(jsonAnalisisMedico.getInt("id_medical_analisis"));
            analisisMedico.setId_request_analisis(jsonAnalisisMedico.getInt("id_request_analisis"));
            analisisMedico.setResultado_laboratorio(jsonAnalisisMedico.getString("resultado_laboratorio"));
            analisisMedico.setStatus_laboratorio(jsonAnalisisMedico.getString("status_laboratorio"));
            analisisMedico.setMotivo_consulta_paciente(jsonAnalisisMedico.getString("motivo_consulta_paciente"));
            analisisMedico.setId_laboratorio(jsonAnalisisMedico.getInt("id_laboratorio"));
            analisisMedico.setNombre_laboratorio(jsonAnalisisMedico.getString("nombre_laboratorio"));
            analisisMedico.setId_analisis(jsonAnalisisMedico.getInt("id_analisis"));
            analisisMedico.setTipo_analisis(jsonAnalisisMedico.getString("tipo_analisis"));
            analisisMedico.setId_paciente(jsonAnalisisMedico.getInt("id_paciente"));
            analisisMedico.setNombres_paciente(jsonAnalisisMedico.getString("nombres_paciente"));
            analisisMedico.setId_doctor(jsonAnalisisMedico.getInt("id_doctor"));
            analisisMedico.setNombres_doctor(jsonAnalisisMedico.getString("nombres_doctor"));
            return analisisMedico;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AnalisisMedico buildObject(JSONObject jsonAnalisisMedico) {
            AnalisisMedico analisisMedico = new AnalisisMedico();
        try {
            int length = 1;
            for (int i = 0; i < length; i++) {
                analisisMedico.setId_medical_analisis(jsonAnalisisMedico.getInt("id_medical_analisis"));
                analisisMedico.setId_request_analisis(jsonAnalisisMedico.getInt("id_request_analisis"));
                analisisMedico.setResultado_laboratorio(jsonAnalisisMedico.getString("resultado_laboratorio"));
                analisisMedico.setStatus_laboratorio(jsonAnalisisMedico.getString("status_laboratorio"));
                analisisMedico.setMotivo_consulta_paciente(jsonAnalisisMedico.getString("motivo_consulta_paciente"));
                analisisMedico.setId_laboratorio(jsonAnalisisMedico.getInt("id_laboratorio"));
                analisisMedico.setNombre_laboratorio(jsonAnalisisMedico.getString("nombre_laboratorio"));
                analisisMedico.setId_analisis(jsonAnalisisMedico.getInt("id_analisis"));
                analisisMedico.setTipo_analisis(jsonAnalisisMedico.getString("tipo_analisis"));
                analisisMedico.setId_paciente(jsonAnalisisMedico.getInt("id_paciente"));
                analisisMedico.setNombres_paciente(jsonAnalisisMedico.getString("nombres_paciente"));
                analisisMedico.setId_doctor(jsonAnalisisMedico.getInt("id_doctor"));
                analisisMedico.setNombres_doctor(jsonAnalisisMedico.getString("nombres_doctor"));

            }
            return analisisMedico;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static List<AnalisisMedico> buildList(JSONArray jsonAnalisisMedico) {
        List<AnalisisMedico> analisisMedicos = new ArrayList<>();
        int length = jsonAnalisisMedico.length();
        for(int i = 0; i < length; i++)
            try {
                analisisMedicos.add(AnalisisMedico.build(jsonAnalisisMedico.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return analisisMedicos;
    }



}


