/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosTest;

import Datos.DAOAreasVerdes;
import Datos.DAOPoblacion;
import Modelo.AreasVerdes;
import Modelo.Poblacion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.junit.Test;

/**
 *
 * @author raguileoam
 */
public class JSONObjectTest {

    @Test
    public void testAV() {
        try {
            String dir="/home/raguileoam/Documentos/5 Semestre/Estructura de datos/Proyecto Semestral/AreasVerdesMVC/datos/";
            ArrayList<AreasVerdes> areasVerdes=DAOAreasVerdes.loadJSON(dir);
            JSONObject jSONObject=new JSONObject();
            jSONObject.put("type", "FeatureCollection");
            jSONObject.put("features", areasVerdes);
            BufferedWriter bufferedWriter = null;
        try {
            File myFile = new File("/home/raguileoam/a.json");
            // check if file exist, otherwise create the file before writing
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(jSONObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){
                 
            }
        }

            
     
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
     @Test
    public void testP() {
        try {
            String dir="/home/raguileoam/Documentos/5 Semestre/Estructura de datos/Proyecto Semestral/AreasVerdesMVC/datos/";
            ArrayList<Poblacion> poblacion=DAOPoblacion.loadJSON(dir);
            JSONObject jSONObject=new JSONObject();
            jSONObject.put("type", "FeatureCollection");
            jSONObject.put("features", poblacion);
            
            BufferedWriter bufferedWriter = null;
        try {
            File myFile = new File("/home/raguileoam/p.json");
            // check if file exist, otherwise create the file before writing
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(jSONObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){
                 
            }
        }

            
     
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}
