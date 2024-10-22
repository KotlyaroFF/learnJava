package kotliarov.dev;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kotliarov.dev.helpers.CommandHelpers;
import kotliarov.dev.task.Task;
import kotliarov.dev.task.TaskManager;
import kotliarov.dev.task.TaskStatus;
import kotliarov.dev.task.TaskType;

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
    taskManager.addTask("test task", TaskType.PERSONAL);
    CommandHelpers.assertTaskAdded(taskManager, "test task");
  }

  @Test
  void testCompleteTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i, TaskType.PERSONAL);
    }
    taskManager.updateTaskStatus(TEST_TASKS_INDEX, TaskStatus.COMPLETED);
    CommandHelpers.assertTaskCompleted(taskManager, TEST_TASKS_INDEX);
  }

  @Test
  void testRemoveTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i, TaskType.PERSONAL);
    }
    taskManager.updateTaskStatus(TEST_TASKS_INDEX, TaskStatus.DELETED);
    CommandHelpers.assertTaskRemoved(taskManager, TEST_TASKS_INDEX);
  }

  @Test
  void testDeleteTask() {
    for (int i = 0; i < TEST_TASKS_COUNT; i++) {
      taskManager.addTask("Task " + i, TaskType.PERSONAL);
    }
    String removedTaskDescription = taskManager.getTasks().get(TEST_TASKS_INDEX + 1).getDescription();
    taskManager.deleteTask(TEST_TASKS_INDEX + 1);

    List<String> taskDescriptionsAfterRemoval = taskManager.getTasks().stream().map(Task::getDescription)
        .collect(Collectors.toList());
    CommandHelpers.assertDeleteTask(taskManager, removedTaskDescription, taskDescriptionsAfterRemoval);
  }

}
