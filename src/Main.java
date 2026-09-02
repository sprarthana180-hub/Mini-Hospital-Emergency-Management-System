import datastructures.*;
import model.Patient;
import model.Visit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();

        Patient samplePatient = new Patient(101, "John Doe", 30, "0712345678", "Fever");
        bst.insert(samplePatient);

        int choice;
        do {
            System.out.println("\n--- Mini Hospital Emergency Management System ---");
            System.out.println("1. Patient Records (BST)");
            System.out.println("2. Emergency Patient Queue (Queue)");
            System.out.println("3. Treatment History (Stack)");
            System.out.println("4. Patient Visit History (Singly Linked List)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- BST Operations ---");
                    System.out.println("1. Insert Patient\n2. Search Patient\n3. Delete Patient\n4. Display All Patients");
                    int bstChoice = scanner.nextInt();
                    if (bstChoice == 1) {
                        System.out.print("Enter ID: "); int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: "); String name = scanner.nextLine();
                        System.out.print("Enter Age: "); int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Contact: "); String contact = scanner.nextLine();
                        System.out.print("Enter Condition: "); String cond = scanner.nextLine();
                        bst.insert(new Patient(id, name, age, contact, cond));
                    } else if (bstChoice == 2) {
                        System.out.print("Enter Patient ID to search: "); int id = scanner.nextInt();
                        Patient p = bst.search(id);
                        if (p != null) System.out.println("Found: " + p);
                        else System.out.println("Patient not found.");
                    } else if (bstChoice == 3) {
                        System.out.print("Enter Patient ID to delete: "); int id = scanner.nextInt();
                        bst.delete(id);
                    } else if (bstChoice == 4) {
                        bst.inOrderTraversal();
                    }
                    break;

                case 2:
                    System.out.println("\n--- Queue Operations ---");
                    System.out.println("1. Enqueue Emergency Patient\n2. Dequeue Patient\n3. Display Queue");
                    int qChoice = scanner.nextInt();
                    if (qChoice == 1) {
                        System.out.print("Enter ID: "); int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: "); String name = scanner.nextLine();
                        System.out.print("Enter Age: "); int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Contact: "); String contact = scanner.nextLine();
                        System.out.print("Enter Condition: "); String cond = scanner.nextLine();
                        queue.enqueue(new Patient(id, name, age, contact, cond));
                    } else if (qChoice == 2) {
                        queue.dequeue();
                    } else if (qChoice == 3) {
                        queue.displayQueue();
                    }
                    break;

                case 3:
                    System.out.println("\n--- Stack Operations ---");
                    System.out.println("1. Push Treatment Record\n2. Pop Treatment Record\n3. Display Stack");
                    int sChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sChoice == 1) {
                        System.out.print("Enter treatment details record: "); String rec = scanner.nextLine();
                        stack.push(rec);
                    } else if (sChoice == 2) {
                        stack.pop();
                    } else if (sChoice == 3) {
                        stack.displayStack();
                    }
                    break;

                case 4:
                    System.out.println("\n--- Linked List Operations (Using sample patient ID 101) ---");
                    System.out.println("1. Add Visit\n2. Remove Visit\n3. Search Visit\n4. Display Visits");
                    int lChoice = scanner.nextInt();
                    if (lChoice == 1) {
                        System.out.print("Enter Visit ID: "); int vid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Date: "); String date = scanner.nextLine();
                        System.out.print("Enter Doctor Name: "); String doc = scanner.nextLine();
                        System.out.print("Enter Diagnosis: "); String diag = scanner.nextLine();
                        System.out.print("Enter Treatment: "); String treat = scanner.nextLine();
                        samplePatient.getVisitHistory().addVisit(vid, date, doc, diag, treat);
                    } else if (lChoice == 2) {
                        System.out.print("Enter Visit ID to remove: "); int vid = scanner.nextInt();
                        samplePatient.getVisitHistory().removeVisit(vid);
                    } else if (lChoice == 3) {
                        System.out.print("Enter Visit ID to search: "); int vid = scanner.nextInt();
                        Visit v = samplePatient.getVisitHistory().searchVisit(vid);
                        if (v != null) System.out.println("Found: " + v);
                        else System.out.println("Visit not found.");
                    } else if (lChoice == 4) {
                        samplePatient.getVisitHistory().displayVisits();
                    }
                    break;

                case 5:
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}