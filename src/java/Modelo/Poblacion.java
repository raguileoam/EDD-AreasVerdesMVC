/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;
import javax.json.JsonObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author raguileoam
 */
public class Poblacion {

    private JsonObject features;
    private int personas;
    private double shape_Area;
    private Object[] coords;
    private String distrito;
    private String macroSector;
    public JSONObject obj;
    private Double av_habitante;

    public Double getAv_habitante() {
        return av_habitante;
    }

    public void setAv_habitante(Double av_habitante) {
        this.av_habitante = av_habitante;
        JSONObject prop=(JSONObject)obj.get("properties");
        prop.put("AV_HABITANTE", av_habitante);
    }

    public Poblacion(JsonObject jsonObject) {
        this.features = jsonObject;
        JsonObject properties = features.getJsonObject("properties");
        this.personas = properties.getJsonNumber("PERSONAS").intValue();
        this.shape_Area = properties.getJsonNumber("Shape__Area").doubleValue();
        distrito = properties.getJsonString("DISTRITO").getString();
        JsonArray coordsJson = features.getJsonObject("geometry").getJsonArray("coordinates").getJsonArray(0).getJsonArray(0);
        coords = coordsJson.toArray();
        HashMap<String, String> map = configMacro();
        if (map.containsKey(distrito)) {
            this.macroSector = map.get(distrito);//properties.getJsonString("MACRO_SECTOR").getString();
        }

        try {
            JSONParser jSONParser = new JSONParser();
            obj = (JSONObject) jSONParser.parse(jsonObject.toString());
            JSONObject prop = (JSONObject) obj.get("properties");
            prop.put("MACRO_SECTOR", getMacroSector());
            HashMap<String, Double> configAV_Hab=configAV_Hab();
            if (configAV_Hab.containsKey(getMacroSector())) {
                    setAv_habitante(configAV_Hab.get(getMacroSector()));//properties.getJsonString("AV_HABITANTE").getString();
        }
        
        } catch (ParseException ex) {
            Logger.getLogger(Poblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public HashMap<String, String> configMacro() {
        HashMap<String, String> map = new HashMap<>();
        //key:distrito-calle-direccion	value:macrosector
        map.put("TROMÉN", "Pedro de Valdivia");
        map.put("RALUNCOYÁN", "Pedro de Valdivia");
        map.put("SAN CARLOS", "Poniente");
        map.put("PUEBLO NUEVO", "Pueblo Nuevo");
        map.put("ESTERO COIHUECO", "El Carmen");
        map.put("JAVIERA CARRERA", "Poniente");
        map.put("SANTA ROSA", "Costanera Cautín");
        map.put("CENTRO", "Centro");
        map.put("ESTADIO MUNICIPAL", "Poniente");
        map.put("SANTA ELENA", "Amanecer");
        map.put("CAUPOLICAN", "Centro");
        map.put("LABRANZA", "Labranza");
        map.put("LANÍN", "Pedro de Valdivia");
        map.put("AVENIDA ALEMANIA", "Poniente");
        map.put("ÑIELOL", "Centro");

        return map;
    }

    public HashMap<String, Double> configAV_Hab() {
        HashMap<String, Double> map = new HashMap<>();
        //key:macrosector value:av por hab
        map.put("Poniente", 14.83);
        map.put("Centro", 10.44);
        map.put("Pueblo Nuevo", 8.02);
        map.put("Amanecer", 7.44);
        map.put("Costanera Cautín", 6.83);
        map.put("El Carmen", 6.83);
        map.put("Pedro de Valdivia", 4.98);
        map.put("Labranza", 7.75);

        return map;
    }

    public String getMacroSector() {
        return macroSector;
    }

    public String getDistrito() {
        return distrito;
    }

    @Override
    public String toString() {
        return obj.toJSONString();
    }

    public int getPersonas() {
        return personas;
    }

    public double getShape_Area() {
        return shape_Area;
    }

    public Object[] getCoords() {
        return coords;
    }
}
