package datastructures;
import model.Patient;

public class PatientBST {
    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
            left = right = null;
        }
    }

    private Node root;

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient);
            System.out.println("Patient inserted successfully into BST.");
            return root;
        }
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("Patient ID already exists in BST.");
        }
        return root;
    }

    public Patient search(int patientId) {
        Node result = searchRec(root, patientId);
        return result != null ? result.patient : null;
    }

    private Node searchRec(Node root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId) {
            return root;
        }
        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }

    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node root, int patientId) {
        if (root == null) {
            System.out.println("Patient ID not found for deletion.");
            return null;
        }
        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient minValue(Node root) {
        Patient minv = root.patient;
        while (root.left != null) {
            minv = root.left.patient;
            root = root.left;
        }
        return minv;
    }

    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("No patients found in records.");
            return;
        }
        System.out.println("--- Patient Records (In-Order Ascending by ID) ---");
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }
}