/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Poblacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.*;

/**
 *
 * @author raguileoam
 */
public class DAOPoblacion {
    static String[] macrosectores={"Poniente","Centro","Pueblo Nuevo","Amanecer","Costanera","El Carmen","Pedro de Valdivia","Labranza"};
        public static ArrayList<Poblacion> loadJSON(String dir) {
         ArrayList<Poblacion> poblaciones=new ArrayList<>();
        try {
           String JSON_FILE=dir+"pobla (original).geojson";
           File file=new File(JSON_FILE);
            InputStream fis = new FileInputStream(file.getAbsolutePath());
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
         for(String macrosector:macrosectores){
             poblaciones.put(macrosector, new LinkedList<>());
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
                poblaciones.get(poblacion.getMacroSector()).add(poblacion);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return poblaciones;
    }

}
