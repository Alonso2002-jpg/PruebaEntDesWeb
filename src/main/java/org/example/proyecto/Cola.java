package org.example.proyecto;

import java.util.Vector;

public class Cola {
    Vector<Vector<Proceso>> colaProcesos;
    Vector<Proceso> procesos;

    int tamano;

    public Cola(int tamano) {
        procesos =new Vector<>(tamano);
        colaProcesos=new Vector<>();
        this.tamano=tamano;
        crearProcesos();
    }

    public void crearProcesos(){
        for (int i = 0; i < tamano; i++) {
            int quantum=(int) ((Math.random()*100+1));
            Proceso proceso=new Proceso();
            proceso.setNombre("P"+i);
            proceso.setQuantum(quantum);
            procesos.add(proceso);
        }

        ordenarProcesos();
    }

    public void ordenarProcesos(){
        for (int i = 0; i < 9; i++) {
            colaProcesos.add(new Vector<>());
            for (int j = 0; j < procesos.size(); j++) {
                if (procesos.get(j).prioridad==i){
                    Proceso newP=procesos.remove(j);
                    colaProcesos.get(i).add(newP);
                    j--;
                }
            }
        }
    }

    public void ejecutarProcesos() {
        while (!colaProcesos.isEmpty()) {
            while (!colaProcesos.get(0).isEmpty()) {
                for (int j = 0; j < colaProcesos.get(0).size(); j++) {
                    Proceso ActProceso = colaProcesos.get(0).remove(j);
                    if (ActProceso.quantum != 0) {
                        ActProceso.quantum--;
                        colaProcesos.get(0).add(ActProceso);
                    }
                }
            }
            colaProcesos.remove(0);
        }
    }

    public Vector<Proceso> getProcesos() {
        return procesos;
    }

    public int getTamanoCola(){
        return tamano;
    }

    public static void main(String[] args) {
        Cola c = new Cola(50);
        c.ejecutarProcesos();
        System.out.println(c.getTamanoCola());
    }
}