package app;

import java.util.Scanner;

import model.Task;
import model.User;
import service.TaskManager;

public class Main {
	public static void main(String[] args) {

		User usuario = new User(1, "Juan Valencia", "juancho@waxboy.com");

		TaskManager taskManager = new TaskManager();

		Scanner scanner = new Scanner(System.in);
        int opcion;

		do {
			System.out.println("Menú de Tareas:");
			System.out.println("1. Agregar tarea");
			System.out.println("2. Listar tareas");
			System.out.println("3. Editar tarea");
			System.out.println("4. Marcar tarea como completada");
			System.out.println("5. Eliminar tarea");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer cuando es int en otra linea cuando es string en la misma linea

			switch (opcion) {

				case 1:

					try{
						System.out.println("Agregar nueva tarea:");
						System.out.print("Ingrese el ID de la tarea: ");
						int id = scanner.nextInt();
						scanner.nextLine(); // Limpiar el buffer
						System.out.print("Ingrese el título de la tarea: ");
						String titulo = scanner.nextLine();
						System.out.print("Ingrese la descripción de la tarea: ");
						String descripcion = scanner.nextLine();
						System.out.print("Ingrese la prioridad de la tarea (Baja, Media, Alta): ");
						String prioridad = scanner.nextLine();

						Task nuevaTarea = new Task (id, titulo, descripcion, prioridad);
						taskManager.addTask(nuevaTarea);
						System.out.println("Tarea agregada exitosamente: " + nuevaTarea.getTitulo());
					} catch (IllegalArgumentException e) {
						System.out.println("Error al agregar la tarea: " + e.getMessage());
					}
					break;

				case 2:

					System.out.println("Listando tareas:");
					taskManager.listTask();

					break;

				case 3:

					try {
						System.out.println("Editar tarea:");
						System.out.print("Ingrese el ID de la tarea a editar: ");
						int id = scanner.nextInt();
						scanner.nextLine(); // Limpiar el buffer
						System.out.print("Ingrese el nuevo título de la tarea: ");
						String nuevoTitulo = scanner.nextLine();
						System.out.print("Ingrese la nueva descripción de la tarea: ");
						String nuevaDescripcion = scanner.nextLine();
						System.out.print("Ingrese la nueva prioridad de la tarea (Baja, Media, Alta): ");
						String nuevaPrioridad = scanner.nextLine();

						taskManager.editTask(id, nuevoTitulo, nuevaDescripcion, nuevaPrioridad);
						System.out.println("Tarea editada exitosamente.");
					} catch (IllegalArgumentException e) {
						System.out.println("Error al editar la tarea: " + e.getMessage());
					}
					break;

				case 4:
					
					try {
						System.out.println("Marcar tarea como completada:");
						System.out.print("Ingrese el ID de la tarea a marcar como completada: ");
						int id = scanner.nextInt();
						scanner.nextLine(); // Limpiar el buffer
						taskManager.marcarComoCompletada(id);
						System.out.println("Tarea marcada como completada exitosamente.");

					} catch (IllegalArgumentException e) {
						System.out.println("Error al marcar la tarea como completada: " + e.getMessage());
					}

					break;

				case 5:
					try {
						System.out.println("Eliminar tarea:");
						System.out.print("Ingrese el ID de la tarea a eliminar: ");
						int id = scanner.nextInt();
						scanner.nextLine(); // Limpiar el buffer
						taskManager.deleteTask(id);
						System.out.println("Tarea eliminada exitosamente.");
					} catch (IllegalArgumentException e) {
						System.out.println("Error al eliminar la tarea: " + e.getMessage());
					}
					break;
				case 6: 
					System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
			}
		} while (opcion != 6);
			scanner.close(); {
			
		}

	}
}
