import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean usarHeapPropio = false;

        System.out.println("Atención de emergencias Hospital Hyun Son");
        System.out.println("Seleccione el tipo de implementación de la cola:");
        System.out.println("1. VectorHeap");
        System.out.println("2. PriorityQueue");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        if (opcion == 1) {
            usarHeapPropio = true;
        } else if (opcion == 2) {
            usarHeapPropio = false;
        } else {
            System.out.println("Opción inválida. Finalizando...");
            return;
        }

        if (usarHeapPropio) {
            VectorHeap<Paciente> cola = new VectorHeap<>();
            cargarPacientesVectorHeap(cola);
            while (!cola.isEmpty()) {
                System.out.print("\nPresiona ENTER para atender al siguiente paciente...");
                scanner.nextLine();
                Paciente siguiente = cola.remove();
                System.out.println("Atendiendo: " + siguiente);
            }
        } else {
            PriorityQueue<Paciente> cola = new PriorityQueue<>();
            cargarPacientes(cola);
            while (!cola.isEmpty()) {
                System.out.print("\nPresiona ENTER para atender al siguiente paciente...");
                scanner.nextLine();
                Paciente siguiente = cola.poll();
                System.out.println("Atendiendo: " + siguiente);
            }
        }

        System.out.println("\n Todos los pacientes han sido atendidos.");
        scanner.close();
    }

    public static void cargarPacientes(java.util.Queue<Paciente> cola) {
        int llegada = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    String prioridad = partes[2].trim().toUpperCase();
                    Paciente paciente = new Paciente(nombre, sintoma, prioridad, llegada++);
                    cola.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void cargarPacientesVectorHeap(VectorHeap<Paciente> cola) {
        int llegada = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    String prioridad = partes[2].trim().toUpperCase();
                    Paciente paciente = new Paciente(nombre, sintoma, prioridad, llegada++);
                    cola.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
