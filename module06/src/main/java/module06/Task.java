//Cruz Matthew 04/13/2024

package module06; // Defines the package for the class

// Task class representing a task with an ID, name, and description
public class Task {
    private final String taskId; // Unique identifier for the task (final because it shouldn't change)
    private String name; // Name of the task
    private String description; // Description of the task

    // Constructor to initialize a new Task object with taskId, name, and description
    public Task(String taskId, String name, String description) {
        this.taskId = taskId; // Assigns the task ID
        this.name = name; // Assigns the name of the task
        this.description = description; // Assigns the description of the task
    }

    // Getter method for the task ID
    public String getTaskId() {
        return taskId; // Returns the task ID
    }

    // Getter method for the task name
    public String getName() {
        return name; // Returns the name of the task
    }

    // Setter method for the task name
    public void setName(String name) {
        this.name = name; // Sets the name of the task
    }

    // Getter method for the task description
    public String getDescription() {
        return description; // Returns the description of the task
    }

    // Setter method for the task description
    public void setDescription(String description) {
        this.description = description; // Sets the description of the task
    }
}