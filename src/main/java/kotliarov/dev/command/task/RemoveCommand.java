package kotliarov.dev.command.task;

import java.util.Scanner;

import kotliarov.dev.TaskManager;
import kotliarov.dev.command.BaseCommand;

public class RemoveCommand extends BaseCommand {

  public RemoveCommand(TaskManager taskManager, Scanner scanner) {
    super(taskManager, scanner);
  }

  @Override
  public void execute() {
    System.out.println("Enter task number to remove: ");
    int task = scanner.nextInt();
    if (taskManager.removeTask(task)) {
      showSuccess();
    } else {
      System.out.println("Task not found.");
    }
    scanner.nextLine();
  }
}
