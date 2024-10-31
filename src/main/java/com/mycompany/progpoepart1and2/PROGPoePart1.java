/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpoepart1and2;
import com.mycompany.progpoepart1and2.Login;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
   //Main class 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PROGPoePart1 {

    public static void main(String[] args) {
        //This is  an instance of the Login class
        Login user = new Login("userName", "firstName", "lastName", "password");
        
        Scanner scanner = new Scanner(System.in);
        
        // Input the details needed for registration process
        System.out.print("Enter the username (it should contain an underscore and have at least 5 characters): ");
        String userName = scanner.nextLine();

        System.out.print("Enter the password (it must contain at least 8 characters, one capital letter, one number, and a special character): ");
        String password = scanner.nextLine();

        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the last name: ");
        String lastName = scanner.nextLine();

        // Setting the details of the user
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        
        // Registration of the user
        String registrationMessage = user.registerUser();
        // Output the registration message 
        System.out.println(registrationMessage);
        
        // Only continue to login if the registration process was correct and approved 
        if (registrationMessage.equals("The user was registered successfully.")) {
            // The login section
            System.out.println("Login");
            System.out.print("Please enter your username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Please enter your password: ");
            String loginPassword = scanner.nextLine(); 
            
            // Login the user
            boolean isLoggedIn = user.loginUser(loginPassword, loginUsername);
            System.out.println(user.returnLoginStatus(isLoggedIn));
            
            if (isLoggedIn) {
                System.out.println("Welcome to EasyKanban!");
                // Continue to task management section 
                boolean keeponUsingApp = true;
                List<Task> tasks = new ArrayList<>();

             while (keeponUsingApp) {
                    System.out.println("Select an option:");
                    System.out.println("1) Add the tasks");
                    System.out.println("2) Show the report - Coming soon");
                    System.out.println("3) Quit or Exit");

                    int option  = scanner.nextInt();
                    scanner.nextLine();  

                    switch (option) {
                        case 1:
                            System.out.print("How many tasks would you like to enter? ");
                            int numberOfTasks = scanner.nextInt();
                            scanner.nextLine();  

                            for (int i = 0; i < numberOfTasks; i++) {
                                System.out.print("Enter the Task Name: ");
                                String taskName = scanner.nextLine();

                                System.out.print("Enter the Task Description or Outline (maximum has to be 50 characters): ");
                                String taskOutline = scanner.nextLine();
                                while (taskOutline.length() > 50) {
                                    System.out.println("Please enter a task outline that is less than 50 characters.");
                                    taskOutline = scanner.nextLine();
                                }

                                System.out.print("Enter the Developer information  (First Last Name): ");
                                String developerInfo= scanner.nextLine();

                                System.out.print("Enter Task time (in hours): ");
                                double taskTime= scanner.nextDouble();
                                scanner.nextLine(); 

                                String taskStatus = JOptionPane.showInputDialog("Choose the Task Status (To Do, Done, Doing):");

                                Task task = new Task(taskName,taskOutline ,developerInfo,taskTime,taskStatus);
                                if (task.checkTaskOutline()) {
                                    tasks.add(task);
                                    JOptionPane.showMessageDialog(null, task.printTaskDetails());
                                } else {
                                    System.out.println("The task description is too long.");
                                }
                            }
                            break;

                        case 2:
                            System.out.println("Coming soon");
                            break;

                        case 3:
                            keeponUsingApp = false;
                            break;

                        default:
                            System.out.println("The option is invalid , please try again.");
                    }
                }

                // Calculate total hours
                double totalHours = 0;
                for (Task task : tasks) {
                    totalHours += task.getTaskTime();
                }
                System.out.println("The total hours in all the tasks: " + totalHours);
            } else {
                System.out.println("Login failed. Please check if you entered your username and password correctly.");
            }
        }

        scanner.close();
    }
}
