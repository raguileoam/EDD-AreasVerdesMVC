# Visualización de la desigualdad de áreas verdes por persona en los macro sectores de Temuco.

#### Asignatura : Estructuras de Datos
#### Integrantes: 
+ Aliwen Melillán
+ Sebastián Contreras
+ Sebastián Robles

# Contenidos

   * [Descripción del proyecto](#descripcion-de-proyecto)
   * [Importar este proyecto](#como-usar-este-proyecto)
   * [Dependencias](#dependencias)
   * [Datos utilizados](#datos-utilizados)
   * [Problemas](#problemas)
   
## Descripción de proyecto
### Problema que se intenta resolver:
En Temuco existe una desigualdad de áreas verdes por persona, no todos los macro sectores de esta ciudad cumple con el estándar internacional de 9 m2/habitante recomendada por la OMS y además no todas las personas son conscientes de este posible deficit en el lugar en el que viven.

El objetivo de este proyecto que estas personas puedan visualizar la desigualdad de áreas verdes por persona en los macro sectores de Temuco.


## Como usar este proyecto

1. Descargar el proyecto como ZIP 
![](https://i.imgur.com/7g0QZNs.png)

2. Importar el proyecto como ZIP en NetBeans
![](https://i.imgur.com/HfA1XpY.png)

3. Una vez importado cambiar String dir de processRequest de clase Home según donde instaló la carpeta.
![](https://i.imgur.com/0N2IAWa.png)

4. Correr el proyecto en NetBeans
![](https://i.imgur.com/V88qiKC.png)

## Dependencias

+ **Java**: 
  + [Json Simple](https://code.google.com/archive/p/json-simple/)
  + JUnit

+ **JavaScript**:

  + [Leaflet](https://leafletjs.com/)

  + [Turf](https://github.com/Turfjs/turf)

  + [LeafletSlider](https://github.com/dwilhelm89/LeafletSlider) modificado

  + JQuery

  + JQueryUI
  
## Datos utilizados

 + [GeoJson Población Temuco extraído del INE](http://ine-chile.maps.arcgis.com/apps/webappviewer/index.html?id=bc3cfbd4feec49699c11e813ae9a629f)
+ [Json Areas Verdes Temuco](http://datos.cedeus.cl/layers/geonode:areas_verdes_prc)



## Problemas

El principal obstáculo del proyecto es que las fuentes de datos de los mapas desaparezcan. Además los datos que se extraen provienen de distintas fuentes lo que dificulta su relación.
Menores obstáculos serían que las librerías no funcionen como se quería o no se le pueda dar el uso que se necesita.

