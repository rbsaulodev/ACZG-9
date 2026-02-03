package main;

import model.enums.Priority;
import model.enums.StatusTask;
import service.CategoryManager;
import service.TodoManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuHandler {
    public static void exibirMenuTarefas(Scanner scanner, TodoManager taskManager, CategoryManager categoryManager) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n--- TAREFAS ---");
        System.out.println("1. Criar Nova Tarefa");
        System.out.println("2. Listar Todas");
        System.out.println("3. Atualizar Status");
        System.out.println("4. Remover Tarefa");
        System.out.print("Escolha: ");

        scanner = new Scanner(System.in);
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("--- CRIAR NOVA TAREFA ---");
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();

                    System.out.print("Data de término (dd/MM/yyyy): ");
                    String dataInput = scanner.nextLine();

                    LocalDate dateToEnd = LocalDate.parse(dataInput, formatter);

                    System.out.print("Prioridade (1 a 5): ");
                    int code = Integer.parseInt(scanner.nextLine());
                    Priority priority = Priority.fromCode(code);

                    System.out.println("\nCategorias Disponíveis:");
                    categoryManager.listAllCategories();
                    System.out.print("Digite o ID da categoria desejada: ");
                    int catId = Integer.parseInt(scanner.nextLine());

                    var category = categoryManager.findById(catId);

                    if (category != null) {
                        taskManager.createTask(name, description, dateToEnd, priority, category);
                        System.out.println("Tarefa vinculada à categoria: " + category.getName());
                    } else {
                        System.out.println("Erro: Categoria não encontrada! Crie a categoria primeiro.");
                    }

                    break;

                case 2:
                    taskManager.listAllTasks();
                    break;

                case 3:
                    System.out.println("\n--- ATUALIZAR TAREFA ---");
                    taskManager.listAllTasks();
                    System.out.print("Digite o ID da tarefa que deseja alterar: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    var tarefaExistente = taskManager.findById(id);
                    if (tarefaExistente == null) {
                        System.out.println("❌ Erro: Tarefa não encontrada!");
                        break;
                    }

                    System.out.print("Novo Nome (Enter para manter): ");
                    String nameToUpdate = scanner.nextLine();

                    System.out.print("Nova Descrição (Enter para manter): ");
                    String descriptionToUpdate = scanner.nextLine();


                    System.out.print("Nova Data (dd/MM/yyyy) (Enter para manter): ");
                    String dataInputToUpdate = scanner.nextLine();
                    LocalDate dateToEndToUpdate = null;
                    if (!dataInputToUpdate.isBlank()) {
                        dateToEndToUpdate = LocalDate.parse(dataInputToUpdate, formatter);
                    }

                    System.out.print("Nova Prioridade (1-5) (Enter para manter): ");
                    String prioInput = scanner.nextLine();
                    Priority priorityToUpdate = null;
                    if (!prioInput.isBlank()) {
                        priorityToUpdate = Priority.fromCode(Integer.parseInt(prioInput));
                    }

                    System.out.print("Novo Status (1-TODO, 2-DOING, 3-DONE) (Enter para manter): ");
                    String statusInput = scanner.nextLine();
                    StatusTask statusToUpdate = null;
                    if (!statusInput.isBlank()) {
                        statusToUpdate = StatusTask.fromCode(Integer.parseInt(statusInput));
                    }

                    taskManager.updateTask(id, nameToUpdate, descriptionToUpdate, dateToEndToUpdate, priorityToUpdate, statusToUpdate);
                    break;
                case 4:
                    System.out.println("\n--- REMOVER TAREFA ---");
                    taskManager.listAllTasks();
                    int idTaskToRemove = Integer.parseInt(scanner.nextLine());
                    System.out.println("Id: ");
                    taskManager.removeTask(idTaskToRemove);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite apenas números.");
        }
    }

    public static void exibirMenuCategorias(Scanner scanner, CategoryManager categoryManager) {
        System.out.println("\n--- MENU DE CATEGORIAS ---");
        System.out.println("1. Criar Categoria");
        System.out.println("2. Listar Todas");
        System.out.println("3. Atualizar Categoria");
        System.out.println("4. Remover Categoria");
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");

        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("\n--- 🆕 NOVA CATEGORIA ---");
                    System.out.print("Nome da Categoria: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();

                    categoryManager.createCategory(nome, desc);
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE CATEGORIAS ---");
                    categoryManager.listAllCategories();
                    break;

                case 3:
                    System.out.println("\n--- ATUALIZAR CATEGORIA ---");
                    categoryManager.listAllCategories();
                    System.out.print("ID da categoria que deseja editar: ");
                    int idEdit = Integer.parseInt(scanner.nextLine());

                    System.out.print("Novo Nome (Enter para manter): ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Descrição (Enter para manter): ");
                    String novaDesc = scanner.nextLine();

                    categoryManager.updateCategory(idEdit, novoNome, novaDesc);
                    break;

                case 4:
                    System.out.println("\n--- REMOVER CATEGORIA ---");
                    categoryManager.listAllCategories();
                    System.out.print("ID da categoria para remover: ");
                    int idRem = Integer.parseInt(scanner.nextLine());

                    categoryManager.removeCategory(idRem);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite apenas números para a opção e ID.");
        }
    }
}
