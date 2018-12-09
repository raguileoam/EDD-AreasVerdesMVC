/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Poblacion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.*;

/**
 *
 * @author raguileoam
 */
public class DAOPoblacion {
        static String[] p_distritors={"TROMÉN","RALUNCOYÁN","SAN CARLOS","PUEBLO NUEVO","ESTERO COIHUECO","JAVIERA CARRERA","SANTA ROSA","CENTRO","ESTADIO MUNICIPAL","SANTA ELENA","CAUPOLICAN","LABRANZA","LANÍN","AVENIDA ALEMANIA","ÑIELOL"};
    public static ArrayList<Poblacion> loadJSON(String dir) {
         ArrayList<Poblacion> poblaciones=new ArrayList<>();
        try {
           String JSON_FILE=dir+"/web/datos/pobla.geojson";
            InputStream fis = new FileInputStream(JSON_FILE);
            //create JsonReader object
            JsonReader jsonReader = Json.createReader(fis);
            JsonArray features=jsonReader.readObject().getJsonArray("features");
            //we can close IO resource and JsonReader now
            jsonReader.close();
            fis.close();
            for (int i = 0; i < features.size(); i++) {
                Poblacion poblacion=new Poblacion(features.getJsonObject(i));
                poblaciones.add(poblacion);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return poblaciones;
    }
        public static HashMap<String,List<Poblacion>> loadJSON2(String dir) {
         HashMap<String,List<Poblacion>> poblaciones=new HashMap<>();
         for(String distrito:p_distritors){
             poblaciones.put(distrito, new LinkedList<>());
         }
        try {
           String JSON_FILE=dir+"/web/datos/pobla.geojson";
            InputStream fis = new FileInputStream(JSON_FILE);
            //create JsonReader object
            JsonReader jsonReader = Json.createReader(fis);
            JsonArray features=jsonReader.readObject().getJsonArray("features");
            //we can close IO resource and JsonReader now
            jsonReader.close();
            fis.close();
            for (int i = 0; i < features.size(); i++) {
                Poblacion poblacion=new Poblacion(features.getJsonObject(i));
                poblaciones.get(poblacion.getDistrito()).add(poblacion);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return poblaciones;
    }

}
