package service;

import model.CategoryTask;
import model.Task;
import model.enums.Priority;
import model.enums.StatusTask;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoManager {
    private List<Task> tasks = new ArrayList<>();

    private void addTask(Task task) {
        tasks.add(task);
        Collections.sort(tasks);
    }


    //Sistema de Memória
    private void saveAllDataCSV() {
        String filename = "src/data/tasks.csv";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("id,name,description,dateToEnd,priority,category,status");
            for (Task t : tasks) {
                pw.println(t.toCSV());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public void loadTasksCSV(CategoryManager catManager) {
        String path = "src/data/tasks.csv";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                int catId = Integer.parseInt(d[5].trim());
                CategoryTask cat = catManager.findById(catId);

                if (cat != null) {
                    Task task = Task.createTask(d[1], d[2], LocalDate.parse(d[3], fmt), Priority.fromCode(Integer.parseInt(d[4])), cat);
                    task.setStatus(StatusTask.valueOf(d[6].trim()));
                    this.tasks.add(task);
                } else {
                    System.out.println("⚠️ Alerta: Categoria ID " + catId + " não encontrada para a tarefa '" + d[1] + "'. Pulando...");
                }
            }
            Collections.sort(tasks);
        } catch (IOException e) {
            System.out.println("Arquivo de tarefas não encontrado.");
        }
    }

    // CRUD
    public void createTask(String name, String description, LocalDate dateToEnd, Priority priority, CategoryTask category) {
        Task newTask = Task.createTask(name, description, dateToEnd, priority, category);
        this.addTask(newTask);
        saveAllDataCSV();
        System.out.println("Nova tarefa criada com ID: " + newTask.getId());
    }

    public void updateTask(Integer id, String name, String description, LocalDate dateToEnd, Priority priority, StatusTask status) {
        tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        task -> {
                            task.updateData(name, description, dateToEnd, priority, status);
                            Collections.sort(tasks);
                            saveAllDataCSV();
                            System.out.println("Tarefa atualizada!");
                        },
                        () -> System.out.println("ID não encontrado.")
                );
    }

    public void removeTask(Integer id) {
        if (tasks.removeIf(t -> t.getId().equals(id))) {
            System.out.println("Removida.");
            saveAllDataCSV();
        } else {
            System.out.println("Não encontrada.");
        }
    }

    public Task findById(Integer id) {
        return tasks.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        }

    public void listAllTasks() {
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