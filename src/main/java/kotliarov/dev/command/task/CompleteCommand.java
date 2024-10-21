package kotliarov.dev.command.task;

import java.util.Scanner;

import kotliarov.dev.TaskManager;
import kotliarov.dev.command.BaseCommand;

public class CompleteCommand extends BaseCommand {

  public CompleteCommand(TaskManager taskManager, Scanner scanner) {
    super(taskManager, scanner);
  }

  @Override
  public void execute() {
    System.out.println("Enter task number to mark as completed: ");
    int task = scanner.nextInt();
    if (taskManager.markTaskAsCompleted(task)) {
      showSuccess();
    } else {
      System.out.println("Task not found.");
    }
    scanner.nextLine();
  }

}
