import org.example.proyecto.Cola;
import org.example.proyecto.Proceso;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColaTest {

    @Test
    public void crearProcesosTest(){
        int tamano=50;
        Cola colaTest = new Cola(tamano);
        assertEquals(tamano,colaTest.getTamanoCola());
    }

    @Test
    public void ordenarProcesosTest(){
        Cola colaTest = new Cola(50);
        Vector<Proceso> copyColaTest= (Vector<Proceso>) colaTest.getColaProcesos().clone();
        Collections.sort(copyColaTest, new Comparator<Proceso>() {
            @Override
            public int compare(Proceso o1, Proceso o2) {
                return o1.getPrioridad() - o2.getPrioridad();
            }
        });
        assertEquals(copyColaTest,colaTest.getColaProcesos());
    }

    @Test
    public void ejecutarProcesosTest(){
        Cola colaTest = new Cola(50);
        colaTest.ejecutarProcesos();
        assertEquals(0,colaTest.getTamanoCola());
    }
}
