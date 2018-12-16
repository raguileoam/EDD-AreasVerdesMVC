<%-- 
    Document   : Map
    Created on : 26-11-2018, 16:08:03
    Author     : raguileoam
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="Modelo.Poblaciones_macroSector"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Poblacion"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==" crossorigin=""/>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="test.css" media="screen" />

        <script src="https://cdn.jsdelivr.net/npm/@turf/turf@5/turf.min.js"></script>
        <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="https://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui-touch-punch/0.2.2/jquery.ui.touch-punch.min.js"></script>


        <script src="lib/SliderControl.js" type="text/javascript"></script>
    </head>
    <body>

        <h1>Areas Verdes</h1>
        <div id="map"></div>
        <script>
            var map = L.map('map').setView([-38.736277, -72.590618], 13);
            L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href=”http://osm.org/copyright”>OpenStreetMap</a> contributors'
            }).addTo(map);
            
            <% 
            Set<String> macrosectores=(Set<String>)request.getAttribute("macrosectores");
            HashMap<String,Poblaciones_macroSector> datosPoblacionx=(HashMap<String,Poblaciones_macroSector>)request.getAttribute("datosPoblacion");
            List<String> group1=new LinkedList<String>();
            List<String> group2=new LinkedList<String>();  
            List<String> group3=new LinkedList<String>();
            List<String> group4=new LinkedList<String>();
            List<String> group5=new LinkedList<String>();
            List<String> group6=new LinkedList<String>();
            
            for(String macrosector:macrosectores){
                String[] tokens=macrosector.split(" ");
                String first=tokens[tokens.length-1].toLowerCase();
                Poblaciones_macroSector poblacion=datosPoblacionx.get(macrosector);
                out.println("var "+first+"=L.geoJson("+poblacion.getPoblaciones()+",{onEachFeature: poblaOnEachFeature, style: style});");
                if(poblacion.getAv_habitante()< 5){
                    group1.add(first);
                }
                else if(poblacion.getAv_habitante()< 6){
                    group2.add(first);}
                else if(poblacion.getAv_habitante()<7){
                    group3.add(first);
                }
                else if(poblacion.getAv_habitante()< 8){
                    group4.add(first);
                }
                else if(poblacion.getAv_habitante()< 9){
                group5.add(first);
                }
                else{group6.add(first);}
                
            }
            out.println("var group1 = L.layerGroup("+group1.toString()+");");
            out.println("var group2 = L.layerGroup("+group2.toString()+");");
            out.println("var group3 = L.layerGroup("+group3.toString()+");");
            out.println("var group4 = L.layerGroup("+group4.toString()+");");
            out.println("var group5 = L.layerGroup("+group5.toString()+");");
            out.println("var group6 = L.layerGroup("+group6.toString()+");");
            out.println("var group = L.layerGroup([group6,group5,group4,group3,group2,group1]);");


            
            %>
            function poblaOnEachFeature(feature, featureLayer) {
                featureLayer.on({
                    mouseover: highlightFeature
                });
                var area = turf.area(feature.geometry);
                featureLayer.bindPopup("Población: <br />Area: " + area.toString()+" m²");
            }
            function style(feature) {
                return {
                    fillColor: getColor(feature.properties.AV_HABITANTE),
                    weight: 2,
                    opacity: 1,
                    color: 'white',
                    dashArray: '3',
                    fillOpacity: 0.7
                };
            }

            function getColor(d) {
                return d < 5 ? '#800026' :
                        d < 6 ? '#BD0026' :
                        d < 7 ? '#E31A1C' :
                        d < 8 ? '#FD8D3C' :
                        d < 9 ? '#FEB24C' :
                        '#FFEDA0';
            }
            var dataAreasVerdes =${datosAreasVerdes};
            var datalayerAreasVerdes = L.geoJson(dataAreasVerdes, {onEachFeature: avOnEachFeature, color: 'green'});
            datalayerAreasVerdes.addTo(map);


            function avOnEachFeature(feature, featureLayer) {
                featureLayer.bindPopup("Area Verde: <br /> Area: " + feature.properties.AREA+" m²");

            }

            function highlightFeature(e) {
                var layer = e.target;
                info.update(layer.feature.properties);
            }

            var info = L.control({position: 'topright'});
            info.onAdd = function (map) {
                this._div = L.DomUtil.create('div', 'info'); // create a div with a class "info"
                this.update();
                return this._div;
            };
// method that we will use to update the control based on feature properties passed
            info.update = function (props) {
                this._div.innerHTML = '<h4>Areas Verdes por persona en Macro Sector: </h4>' + (props ?
                         '<b>'+props.AV_HABITANTE+'m<sup>2</sup> por habitante</b><br /><br />'+
                        '<b>'+props.DISTRITO+'</b> en Macro Sector <b>' + props.MACRO_SECTOR + '</b><br />'+ 
                         props.PERSONAS + ' personas / m<sup>2</sup>'+'<br />'
                                
                        : 'Elija un lugar');
            };
            info.addTo(map);

            var legend = L.control({position: 'bottomright'});
            legend.onAdd = function (map) {
                var div = L.DomUtil.create('div', 'info legend'),
                        grades = [0,5, 6, 7, 8, 9],
                        labels = [];
                // loop through our density intervals and generate a label with a colored square for each interval
                for (var i = 0; i < grades.length; i++) {
                    div.innerHTML +=
                            '<i style="background:' + getColor(grades[i] + 1) + '"></i> ' +
                            grades[i] + (grades[i + 1] ? '&ndash;' + grades[i + 1] + ' m²/habitante' + '<br>' : '+');
                }
                return div;
            };
            legend.addTo(map);

            var sliderControl = L.control.sliderControl({
                position: 'bottomright',
                layer: group,
                showAllOnStart: true,
                attribute: 'MACRO_SECTOR',
                orientation: 'vertical'
            });
            map.addControl(sliderControl);
            sliderControl.startSlider();


        </script>
    </body>
</html>
