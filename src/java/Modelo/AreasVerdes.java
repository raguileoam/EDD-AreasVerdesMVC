/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 * Clase que representa y tiene datos de Areas Verdes,
 * @author raguileoam
 */
public class AreasVerdes {

    private JsonObject features;
    private double area;
    private String sector;
    public JsonArray coords;
    private String macroSector;
    private Double av_habitante;

    public AreasVerdes(JsonObject jsonObject) {
        this.features = jsonObject;
        JsonObject properties = features.getJsonObject("properties");
        this.area = properties.getJsonNumber("AREA").doubleValue();
        this.sector = properties.getJsonString("DISTRITO").getString();
        this.coords = features.getJsonObject("geometry").getJsonArray("coordinates");
        this.macroSector =properties.getJsonString("MACRO_SECTOR").getString();
        this.av_habitante=properties.getJsonNumber("AV_HABITANTE").doubleValue();
    }
    public Double getAv_habitante() {
        return av_habitante;
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

    public String getMacroSector() {
        return macroSector;
    }

    @Override
    public String toString() {
        return features.toString();
    }
}
