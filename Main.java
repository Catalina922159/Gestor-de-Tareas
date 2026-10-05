/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 24485191
 */
import java.util.ArrayList;
import java.util.Scanner;

// Clase que representa una Tarea individual
class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    @Override
    public String toString() {
        String estado = completada ? "[X]" : "[ ]";
        return estado + " " + descripcion;
    }
}

// Clase principal con la lógica del menú
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarea> listaTareas = new ArrayList<>();
        int opcion = 0;

        System.out.println("=== GESTOR DE TAREAS BÁSICO ===");

        do {
            System.out.println("\nElegí una opción:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver lista de tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Escribí la descripción de la tarea: ");
                        String desc = scanner.nextLine();
                        listaTareas.add(new Tarea(desc));
                        System.out.println("¡Tarea agregada con éxito!");
                        break;

                    case 2:
                        System.out.println("\n--- TUS TAREAS ---");
                        if (listaTareas.isEmpty()) {
                            System.out.println("No hay tareas registradas.");
                        } else {
                            for (int i = 0; i < listaTareas.size(); i++) {
                                System.out.println((i + 1) + ". " + listaTareas.get(i));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Número de tarea a completar: ");
                        if (scanner.hasNextInt()) {
                            int num = scanner.nextInt();
                            if (num > 0 && num <= listaTareas.size()) {
                                listaTareas.get(num - 1).marcarComoCompletada();
                                System.out.println("¡Tarea marcada como completada!");
                            } else {
                                System.out.println("Número de tarea inválido.");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("¡Saliendo del programa. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción no válida. Intentá de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingresá un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
            }

        } while (opcion != 4);

        scanner.close();
    }
}

