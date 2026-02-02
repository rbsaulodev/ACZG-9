package model;

import model.enums.Priority;
import model.enums.StatusTask;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {
    private String name;
    private String description;
    private LocalDate dateToEnd;
    private Priority priority;
    private CategoryTask category;
    private StatusTask status;

    public Task(String name, String description, LocalDate dateToEnd, Priority priority, CategoryTask category, StatusTask status) {
        this.name = name;
        this.description = description;
        this.dateToEnd = dateToEnd;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    @Override
    public int compareTo(Task other) {
        return other.getPriority().getNumber().compareTo(this.priority.getNumber());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s [%s] | Prioridade: %d | Fim: %s | Cat: %s\n   Obs: %s",
                status, name, priority.getNumber(), dateToEnd.format(formatter), category.getName(), description);
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
}
