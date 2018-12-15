/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.DAOAreasVerdes;
import Datos.DAOPoblacion;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author raguileoam
 */
public class Mapa {
    public final static String[] macrosectores={"Poniente","Centro","Pueblo Nuevo","Amanecer","Costanera Cautín","El Carmen","Pedro de Valdivia","Labranza"};
    private List<AreasVerdes> areasVerdes;
    static final Double[] coords = {-38.736277, -72.590618};
    private HashMap<String, List<Poblacion>> poblaciones;
    
    public Mapa(String dir) {
        this.poblaciones = DAOPoblacion.loadJSON(dir);
        this.areasVerdes = DAOAreasVerdes.loadJSON(dir);
      
    }

    public List<Poblacion> getPoblacionesList() {
        List<Poblacion> poblacions=new LinkedList<>();
        for(List<Poblacion> p:poblaciones.values()){
            poblacions.addAll(p);
        }
        return poblacions;
    }

    public HashMap<String, List<Poblacion>> getPoblaciones() {
        return poblaciones;
    }
  
    public List<AreasVerdes> getAreasVerdes() {
        return areasVerdes;
    }

    public Double[] getCoords() {
        return coords;
    }
}
