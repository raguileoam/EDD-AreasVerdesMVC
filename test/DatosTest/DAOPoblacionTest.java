/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosTest;

import Datos.DAOPoblacion;
import Modelo.Poblacion;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author raguileoam
 */
public class DAOPoblacionTest {
    ArrayList<Poblacion> poblaciones;
    @Before
    public void setup(){
        poblaciones=DAOPoblacion.loadJSON("/home/raguileoam/Descargas/ModeloMVC/");
    }
    @Test
    public void test(){
        System.out.println(poblaciones.get(0).toString());
    }
    
}
