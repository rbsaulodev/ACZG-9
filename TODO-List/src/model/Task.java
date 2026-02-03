package model;

import model.enums.Priority;
import model.enums.StatusTask;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {
    private static int idCounter = 0;
    private final Integer id;
    private String name;
    private String description;
    private LocalDate dateToEnd;
    private Priority priority;
    private CategoryTask category;
    private StatusTask status;

    private Task(String name, String description, LocalDate dateToEnd, Priority priority, CategoryTask category, StatusTask status) {
        this.id = ++idCounter;
        this.name = name;
        this.description = description;
        this.dateToEnd = dateToEnd;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    public static Task createTask(String name, String description, LocalDate dateToEnd, Priority priority, CategoryTask category) {
        return new Task(name, description, dateToEnd, priority, category, StatusTask.TODO);
    }

    public void updateData(String name, String description, LocalDate dateToEnd, Priority priority, StatusTask status) {
        if (name != null && !name.isBlank()) this.name = name;
        if (description != null && !description.isBlank()) this.description = description;
        if (dateToEnd != null) this.dateToEnd = dateToEnd;
        if (priority != null) this.priority = priority;
        if (status != null) this.status = status;
    }

    @Override
    public int compareTo(Task other) {
        return other.getPriority().getNumber().compareTo(this.priority.getNumber());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("ID: %d | %s [%s] | Prioridade: %s | Fim: %s | Categoria: %s",
                id, status, name, priority.getNumber(), dateToEnd.format(formatter), category.getName());
    }

    public String toCSV() {
        return String.format("%d,%s,%s,%s,%d,%d,%s",
                id,
                name,
                description,
                dateToEnd,
                priority.getNumber(),
                category.getId(),
                status.name()
        );
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateToEnd() {
        return dateToEnd;
    }

    public void setDateToEnd(LocalDate dateToEnd) {
        this.dateToEnd = dateToEnd;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public CategoryTask getCategory() {
        return category;
    }

    public void setCategory(CategoryTask category) {
        this.category = category;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }
}
