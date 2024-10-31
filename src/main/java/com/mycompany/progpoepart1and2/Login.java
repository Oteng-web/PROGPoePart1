/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoepart1and2;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    
    //methods for each variable 

    public Login(String username, String firstName, String lastName, String password) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    
    
    //Getter and setter methods for each variable 
    public String getFirstName(){
        return firstName;
         }
    public void setFirstName(String firstName){
      this.firstName= firstName;  
    }
    
    public String getLastName(String lastName){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
        }
    public void setUsername(String userName ){
        this.userName=userName;
    }
    public String getUsername(){
       return userName;
    }
    public void setPassword(String password) {
      this.password=password;  
    }
    public String getpassword(){
        return password;
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


    

