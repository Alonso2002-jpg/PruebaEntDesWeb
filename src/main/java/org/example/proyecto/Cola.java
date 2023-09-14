package org.example.proyecto;

import java.util.Random;
import java.util.Vector;

public class Cola{
    Vector<Proceso> colaProcesos=new Vector<>(50);

    public Cola() {
        crearProcesos();
    }

    public void crearProcesos(){
        for (int i = 0; i < 5; i++) {
            int quantum=(int) ((Math.random()*100+1));
            Proceso proceso=new Proceso();
            proceso.setNombre("P"+i);
            proceso.setQuantum(quantum);
            colaProcesos.add(proceso);
        }
        ordenarProcesos();
    }

    public void ordenarProcesos(){
        for (int i = 0; i < colaProcesos.size(); i++) {
            for (int j = 0; j < colaProcesos.size() - 1; j++) {
                if (colaProcesos.get(j).prioridad > colaProcesos.get(j+1).prioridad) {
                    Proceso temp = colaProcesos.get(j);
                    colaProcesos.set(j,colaProcesos.get(j+1));
                    colaProcesos.set(j+1,temp);
                }
            }
        }

    }

    public void ejecutarProcesos(){
        mostrarProcesos();
        while (!colaProcesos.isEmpty()){
            Proceso pr=colaProcesos.remove(0);
            System.out.println("Al proceso " + pr.nombre + " le queda "+pr.quantum);
            pr.quantum--;

            if (pr.quantum>0){
                colaProcesos.add(pr);
            }else{
                System.out.println("Proceso : "+pr.nombre + " acabado!");
            }
        }
        System.out.println("Acabado");
    }
    public void mostrarProcesos(){
        if (!colaProcesos.isEmpty()){
            for (int i = 0; i < colaProcesos.size(); i++) {
                System.out.println(colaProcesos.get(i));
            }
        }else{
            System.out.println("Esta vacio!");
        }
    }

    public static void main(String[] args) {
        Cola c = new Cola();
        c.ejecutarProcesos();
    }
}