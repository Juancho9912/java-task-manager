package service;
import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private List<Task> tasks;

	public TaskManager() {
		this.tasks = new ArrayList<>();
	}

	public void addTask(Task task) {
		for (Task t : tasks){
			if (t.getId() == task.getId()) {
				throw new IllegalArgumentException("Ya existe una tarea con el ID: " + task.getId());
			}else if (t.getTitulo().equals(task.getTitulo())) {
				throw new IllegalArgumentException("Ya existe una tarea con el título: " + task.getTitulo());
			}
		}
		tasks.add(task);
	}

	public Task searchTaskforId(int id) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				return task;
			}
		}
		throw new IllegalArgumentException("No se encontró una tarea con el ID: " + id);
    }

    public void deleteTask(int id) {
		Task task = searchTaskforId(id);
		tasks.remove(task);
    }

    public void marcarComoCompletada(int id) {
		Task task = searchTaskforId(id);
		task.completar();
    }

    public void listTask() {
		if (tasks.isEmpty()) {
			System.out.println("No hay tareas registradas.");
			return;
		} else {
			for (Task task: tasks) {
				System.out.println(task);
			}
		}
    }

    public void editTask(int id, String nuevoTitulo, String nuevaDescripcion, String nuevaPrioridad) {
		Task task = searchTaskforId(id);
		task.setTitulo(nuevoTitulo);
		task.setDescripcion(nuevaDescripcion);
		try {
			task.setPrioridad(nuevaPrioridad);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Prioridad no válida: " + nuevaPrioridad);
		}
    }
}
