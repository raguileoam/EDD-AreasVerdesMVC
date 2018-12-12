/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;
import javax.json.JsonArray;
import javax.json.JsonObject;
import org.json.simple.JSONObject;

/**
 *
 * @author raguileoam
 */
public class AreasVerdes {

    private JsonObject features;
    private double area;
    private String sector;
    public JsonArray coords;
    private String id;
    private String macroSector;

    public AreasVerdes(JsonObject jsonObject) {
        this.features = jsonObject;
        JsonObject properties = features.getJsonObject("properties");
        this.id = features.getJsonString("id").getString();
        this.area = properties.getJsonNumber("AREA").doubleValue() * 1000000;//cambio de unidades a las que tiene poblacion
        this.sector = properties.getJsonString("APELLIDO2").getString();//properties.getJsonString("DISTRITO").getString();
        this.coords = features.getJsonObject("geometry").getJsonArray("coordinates");
        HashMap<String, String> map = configMacro();
        if (map.containsKey(sector)) {
            this.macroSector = map.get(sector);//properties.getJsonString("MACRO_SECTOR").getString();
        }

    }

    public HashMap<String, String> configMacro() {
        HashMap<String, String> map = new HashMap<>();
        //key:distrito-calle-direccion	value:macrosector
        map.put("ALEMANIA", "Poniente");
        map.put("AQUELARRE", "Amanecer");
        map.put("AMANECER", "Amanecer");
        map.put("EL MAIPO", "Amanecer");
        map.put("EL CARMEN", "El Carmen");
        map.put("PEDRO DE VALDIVIA", "Pedro de Valdivia");
        map.put("LA FRONTERA", "Poniente");
        map.put("CENTRO", "Centro");
        map.put("PUEBLO NUEVO", "Pueblo Nuevo");
        map.put("COSTANERA DEL CAUTIN", "Costanera Cautín");
        map.put("LAS MARIPOSAS", "Pueblo Nuevo");
        map.put("PABLO NERUDA", "Poniente");
        map.put("MOP VIALIDAD", "Centro");
        return map;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public double getArea() {
        return area;
    }

    public JsonArray getCoords() {
        return coords;
    }

    public JSONObject getJsonString() {
        JSONObject json = new JSONObject();
        json.put("type", "Feature");
        json.put("id", id);
        json.put("geometry", getGeometry());
        json.put("properties", getProperties());
        return json;
    }

    public String getMacroSector() {
        return macroSector;
    }

    @Override
    public String toString() {
        return getJsonString().toString();

    }

    public JSONObject getGeometry() {
        JSONObject geometry = new JSONObject();
        geometry.put("coordinates", getCoords());
        geometry.put("type", "MultiPolygon");
        return geometry;

    }

    public JSONObject getProperties() {
        JSONObject properties = new JSONObject();
        properties.put("AREA", getArea());
        properties.put("DISTRITO", getSector());
        properties.put("MACRO_SECTOR", getMacroSector());
        return properties;
    }

}
