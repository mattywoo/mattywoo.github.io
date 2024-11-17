//Cruz Matthew 04/13/2024

package module06; // Defines the package for the class

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

    // Method to retrieve a task by its taskId
    public Task getTask(String taskId) {
        return tasks.get(taskId); // Returns the task associated with the given taskId
    }
}