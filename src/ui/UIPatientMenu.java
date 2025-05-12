package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import model.Doctor;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appoinment");
            System.out.println("2. My appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {

        int response = 0;
        do {
            System.out.println("::Book an appoinment");
            System.out.println("::Select date");
            // Numeracion de lista de fechas
            // Indice fecha seleccionada
            // [doctors]
            // 1.- doctor1
            // //-1 fecha1
            // //-1 fecha2
            // 2.-doctor2
            // 3.-doctor3
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctosAvailableAppoinments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctosAvailableAppoinments
                        .get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppoinments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppoinments.put(Integer.valueOf(j), UIDoctorMenu.doctosAvailableAppoinments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppoinments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get((responseDateSelected));
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor(null, null, null);
            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName() +
                    " Date: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    " Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.addAppoinmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }

        } while (response != 0);
    }

    private static void showPatientMyAppointments() {
        int response = 0;
        do {
            System.out.println(":: My Appoinments");
            if (UIMenu.patientLogged.getAppoinmentDoctors().size() == 0) {
                System.out.println("Don't have appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppoinmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppoinmentDoctors().get(i).getDate() +
                        "Time: " + UIMenu.patientLogged.getAppoinmentDoctors().get(i).getTime() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppoinmentDoctors().get(i).getDoctor().getName());
            }

            System.out.println("0. Return");

        } while (response != 0);
    }

}
