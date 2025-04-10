public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private String descripcion;
    private int llegada;
    private String priority;

    public Paciente(String nombre, String descripcion, String priority, int llegada){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.priority = priority; 
        this.llegada= llegada;
    }
    @Override
    public int compareTo(Paciente p){ //-1 quien debe ser atendido antes, 1 si debe ser atendido después
        if(this.priority.compareTo(p.priority) == 0){
            if(this.llegada < p.llegada){
                return -1;
            }
            return 1;
        }
        return this.priority.compareTo(p.priority);
    }

    @Override
    public String toString(){
        return nombre + ", " + descripcion + ", " + priority; 
    }

}