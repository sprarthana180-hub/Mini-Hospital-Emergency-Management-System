package datastructures;

public class TreatmentStack {
    private class Node {
        String treatmentRecord;
        Node next;

        Node(String treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
            this.next = null;
        }
    }

    private Node top;

    public void push(String record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record pushed to stack successfully.");
    }

    public String pop() {
        if (top == null) {
            System.out.println("Stack is empty. No treatment records to pop.");
            return null;
        }
        String poppedRecord = top.treatmentRecord;
        top = top.next;
        System.out.println("Most recent treatment record removed: " + poppedRecord);
        return poppedRecord;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("Treatment history stack is empty.");
            return;
        }
        Node current = top;
        System.out.println("--- Treatment History Stack (LIFO) ---");
        while (current != null) {
            System.out.println(current.treatmentRecord);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}