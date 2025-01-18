# FORO HUB

Bienvenidos a Foro Hub! Foro Hub es un proyecto **BackEnd** como parte del programa **One Alura Latam**.
Este aplicativo es una herramienta muy utilizada en el ambiente educativo ya que permite gestionar Tópicos de Alumnos [Sugerencia, Consulta, Error].
A medida que los Tópicos son respondidos, cambiarán de estado para indicar a los responsables cuáles tópicos aún quedan Pendientes de respuesta.
De esta forma, profesores y mentores podrán acompañar efectiva y eficientemente a los alumnos en el desarrollo de su preparación profesional.

**Reglas del Negocio:**

🔖 Sólo podrá crear un Tópico un Alumno registrado y activo.

🔖 El listado de Alumnos sólo mostrará Alumnos activos.

🔖 El listado de Tópicos sólo mostrará Tópicos que no se encuentren Eliminados.


## ** Estado del Proyecto **

⏳ En desarrollo.

## ** Características tecnológicas **

🔧 Lenguaje de Programación: JDK 17

🔧 Entorno de Desarrollo: IntelliJ

🔧 Framework de desarrollo: Spring Boot

🔧 Seguridad: Spring Security - JWT - ByCrip

🔧 Persistencia de Datos: Spring Data JPA

🔧 Gestión de BD: Flyway

🔧 Documentación de API: SpringDoc OpenAPI


## ** Funcionalidades **

**🟪 POST / login :** __Autentica y autoriza al usuario Admin.

**🟩 POST / alumnos :**__Registra un nuevo alumno.
    

**🟩 POST / topicos :**__Registra un nuevo tópico.

**🟩 POST / respuestas :**__Registra una nueva respuesta.

**🟦 GET / alumnos :**__Lista alumnos activos.

**🟦 POST / alumnos / {id} :**__Muestra un alumno activo específico.

**🟦 GET / topicos :**__Lista tópicos Pendientes y Contestados.

**🟦 POST / topicos / {id} :**__Muestra un tópico específico.

**🟦 GET / respuestas :**__Lista respuestas.

**🟦 GET / respuestas / {id} :**__Muestra una respuesta específica.

**🟧 PUT / alumnos :**__Modifica datos de un alumno.

**🟧 PUT / topicos :**__Modifica datos de un tópico.

**🟧 PUT / respuestas :**__Modifica datos de una respuesta.

**🟥 DELETE / alumnos / {id} :**__Elimina un alumno.

**🟥 DELETE / topicos / {id} :**__Elimina un tópico.

**🟥 DELETE / respuestas / {id} :**__Elimina una respuesta.


## ** Instalación y configuración del proyecto **

1️⃣ Crea una carpeta en tu entorno local. 

2️⃣ En la terminal deslízate hacia la carpeta y clona el proyecto "One Foro Hub":
https://github.com/ClauJulian/one_forohub.git

3️⃣ Instala Java, Intellij, PostgreSQL en tu entorno local.

4️⃣ Crea la Base de datos en tu Postgres y actualiza con tus datos el archivo aplpication.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_base_de_datos

spring.datasource.username=  tu_nombre_de_usuario

spring.datasource.password=  tu_clave


5️⃣ Haz correr el proyecto para que se ejecuten las migraciones y se creen las tablas en tu base de datos. 
Las migraciones insertarán datos iniciales.

6️⃣ Para desplegar el aplicativo, escribe en tu navegador :
http://localhost:8080/swagger-ui/index.html

7️⃣ Para inicia sesión abre la función **✅ POST / login** y presiona el botón ** ✅ Try it out**. 
Actualiza los datos del script en pantalla con los datos del usuario:

"login": "maria.perez",

"password": "123456"

Presiona ** ✅ Execute** y debajo se desplegará el resultado de tu login de donde obtendrás un **token**.
Copia el token sin comillas. Abre el botón ** ✅ Authorize** en  la parte superior de la pantalla y pega el token para autenticar el usuario.

8️⃣ Ahora puedes probar todas las funcionalidades de Foro Hub!!

## ** Agradecimientos **

👏 Alura Latam

👏 Oracle

👏 Compañeros del G7-BackEnd de ONE ALURA LATAM

## ** Comentarios y Contacto **

📭 wg.claudiajulian@gmail.com

## ** Desarrolador **

Claudia Edith Julian Full Stack PHP - React Licenciada en Administración de Empresas https://www.linkedin.com/in/claudiaedithjulian/

