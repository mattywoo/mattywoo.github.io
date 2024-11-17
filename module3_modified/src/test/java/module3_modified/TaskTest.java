//Cruz Matthew 11/16/2024

package module3_modified; // Defines the package for the class

import org.junit.jupiter.api.Test; // Imports the @Test annotation for marking test methods

import module03_modified.Task; // Imports the Task class

import static org.junit.jupiter.api.Assertions.*; // Imports assertion methods for testing

// Test class for Task class, testing the creation and updating of tasks
public class TaskTest {

    // Test method for verifying the correct creation of a Task object
    @Test
    public void testTaskCreation() {
        // Creates a Task object with ID, name, and description
        Task task = new Task("1234567890", "TaskName", "TaskDescription");
        
        // Asserts that the task ID is correctly set
        assertEquals("1234567890", task.getTaskId());
        
        // Asserts that the task name is correctly set
        assertEquals("TaskName", task.getName());
        
        // Asserts that the task description is correctly set
        assertEquals("TaskDescription", task.getDescription());
    }

    // Test method for verifying that the task name can be updated
    @Test
    public void testTaskNameUpdate() {
        // Creates a Task object with ID, name, and description
        Task task = new Task("1234567890", "TaskName", "TaskDescription");
        
        // Updates the task name to "NewTaskName"
        task.setName("NewTaskName");
        
        // Asserts that the task name has been updated correctly
        assertEquals("NewTaskName", task.getName());
    }

    // Test method for verifying that the task description can be updated
    @Test
    public void testTaskDescriptionUpdate() {
        // Creates a Task object with ID, name, and description
        Task task = new Task("1234567890", "TaskName", "TaskDescription");
        
        // Updates the task description to "NewTaskDescription"
        task.setDescription("NewTaskDescription");
        
        // Asserts that the task description has been updated correctly
        assertEquals("NewTaskDescription", task.getDescription());
    }

    // Test method for verifying the task status can be updated (if applicable)
    @Test
    public void testTaskStatusUpdate() {
        Task task = new Task("1234567890", "TaskName", "TaskDescription");

        // Assuming there is a method to mark the task as completed
        task.setStatus("Completed");  // Example, assuming `setStatus` exists
        
        // Asserts that the task status has been updated correctly
        assertEquals("Completed", task.getStatus());
    }

    // Test method for verifying the task can be marked as incomplete (if applicable)
    @Test
    public void testTaskStatusIncomplete() {
        Task task = new Task("1234567890", "TaskName", "TaskDescription");

        // Assuming there is a method to mark the task as incomplete
        task.setStatus("Incomplete");  // Example, assuming `setStatus` exists
        
        // Asserts that the task status has been set to "Incomplete"
        assertEquals("Incomplete", task.getStatus());
    }
}
