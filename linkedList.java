/*   linkedList.java
 *   Pratham Agarwal
 */


import java.util.HashSet;
import java.util.Scanner;

// Node class represents each student
class Node {
    int studentId;
    String name;
    Node next;

    // Constructor for Node
    Node(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.next = null;
    }
}

// linkedList class to manage the linked list
class linkedList {
    private Node head;
    private HashSet<Integer> idSet = new HashSet<>(); // Keeps track of unique IDs

    // Add a student at a specific position
    public void addStudent(int studentId, String name, int position) {
        if (idSet.contains(studentId)) {
            System.out.println("Student ID " + studentId + " already exists! Cannot add duplicate ID.");
            return;
        }

        Node newNode = new Node(studentId, name);
        idSet.add(studentId);

        if (position == 1 || head == null) { // Add at the head
            newNode.next = head;
            head = newNode;
            System.out.println(name + " (ID: " + studentId + ")");
            return;
        }

        Node current = head;
        int currentPosition = 1;

        // Traverse to the node just before the position
        while (current.next != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
        System.out.println( position + ": " + name + " (ID: " + studentId + ")");
    }

    // Remove a student by name (case-insensitive)
    public void removeStudent(String name) {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        while (head != null && head.name.equalsIgnoreCase(name)) {
            System.out.println("Removing student: " + head.name + " (ID: " + head.studentId + ")");
            idSet.remove(head.studentId);
            head = head.next;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.name.equalsIgnoreCase(name)) {
                System.out.println("Removing student: " + current.next.name + " (ID: " + current.next.studentId + ")");
                idSet.remove(current.next.studentId);
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Search for a student by name or ID
    public void searchStudent(Scanner scanner) {
        System.out.println("Search by: 1. Name 2. ID");
        int searchType = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (searchType == 1) { // Search by name
            System.out.print("Enter name to search: ");
            String name = scanner.nextLine();
            Node current = head;
            boolean found = false;
            while (current != null) {
                if (current.name.equalsIgnoreCase(name)) {
                    System.out.println("Found student: " + current.name + " (ID: " + current.studentId + ")");
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("No student found with the name '" + name + "'.");
            }
        } else if (searchType == 2) { // Search by ID
            System.out.print("Enter ID to search: ");
            int id = scanner.nextInt();
            Node current = head;
            while (current != null) {
                if (current.studentId == id) {
                    System.out.println("Found student: " + current.name + " (ID: " + current.studentId + ")");
                    return;
                }
                current = current.next;
            }
            System.out.println("No student found with ID " + id + ".");
        } else {
            System.out.println("Invalid search type!");
        }
    }

    // Display all students
    public void displayStudents() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        Node current = head;
        System.out.println("Students in the linked list:");
        while (current != null) {
            System.out.println("ID: " + current.studentId + ", Name: " + current.name);
            current = current.next;
        }
    }

    // Generate 100000 students with sequential IDs and names
    public void generateRandomStudents() {
        int id = 1;
        String currentName = "A";

        for (int i = 0; i < 100000; i++) {
            addStudent(id++, currentName, i + 1);
            currentName = incrementName(currentName);
        }
    }

    // Helper method to increment names alphabetically
    private String incrementName(String name) {
        int length = name.length();
        char[] chars = name.toCharArray();

        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] < 'Z') {
                chars[i]++;
                return String.valueOf(chars);
            } else {
                chars[i] = 'A';
            }
        }

        return "A" + String.valueOf(chars);
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        linkedList list = new linkedList();
        Scanner scanner = new Scanner(System.in);

        // Generate 100000 random students
        list.generateRandomStudents();

        while (true) {
            System.out.println("\n--- Linked List Operations ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student by Name");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position to Add: ");
                    int position = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    list.addStudent(id, name, position);
                    break;

                case 2:
                    System.out.print("Enter Student Name to remove: ");
                    String removeName = scanner.nextLine();
                    list.removeStudent(removeName);
                    break;

                case 3:
                    list.searchStudent(scanner);
                    break;

                case 4:
                    list.displayStudents();
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
