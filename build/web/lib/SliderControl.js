/* global L */

L.Control.SliderControl = L.Control.extend({
    options: {
        position: 'topright',
        layers: null,
        attribute: 'time',
        maxValue: 6,
        minValue: 0,
        showAllOnStart: false,
        markers: null,
        orientation: 'horizontal',
    },

    initialize: function (options) {
        L.Util.setOptions(this, options);
        this._layer = this.options.layer;

    },

    setPosition: function (position) {
        var map = this._map;
        if (map)
            map.removeControl(this);
        this.options.position = position;
        if (map)
            map.addControl(this);
        this.startSlider();
        return this;
    },

    onAdd: function (map) {
        this.options.map = map;
        // Create a control sliderContainer with a jquery ui slider
        var sliderContainer = L.DomUtil.create('div', 'slider', this._container);
        $(sliderContainer).append('<div id="leaflet-slider" style="width:15px;height:90px">');
        //Prevent map panning/zooming while using the slider
        $(sliderContainer).mousedown(function () {
            map.dragging.disable();
        });
        $(document).mouseup(function () {
            map.dragging.enable();
        });
        var options = this.options;
        this.options.markers = [];

        //If a layer has been provided: calculate the min and max values for the slider
        if (this._layer) {
            var index_temp = 0;
           
            this._layer.eachLayer(function (layer) {
                options.markers[index_temp] = layer;
                ++index_temp;
            });
            options.maxValue = index_temp - 1;
            this.options = options;
        } else {
            console.log("Error: You have to specify a layer via new SliderControl({layer: your_layer});");
        }
        return sliderContainer;
    },

    onRemove: function (map) {
        //Delete all markers which where added via the slider and remove the slider div
        for (i = this.options.minValue; i <= this.options.maxValue; i++) {
            map.removeLayer(this.options.markers[i]);
        }
        $('#leaflet-slider').remove();
        // unbind listeners to prevent memory leaks
        $(document).off("mouseup");
        $(".slider").off("mousedown");
    },

    startSlider: function () {
        _options = this.options;
        var index_start = _options.minValue;
        if (_options.showAllOnStart) {
            index_start = _options.maxValue;
            _options.value = _options.maxValue;
        }
        $("#leaflet-slider").slider({
            value: _options.value,
            values: _options.values,
            min: _options.minValue,
            max: _options.maxValue,
            orientation: _options.orientation,
            step: 1,
            slide: function (e, ui) {
                var map = _options.map;
                var fg = L.featureGroup();
                if (!!_options.markers[ui.value]) {
                    var i;
                    // clear markers
                    for (i = _options.minValue; i <= _options.maxValue; i++) {
                        if (_options.markers[i])
                            map.removeLayer(_options.markers[i]);
                    }
                    for (i = ui.value; i <= _options.maxValue; i++) {
                        if (_options.markers[i]) {
                            map.addLayer(_options.markers[i]);
                            fg.addLayer(_options.markers[i]);
                        }
                    }
                }
            }
        });

        for (i = _options.minValue; i <= index_start; i++) {
            _options.map.addLayer(_options.markers[i]);
        }
    }
});

L.control.sliderControl = function (options) {
    return new L.Control.SliderControl(options);
};
