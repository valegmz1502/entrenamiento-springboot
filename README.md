# Prueba Técnica - Algoritmo de Entrenamiento de Fútbol 5

## 1. Descripción del proyecto

Este proyecto corresponde a una prueba técnica para desarrollar un algoritmo capaz de almacenar la información obtenida durante los entrenamientos de un equipo de fútbol 5 y, al finalizar los tres entrenamientos de la semana, determinar cuáles son los cinco jugadores titulares de acuerdo con sus resultados.

El equipo está conformado por 7 jugadores, pero solamente 5 jugadores pueden ser titulares en un partido.

Durante cada entrenamiento se registran tres aspectos de cada jugador:

* Potencia de tiro.
* Velocidad del jugador.
* Pases efectivos.

A partir de estos tres valores se calcula una puntuación para cada jugador.

La fórmula utilizada es:

* Potencia de tiro: 20%.
* Velocidad: 30%.
* Pases efectivos: 50%.

Al completar los tres entrenamientos de la semana, el sistema calcula el promedio de los resultados obtenidos por cada jugador, ordena a los jugadores de acuerdo con su puntuación y selecciona los cinco jugadores con mayor puntuación.

Si todavía no existen los tres entrenamientos completos, el sistema no genera el equipo titular y muestra un mensaje indicando que la información es insuficiente.

---

# 2. Objetivo

El objetivo principal es desarrollar una aplicación que permita:

1. Recibir los resultados de los entrenamientos en formato JSON.
2. Almacenar la información de los entrenamientos.
3. Registrar la información de los jugadores.
4. Calcular automáticamente la puntuación de cada jugador.
5. Comprobar que existan los tres entrenamientos necesarios.
6. Calcular el promedio de cada jugador.
7. Ordenar los jugadores de mayor a menor puntuación.
8. Seleccionar los cinco jugadores titulares.
9. Retornar la información de los titulares en formato JSON.
10. Permitir probar el funcionamiento mediante Postman.

---

# 3. Tecnologías utilizadas

Para desarrollar el proyecto se utilizaron las siguientes herramientas:

* Java.
* Spring Boot.
* Maven.
* Spring Data JPA.
* MySQL.
* MySQL Workbench.
* Postman.
* Visual Studio Code.
* Git.
* GitHub.

---

# 4. Requisitos para ejecutar el proyecto

Para ejecutar el proyecto se necesita tener instalado:

* Java JDK.
* Maven o utilizar el Maven Wrapper incluido en el proyecto.
* MySQL.
* Visual Studio Code o cualquier otro editor de código.
* Postman para realizar las pruebas de los endpoints.
* Git, si se desea clonar el repositorio.

---

# 5. Estructura del proyecto

El proyecto utiliza una arquitectura organizada por capas.

```text
src
└── main
    ├── java
    │   └── com.equipo.entrenamiento
    │       ├── controller
    │       ├── dto
    │       ├── model
    │       ├── repository
    │       ├── service
    │       └── EntrenamientoApplication.java
    │
    └── resources
        └── application.yaml
```

## 5.1 Controller

La carpeta `controller` contiene las clases encargadas de recibir las solicitudes realizadas a la aplicación.

En este proyecto se encuentra:

```text
EntrenamientoController.java
```

El controlador contiene los endpoints utilizados para:

* Guardar un entrenamiento.
* Consultar los entrenamientos.
* Consultar los jugadores titulares.

El controlador recibe las peticiones y las envía al servicio correspondiente.

---

## 5.2 Service

La carpeta `service` contiene la lógica principal del proyecto.

En este proyecto se encuentra:

```text
EntrenamientoService.java
```

Aquí se realizan operaciones como:

* Calcular la puntuación de cada jugador.
* Buscar o crear jugadores.
* Guardar los entrenamientos.
* Obtener los entrenamientos.
* Comprobar si existe suficiente información.
* Calcular los promedios.
* Ordenar los jugadores.
* Seleccionar los cinco titulares.

La lógica principal del algoritmo se encuentra en esta capa.

---

## 5.3 Model

La carpeta `model` contiene las clases que representan los datos principales del sistema.

Se utilizaron:

```text
Entrenamiento.java
Jugador.java
ResultadoEntrenamiento.java
```

### Entrenamiento

Representa un entrenamiento realizado por el equipo.

Contiene la información relacionada con el número del entrenamiento y sus resultados.

### Jugador

Representa a cada jugador del equipo.

El equipo inicialmente tiene 7 jugadores.

### ResultadoEntrenamiento

Representa los resultados obtenidos por un jugador durante un entrenamiento.

Contiene información como:

* Nombre del jugador.
* Potencia de tiro.
* Velocidad.
* Pases efectivos.
* Resultado calculado.

También se relaciona con el jugador correspondiente.

---

# 6. DTO

La carpeta `dto` contiene objetos utilizados para enviar la información que necesita recibir el cliente.

En el proyecto se encuentran:

```text
JugadorTitularDTO.java
ResultadoEntrenamientoDTO.java
```

## JugadorTitularDTO

Se utiliza para devolver la información final de los jugadores titulares.

El resultado contiene:

```json
{
    "jugador": "Jugador3",
    "puntuacion": 31.9
}
```

De esta manera, la respuesta solamente muestra la información necesaria del jugador titular.

---

# 7. Repository

La carpeta `repository` contiene las interfaces utilizadas para comunicarse con la base de datos.

Se encuentran:

```text
EntrenamientoRepository.java
JugadorRepository.java
ResultadoEntrenamientoRepository.java
```

Estas interfaces permiten realizar operaciones sobre los datos almacenados.

Por ejemplo:

* Guardar información.
* Buscar información.
* Obtener todos los registros.
* Buscar un jugador por su nombre.

Se utiliza Spring Data JPA para facilitar estas operaciones.

---

# 8. Base de datos

El proyecto utiliza MySQL para almacenar la información.

La base de datos contiene información relacionada con:

* Entrenamientos.
* Jugadores.
* Resultados de los entrenamientos.

La conexión con la base de datos se configura en:

```text
src/main/resources/application.yaml
```

La aplicación utiliza esta configuración para conectarse a MySQL.

---

# 9. Funcionamiento del algoritmo

El cálculo de la puntuación se realiza utilizando los porcentajes indicados en la prueba técnica.

La fórmula utilizada es:

```text
Resultado =
(Potencia de tiro × 0.20)
+
(Velocidad × 0.30)
+
(Pases efectivos × 0.50)
```

## Ejemplo

Para el Jugador3:

```text
Potencia de tiro = 15
Velocidad = 3
Pases = 30
```

Se realiza el cálculo:

```text
15 × 0.20 = 3
3 × 0.30 = 0.9
30 × 0.50 = 15
```

Finalmente:

```text
3 + 0.9 + 15 = 18.9
```

Por lo tanto, el resultado del Jugador3 en ese entrenamiento es:

```text
18.9
```

---

# 10. Cálculo de los titulares

El equipo tiene 7 jugadores y solamente 5 pueden ser titulares.

Durante la semana se realizan 3 entrenamientos.

Por lo tanto, para tener información completa se necesitan:

```text
7 jugadores × 3 entrenamientos = 21 resultados
```

Cuando existen los resultados necesarios, el sistema obtiene los resultados de cada jugador y calcula su promedio.

La fórmula utilizada es:

```text
Promedio = suma de los resultados / 3
```

El promedio se redondea a dos decimales para presentar una puntuación más clara.

Después, los 7 jugadores son ordenados desde la puntuación más alta hasta la más baja.

Finalmente se toman los primeros 5 jugadores de la lista.

---

# 11. Validación de información insuficiente

El sistema no debe seleccionar titulares si todavía no se han realizado los tres entrenamientos.

Para realizar esta validación se comprueba que existan al menos 21 resultados:

```java
if (resultados.size() < 21) {
    return new ArrayList<>();
}
```

Si existen menos de 21 resultados, el servicio devuelve una lista vacía.

El controlador identifica esta situación y devuelve el mensaje:

```text
Información insuficiente. Se necesitan los 3 entrenamientos.
```

De esta manera se cumple la condición establecida en la prueba técnica.

---

# 12. Endpoints

La aplicación utiliza la ruta principal:

```text
/entrenamientos
```

## 12.1 Guardar entrenamiento

### Método

```text
POST
```

### URL

```text
http://localhost:8080/entrenamientos
```

Este endpoint recibe la información del entrenamiento en formato JSON.

### Ejemplo de solicitud

```json
{
    "numero": 4,
    "resultados": [
        {
            "nombreJugador": "Jugador1",
            "potenciaTiro": 10,
            "velocidad": 5,
            "pases": 25
        },
        {
            "nombreJugador": "Jugador2",
            "potenciaTiro": 16,
            "velocidad": 5,
            "pases": 20
        },
        {
            "nombreJugador": "Jugador3",
            "potenciaTiro": 15,
            "velocidad": 3,
            "pases": 30
        }
    ]
}
```

El JSON debe contener los resultados correspondientes a los jugadores del entrenamiento.

Al recibir la información, el sistema calcula automáticamente el resultado de cada jugador y guarda la información en la base de datos.

Si el proceso se realiza correctamente, se obtiene:

```text
Entrenamiento guardado correctamente
```

---

# 13. Consultar entrenamientos

### Método

```text
GET
```

### URL

```text
http://localhost:8080/entrenamientos
```

Este endpoint permite consultar los entrenamientos almacenados en la base de datos.

La respuesta se devuelve en formato JSON.

---

# 14. Consultar jugadores titulares

### Método

```text
GET
```

### URL

```text
http://localhost:8080/entrenamientos/titulares
```

Este endpoint ejecuta el algoritmo para determinar los cinco jugadores titulares.

Cuando existen los tres entrenamientos completos, la respuesta tiene una estructura similar a:

```json
[
    {
        "jugador": "Jugador3",
        "puntuacion": 31.9
    },
    {
        "jugador": "Jugador1",
        "puntuacion": 26.97
    },
    {
        "jugador": "Jugador7",
        "puntuacion": 25.23
    },
    {
        "jugador": "Jugador2",
        "puntuacion": 24.9
    },
    {
        "jugador": "Jugador6",
        "puntuacion": 23.67
    }
]
```

La cantidad de resultados devueltos es 5 porque solamente cinco jugadores pueden ser titulares.

Los resultados aparecen organizados desde la mayor puntuación hasta la menor.

---

# 15. Respuesta cuando no existe suficiente información

Si todavía no se han realizado los tres entrenamientos, el endpoint:

```text
GET http://localhost:8080/entrenamientos/titulares
```

devuelve:

```text
Información insuficiente. Se necesitan los 3 entrenamientos.
```

Esto evita que el sistema seleccione titulares utilizando información incompleta.

---

# 16. Pruebas realizadas con Postman

Durante el desarrollo se utilizó Postman para comprobar el funcionamiento de la API.

Se realizaron principalmente las siguientes pruebas:

### Prueba 1 - Guardar entrenamiento

Se realizó una petición:

```text
POST /entrenamientos
```

enviando los datos en formato JSON.

Resultado esperado:

```text
Entrenamiento guardado correctamente
```

---

### Prueba 2 - Consultar entrenamientos

Se realizó:

```text
GET /entrenamientos
```

para verificar que la información enviada mediante POST quedara almacenada.

---

### Prueba 3 - Consultar titulares

Se realizó:

```text
GET /entrenamientos/titulares
```

para comprobar que el algoritmo seleccionara los cinco jugadores con mayor puntuación.

---

### Prueba 4 - Información insuficiente

Se verificó el comportamiento del sistema cuando no existían los 21 resultados necesarios.

El sistema respondió:

```text
Información insuficiente. Se necesitan los 3 entrenamientos.
```

---

### Prueba 5 - Cálculo de resultados

También se comprobaron manualmente algunos cálculos para verificar que los porcentajes fueran aplicados correctamente.

Por ejemplo:

```text
Jugador3

Potencia:
15 × 20% = 3

Velocidad:
3 × 30% = 0.9

Pases:
30 × 50% = 15

Resultado:
3 + 0.9 + 15 = 18.9
```

El resultado obtenido coincidió con el calculado por el sistema.

---

# 17. Ejecución del proyecto

## Paso 1 - Clonar el repositorio

Desde una terminal se puede clonar el proyecto utilizando:

```bash
git clone https://github.com/valegmz1502/entrenamiento-springboot.git
```

Después se ingresa a la carpeta:

```bash
cd entrenamiento-springboot
```

---

## Paso 2 - Configurar la base de datos

Se debe tener MySQL instalado y funcionando.

La base de datos utilizada por el proyecto debe estar disponible y la información de conexión debe coincidir con la configuración del archivo:

```text
src/main/resources/application.yaml
```

---

## Paso 3 - Abrir el proyecto

El proyecto puede abrirse en Visual Studio Code.

Se debe abrir la carpeta principal del proyecto, donde se encuentran archivos como:

```text
pom.xml
mvnw
mvnw.cmd
src
```

---

## Paso 4 - Ejecutar Spring Boot

En Windows se puede ejecutar el proyecto utilizando el Maven Wrapper:

```bash
.\mvnw.cmd spring-boot:run
```

También se puede ejecutar desde Visual Studio Code utilizando la clase:

```text
EntrenamientoApplication.java
```

Cuando la aplicación inicia correctamente, en la terminal aparece un mensaje similar a:

```text
Started EntrenamientoApplication
```

Esto indica que la aplicación Spring Boot inició correctamente.

---

# 18. Puerto utilizado

La aplicación se ejecuta normalmente en:

```text
http://localhost:8080
```

Por lo tanto, los endpoints principales son:

```text
POST http://localhost:8080/entrenamientos

GET http://localhost:8080/entrenamientos

GET http://localhost:8080/entrenamientos/titulares
```

---

# 19. Git y GitHub

Durante el desarrollo también se utilizó Git para llevar el control del proyecto.

Se realizaron los siguientes pasos:

1. Se creó el repositorio local utilizando `git init`.
2. Se agregaron los archivos mediante `git add .`.
3. Se realizó el primer commit.
4. Se creó un repositorio en GitHub.
5. Se conectó el repositorio local con GitHub.
6. Se realizó el `git push`.
7. El proyecto quedó almacenado en GitHub.

Repositorio:

https://github.com/valegmz1502/entrenamiento-springboot

---

# 20. Archivos principales

Los archivos principales desarrollados son:

```text
EntrenamientoApplication.java
```

Clase principal encargada de iniciar la aplicación Spring Boot.

```text
EntrenamientoController.java
```

Recibe las peticiones HTTP de los usuarios.

```text
EntrenamientoService.java
```

Contiene la lógica principal para calcular resultados y seleccionar titulares.

```text
Entrenamiento.java
```

Representa un entrenamiento.

```text
Jugador.java
```

Representa un jugador.

```text
ResultadoEntrenamiento.java
```

Representa el resultado obtenido por un jugador en un entrenamiento.

```text
JugadorTitularDTO.java
```

Permite devolver la información de los jugadores titulares.

```text
ResultadoEntrenamientoDTO.java
```

Permite manejar información de los resultados como objeto de transferencia.

```text
EntrenamientoRepository.java
JugadorRepository.java
ResultadoEntrenamientoRepository.java
```

Permiten trabajar con la información almacenada en la base de datos.

```text
application.yaml
```

Contiene la configuración de la aplicación y la conexión con la base de datos.

```text
pom.xml
```

Contiene las dependencias y configuración de Maven utilizadas por el proyecto.

---

# 21. Flujo general del sistema

El funcionamiento general puede representarse de la siguiente manera:

```text
             POSTMAN
                |
                v
        EntrenamientoController
                |
                v
        EntrenamientoService
                |
        +-------+-------+
        |               |
        v               v
   Cálculo de       Validación de
   resultados       información
        |               |
        +-------+-------+
                |
                v
          Repositories
                |
                v
             MySQL
```

Para consultar los titulares:

```text
Postman
   |
   v
GET /entrenamientos/titulares
   |
   v
Controller
   |
   v
Service
   |
   v
Obtener resultados
   |
   v
Comprobar 21 resultados
   |
   v
Calcular promedio
   |
   v
Ordenar jugadores
   |
   v
Seleccionar 5 jugadores
   |
   v
Retornar JSON
```

---

# 22. Escalabilidad

La prueba plantea inicialmente un equipo de fútbol 5 con 7 jugadores, pero también indica que la solución podría escalarse a un equipo de fútbol 11.

La estructura utilizada permite realizar modificaciones posteriores para trabajar con una cantidad diferente de jugadores.

Por ejemplo, la cantidad de titulares y jugadores podría convertirse en valores configurables en lugar de estar definida directamente en el código.

Para esta prueba se mantuvo la configuración solicitada:

```text
7 jugadores
5 titulares
3 entrenamientos
```

---

# 23. Resultado final

La aplicación permite almacenar los resultados de los entrenamientos, calcular automáticamente la puntuación de cada jugador y determinar los cinco jugadores titulares al finalizar los tres entrenamientos de la semana.

El sistema también controla que no se genere un equipo titular cuando no existe suficiente información.

Con esto se cumplen las principales condiciones establecidas en la prueba técnica:

* Recepción de datos mediante JSON.
* Almacenamiento de entrenamientos.
* Cálculo de resultados.
* Uso de los porcentajes establecidos.
* Validación de los tres entrenamientos.
* Selección de cinco titulares.
* Respuesta de titulares en JSON.
* Pruebas mediante Postman.
* Proyecto desarrollado en Java con Spring Boot.
* Código almacenado en un repositorio GitHub.

---

# 24. Autor

Proyecto desarrollado como solución a una prueba técnica de desarrollo de software utilizando Java y Spring Boot.
