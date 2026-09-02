package datastructures;
import model.Visit;

public class VisitLinkedList {
    private Visit head;

    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        Visit newVisit = new Visit(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newVisit;
        } else {
            Visit current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newVisit;
        }
        System.out.println("Visit added successfully to patient history.");
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }
        if (head.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit ID " + visitId + " removed successfully.");
            return;
        }
        Visit current = head;
        while (current.next != null && current.next.getVisitId() != visitId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Visit ID " + visitId + " removed successfully.");
        } else {
            System.out.println("Visit ID " + visitId + " not found.");
        }
    }

    public Visit searchVisit(int visitId) {
        Visit current = head;
        while (current != null) {
            if (current.getVisitId() == visitId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        Visit current = head;
        System.out.println("--- Patient Visit History ---");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
