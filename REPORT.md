# Lab 1 Git Race -- Project Report

## Description of Changes

Se implementó una funcionalidad para la gestión de datos junto a un panel de estadisticas.Los cambios incluyen:

### Infraestuctura

- Modificación del **Docker compose** para incluir un servicio de PostgreSQL.

- Configuración de **Spring Boot** para usar **H2 en memoria** en los test, para ejecuciones eficientes y aisladas.

### Persistencia de Datos

- **Entidad `Greeting`**:  Se creó una entidad JPA con anotaciones (`@Entity`) para mapear a la tabla `greetings`, incluyendo campos para `id`, `name`, `timestamp` y `message`.

- **Repository**: Se implementó `GreetingRepository`, que 
extiende `JpaRepository`, para el acceso a los datos.

### Capa de Servicio 
- **`GreetingService`**: Servicio desarollado para encapsular la logica de negocio. Ofreciendo metodos para guarda un saludo y recuperar el historial completo ((`saveGreeting(name: String)`) y (`getHistory()`))

### Mejoras en la API

- **Endpoints REST**:

- `GET /api/greeting/save?name={name}`: Guarda un saludo y devuelve un objeto JSON con el mensaje y timestamp.
- `GET /api/greeting/history`: Devuelve la lista completa de todos los saludos almacenados.

### Panel de Estadísticas

- **`stats.html`**: Nueva página que consume la API `/api/greeting/history` mediante JavaScript y **Chart.js**, generando un gráfico de barras con la frecuencia de saludos por nombre de usuario.

## Technical Decisions

| Decisión Técnica | Justificación |
|-----------------|---------------|
**Spring Data JPA para persistencia** | Facilita la implementación de la capa de acceso a datos mediante `GreetingRepository`.

**Base de Datos Dual: PostgreSQL + H2** | Postgresql asegura persistencia real, mientras que H2 en memoria permite ejecuciones deterministas que son claves para testing sin depender de un contenedor externo.

**Uso de `LocalDateTime.now()` en la Entidad** | Para garantizar registros de tiempo precisos y consistentes al guardar saludos.


## Learning Outcomes

- **Buenas Prácticas de Git**: Aplicación de **commit messages claros**, **commits atómicos**, **feature branches** 

- **Documentación Técnica**: Mejora en la redacción de documentación técnica clara y comprensible, justificando decisiones de diseño en `REPORT.md`.


### AI Tools Used
- **ChatGPT 4**
- **Gemini**

### AI-Assisted Work
- Asistencia en **depuración del JavaScript** de `stats.html` y en **depuracion de controladores**.
- Ayuda en la **creación de tests** para la aplicación.
- Revisión y mejora de la redacción de los archivos Markdown (`.md`) del proyecto.

**Proporción de trabajo asistido por IA**: ~30% (Depuración, tests y documentación); 70% trabajo original.


### Original Work
- **Arquitectura y Lógica de Negocio**: Definición y diseño de la entidad `Greeting`, el servicio `GreetingService` y los controladores REST y Web (`GreetingApiController` y `GreetingWebController`) completamente originales.
- **Implementación de Spring Data JPA**: Desarrollo independiente de `GreetingRepository` y su integración con la capa de servicio para persistencia de datos.
- **Flujo de Datos y Endpoints**: Creación del endpoint `/api/greeting/save` y orquestación completa del flujo de datos entre API, servicio y repositorio, incluyendo la gestión de timestamps y mensajes generados.
- **Añadir Servico Postgresql** : Modificación del docker compose para añadir una servicio para la base de datos PostrgreSQL

