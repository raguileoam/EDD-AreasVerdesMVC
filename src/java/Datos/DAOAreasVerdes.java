/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.AreasVerdes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.*;

/**
 *
 * @author raguileoam
 */
public class DAOAreasVerdes {
    public static List<AreasVerdes> loadJSON(String dir) {
         List<AreasVerdes> areasVerdesArray=new LinkedList<>();
        try {
           String JSON_FILE=dir+"areas.geojson";
             File file=new File(JSON_FILE);
            InputStream fis = new FileInputStream(file.getAbsolutePath());
            //create JsonReader object
            JsonReader jsonReader = Json.createReader(fis);
            JsonArray features=jsonReader.readObject().getJsonArray("features");
            //we can close IO resource and JsonReader now
            jsonReader.close();
            fis.close();
            for (int i = 0; i < features.size(); i++) {
                AreasVerdes areasVerdes=new AreasVerdes(features.getJsonObject(i));
                if(!areasVerdes.getSector().equals("")){
                    areasVerdesArray.add(areasVerdes);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return areasVerdesArray;
    }
}
