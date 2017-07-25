
package pe.edu.upc.labontime.models;

import java.util.HashMap;
import java.util.Map;


public class ResponseBD {


    private Boolean estado;

    private Object mensaje;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Boolean getEstado() {
        return estado;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public Object getMensaje() {
        return mensaje;
    }


    public void setMensaje(Object mensaje) {
        this.mensaje = mensaje;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
