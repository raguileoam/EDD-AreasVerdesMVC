/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTests;

import Modelo.Poblacion;
import com.sun.xml.bind.StringInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonWriter;
import org.junit.Before;

/**
 *
 * @author raguileoam
 */
public class PoblacionTest {
    Poblacion poblacionTest;
    @Before 
    public void setup(){
        InputStream in = new StringInputStream("");
        poblacionTest=new Poblacion(Json.createReader(in).readObject());
    }
}
