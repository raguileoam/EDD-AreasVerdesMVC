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
    private List<AreasVerdes> areasVerdes;
    private HashMap<String, Double> interseccionAV;
    private HashMap<String, Double> interseccionP;

    static final Double[] coords = {-38.736277, -72.590618};

    public Mapa(String dir) {
        this.poblaciones = DAOPoblacion.loadJSON(dir);
        this.areasVerdes = DAOAreasVerdes.loadJSON(dir);
        interseccionAV = interseccionAV();
        interseccionP = interseccionP();
    }

    public List<Poblacion> getPoblaciones() {
        return poblaciones;
    }

    public List<AreasVerdes> getAreasVerdes() {
        return areasVerdes;
    }

    public Double[] getCoords() {
        return coords;
    }

    /**
     * Determina área total de areas verdes y poblacion total en un sector
     * determinado.
     *
     * @return Hashmap con sector como clave y un array que contiene el area
     * total de areas verdes y la poblacion total en un sector.
     */
    public HashMap<String, Double> interseccionP() {
        HashMap<String, Double> hmapP = new HashMap<>();
        for (Poblacion poblacion : poblaciones) {
            String sector = poblacion.getMacroSector();
            double numHabitantes = poblacion.getPersonas();
            if (hmapP.containsKey(sector)) {
                numHabitantes += hmapP.get(sector);
            }
            hmapP.put(sector, numHabitantes);
        }
        return hmapP;
    }

    /**
     * Determina área total de areas verdes y poblacion total en un sector
     * determinado.
     *
     * @return Hashmap con sector como clave y un array que contiene el area
     * total de areas verdes y la poblacion total en un sector.
     */
    public HashMap<String, Double> interseccionAV() {
        HashMap<String, Double> hmapAV = new HashMap<>();
        for (AreasVerdes areaVerde : areasVerdes) {
            String sector = areaVerde.getMacroSector();
            double numAreasVerdes = areaVerde.getArea();
            if(hmapAV.containsKey("Costanera Cautín")) System.out.println(numAreasVerdes);

            if (hmapAV.containsKey(sector)) {
                numAreasVerdes += hmapAV.get(sector);
            }
            hmapAV.put(sector, numAreasVerdes);
        }

        return hmapAV;
    }

}
