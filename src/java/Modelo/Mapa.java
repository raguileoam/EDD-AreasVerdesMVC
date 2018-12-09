/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.DAOAreasVerdes;
import Datos.DAOPoblacion;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author raguileoam
 */
public class Mapa {
    private List<Poblacion> poblaciones;
    private List<AreasVerdes>  areasVerdes;
    private HashMap<String, Double[]> interseccion;
    private final Double[] coords={-38.736277, -72.590618};

    public Mapa(String dir) {
        this.poblaciones=DAOPoblacion.loadJSON(dir);
        this.areasVerdes=DAOAreasVerdes.loadJSON(dir);
        interseccion=interseccion();
    }

    public List<Poblacion> getPoblaciones() {
        return poblaciones;
    }

    public HashMap<String, Double[]> getInterseccion() {
        return interseccion;
    }
    


    public List<AreasVerdes> getAreasVerdes() {
        return areasVerdes;
    }

    public Double[] getCoords() {
        return coords;
    }
    
    /**
     * Determina área total de areas verdes y poblacion total en un sector determinado. 
     * @return Hashmap con sector como clave y un array que contiene el area total de areas verdes 
     * y la poblacion total en un sector. 
     */
    public HashMap<String, Double[]> interseccion(){
        HashMap<String, Double[]> hmap = new HashMap<>();
        for(Poblacion poblacion:poblaciones){
            for(AreasVerdes areaVerde:areasVerdes){
                if(poblacion.getDistrito().equals(areaVerde.getSector())){
                    String sector=poblacion.getDistrito();
                    double numHabitantes=poblacion.getPersonas();
                    double numAreasVerdes=areaVerde.getArea();
                    if(hmap.containsKey(sector)){
                        numAreasVerdes+=hmap.get(sector)[0];
                        numHabitantes+=hmap.get(sector)[1];
                    }
                    Double[] values={numAreasVerdes,numHabitantes};
                    hmap.put(sector, values);
                }
            }
        }
        return hmap;
    } 
}    

