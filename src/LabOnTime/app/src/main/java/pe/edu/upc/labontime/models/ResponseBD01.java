
package pe.edu.upc.labontime.models;

import java.util.HashMap;
import java.util.Map;


public class ResponseBD01 {


    private ResponseBD responseBD;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public ResponseBD getResponseBD() {
        return responseBD;
    }


    public void setResponseBD(ResponseBD responseBD) {
        this.responseBD = responseBD;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
