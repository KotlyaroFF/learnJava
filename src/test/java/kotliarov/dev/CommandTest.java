package kotliarov.dev;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kotliarov.dev.command.task.AddCommand;
import kotliarov.dev.command.task.CompleteCommand;
import kotliarov.dev.command.task.DeleteCommand;
import kotliarov.dev.command.task.RemoveCommand;
import kotliarov.dev.helpers.CommandHelpers;
import kotliarov.dev.task.Task;
import kotliarov.dev.task.TaskManager;
import kotliarov.dev.task.TaskType;

public class CommandTest {

  private static final int TEST_TASKS_COUNT = 5;
  private static final int TEST_TASKS_INDEX = 0;
  private static final String TEST_SCANNER_VALUE = String.valueOf(TEST_TASKS_INDEX + 1) + "\n";

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
      taskManager.addTask("Task " + i, TaskType.PERSONAL);
    }
    CompleteCommand completeCommand = new CompleteCommand(taskManager, new Scanner(TEST_SCANNER_VALUE));
    completeCommand.execute();
    CommandHelpers.assertTaskCompleted(taskManager, TEST_TASKS_INDEX);
  }

  @Test
  public void TestRemoveTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i, TaskType.PERSONAL);
    }
    RemoveCommand removeCommand = new RemoveCommand(taskManager, new Scanner(TEST_SCANNER_VALUE));
    removeCommand.execute();
    CommandHelpers.assertTaskRemoved(taskManager, TEST_TASKS_INDEX);
  }

  @Test
  public void TestDeleteTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i, TaskType.PERSONAL);
    }

    String removedTaskDescription = taskManager.getTasks().get(TEST_TASKS_INDEX).getDescription();

    DeleteCommand DeleteCommand = new DeleteCommand(taskManager, new Scanner(TEST_SCANNER_VALUE));
    DeleteCommand.execute();
    List<String> taskDescriptionsAfterRemoval = taskManager.getTasks().stream().map(Task::getDescription)
        .collect(Collectors.toList());

    CommandHelpers.assertDeleteTask(taskManager, removedTaskDescription, taskDescriptionsAfterRemoval);
  }

}
