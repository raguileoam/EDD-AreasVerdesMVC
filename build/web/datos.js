var map = L.map('map').setView([-38.736277, -72.590618], 13);
L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href=”http://osm.org/copyright”>OpenStreetMap</a> contributors'
}).addTo(map);

$.getJSON("datos/pobla.geojson", function (data) {
// add GeoJSON layer to the map once the file is loaded
    var datalayer = L.geoJson(
            data, {onEachFeature: poblaOnEachFeature, color: 'red', style: style});
    datalayer.addTo(map);
});

function poblaOnEachFeature(feature, featureLayer) {
    featureLayer.on({
        mouseover: highlightFeature
    });
    featureLayer.bindPopup(JSON.stringify(10000 * feature.properties.PERSONAS / feature.properties.Shape__Area));
}

$.getJSON("datos/areas.json", function (data) {
// add GeoJSON layer to the map once the file is loaded
    var datalayer = L.geoJson(data, {onEachFeature: areaOnEachFeauture, color: 'green'});
    datalayer.addTo(map);
});

function areaOnEachFeauture(feature, featureLayer) {
    featureLayer.bindPopup(JSON.stringify(feature.properties.AREA));
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