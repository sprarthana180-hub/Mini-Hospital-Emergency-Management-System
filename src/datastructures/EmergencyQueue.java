package datastructures;
import model.Patient;

public class EmergencyQueue {
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front, rear;

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient added to emergency waiting queue.");
    }

    public Patient dequeue() {
        if (front == null) {
            System.out.println("Queue is empty. No emergency patients waiting.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println("Patient treated and removed from queue: " + patient.getName());
        return patient;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Emergency queue is currently empty.");
            return;
        }
        Node current = front;
        System.out.println("--- Emergency Waiting Queue ---");
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}