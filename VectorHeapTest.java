import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class VectorHeapTest {

    @Test
    public void testAdd() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        Paciente p1 = new Paciente("Juan", "Fractura", "C", 0);
        Paciente p2 = new Paciente("Maria", "Apendicitis", "A", 1);
        Paciente p3 = new Paciente("Pedro", "Dolor", "B", 2);

        heap.add(p1);
        heap.add(p2);
        heap.add(p3);

        // El más prioritario es Maria (A)
        assertEquals("Maria, Apendicitis, A", heap.remove().toString());
    }

    @Test
    public void testRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        Paciente p1 = new Paciente("Juan", "Fractura", "C", 0);
        Paciente p2 = new Paciente("Pedro", "Dolor", "B", 1);

        heap.add(p1);
        heap.add(p2);

        Paciente primero = heap.remove(); // Debe salir Pedro (B)
        Paciente segundo = heap.remove(); // Luego Juan (C)

        assertEquals("Pedro, Dolor, B", primero.toString());
        assertEquals("Juan, Fractura, C", segundo.toString());
        assertTrue(heap.isEmpty());
    }
}
