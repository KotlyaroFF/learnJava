package kotliarov.dev.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import kotliarov.dev.command.base.ListCommand;
import kotliarov.dev.command.task.AddCommand;
import kotliarov.dev.command.task.CompleteCommand;
import kotliarov.dev.command.task.DeleteCommand;
import kotliarov.dev.command.task.RemoveCommand;
import kotliarov.dev.task.TaskManager;

public class CommandProcessor {

  private Map<String, Command> commands = new HashMap<>();

  public CommandProcessor(TaskManager taskManager, Scanner scanner) {
    commands.put("add", new AddCommand(taskManager, scanner));
    commands.put("list", new ListCommand(taskManager, scanner));
    commands.put("complete", new CompleteCommand(taskManager, scanner));
    commands.put("remove", new RemoveCommand(taskManager, scanner));
    commands.put("delete", new DeleteCommand(taskManager, scanner));

  }

  public void process(String commandName) {
    Command command = commands.get(commandName);
    if (command != null) {
      command.execute();
    } else {
      System.out.println("Unknown command. Try again.");
    }
  }
}
