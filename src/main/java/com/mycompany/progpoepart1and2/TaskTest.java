/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoepart1and2;
import static org.junit.jupiter.api.Assertions.*;
import org .junit.jupiter.api.Test;

/**k1
 *
 * @author RC_Student_lab
 */
public class TaskTest {

    @Test
    public void testTaskOutline() {
        Task task = new Task("Login Feature", "Create login in order to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskOutline());

        task = new Task("Login Feature", "This description is way too long to be accepted by the task management system", "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskOutline());
    }

    @Test
    public void testTaskIdentification() {
        Task task = new Task("Login Feature", "Create Login", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task.createTaskIdentification());

        task = new Task("Add Task Feature", "Create Add Task", "Mike Smith", 10, "Doing");
        assertEquals("AD:1:ITH", task.createTaskIdentification());
    }

    @Test
    public void testTotalHours() {
        Task task1 = new Task("Task 1", "First task", "Dev A", 5, "To Do");
        Task task2 = new Task("Task 2", "Second task", "Dev B", 10, "Doing");

        double total = task1.getTaskTime() + task2.getTaskTime();
        assertEquals(15, total);
    }
}
