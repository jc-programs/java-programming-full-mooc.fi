/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
import java.util.Scanner;

public class UserInterface {

    private TodoList list;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                System.out.print("To add: ");
                String task = this.scanner.nextLine();
                this.list.add(task);
            } else if (command.equals("list")) {
                this.list.print();
            } else if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int number = Integer.valueOf(this.scanner.nextLine());
                this.list.remove(number);
            } else {
                
            }
        }
    }
    
}
