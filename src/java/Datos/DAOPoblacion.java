/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Mapa;
import Modelo.Poblacion;
import Modelo.Poblaciones_macroSector;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    
    public static HashMap<String,Poblaciones_macroSector> loadJSON(String dir) {
         HashMap<String,Poblaciones_macroSector> poblaciones=new HashMap<>();
         for(String macrosector:Poblaciones_macroSector.configAV_Hab.keySet()){
             poblaciones.put(macrosector, new Poblaciones_macroSector(macrosector));
         }
        try {
           String JSON_FILE=dir+"poblaciones.geojson";
            InputStream fis = new FileInputStream(JSON_FILE);
            //create JsonReader object
            JsonReader jsonReader = Json.createReader(fis);
            JsonArray features=jsonReader.readObject().getJsonArray("features");
            //we can close IO resource and JsonReader now
            jsonReader.close();
            fis.close();
            for (int i = 0; i < features.size(); i++) {
                Poblacion poblacion=new Poblacion(features.getJsonObject(i));
                String macrosector=poblacion.getMacroSector();
                if(poblaciones.containsKey(macrosector)){
                poblaciones.get(macrosector).getPoblaciones().add(poblacion);
                }
                else{
                    System.out.println("Dato perdido: "+macrosector);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return poblaciones;
    }

}
