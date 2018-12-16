/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.DAOAreasVerdes;
import Datos.DAOPoblacion;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author raguileoam
 */
public class Mapa {
    private List<AreasVerdes> areasVerdes;
    static final Double[] coords = {-38.736277, -72.590618};
    private HashMap<String,Poblaciones_macroSector> poblaciones;
    
    private HashMap<Integer,Color> colores(){
        HashMap<Integer,Color> colores=new HashMap<>();
        colores.put(3, Color.getColor("#800026"));
        colores.put(5,Color.getColor("#BD0026"));
        colores.put(7, Color.getColor("#E31A1C"));
        colores.put(9, Color.getColor("#FD8D3C"));
        colores.put(13, Color.getColor("#FEB24C"));
        colores.put(15, Color.getColor("#FED976"));
        return null;
    }
    public Mapa(String dir) {
        this.poblaciones=DAOPoblacion.loadJSON(dir);
        this.areasVerdes = DAOAreasVerdes.loadJSON(dir);
      
    }

    public List<Poblacion> getPoblacionesList() {
        List<Poblacion> poblacions=new LinkedList<>();
        for(Poblaciones_macroSector p:poblaciones.values()){
            poblacions.addAll(p.getPoblaciones());
        }
        return poblacions;
    }

    public HashMap<String,Poblaciones_macroSector> getPoblaciones() {
        return poblaciones;
    }
  
    public List<AreasVerdes> getAreasVerdes() {
        return areasVerdes;
    }

    public Double[] getCoords() {
        return coords;
    }
}
