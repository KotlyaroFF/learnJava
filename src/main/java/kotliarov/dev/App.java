package kotliarov.dev;

import java.util.Scanner;

import kotliarov.dev.command.CommandProcessor;

public class App {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        CommandProcessor processor = new CommandProcessor(taskManager, scanner);
        String command;

        System.out.println(OutCommand.intro);

        do {
            command = scanner.nextLine().trim();
            processor.process(command);
            System.out.println(OutCommand.baseOut);

        } while (!command.equals("exit"));

        scanner.close();
    }
}
