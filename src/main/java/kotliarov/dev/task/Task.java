package kotliarov.dev.task;

public class Task {
    private static int idCounter = 0; // Static field for ID incrementation
    private int id;
    private String description; // Task description
    private TaskStatus taskStatus; // Task status
    private TaskType taskType; // Task type

    // Constructor for creating a new task
    public Task(String description, TaskType type) {
        this.id = ++idCounter;
        this.description = description;
        this.taskStatus = TaskStatus.NEW;
        this.taskType = type;
    }

    // Get task id
    public int getId() {
        return id;
    }

    // Get task description
    public String getDescription() {
        return description;
    }

    // Get task status
    public TaskStatus getStatus() {
        return taskStatus;
    }

    // Update task status
    public Task updateStatus(TaskStatus status) {
        taskStatus = status;
        return this;
    }

    // Get task type
    public TaskType getType() {
        return taskType;
    }

    // Update task type
    public Task updateType(TaskType type) {
        taskType = type;
        return this;
    }
}