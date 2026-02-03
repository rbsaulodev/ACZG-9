package service;

import model.Task;
import model.enums.Priority;
import model.enums.StatusTask;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void updateTask(Integer id, String name, String description, LocalDate dateToEnd, Priority priority, StatusTask status) {
        tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        task -> {
                            task.updateData(name, description, dateToEnd, priority, status);
                            Collections.sort(tasks);
                            System.out.println("Tarefa atualizada!");
                        },
                        () -> System.out.println("ID não encontrado.")
                );
    }

    public void removeTask(Integer id) {
        if (tasks.removeIf(t -> t.getId().equals(id))) {
            System.out.println("Removida.");
        } else {
            System.out.println("Não encontrada.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) System.out.println("Lista vazia.");
        else tasks.forEach(System.out::println);
    }

    public void listDoneTasks() {
        tasks.stream()
                .filter(t -> t.getStatus() == StatusTask.DONE)
                .forEach(System.out::println);
    }

    public void listToDoTaks(){
        tasks.stream()
                .filter(t -> t.getStatus() == StatusTask.TODO)
                .forEach(System.out::println);
    }

    public void listDoingTaks(){
        tasks.stream()
                .filter(t -> t.getStatus() == StatusTask.DOING)
                .forEach(System.out::println);
    }

    public void listTaskByNumber(Integer number){
        tasks.stream()
                .filter(t -> t.getStatus() == StatusTask.fromCode(number))
                .forEach(System.out::println);
    }
}