package com.company;

import com.company.controllers.DoctorController;
import com.company.entities.Doctor;
import com.company.repositories.interfaces.IDoctorRepository;

import java.util.Scanner;

public class DoctorFrontend {
    private final DoctorController controller;
    private final Scanner scanner;

    public DoctorFrontend(IDoctorRepository repo){
        this.controller=new DoctorController(repo) ;
        this.scanner=new Scanner(System.in) ;
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to E-Healthcare system , user ");
            System.out.println("Select option:");
            System.out.println("1. Get all doctors");
            System.out.println("2. Find doctor by id");
            System.out.println("3. Insert new doctor");
            System.out.println("4. Find available doctors(without patients)");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllDoctorsMenu();;
                } else if (option == 2) {
                    getDoctorByIdMenu();
                } else if (option == 3) {
                    createDoctorMenu();
                } else if (option == 4) {
                    isAvailableMenu() ;
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

    public void getAllDoctorsMenu() {
        String response = controller.getAllDoctors();
        System.out.println(response);
    }

    public void getDoctorByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Doctor doctor = controller.getDoctor(id);
        String response = (doctor == null ? "Doctor was not found!" : doctor.toString());
        System.out.println(response);
    }

    public void createDoctorMenu() {
        System.out.println("Enter name of Doctor");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter specialty of doctor(branch)");
        String speciality = scanner.next();
        System.out.println("Please enter is doctor free of patient (0-if yes , 1-if no)");
        boolean available = scanner.nextBoolean();

        String response = controller.createDoctor(name, surname, gender , speciality ,available);
        System.out.println(response);
    }

    public void isAvailableMenu() {
        System.out.println("Please enter availability");

        boolean available = scanner.nextBoolean();

        String doctor = controller.isAvailable(available);
        String response = (doctor == null ? "Train was not found!" : "" + doctor.toString());
        System.out.println(response);
    }



}
