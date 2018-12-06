/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.DAOAreasVerdes;
import Datos.DAOPoblacion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


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
    

       public static ArrayList<String> testP(ArrayList<Poblacion> poblaciones){
                   List av=new LinkedList<>();
        for(int i=0;i<poblaciones.size();i++){
            //System.out.println(i+" "+mapa.getAreasVerdes().get(i).getSector());
            if(!av.contains(poblaciones.get(i).getDistrito())){
                av.add(poblaciones.get(i).getDistrito());
            }
    }
        //System.out.println(av);
        return new ArrayList(av);
    }
       public static String randomSector(ArrayList<Poblacion> poblaciones){
           ArrayList<String> randomList = testP(poblaciones);
           Random rnd=new Random();
           int i=rnd.nextInt();
           return randomList.get(i);
       }
}    

