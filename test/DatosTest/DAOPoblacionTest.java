/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosTest;

import Datos.DAOPoblacion;
import Modelo.Mapa;
import Modelo.Poblacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author raguileoam
 */
public class DAOPoblacionTest {
    Mapa mapa;
     LinkedList<String> av;
     LinkedList<String> p;
    @Before
    public void setup(){
        av=new LinkedList<>();
        p=new LinkedList<>();
        String dir="/home/raguileoam/Documentos/5 Semestre/Estructura de datos/Proyecto Semestral/EDD-AreasVerdes";
        mapa=new Mapa(dir);
    }
    @Test
    public void testAV(){
        for(int i=0;i<mapa.getAreasVerdes().size();i++){
            //System.out.println(i+" "+mapa.getAreasVerdes().get(i).getSector());
            if(!av.contains(mapa.getAreasVerdes().get(i).getSector())){
                av.add(mapa.getAreasVerdes().get(i).getSector());
            }
    }
        //System.out.println(av);
    }
        @Test
    public void testP(){
        for(int i=0;i<mapa.getPoblacion().size();i++){
            System.out.println(i+" "+mapa.getPoblacion().get(i).getDistrito());
            if(!p.contains(mapa.getPoblacion().get(i).getDistrito())){
                p.add(mapa.getPoblacion().get(i).getDistrito());
            }
    }
        System.out.println(p);
    }
    
    
}
