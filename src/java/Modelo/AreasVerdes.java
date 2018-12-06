/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 *
 * @author raguileoam
 */
public class AreasVerdes {
    private JsonObject features;
    private double area;
    private Object[] coords;

    public AreasVerdes(JsonObject jsonObject ) {
    this.features=jsonObject;
    JsonObject properties=features.getJsonObject("properties");
    this.area=properties.getJsonNumber("AREA").doubleValue();
    JsonArray coordsJson = features.getJsonObject("geometry").getJsonArray("coordinates").getJsonArray(0).getJsonArray(0);
    coords=coordsJson.toArray();
    }

    @Override
    public String toString() {
        return features.toString();
    }
    
  
    public double getArea() {
        return area;
    }

    public Object[] getCoords() {
        return coords;
    }
    
    
}
