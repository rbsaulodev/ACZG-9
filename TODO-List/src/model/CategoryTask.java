package model;

public class CategoryTask {
    private static int idCounter = 0;
    private Integer id;
    private String name;
    private String description;

    public CategoryTask(Integer id, String name, String description) {
        this.id = ++idCounter;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

}
