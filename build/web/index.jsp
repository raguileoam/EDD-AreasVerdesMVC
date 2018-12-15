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
            var dataPoblacion =${datosPoblacion};
            var datalayerPoblacion = L.geoJson(dataPoblacion, {onEachFeature: poblaOnEachFeature, style: style});
            //datalayerPoblacion.addTo(map);


            function poblaOnEachFeature(feature, featureLayer) {
                featureLayer.on({
                    mouseover: highlightFeature
                });
                var area = turf.area(feature.geometry);
                featureLayer.bindPopup("Poblacion: turf " + area.toString() + " json" + feature.properties.Shape__Area);
                //


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
                return d < 3 ? '#800026' :
                        d < 5 ? '#BD0026' :
                        d < 7 ? '#E31A1C' :
                        d < 9 ? '#FD8D3C' :
                        d < 13 ? '#FEB24C' :
                        d < 15 ? '#FED976' :
                        '#FFEDA0';
            }
            var dataAreasVerdes =${datosAreasVerdes};
            var datalayerAreasVerdes = L.geoJson(dataAreasVerdes, {onEachFeature: avOnEachFeature, color: 'green'});
            var datalayerAreasVerdes1 = L.geoJson(dataAreasVerdes, {onEachFeature: avOnEachFeature, color: 'red'});
            var datalayerAreasVerdes2 = L.geoJson(dataAreasVerdes, {onEachFeature: avOnEachFeature, color: 'blue'});

            //datalayerAreasVerdes.addTo(map);
             var group = L.layerGroup([datalayerAreasVerdes, datalayerPoblacion,datalayerAreasVerdes1,datalayerAreasVerdes2]);

            function avOnEachFeature(feature, featureLayer) {
                var area = turf.area(feature.geometry);
                featureLayer.bindPopup("Area Verde: " + feature.properties.DISTRITO + " turf " + area.toString() + " json" + feature.properties.AREA);

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
                this._div.innerHTML = '<h4>Poblacion por m² respecto a areas verdes</h4>' + (props ?
                        '<b>' + props.DISTRITO + '' + '</b> en ' + props.MACRO_SECTOR + '<br />' + props.PERSONAS + ' personas / mi<sup>2</sup>'
                        : 'Elija un lugar');
            };
            info.addTo(map);

            var legend = L.control({position: 'bottomright'});
            legend.onAdd = function (map) {
                var div = L.DomUtil.create('div', 'info legend'),
                        grades = [4, 5, 7, 9, 13, 15],
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
