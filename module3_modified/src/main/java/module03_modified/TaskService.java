//Cruz Matthew 11/16/2024

package module03_modified; // Defines the package for the class

import java.util.Date; // For managing task deadlines
import java.util.HashMap; // Imports HashMap class for storing tasks by ID
import java.util.Map; // Imports Map interface for task storage

// Service class to manage tasks, including adding, deleting, updating, and retrieving tasks
public class TaskService {
    // A map to store tasks with taskId as the key and Task as the value
    private final Map<String, Task> tasks;

    // Constructor initializing the tasks map as a new HashMap
    public TaskService() {
        this.tasks = new HashMap<>();
    }

    // Method to add a task to the tasks map
    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task); // Puts the task into the map using its ID as the key
    }

    // Method to delete a task from the tasks map by taskId
    public void deleteTask(String taskId) {
        tasks.remove(taskId); // Removes the task associated with the given taskId from the map
    }

    // Method to update the name of an existing task based on taskId
    public void updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId); // Retrieves the task using the taskId
        if (task != null) { // Checks if the task exists
            task.setName(newName); // Updates the task's name if it exists
        }
    }

    // Method to update the description of an existing task based on taskId
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId); // Retrieves the task using the taskId
        if (task != null) { // Checks if the task exists
            task.setDescription(newDescription); // Updates the task's description if it exists
        }
    }

    // Method to update the deadline of an existing task
    public void updateTaskDeadline(String taskId, Date newDeadline) {
        Task task = tasks.get(taskId); // Retrieves the task using the taskId
        if (task != null) { // Checks if the task exists
            task.setDeadline(newDeadline); // Updates the task's deadline if it exists
        }
    }

    // Method to mark a task as completed
    public void markTaskAsCompleted(String taskId) {
        Task task = tasks.get(taskId); // Retrieves the task using the taskId
        if (task != null) { // Checks if the task exists
            task.markAsCompleted(); // Marks the task as completed
        }
    }

    // Method to mark a task as not completed
    public void markTaskAsNotCompleted(String taskId) {
        Task task = tasks.get(taskId); // Retrieves the task using the taskId
        if (task != null) { // Checks if the task exists
            task.markAsNotCompleted(); // Marks the task as not completed
        }
    }

    // Method to retrieve a task by its taskId
    public Task getTask(String taskId) {
        return tasks.get(taskId); // Returns the task associated with the given taskId
    }

    // Method to retrieve all tasks in the system
    public Map<String, Task> getAllTasks() {
        return new HashMap<>(tasks); // Returns a copy of the tasks map to avoid external modification
    }

    // Method to retrieve tasks based on their completion status
    public Map<String, Task> getTasksByCompletionStatus(boolean isCompleted) {
        Map<String, Task> filteredTasks = new HashMap<>();
        for (Map.Entry<String, Task> entry : tasks.entrySet()) {
            if (entry.getValue().isCompleted() == isCompleted) {
                filteredTasks.put(entry.getKey(), entry.getValue());
            }
        }
        return filteredTasks; // Returns tasks filtered by completion status
    }

    // Method to print all tasks (for debugging or UI purposes)
    public void printAllTasks() {
        tasks.values().forEach(task -> System.out.println(task.toString()));
    }
}
