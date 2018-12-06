<%-- 
    Document   : Map
    Created on : 26-11-2018, 16:08:03
    Author     : raguileoam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==" crossorigin=""/>
        <link rel="stylesheet" type="text/css" href="test.css" media="screen" />
        <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@turf/turf@5/turf.min.js"></script>
    </head>
    <body>

        <h1>Test MVC Areas Verdes</h1>
        <div id="map"></div>
        <script>
            var map = L.map('map').setView([-38.736277, -72.590618], 13);
            L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href=”http://osm.org/copyright”>OpenStreetMap</a> contributors'
            }).addTo(map);

            var dataPoblacion = ${datosPoblacion};
            var points = new Array();
            var datalayerPoblacion = L.geoJson(dataPoblacion, {onEachFeature: poblaOnEachFeature, style: style});
            datalayerPoblacion.addTo(map);
            
          
            function poblaOnEachFeature(feature, featureLayer) {
                featureLayer.on({
                    mouseover: highlightFeature
                });
                var center = turf.center(feature);
                var point = turf.point(center.geometry.coordinates);
                points.push(point);
                //feature.properties.CENTER=center.geometry.coordinates;
                featureLayer.bindPopup(center.geometry.coordinates.toString());
                
            }
            function style(feature) {
                return {
                    fillColor: getColor(10000 * feature.properties.PERSONAS / feature.properties.Shape__Area),
                    weight: 2,
                    opacity: 1,
                    color: 'white',
                    dashArray: '3',
                    fillOpacity: 0.7
                };
            }

            function getColor(d) {
                return d > 200 ? '#800026' :
                        d > 100 ? '#BD0026' :
                        d > 50 ? '#E31A1C' :
                        d > 20 ? '#FC4E2A' :
                        d > 10 ? '#FD8D3C' :
                        d > 5 ? '#FEB24C' :
                        d > 2 ? '#FED976' :
                        '#FFEDA0';
            }
            var pointsFC=turf.featureCollection(points);
            //var voronoiPolygons = turf.voronoi(pointsFC);
            //var dataLayervoronoi=L.geoJson(voronoiPolygons, {color: 'white'});
            //dataLayervoronoi.addTo(map);
            
            
            var dataAreasVerdes =${datosAreasVerdes};
            var datalayerAreasVerdes = L.geoJson(dataAreasVerdes, {onEachFeature:areaOnEachFeature, color: 'green'});
            datalayerAreasVerdes.addTo(map);
            function areaOnEachFeature(feature, featureLayer) {
                featureLayer.on({
                    mouseover: highlightFeature
                });
                var center = turf.center(feature);
                var point = turf.point(center.geometry.coordinates);
                points.push(point);
                if(feature.properties.APELLIDO2==""){
                    console.log("Valor vacio");
                }
                 if(feature.properties.APELLIDO1!=""){
                    console.log(feature.properties.APELLIDO1.toString());
                }
                //feature.properties.CENTER=center.geometry.coordinates;
                featureLayer.bindPopup(center.geometry.coordinates.toString());
                
            }
            function highlightFeature(e) {
                var layer = e.target;
                info.update(layer.feature.properties);
            }

            var info = L.control();

            info.onAdd = function (map) {
                this._div = L.DomUtil.create('div', 'info'); // create a div with a class "info"
                this.update();
                return this._div;
            };
            

// method that we will use to update the control based on feature properties passed
            info.update = function (props) {
                this._div.innerHTML = '<h4>Poblacion por m² respecto a areas verdes</h4>' + (props ?
                        '<b>' + props.DISTRITO + '</b><br />' + props.PERSONAS + ' personas / mi<sup>2</sup>'
                        : 'Elija un lugar');
            };

            info.addTo(map);

            var legend = L.control({position: 'bottomright'});

            legend.onAdd = function (map) {

                var div = L.DomUtil.create('div', 'info legend'),
                        grades = [0, 2, 5, 10, 20, 50, 100, 200],
                        labels = [];

                // loop through our density intervals and generate a label with a colored square for each interval
                for (var i = 0; i < grades.length; i++) {
                    div.innerHTML +=
                            '<i style="background:' + getColor(grades[i] + 1) + '"></i> ' +
                            grades[i] + (grades[i + 1] ? '&ndash;' + grades[i + 1] + '<br>' : '+');
                }

                return div;
            };

            legend.addTo(map);
            
            var test1=dataPoblacion[0].geometry.coordinates;
            var test2=dataPoblacion[1].geometry.coordinates;
            var poly1=turf.polygon(test1);
            var poly2=turf.polygon(test2);
            var intersection = turf.intersect(poly1, poly2);
            console.log(poly1);
            console.log(poly2);
            console.log(intersection);
            
        </script>
    </body>
</html>