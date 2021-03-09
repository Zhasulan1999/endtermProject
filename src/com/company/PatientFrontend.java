package com.company;

import com.company.controllers.PatientController;
import com.company.entities.Patient;
import com.company.repositories.interfaces.IPatientRepository;

import java.util.Scanner;

public class PatientFrontend {
    private final PatientController controller;
    private final Scanner scanner;

    public PatientFrontend(IPatientRepository repo){
        this.controller=new PatientController(repo) ;
        this.scanner=new Scanner(System.in) ;
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to E-Healthcare system , user ");
            System.out.println("Select option:");
            System.out.println("1. Get all patients");
            System.out.println("2. Find patient by id");
            System.out.println("3. Insert new patient");
        //    System.out.println("4. Find available doctors(without patients)");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllPatientMenu();;
                } else if (option == 2) {
                    getPatientByIdMenu();
                } else if (option == 3) {
                    createPatientMenu();
//                } else if (option == 4) {
//                    isAvailableMenu() ;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllPatientMenu() {
        String response = controller.getAllPatients();
        System.out.println(response);
    }

    public void getPatientByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Patient patient = controller.getPatient(id);
        String response = (patient == null ? "Patient was not found!" : patient.toString());
        System.out.println(response);
    }

    public void createPatientMenu() {
        System.out.println("Enter name of Patient");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter illness of patient");
        String illness = scanner.next();
        System.out.println("Please enter your preference (0-if man , 1-if woman)");
        boolean preference = scanner.nextBoolean();

        String response = controller.createPatient(name, surname, gender , illness ,preference);
        System.out.println(response);
    }




}

