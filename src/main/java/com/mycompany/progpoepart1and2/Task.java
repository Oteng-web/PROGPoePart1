/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoepart1and2;

public class Task {
    private String taskName;
    private String taskIdentification;
    private int    taskNo;
    private String developerInfo;
    private String taskOutline ;
    private String taskStatus;
    private double taskTime;
    
    

    public Task(int taskNo, double taskTime,String taskName,String developerInfo,  String taskOutline ,String taskStatus) {
        this.taskName = taskName;
        this.taskNo = taskNo;
        this.taskOutline = taskOutline ;
        this.developerInfo = developerInfo ;
        this.taskTime = taskTime;
        this.taskStatus = taskStatus;
        this.taskIdentification = createTaskIdentification();
    }

    Task(String taskName, String taskOutline, String developerInfo, double taskTime, String taskStatus) {
    }

    public boolean checkTaskOutline () {
        return taskOutline .length() <= 50;
    }

    public String createTaskIdentification() {
        return (taskName.substring(0, 2).toUpperCase() + ":" + taskNo+ ":" + developerInfo.substring(developerInfo.length() - 3).toUpperCase());
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Info: " + developerInfo+ "\n" +
               "Task No: " + taskNo + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description/Outline: " + taskOutline + "\n" +
               "Task Identification: " + taskIdentification + "\n" +
               "Time: " + taskTime + " hours";
    }

    public double getTaskTime() {
        return taskTime;
    }
}
