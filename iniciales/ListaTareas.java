package iniciales;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaTareas {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>(); // lista de tasks
        Scanner scanner = new Scanner(System.in);
        int choice;

        // do-while: lo ejecutará al menos una vez
        do {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.println("Choose an option:");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume la nueva línea

            switch (choice) {
                case 1:
                    System.out.println("Enter task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    break;
                case 2:
                    System.out.println("Your tasks: ");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Enter task number to remove: ");
                    int taskNumber = scanner.nextInt();
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        tasks.remove(taskNumber - 1);
                    } else {
                        System.out.println("ERROR! Invalid task number.");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye! :) ");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }
}
