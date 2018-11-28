/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author raguileoam
 */
public class Poblacion {
    private int personas;
    private int shape_Area;

    public Poblacion(int personas, int shape_Area) {
        this.personas = personas;
        this.shape_Area = shape_Area;
    }

    @Override
    public String toString() {
        return "Poblacion{" + "personas=" + personas + ", shape_Area=" + shape_Area + '}';
    }
    
}
