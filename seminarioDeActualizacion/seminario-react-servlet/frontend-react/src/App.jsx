import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [alumnos, setAlumnos] = useState([]);
  const [nombre, setNombre] = useState("");

  const cargarAlumnos = () => {
    fetch("http://localhost:8080/backend-servlet/api/alumnos")
      .then((response) => response.json())
      .then((data) => setAlumnos(data))
      .catch((error) => console.error("Error al obtener alumnos:", error));
  };

  useEffect(() => {
    cargarAlumnos();
  }, []);

  const guardarAlumno = (e) => {
    e.preventDefault();

    fetch("http://localhost:8080/backend-servlet/api/alumnos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ nombre: nombre }),
    })
      .then((response) => response.json())
      .then(() => {
        setNombre("");
        cargarAlumnos();
      })
      .catch((error) => console.error("Error al guardar alumno:", error));
  };

  return (
    <main className="contenedor">
      <h1>Seminario de Actualización</h1>
      <h2>Listado de alumnos</h2>

      <form onSubmit={guardarAlumno} className="formulario">
        <input
          type="text"
          placeholder="Ingrese nombre"
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
          required
        />

        <button type="submit">Guardar alumno</button>
      </form>

      <ul className="lista">
        {alumnos.map((alumno) => (
          <li key={alumno.id}>
            {alumno.id} - {alumno.nombre}
          </li>
        ))}
      </ul>
    </main>
  );
}

export default App;