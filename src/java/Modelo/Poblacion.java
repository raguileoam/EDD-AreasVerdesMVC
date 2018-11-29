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
public class Poblacion {
    private JsonObject features;
    private int personas;
    private double shape_Area;

    public Poblacion(JsonObject jsonObject ) {
    this.features=jsonObject;
    JsonObject properties=features.getJsonObject("properties");
    this.personas = properties.getJsonNumber("PERSONAS").intValue();
    this.shape_Area=properties.getJsonNumber("Shape__Area").doubleValue();
             
    }

    @Override
    public String toString() {
        return features.toString();
    }

    public int getPersonas() {
        return personas;
    }

    public double getShape_Area() {
        return shape_Area;
    }
    
    
}
