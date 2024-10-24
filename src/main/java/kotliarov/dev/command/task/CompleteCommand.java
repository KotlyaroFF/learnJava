package kotliarov.dev.command.task;

import java.util.Scanner;

import kotliarov.dev.command.BaseCommand;
import kotliarov.dev.task.TaskManager;
import kotliarov.dev.task.TaskStatus;

public class CompleteCommand extends BaseCommand {

  public CompleteCommand(TaskManager taskManager, Scanner scanner) {
    super(taskManager, scanner);
  }

  @Override
  public void execute() {
    System.out.println("Enter task number to mark as completed: ");
    int index = scanner.nextInt();
    if (taskManager.updateTaskStatus(index - 1, TaskStatus.COMPLETED) != null) {
      showSuccess();
    } else {
      System.out.println("Task not found.");
    }
    scanner.nextLine();
  }

}
