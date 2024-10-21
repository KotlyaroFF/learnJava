package kotliarov.dev;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
  private List<Task> tasks;

  public TaskManager() {
    tasks = new ArrayList<>();
  }

  public void addTask(String description) {
    tasks.add(new Task(description));
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public boolean removeTask(int index) {
    if (index >= 0 && index < tasks.size()) {
      tasks.remove(index);
      return true;
    } else {
      return false;
    }
  }

  public boolean markTaskAsCompleted(int index) {
    if (index >= 0 && index < tasks.size()) {
      tasks.get(index).markAsCompleted();
      return true;
    } else {
      return false;
    }
  }

  public void listTasks() {
    if (tasks.size() == 0) {
      System.out.println("List not have elements");
    }
    for (int i = 0; i < tasks.size(); i++) {
      Task task = tasks.get(i);
      System.out.println(
          (i + 1) + ". " + task.getDescription() + " [" + (task.isCompleted() ? "Completed" : "Not Completed") + "]");
    }
  }

}
