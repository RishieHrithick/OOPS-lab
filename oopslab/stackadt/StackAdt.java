package stackadt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StackAdt {

    private static PrintWriter logWriter;

    public static void main(String[] args) {
        try {
            logWriter = new PrintWriter(new FileWriter("stack_log.txt", true)); // append mode
        } catch (IOException e) {
            System.out.println("Failed to open log file: " + e.getMessage());
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial stack size: ");
        logWriter.println("Enter initial stack size: ");
        int initialSize = sc.nextInt();
        sc.nextLine(); // consume newline
        logWriter.println(initialSize);
        logWriter.flush();

        StackArray<String> stack = new StackArray<>(initialSize);

        int choice;
        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push  2. Pop  3. Display  4. Exit");

            System.out.print("Choice: ");
            logWriter.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            logWriter.println(choice);
            logWriter.flush();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter value to push: ");
                        logWriter.println("Enter value to push: ");
                        String value = sc.nextLine();
                        logWriter.println(value);
                        logWriter.println("Pushed " + value);
                        logWriter.flush();

                        stack.push(value);
                    }
                    case 2 -> {
                        String popped = stack.pop();
                        logWriter.println("Popped " + popped);
                        logWriter.flush();
                    }
                    case 3 -> {
                        stack.display();
                        logWriter.println("Displayed stack: " + stack.toString());
                        logWriter.flush();
                    }
                    case 4 -> {
                        logWriter.println("exit ...");
                        logWriter.flush();
                    }
                    default -> {
                        System.out.println("Invalid choice. Try again.");
                        logWriter.println("Invalid choice: " + choice);
                        logWriter.flush();
                    }
                }
            } catch (Exception e) {
                logWriter.println("Exception: " + e.getMessage());
                logWriter.flush();
            }

        } while (choice != 4);

        sc.close();
        logWriter.close();
    }
}

