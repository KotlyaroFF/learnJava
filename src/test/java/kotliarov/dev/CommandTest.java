package kotliarov.dev;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kotliarov.dev.command.task.AddCommand;
import kotliarov.dev.command.task.CompleteCommand;
import kotliarov.dev.command.task.RemoveCommand;
import kotliarov.dev.helpers.CommandHelpers;

public class CommandTest {

  private static final int TEST_TASKS_COUNT = 5;
  private static final int TEST_TASKS_INDEX = 0;

  String testScannerValue = String.valueOf(TEST_TASKS_INDEX) + "\n";

  private TaskManager taskManager;

  @BeforeEach
  private void setUp() {
    taskManager = new TaskManager();
  }

  @Test
  public void TestAddCommand() {
    AddCommand addCommand = new AddCommand(taskManager, new Scanner("test task"));
    addCommand.execute();
    CommandHelpers.assertTaskAdded(taskManager, "test task");
  }

  @Test
  public void TestCompleteCommand() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i);
    }
    CompleteCommand completeCommand = new CompleteCommand(taskManager, new Scanner(testScannerValue));
    completeCommand.execute();
    CommandHelpers.assertTaskCompleted(taskManager, TEST_TASKS_INDEX);
  }

  @Test
  public void TestRemoveTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i);
    }

    String removedTaskDescription = taskManager.getTasks().get(TEST_TASKS_INDEX).getDescription();

    RemoveCommand removeCommand = new RemoveCommand(taskManager, new Scanner(testScannerValue));
    removeCommand.execute();
    List<String> taskDescriptionsAfterRemoval = taskManager.getTasks().stream().map(Task::getDescription)
        .collect(Collectors.toList());

    CommandHelpers.assertRemoveTask(taskManager, removedTaskDescription, taskDescriptionsAfterRemoval);
  }

}
