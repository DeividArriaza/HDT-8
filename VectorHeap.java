import java.util.Vector;
/*
 * Clase VectorHeap para una cola de prioridad
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector<E>();
    }

    /*
     * En el vector, cada nodo tendrá a su padre, hijo izquierdo, 
     * e hijo derecho con base en su posición actual
     */
    private int parent(int i) { 
        return (i - 1) / 2; 
    }
    private int left(int i) { 
        return 2 * i + 1; 
    }
    private int right(int i) {
         return 2 * i + 2;
    }


    /*
     * Metodo para colocar a una hoja en su posición correcta dentro dle arbol
     */
    private void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /*
     * Método para bajar la raíz, esto sirve para cuando se desea eliminar (sacar) el valor de mayor prioridad
     */
    private void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int child = left(root);
            if (child < heapSize) {
                int right = right(root);
                if (right < heapSize && data.get(right).compareTo(data.get(child)) < 0) {
                    child = right;
                }
                if (data.get(child).compareTo(value) < 0) {
                    data.set(root, data.get(child));
                    root = child;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        data.set(root, value);
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        E minVal = data.get(0);
        E last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            pushDownRoot(0);
        }
        return minVal;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
