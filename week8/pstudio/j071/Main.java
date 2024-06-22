package pstudio.j071;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main j071 = new Main();
        j071.run();
    }

    public void displayHelp() {
        System.out.println("add: Add a new item");
        System.out.println("del: Delete an item");
        System.out.println("edit: Edit an item");
        System.out.println("ls: List all items");
        System.out.println("ls_name: Sort items by name");
        System.out.println("ls_date: Sort items by date");
        System.out.println("ls_desc: Sort items in descending order");
        System.out.println("exit: Exit the program");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        TodoCRUD manager = new TodoCRUD();
        boolean quit = false;
        do {
            System.out.print("> ");
            String line = sc.nextLine();
            String[] command = line.split(" ");
            String choice = command[0];
            switch (choice) {
                case "add":
                    manager.addItem();
                    break;
                case "del":
                    manager.deleteItem();
                    break;
                case "edit":
                    manager.updateItem();
                    break;
                case "ls":
                    manager.printItem();
                    break;
                case "ls_name":
                    manager.sortByName();
                    manager.printItem();
                    break;
                case "ls_date":
                    manager.sortByDate();
                    manager.printItem();
                    break;
                case "ls_desc":
                    manager.reverseList();
                    manager.printItem();
                    break;
                case "?":
                    displayHelp();
                    break;
                case "exit":
                    quit = true;
                    break;
                default:
                    System.out.println("? for help.");
                    break;
            }
        } while (!quit);
        sc.close();
    }
}
