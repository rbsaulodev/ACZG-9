package service;

import model.CategoryTask;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    private List<CategoryTask> categories = new ArrayList<>();

    public void addTask(CategoryTask category) {
        categories.add(category);
    }

    public void updateCategory(Integer id, String name, String description) {
        categories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        category -> {
                            category.updateData(name, description);
                            System.out.println("Categoria atualizada!");
                        },
                        () -> System.out.println("Categoria não encontrada.")
                );
    }

    public void removeCategory(Integer id) {
        if (categories.removeIf(t -> t.getId().equals(id))) {
            System.out.println("Removida.");
        } else {
            System.out.println("Não encontrada.");
        }
    }

    public void listCategories() {
        if (categories.isEmpty()) System.out.println("Lista vazia.");
        else categories.forEach(System.out::println);
    }

    public CategoryTask findById(Integer id) {
        return categories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
