//Cruz Matthew 04/13/2024

package module06; // Defines the package for the class

import org.junit.jupiter.api.Test; // Imports JUnit's Test annotation for unit tests
import static org.junit.jupiter.api.Assertions.*; // Imports assertion methods for validating test results

// Test class to validate the functionality of TaskService methods
public class TaskServiceTest {

    // Test case to verify the addTask method works as expected
    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService(); // Creates an instance of TaskService
        Task task = new Task("1234567890", "TaskName", "TaskDescription"); // Creates a new Task object
        taskService.addTask(task); // Adds the task to the TaskService
        assertEquals(task, taskService.getTask("1234567890")); // Asserts that the task retrieved matches the added task
    }

    // Test case to verify the deleteTask method works as expected
    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService(); // Creates an instance of TaskService
        Task task = new Task("1234567890", "TaskName", "TaskDescription"); // Creates a new Task object
        taskService.addTask(task); // Adds the task to the TaskService
        taskService.deleteTask("1234567890"); // Deletes the task using its ID
        assertNull(taskService.getTask("1234567890")); // Asserts that the task is no longer in the TaskService (should be null)
    }

    // Test case to verify the updateTaskName method works as expected
    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService(); // Creates an instance of TaskService
        Task task = new Task("1234567890", "TaskName", "TaskDescription"); // Creates a new Task object
        taskService.addTask(task); // Adds the task to the TaskService
        taskService.updateTaskName("1234567890", "NewTaskName"); // Updates the task's name
        assertEquals("NewTaskName", taskService.getTask("1234567890").getName()); // Asserts that the task's name was updated
    }

    // Test case to verify the updateTaskDescription method works as expected
    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService(); // Creates an instance of TaskService
        Task task = new Task("1234567890", "TaskName", "TaskDescription"); // Creates a new Task object
        taskService.addTask(task); // Adds the task to the TaskService
        taskService.updateTaskDescription("1234567890", "NewTaskDescription"); // Updates the task's description
        assertEquals("NewTaskDescription", taskService.getTask("1234567890").getDescription()); // Asserts that the task's description was updated
    }
}