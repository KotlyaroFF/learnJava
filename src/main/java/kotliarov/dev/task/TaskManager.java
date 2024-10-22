package kotliarov.dev.task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
  private List<Task> tasks;

  public TaskManager() {
    tasks = new ArrayList<>();
  }

  public void addTask(String description, TaskType type) {
    tasks.add(new Task(description, type));
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public boolean deleteTask(int index) {
    if (index >= 0 && index < tasks.size()) {
      tasks.remove(index);
      return true;
    } else {
      return false;
    }
  }

  public TaskStatus updateTaskStatus(int index, TaskStatus status) {
    if (index >= 0 && index < tasks.size()) {
      tasks.get(index).updateStatus(status);
      return tasks.get(index).getStatus();
    } else {
      return null;
    }
  }

  public TaskType updateTaskType(int index, TaskType type) {
    if (index >= 0 && index < tasks.size()) {
      tasks.get(index).updateType(type);
      return tasks.get(index).getType();
    } else {
      return null;
    }
  }

  public void listTasks() {
    if (tasks.size() == 0) {
      System.out.println("The list does not contain any elements.");
    }
    for (int i = 0; i < tasks.size(); i++) {
      Task task = tasks.get(i);
      System.out.println(
          (i + 1) + ". " + task.getDescription() + " [" + (task.getStatus()) + "]");
    }
  }

}
