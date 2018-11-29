/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.json.JsonObject;

/**
 *
 * @author raguileoam
 */
public class AreasVerdes {
    private JsonObject features;
    private double area;

    public AreasVerdes(JsonObject jsonObject ) {
    this.features=jsonObject;
    JsonObject properties=features.getJsonObject("properties");
    this.area=properties.getJsonNumber("AREA").doubleValue();
    }

    @Override
    public String toString() {
        return features.toString();
    }

    public double getArea() {
        return area;
    }
    
}
