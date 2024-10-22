package kotliarov.dev.command.base;

import java.util.Scanner;

import kotliarov.dev.command.BaseCommand;
import kotliarov.dev.task.TaskManager;

public class ListCommand extends BaseCommand {

  public ListCommand(TaskManager taskManager, Scanner scanner) {
    super(taskManager, scanner);
  }

  @Override
  public void execute() {
    taskManager.listTasks();
  }

}
