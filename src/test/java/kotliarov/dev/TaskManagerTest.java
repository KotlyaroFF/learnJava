package kotliarov.dev;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kotliarov.dev.helpers.CommandHelpers;

public class TaskManagerTest {
  private TaskManager taskManager;

  private static final int TEST_TASKS_COUNT = 5;
  private static final int TEST_TASKS_INDEX = 3;

  @BeforeEach
  void setUp() {
    taskManager = new TaskManager();
  }

  @Test
  void testAddTask() {
    taskManager.addTask("test task");
    CommandHelpers.assertTaskAdded(taskManager, "test task");
  }

  @Test
  void testCompleteTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i);
    }
    taskManager.markTaskAsCompleted(TEST_TASKS_INDEX);
    CommandHelpers.assertTaskCompleted(taskManager, TEST_TASKS_INDEX);
  }

  @Test
  void testRemoveTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i);
    }
    String removedTaskDescription = taskManager.getTasks().get(TEST_TASKS_INDEX).getDescription();
    taskManager.removeTask(TEST_TASKS_INDEX);

    List<String> taskDescriptionsAfterRemoval = taskManager.getTasks().stream().map(Task::getDescription)
        .collect(Collectors.toList());
    CommandHelpers.assertRemoveTask(taskManager, removedTaskDescription, taskDescriptionsAfterRemoval);
  }

}
