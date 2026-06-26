package funcional;

public class Alumno {
    private int legajo;
private String nombre;
private String apellido;
private int edad;
private double promedio;
private String carrera;
public Alumno(int legajo, String nombre, String apellido, int edad, double promedio, String carrera) {
    this.legajo = legajo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.promedio = promedio;
    this.carrera = carrera;
}
public int getLegajo() {
    return legajo;
}
public void setLegajo(int legajo) {
    this.legajo = legajo;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getApellido() {
    return apellido;
}
public void setApellido(String apellido) {
    this.apellido = apellido;
}
public int getEdad() {
    return edad;
}
public void setEdad(int edad) {
    this.edad = edad;
}
public double getPromedio() {
    return promedio;
}
public void setPromedio(double promedio) {
    this.promedio = promedio;
}
public String getCarrera() {
    return carrera;
}
public void setCarrera(String carrera) {
    this.carrera = carrera;
}

@Override
public String toString() {
    return "Alumno [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
            + ", promedio=" + promedio + ", carrera=" + carrera + "]";
}


}
