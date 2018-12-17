# Visualización de la desigualdad de áreas verdes por persona en los macro sectores de Temuco.

#### Asignatura : Estructuras de Datos
#### Integrantes: 
+ Aliwen Melillán
+ Sebastián Contreras
+ Sebastián Robles

# Contenidos

   * [Descripción del proyecto](#descripción-de-proyecto)
   * [Importar este proyecto](#como-usar-este-proyecto)
   * [Dependencias](#dependencias)
   * [Datos utilizados](#datos-utilizados)
   * [Resultados de evaluación de usuarios](#evaluacion-de-usuarios)   
   
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
![](https://i.imgur.com/CsiBokA.png)

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
  + Se utilizan datos como el aŕea, personas en ese área, y el distrito en donde está el área.
  + Se añaden datos como el macro sector y el valor de áreas verdes por persona en el macro sector.
+ [Json Areas Verdes Temuco](http://datos.cedeus.cl/layers/geonode:areas_verdes_prc)
  + Se utilizan datos como el aŕea, y el distrito en donde está el área.
  + Se añaden datos como el macro sector y el valor de áreas verdes por persona en el macro sector.
  
  
  
## Evaluacion de usuarios

<details><summary>Estudiante UCT</summary>
<p>

<img src="https://i.imgur.com/gZYrgo3.jpg" alt="Estudiante UCTt" width="500" height="300">

#### Observaciones
* __¿Estima si en el lugar en el que vive existe escasez de áreas verdes?__
  - No.
* __¿Fue necesario explicarle lo que mostraba el mapa?__
  - No, con la leyenda mostrada en el mapa fue suficiente.
* __¿Le fue posible encontrar su sector y verificar si había escasez de áreas verdes?__
  - Sí, su sector era Pueblo Nuevo.



</p>
</details>

<details><summary>Estudiante Liceo</summary>
<p>
  
<img src="https://i.imgur.com/r8OTf9y.jpg" alt="Estudiante Liceo" width="500" height="300">

#### Observaciones
* __¿Estima si en el lugar en el que vive existe escasez de áreas verdes?__
  - No.
* __¿Fue necesario explicarle lo que mostraba el mapa?__
  - Sí, no fue suficiente con lo que se mostraba en la leyenda del mapa.
* __¿Le fue posible encontrar su sector y verificar si había escasez de áreas verdes?__
  - Sí, su sector era Pueblo Nuevo.


</p>
</details>

<details><summary>Adulta Mayor</summary>
<p>
  
<img src="https://i.imgur.com/5wMzOpv.jpg" alt="Adulta Mayor" width="500" height="300">

#### Observaciones
* __¿Estima si en el lugar en el que vive existe escasez de áreas verdes?__
  - No, al contrario,piensa que el sector en donde vive hay muchas áreas verdes.
* __¿Fue necesario explicarle lo que mostraba el mapa?__
  - Sí, por problemas de visión. Con explicar el modo de uso y herramientas de la página lo entendió mejor.
* __¿Le fue posible encontrar su sector y verificar si había escasez de áreas verdes?__
  - En un principio no, pero al mover el mapa logró encontrar el sector. Su sector era Labranza y se dió cuenta que habia menos áreas verdes de lo que pensaba.


</p>
</details>

<details><summary>Adulta Mayor</summary>
<p>
  
<img src="https://i.imgur.com/AKUmXysg.jpg" alt="Adulta Mayor" width="418" height="300">

#### Observaciones
__Esta persona vive en Villarrica__
* __¿Fue necesario explicarle lo que mostraba el mapa?__
  - Sí, al principio no logró identificar que lugar se mostraba en el mapa.
* __¿Le fue posible identificar la finalidad de la leyenda del mapa?__
  - Determinó inmediatamente una relación entre los colores y el significado esperado (rojo como situación adversa, colores claros para lo contrario). Luego de leer el resto de información del mapa y de la página entendió completamente la finalidad.
* __Luego de ver el mapa, ¿cambia su percepción respecto a la ciudad de Temuco y sus áreas verdes?__
  - No, siempre consideró que en Temuco eran escasas, aunque le sorprende que el centro de Temuco aparezca sin escasez.


</p>
</details>



