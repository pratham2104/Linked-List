# Linked List Student Management Programs

This repository contains two implementations of a student management system that utilizes a linked list to manage student data. The two programs are:

1. **Custom Linked List Implementation**: Implements a linked list using custom `Node` objects and manual pointer manipulation.
2. **Java LinkedList Library Implementation**: Utilizes Java's built-in `LinkedList` class for efficient list operations.

Both programs allow you to add, remove, search, and display student information, as well as generate a large dataset of 100,000 students for performance testing.

---

## 1. Custom Linked List Implementation

### Description
This version implements a linked list from scratch using a custom `Node` class. Each `Node` represents a student, storing the student's ID, name, and a reference to the next node in the list. A `linkedList` class manages the operations, including:
- Adding a student to a specific position.
- Removing a student by name (case-insensitive).
- Searching for a student by ID or name.
- Displaying all students in the list.
- Generating 100,000 students with sequential IDs and alphabetic names.

### Features
- Custom implementation of the linked list structure.
- Manual management of pointers (`next` references).
- Ensures unique student IDs using a `HashSet`.

---

## 2. Java LinkedList Library Implementation

### Description
This version uses Java's built-in `LinkedList` class to manage the list of students. It leverages Java's library methods for efficient insertion, deletion, and traversal. Each student is represented by a `Student` class with attributes for ID and name. A `LinkedListManager` class provides the following functionality:
- Adding a student to a specific position.
- Removing a student by name (case-insensitive).
- Searching for a student by ID or name.
- Displaying all students in the list.
- Generating 100,000 students with sequential IDs and alphabetic names.

### Features
- Simplified logic using Java's `LinkedList`.
- Reduces manual pointer manipulation.
- Cleaner and more concise code.

---

## Dataset Generation

Both implementations include a method to generate a dataset of 100,000 students:
- **Sequential IDs**: Starts from `1` and increments by `1`.
- **Alphabetic Names**: Begins with `A`, progresses to `Z`, then `AA`, `AB`, and so on.

This feature can be used to test the efficiency and scalability of the programs.

---

## Usage Instructions

### Running the Program
1. Compile the `.java` file using `javac`.
2. Run the program with `java`.
3. Follow the interactive menu to perform operations.

### Menu Options
- **Add Student**: Enter student details (ID, name, position) to add to the list.
- **Remove Student**: Remove a student by name.
- **Search Student**: Search for a student by ID or name.
- **Display All Students**: View all students in the list.
- **Exit**: Exit the program.

### Example Commands
```plaintext
--- Linked List Operations ---
1. Add Student
2. Remove Student by Name
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 1
Enter Student ID: 101
Enter Student Name: John Doe
Enter Position to Add: 2
