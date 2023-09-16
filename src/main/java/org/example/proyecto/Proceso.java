package org.example.proyecto;

import java.util.Date;
import java.util.UUID;

public class Proceso {

    String PID;
    String nombre;
    Date tiempoCreacion;
    Date tiempoUltiModif;
    int quantum;
    int prioridad;

    public Proceso() {
       PID = UUID.randomUUID().toString();
       prioridad=(int) ((Math.random()*9));
       tiempoCreacion=new Date();
       tiempoUltiModif= new Date();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void reducirQuantum(){
        quantum--;
        tiempoUltiModif=new Date();
    }

    public void mostrarFecha(){
        System.out.println(tiempoCreacion);
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "PID='" + PID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tiempoCreacion=" + tiempoCreacion +
                ", tiempoUltiModif=" + tiempoUltiModif +
                ", quantum=" + quantum +
                ", prioridad=" + prioridad +
                '}';
    }
}
