/*   LinkedListManager.java
 *   Pratham Agarwal
 */


import java.util.LinkedList;
import java.util.Scanner;

// Student class to represent each student
class Student {
    int studentId;
    String name;

    // Constructor for Student
    Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name;
    }
}

// LinkedListManager class to handle operations using LinkedList
class LinkedListManager {
    private LinkedList<Student> studentList = new LinkedList<>();

    // Add a student at a specific position
    public void addStudent(int studentId, String name, int position) {
        for (Student student : studentList) {
            if (student.studentId == studentId) {
                System.out.println("Student ID " + studentId + " already exists! Cannot add duplicate ID.");
                return;
            }
        }

        Student newStudent = new Student(studentId, name);

        if (position <= 1 || studentList.isEmpty()) { // Add at the head
            studentList.addFirst(newStudent);
        } else if (position > studentList.size()) { // Add at the tail
            studentList.addLast(newStudent);
        } else { // Add at specific position
            studentList.add(position - 1, newStudent);
        }

        System.out.println(name + " (ID: " + studentId + ") added at position " + position + ".");
    }

    // Remove a student by name (case-insensitive)
    public void removeStudent(String name) {
        boolean removed = studentList.removeIf(student -> student.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Student(s) with the name '" + name + "' removed.");
        } else {
            System.out.println("No student found with the name '" + name + "'.");
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
            boolean found = false;
            for (Student student : studentList) {
                if (student.name.equalsIgnoreCase(name)) {
                    System.out.println("Found student: " + student);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No student found with the name '" + name + "'.");
            }
        } else if (searchType == 2) { // Search by ID
            System.out.print("Enter ID to search: ");
            int id = scanner.nextInt();
            for (Student student : studentList) {
                if (student.studentId == id) {
                    System.out.println("Found student: " + student);
                    return;
                }
            }
            System.out.println("No student found with ID " + id + ".");
        } else {
            System.out.println("Invalid search type!");
        }
    }

    // Display all students
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }

        System.out.println("Students in the linked list:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Generate 100,000 students with sequential IDs and names
    public void generateRandomStudents() {
        int id = 1;
        String currentName = "A";

        for (int i = 0; i < 100000; i++) {
            studentList.add(new Student(id++, currentName));
            currentName = incrementName(currentName);
        }

        System.out.println("Generated 100,000 students.");
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
        LinkedListManager manager = new LinkedListManager();
        Scanner scanner = new Scanner(System.in);

        // Generate 100,000 random students
        manager.generateRandomStudents();

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
                    manager.addStudent(id, name, position);
                    break;

                case 2:
                    System.out.print("Enter Student Name to remove: ");
                    String removeName = scanner.nextLine();
                    manager.removeStudent(removeName);
                    break;

                case 3:
                    manager.searchStudent(scanner);
                    break;

                case 4:
                    manager.displayStudents();
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
