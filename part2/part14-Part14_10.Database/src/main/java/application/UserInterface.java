package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            if (command.equals("1")) {
                list();
            } else if (command.equals("2")) {
                add();
            } else if (command.equals("3")) {
                markAsDone();
            } else if (command.equals("4")) {
                remove();
            } else {
                System.err.println(command + " not recognized");
            }
        }

        System.out.println("Thank you!");
    }

    private void list() {
        System.out.println("Listing the database contents");
        try {
            List<Todo> todos = database.list();
            todos.forEach(todo -> System.out.println(todo));
        } catch (SQLException e) {
            System.err.println("DAO error: " + e.toString());
        }
    }

    private void add() {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();

        try {
            database.add(new Todo(name, description, false));
        } catch (SQLException e) {
            System.err.println("DAO error: " + e.toString());
        }
    }

    private void markAsDone() {
        int id = askInteger("Which todo should be marked as done (give the id)?");

        try {
            database.markAsDone(id);
        } catch (SQLException e) {
            System.err.println("DAO error: " + e.toString());
        }
    }

    private void remove() {
        int id = askInteger("Which todo should be marked as done (give the id)?");

        try {
            database.remove(id);
        } catch (SQLException e) {
            System.err.println("DAO error: " + e.toString());
        }
    }

    private int askInteger(String question) {
        while (true) {
            System.out.println(question);
            String number = scanner.nextLine();
            try {
                return Integer.valueOf(number);
            } catch (NumberFormatException e) {
                System.err.println(number + " is not an integer. Error: " + e.toString());
            }
        }
    }
}
