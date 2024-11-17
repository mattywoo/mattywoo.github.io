//Cruz Matthew 11/16/2024

package module03_modified; // Defines the package for the class

import java.util.Date; // Importing Date to track deadlines and completion status

// Task class representing a task with an ID, name, description, deadline, and completion status
public class Task {
    private final String taskId; // Unique identifier for the task (final because it shouldn't change)
    private String name; // Name of the task
    private String description; // Description of the task
    private Date deadline; // Deadline for the task
    private boolean isCompleted; // Status of the task (completed or not)
	@SuppressWarnings("unused")
	private Object status;

    // Constructor to initialize a new Task object with taskId, name, and description
    public Task(String taskId, String name, String description) {
        this.taskId = taskId; // Assigns the task ID
        this.name = name; // Assigns the name of the task
        this.description = description; // Assigns the description of the task
        this.deadline = null; // Deadline initially set to null
        this.isCompleted = false; // Task initially set as not completed
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

    // Getter method for the task deadline
    public Date getDeadline() {
        return deadline; // Returns the task deadline
    }

    // Setter method for the task deadline
    public void setDeadline(Date deadline) {
        this.deadline = deadline; // Sets the task deadline
    }

    // Getter method for the completion status of the task
    public boolean isCompleted() {
        return isCompleted; // Returns whether the task is completed or not
    }

    // Marks the task as completed
    public void markAsCompleted() {
        this.isCompleted = true; // Sets the task as completed
    }

    // Marks the task as not completed
    public void markAsNotCompleted() {
        this.isCompleted = false; // Sets the task as not completed
    }

    // Returns a string representation of the task, including its attributes
    @Override
    public String toString() {
        return "Task ID: " + taskId +
               "\nName: " + name +
               "\nDescription: " + description +
               "\nDeadline: " + (deadline != null ? deadline : "No deadline set") +
               "\nCompleted: " + (isCompleted ? "Yes" : "No");
    }


	// Method to set the task's status
	public void setStatus(String status) {
	    this.status = status; // Assigns the provided value to the 'status' field
	}

	// Method to get the task's status
	public String getStatus() {
	    return (String) this.status; // Returns the current value of the 'status' field
	}
}