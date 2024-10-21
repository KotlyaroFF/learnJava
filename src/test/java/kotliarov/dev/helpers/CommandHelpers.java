package kotliarov.dev.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import kotliarov.dev.Task;
import kotliarov.dev.TaskManager;

public class CommandHelpers {

  public static void assertTaskAdded(TaskManager taskManager, String description) {
    assertEquals(1, taskManager.getTasks().size(), "Task list should have 1 task");
    assertEquals("test task", taskManager.getTasks().get(0).getDescription(), "Task description should match");
  }

  public static void assertTaskCompleted(TaskManager taskManager, int index) {
    List<Task> tasks = taskManager.getTasks();
    for (int i = 0; i < tasks.size(); i++) {
      Task task = tasks.get(i);
      if (i == index) {
        assertTrue(task.isCompleted(), "Task at index " + i + " should be complete");
      } else {
        assertFalse(task.isCompleted(), "Task at index " + i + " should not be complete");
      }
    }
  }

  public static void assertRemoveTask(TaskManager taskManager, String removedTaskDescription,
      List<String> expectedDescriptions) {
    List<Task> tasks = taskManager.getTasks();

    assertEquals(expectedDescriptions.size(), tasks.size(),
        "The size of the task list should be " + expectedDescriptions.size());

    for (int i = 0; i < tasks.size(); i++) {
      Task task = tasks.get(i);
      String description = task.getDescription();

      assertNotEquals(removedTaskDescription, description, "Removed task should not be in the list");

      assertEquals(expectedDescriptions.get(i), description,
          "Task at index " + i + " should have the expected description");

    }
  }
}
