/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.DAOAreasVerdes;
import Datos.DAOPoblacion;
import java.util.ArrayList;


/**
 *
 * @author raguileoam
 */
public class Mapa {
    private  ArrayList<Poblacion> poblacion;
    private ArrayList<AreasVerdes>  areasVerdes;
    private final Double[] coords={-38.736277, -72.590618};

    public Mapa(String dir) {
        this.poblacion=DAOPoblacion.loadJSON(dir);
        this.areasVerdes=DAOAreasVerdes.loadJSON(dir);
    }

    public ArrayList<Poblacion> getPoblacion() {
        return poblacion;
    }

    public ArrayList<AreasVerdes> getAreasVerdes() {
        return areasVerdes;
    }

    public Double[] getCoords() {
        return coords;
    }
    
    public void intersecion(){
    }
    
    
}
