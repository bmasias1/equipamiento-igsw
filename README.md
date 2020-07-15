# Equipamiento IGSW

Microservicio dedicado a la administración del equipamiento hospitalario para el proyecto de ingeniería de software, primer semestre 2020.

## Estructura interna

### Paquetes (*)

Los paquetes son usados para distinguir y encapsular funcionalidades. Ayuda a la modularidad, y por supuesto, evita conflictos que surjan entre nombres de funciones que son iguales pero no hacen lo mismo. 

Acá para generar un orden se prefiere usar:

* com.rocket.main (por defecto): Es la función main donde se corre springboot.
* com.rocket.main.**model**: Es donde se almacenarán todos los objetos a trabajar. En nuestro caso, sólo tendremos el objeto Equipamiento (detallado más abajo), y básicamente preserva la misma estructura con la base de datos, entiéndase atributos.
* com.rocket.main.**dao**: Es donde se definirán todos los DAO, es decir, los repositorios para poder persistir y manejar los distintos objetos. Evidentemente, los objetos allí serán todos interfaces porque así lo dicta la documentación (cada repositorio debe ser una interfaz).
* com.rocket.main.**controller**: Es donde se describen todos los controladores de cada objeto pertinente, es decir, objetos que son capaces de manejar los ruteos que hacemos mediante las distintas peticiones GET, POST, PUT o DELETE por ejemplo.

### Propiedades de la aplicación (*)

En el directorio `src/main/resources` está el archivo application.properties. Para usarlo con la base de datos PostgreeSQL borrar la configuración actual (sólo la ocupé para unas pruebas).

