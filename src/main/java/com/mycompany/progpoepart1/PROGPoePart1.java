/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpoepart1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
public class PROGPoePart1 {

   public static void main(String[] args) {
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

        // Create the Login object with the user details(all of them)
        Login user = new Login(userName, firstName, lastName, password);
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);

        // Only continue to login if registration process was approved
        if (registrationMessage.equals("The user was registered successfully.")) {
            // The login section
            System.out.println("Login");
            System.out.print("Please enter your username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Please enter your password: ");
            String loginPassword = scanner.nextLine(); //You should get the password input

            boolean isLoggedIn = user.loginUser(loginPassword, loginUsername);
            System.out.println(user.returnLoginStatus(isLoggedIn));
        }

        scanner.close();
    }
}

class Login {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    public Login(String username, String firstName, String lastName, String password) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
//Method checking the username
    public boolean checkUsername() {
        return userName.contains("_") && userName.length() >= 5;
    }
//Method checking if the password is complex
    public boolean checkPasswordComplexity() {
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*!()]).{8,}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
//Method checking the login status of the user
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it's great to see you again.";
        } else {
            return "The username or password is not correct, please try again.";
        }
    }
//Method responsible for the registration of the user
    public String registerUser() {
        if (!checkUsername()) {
            return "The username was not formatted correctly. Ensure it has at least 5 characters and contains an underscore.";
        } else if (!checkPasswordComplexity()) {
            return "The password must have at least 8 characters, including one capital letter, one number, and a special character.";
        } else {
            return "The user was registered successfully.";
        }
    }

    public boolean loginUser(String inputPassword, String inputUsername) {
        return this.userName.equals(inputUsername) && this.password.equals(inputPassword);
    }
}

    

