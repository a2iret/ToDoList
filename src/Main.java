import enums.ToDoListStatus;
import models.ToDoList;
import services.ToDoListService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ToDoListService toDoListService = new ToDoListService();
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("Выберите действия:\n1. Создать\n2. Редактировать\n3. Удалить \n4. Показать задачи \n5. Выполнить задачу");
            System.out.print("\nВыберите номер действия (1-5): ");
            int answer = scan.nextInt();
            switch (answer) {
                case 1:
                    System.out.print("\nВведите текстовое описание задачи: ");
                    toDoListService.createToDoList(scan.next());
                    break;
                case 2:
                    System.out.print("\nВведите идентификатор задачи для редоктирование: ");
                    int answerUpdate = scan.nextInt();
                    System.out.print("\nВведите новое текстовое описание задачи: ");
                    System.out.println(toDoListService.updateToDoList(answerUpdate, scan.next()));
                    break;
                case 3:
                    System.out.print("\nВведите идентификатор задачи для удаления: ");
                    System.out.println(toDoListService.deleteToDoList(scan.nextInt()));
                    break;
                case 4:
                    System.out.println("Список задач:");
                    toDoListService.showAllNotes();
                    break;
                case 5:
                    System.out.print("\nВведите идентификатор задачи если вы выполнили задание: ");
                    System.out.println(toDoListService.completeTask(scan.nextInt()));
                    break;
                default:
                    System.out.println("\nВведите правильное значение!\n");
            }
        }
    }
}
