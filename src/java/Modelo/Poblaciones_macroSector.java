/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author raguileoam
 */
public class Poblaciones_macroSector implements Comparable<Double>{
    List<Poblacion> poblaciones;
    double av_habitante;
    String macrosector;
    public static final HashMap<String, Double> configAV_Hab=configAV_Hab();
    public Poblaciones_macroSector(String macrosector) {
        this.poblaciones = new LinkedList<>();
        this.macrosector = macrosector;
        this.av_habitante=configAV_Hab.get(macrosector);
    }

    public List<Poblacion> getPoblaciones() {
        return poblaciones;
    }

    public double getAv_habitante() {
        return av_habitante;
    }

    public String getMacrosector() {
        return macrosector;
    }

    public HashMap<String, Double> getConfigAV_Hab() {
        return configAV_Hab;
    }


        public static HashMap<String, Double> configAV_Hab() {
        HashMap<String, Double> map = new HashMap<>();
        //key:macrosector value:av por hab,ordenados por av por persona
        map.put("Poniente", 14.83);
        map.put("Centro", 10.44);
        map.put("Pueblo Nuevo", 8.02);
        map.put("Labranza", 7.75);
        map.put("Amanecer", 7.44);
        map.put("Costanera Cautín", 6.83);
        map.put("El Carmen", 6.83);
        map.put("Pedro de Valdivia", 4.98);
        return map;
}

    @Override
    public int compareTo(Double t) {
        return this.compareTo(t);
    }
}
