# Sistema de Gestión de Turnos — Trabajo Práctico Grupal Integrador

**Asignatura:** Algoritmos y Estructuras de Datos III  
**Etapa:** 1 — Construcción de un proyecto en Java con Maven

---

## Instrucciones para el profesor

Este repositorio contiene el proyecto Maven completo. Para compilar, testear y ejecutar el sistema, siga los pasos de la sección **Comandos Maven** más abajo. Todo el código fuente, los tests unitarios y el JAR ejecutable se encuentran dentro de la carpeta `gestion-turnos/`.

---

## Estructura del proyecto

```
Algoritmos/
└── gestion-turnos/
    ├── pom.xml
    └── src/
        ├── main/java/com/universitas/
        │   ├── App.java
        │   ├── Persona.java          ← clase abstracta (ampliación opcional)
        │   ├── Paciente.java
        │   ├── Profesional.java
        │   ├── Especialidad.java
        │   ├── Consultorio.java
        │   ├── Turno.java
        │   └── SistemaTurnos.java
        └── test/java/com/universitas/
            ├── PacienteTest.java
            ├── ProfesionalTest.java
            ├── EspecialidadTest.java
            ├── ConsultorioTest.java
            ├── Turnoest.java         ← clase TurnoTest
            └── SistemaTurnosTest.java
```

---

## Comandos Maven

Todos los comandos se ejecutan desde la carpeta `gestion-turnos/`:

```bash
# Limpiar artefactos anteriores
mvn clean

# Ejecutar todos los tests unitarios
mvn test

# Compilar, testear y generar el JAR
mvn clean package

# Ejecutar el JAR generado
java -jar target/gestion-turnos-1.0-SNAPSHOT.jar
```

---

## Modelo de clases (Diagrama UML)

```
                    +------------------+
                    |    <<abstract>>  |
                    |     Persona      |
                    +------------------+
                    | - nombre: String |
                    | - apellido: String|
                    | - dni: String    |
                    +------------------+
                    | + getNombre()    |
                    | + getApellido()  |
                    | + getDni()       |
                    +--------+---------+
                             |
              +--------------+--------------+
              |                             |
   +----------+----------+     +-----------+----------+
   |       Paciente       |     |       Profesional    |
   +---------------------+     +---------------------+
   | - numeroAfiliado:   |     | - matricula: String  |
   |   String            |     | - especialidad:      |
   +---------------------+     |   Especialidad       |
   | + getNumeroAfiliado()|     +---------------------+
   | + setNumeroAfiliado()|     | + getMatricula()     |
   +---------------------+     | + getEspecialidad()  |
                               +----------+----------+
                                          |
                                          | usa
                               +----------+----------+
                               |     Especialidad    |
                               +---------------------+
                               | - nombre: String    |
                               | - descripcion:String|
                               +---------------------+
                               | + getNombre()       |
                               | + getDescripcion()  |
                               +---------------------+

   +---------------------+
   |     Consultorio     |
   +---------------------+
   | - numero: int       |
   | - sector: String    |
   +---------------------+
   | + getNumero()       |
   | + getSector()       |
   +---------------------+

   +-------------------------------------------------------+
   |                        Turno                          |
   +-------------------------------------------------------+
   | - paciente: Paciente                                  |
   | - profesional: Profesional                            |
   | - consultorio: Consultorio                            |
   | - fecha: LocalDate                                    |
   | - hora: LocalTime                                     |
   | - estado: String  ("Pendiente" | "Confirmado" |       |
   |                    "Cancelado" | "Reprogramado")      |
   +-------------------------------------------------------+
   | + confirmar()                                         |
   | + cancelar()                                          |
   | + reprogramar(nuevaFecha, nuevaHora)                  |
   | + getters / setters                                   |
   +-------------------------------------------------------+

   +-------------------------------------------------------+
   |                   SistemaTurnos                       |
   +-------------------------------------------------------+
   | - turnos: List<Turno>                                 |
   | - pacientes: List<Paciente>                           |
   | - profesionales: List<Profesional>                    |
   | - consultorios: List<Consultorio>                     |
   +-------------------------------------------------------+
   | + registrarPaciente(Paciente)                         |
   | + registrarProfesional(Profesional)                   |
   | + registrarConsultorio(Consultorio)                   |
   | + agendarTurno(...): boolean                          |
   | + getTurnos() / getPacientes() / ...                  |
   +-------------------------------------------------------+
```

**Relaciones:**
- `Paciente` y `Profesional` **heredan** de la clase abstracta `Persona`.
- `Profesional` **tiene** una `Especialidad` (composición).
- `Turno` **asocia** un `Paciente`, un `Profesional` y un `Consultorio`.
- `SistemaTurnos` **administra** colecciones de `Turno`, `Paciente`, `Profesional` y `Consultorio`.

---

## Descripción de las clases

### `Persona` (abstracta)
Clase base que agrupa los atributos comunes a toda persona del sistema: `nombre`, `apellido` y `dni`. No puede instanciarse directamente. Implementa la **actividad opcional de ampliación** que sugiere agregar herencia mediante una clase abstracta.

### `Paciente`
Extiende `Persona`. Agrega el atributo `numeroAfiliado` (obra social del paciente). Hereda todos los getters/setters de `Persona`.

### `Especialidad`
Clase independiente que representa una especialidad médica. Atributos: `nombre` y `descripcion`. Sin dependencias con otras clases del dominio.

### `Profesional`
Extiende `Persona`. Agrega `matricula` y una referencia a su `Especialidad`. Modela la relación *"un Profesional pertenece a una Especialidad"*.

### `Consultorio`
Representa un consultorio físico con `numero` (entero) y `sector` (descripción de la ubicación).

### `Turno`
Clase central del sistema. Vincula `Paciente`, `Profesional` y `Consultorio` en una fecha (`LocalDate`) y hora (`LocalTime`). El estado inicial es `"Pendiente"` y puede cambiar mediante los métodos de negocio:
- `confirmar()` → estado `"Confirmado"`
- `cancelar()` → estado `"Cancelado"`
- `reprogramar(fecha, hora)` → actualiza fecha/hora y estado `"Reprogramado"`

Se usa `LocalDate` y `LocalTime` en lugar de `String`, implementando otra **actividad opcional de ampliación**.

### `SistemaTurnos`
Clase gestora central que mantiene en memoria listas de todas las entidades. El método `agendarTurno()` incluye validación de turnos duplicados: si el mismo profesional ya tiene un turno activo en la misma fecha y hora, el método retorna `false` y no agrega el turno. Esta es la tercera **actividad opcional de ampliación** implementada.

### `App`
Clase con el método `main`. Demuestra el flujo completo del sistema: creación de entidades, registro en el sistema, agendado de turnos, intento de turno duplicado, y uso de los métodos `confirmar()`, `reprogramar()` y `cancelar()`.

---

## Tests unitarios

Cada clase de dominio tiene su correspondiente clase de test con JUnit 5:

| Clase de test        | Archivo fuente         | Qué verifica |
|----------------------|------------------------|--------------|
| `PacienteTest`       | `PacienteTest.java`    | Constructor con parámetros, getters y setters de `Paciente` y atributos heredados de `Persona` |
| `ProfesionalTest`    | `ProfesionalTest.java` | Constructor con parámetros, getters de matrícula y acceso a la especialidad anidada |
| `EspecialidadTest`   | `EspecialidadTest.java`| Constructor con parámetros, getters y setters de `nombre` y `descripcion` |
| `ConsultorioTest`    | `ConsultorioTest.java` | Constructor con parámetros, getters y setters de `numero` y `sector` |
| `TurnoTest`          | `Turnoest.java`        | Estado inicial `"Pendiente"`, y correcto cambio de estado con `confirmar()`, `cancelar()` y `reprogramar()` |
| `SistemaTurnosTest`  | `SistemaTurnosTest.java`| Registro de entidades en colecciones, agendado exitoso, y validación de turno duplicado (retorna `false` y no agrega) |

---

## Ampliaciones opcionales implementadas

El proyecto implementa las cuatro mejoras opcionales sugeridas por el enunciado:

1. **Validación de turno duplicado:** `SistemaTurnos.agendarTurno()` rechaza un turno si el profesional ya tiene uno activo en el mismo horario.
2. **`LocalDate` y `LocalTime`:** `Turno` usa tipos de fecha y hora del paquete `java.time` en lugar de `String`.
3. **Herencia con clase abstracta `Persona`:** `Paciente` y `Profesional` extienden `Persona`.
4. **Manejo correcto de estados:** los métodos de negocio de `Turno` gestionan un ciclo de vida explícito mediante el atributo `estado`.

---

## Notas adicionales

- El sistema opera completamente **en memoria**. No requiere persistencia en archivos ni bases de datos.
- El proyecto fue generado con el arquetipo `maven-archetype-quickstart`.
- El JAR ejecutable se genera en `target/gestion-turnos-1.0-SNAPSHOT.jar` al correr `mvn clean package`.
