package kotliarov.dev.command;

import java.util.Scanner;

import kotliarov.dev.task.TaskManager;

public abstract class BaseCommand implements Command {
  protected TaskManager taskManager;
  protected Scanner scanner;

  public BaseCommand(TaskManager taskManager, Scanner scanner) {
    this.taskManager = taskManager;
    this.scanner = scanner;
  }

  protected void showSuccess() {
    System.out.println("--success--");
    taskManager.listTasks();
  }
}
