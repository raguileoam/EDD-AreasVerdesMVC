/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosTest;

import Datos.DAOPoblacion;
import Modelo.Poblacion;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author raguileoam
 */
public class DAOPoblacionStructureTest {
    String dir="/home/raguileoam/Documentos/5 Semestre/Estructura de datos/Proyecto Semestral/EDD-AreasVerdes";
    Long in;
    Long out;
    @Before
    public void setup(){
       in=System.nanoTime();
    }
    
    @Test
    public void test(){
        System.out.println("ArrayList");
        DAOPoblacion.loadJSON(dir);
    }
    @Test
    public void test2(){
        System.out.println("HashMap");
        HashMap<String, List<Poblacion>> hashmap = DAOPoblacion.loadJSON2(dir);
        Iterator<List<Poblacion>> iterator = hashmap.values().iterator();
        while (iterator.hasNext()) {
            List<Poblacion> nextElement = iterator.next();
            nextElement.forEach(element -> System.out.println(element.getDistrito()));
        }
        
    }
    @After
    public void end(){
        out=System.nanoTime();
        System.out.println(out-in);
    }
}
