package kotliarov.dev;

public class Task {
    private String description;   // Описание задачи
    private boolean isCompleted;  // Статус выполнения задачи

    // Конструктор для создания новой задачи
    public Task (String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Получить описание задачи
    public String getDescription() {
        return description;
    }

    // Проверить, выполнена ли задача
    public boolean isCompleted() {
        return isCompleted;
    }

    // Отметить задачу как выполненную
    public void markAsCompleted() {
        this.isCompleted = true;
    }
}