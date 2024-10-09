
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jc
 */
public class UserInterface {

    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            String command = this.ask("Command: ");
            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                String task = this.ask("Task: ");
                this.list.add(task);
            } else if (command.equals("list")) {
                this.list.print();
            } else if (command.equals("remove")) {
                int task = Integer.valueOf(this.ask("Which task was completed? "));
                this.list.remove(task);
            }
        }
    }

    private String ask(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }

}
