package kotliarov.dev.command.task;

import java.util.Scanner;

import kotliarov.dev.command.BaseCommand;
import kotliarov.dev.task.TaskManager;

public class DeleteCommand extends BaseCommand {

  public DeleteCommand(TaskManager taskManager, Scanner scanner) {
    super(taskManager, scanner);
  }

  @Override
  public void execute() {
    System.out.println("Enter task number to DELETE: ");
    int index = scanner.nextInt();
    if (taskManager.deleteTask(index - 1)) {
      showSuccess();
    } else {
      System.out.println("Task not found.");
    }
    scanner.nextLine();
  }
}
