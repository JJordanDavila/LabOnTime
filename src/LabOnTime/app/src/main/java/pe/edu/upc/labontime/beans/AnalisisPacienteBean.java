package pe.edu.upc.labontime.beans;


public class AnalisisPacienteBean {

    private String nombreAnalisis;
    private String descripcionAnalisis;
    private String laboratorio;
    private String resultadoAnalisis;
    private int pictureId;

    public AnalisisPacienteBean(String nombreAnalisis, String descripcionAnalisis, String laboratorio, String resultadoAnalisis, int pictureId)
    {
        this.nombreAnalisis = nombreAnalisis;
        this.descripcionAnalisis = descripcionAnalisis;
        this.laboratorio = laboratorio;
        this.resultadoAnalisis = resultadoAnalisis;
        this.pictureId = pictureId;
    }

    public String getNombreAnalisis() {
        return nombreAnalisis;
    }

    public void setNombreAnalisis(String nombreAnalisis) {
        this.nombreAnalisis = nombreAnalisis;
    }

    public String getDescripcionAnalisis() {
        return descripcionAnalisis;
    }

    public void setDescripcionAnalisis(String descripcionAnalisis) {
        this.descripcionAnalisis = descripcionAnalisis;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getResultadoAnalisis() {
        return resultadoAnalisis;
    }

    public void setResultadoAnalisis(String resultadoAnalisis) {
        this.resultadoAnalisis = resultadoAnalisis;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }


}
