package kotliarov.dev.command.task;

import java.util.Scanner;

import kotliarov.dev.command.BaseCommand;
import kotliarov.dev.task.TaskManager;
import kotliarov.dev.task.TaskType;

public class AddCommand extends
    BaseCommand {

  public AddCommand(TaskManager taskManager, Scanner scanner) {
    super(taskManager, scanner);
  }

  @Override
  public void execute() {
    System.out.println("Enter task description: ");
    String description = scanner.nextLine();
    taskManager.addTask(description, TaskType.PERSONAL);
    showSuccess();
  }

}
