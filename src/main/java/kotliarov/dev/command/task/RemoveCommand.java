package kotliarov.dev.command.task;

import java.util.Scanner;

import kotliarov.dev.command.BaseCommand;
import kotliarov.dev.task.TaskManager;
import kotliarov.dev.task.TaskStatus;

public class RemoveCommand extends BaseCommand {

  public RemoveCommand(TaskManager taskManager, Scanner scanner) {
    super(taskManager, scanner);
  }

  @Override
  public void execute() {
    System.out.println("Enter task number to remove: ");
    int index = scanner.nextInt();
    if (taskManager.updateTaskStatus(index - 1, TaskStatus.DELETED) != null) {
      showSuccess();
    } else {
      System.out.println("Task not found.");
    }
    scanner.nextLine();
  }
}
