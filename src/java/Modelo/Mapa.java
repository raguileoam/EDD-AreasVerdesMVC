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
public class Mapa {
    private Poblacion poblacion;
    private AreasVerdes areasVerdes;
    private final Double[] coords={-38.736277, -72.590618};
    

    public Mapa(Poblacion poblacion, AreasVerdes areasVerdes) {
        this.poblacion = poblacion;
        this.areasVerdes = areasVerdes;
    }
    
    
}
