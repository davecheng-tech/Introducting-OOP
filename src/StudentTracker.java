/**
 * StudentTracker.java
 *
 * This is a demonstration of procedural programming using parallel arrays.
 * It tracks basic student data (names, ages, grades, and absences).
 *
 * It is intentionally cumbersome and difficult to maintain, to showcase why
 * Object-Oriented Programming (OOP) is a better approach for managing complex data.
 *
 * Functionalities:
 * 1. Add a new student.
 * 2. List all students.
 * 3. Update a student's grade.
 * 4. Record a student's absence.
 * 5. Remove a student.
 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 
 public class StudentTracker {
 
     /**
      * Parallel arrays storing student information.
      * Each index in all arrays represents a single student.
      */
     static String[] studentNames = new String[100];
     static int[] studentGrades = new int[100];
     static int[] studentAges = new int[100];
     static int[] studentAbsences = new int[100];
 
     /**
      * Tracks how many students have been added.
      */
     static int studentCount = 0;
 
     /**
      * Main method to run the student tracker menu.
      *
      * @param args Command line arguments (not used)
      * @throws IOException If an I/O error occurs during user input
      */
     public static void main(String[] args) throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int choice;
 
         do {
             printMenu();
             choice = Integer.parseInt(reader.readLine());
 
             switch (choice) {
                 case 1:
                     addStudent(reader);
                     break;
                 case 2:
                     listStudents();
                     break;
                 case 3:
                     updateStudentGrade(reader);
                     break;
                 case 4:
                     recordAbsence(reader);
                     break;
                 case 5:
                     removeStudent(reader);
                     break;
                 case 0:
                     System.out.println("Goodbye!");
                     break;
                 default:
                     System.out.println("Invalid choice. Try again.");
             }
         } while (choice != 0);
     }
 
     /**
      * Prints the main menu options to the console.
      */
     static void printMenu() {
         System.out.println("\nSTUDENT TRACKER MENU");
         System.out.println("1. Add a new student");
         System.out.println("2. List all students");
         System.out.println("3. Update a student's grade");
         System.out.println("4. Record an absence");
         System.out.println("5. Remove a student");
         System.out.println("0. Exit");
         System.out.print("Enter choice: ");
     }
 
     /**
      * Adds a new student to the parallel arrays.
      *
      * @param reader BufferedReader for user input
      * @throws IOException If an I/O error occurs
      */
     static void addStudent(BufferedReader reader) throws IOException {
         if (studentCount >= studentNames.length) {
             System.out.println("Cannot add more students.");
             return;
         }
 
         System.out.print("Enter student name: ");
         studentNames[studentCount] = reader.readLine();
 
         System.out.print("Enter student age: ");
         studentAges[studentCount] = Integer.parseInt(reader.readLine());
 
         System.out.print("Enter student grade: ");
         studentGrades[studentCount] = Integer.parseInt(reader.readLine());
 
         studentAbsences[studentCount] = 0; // default absence is 0
 
         System.out.println("Student added successfully!");
         studentCount++;
     }
 
     /**
      * Lists all current students and their information.
      */
     static void listStudents() {
         if (studentCount == 0) {
             System.out.println("No students to display.");
             return;
         }
 
         System.out.println("\nSTUDENT LIST:");
         for (int i = 0; i < studentCount; i++) {
             System.out.println((i + 1) + ". " + studentNames[i] + " | Age: " + studentAges[i]
                     + " | Grade: " + studentGrades[i] + " | Absences: " + studentAbsences[i]);
         }
     }
 
     /**
      * Updates the grade of a specific student.
      *
      * @param reader BufferedReader for user input
      * @throws IOException If an I/O error occurs
      */
     static void updateStudentGrade(BufferedReader reader) throws IOException {
         if (studentCount == 0) {
             System.out.println("No students to update.");
             return;
         }
 
         listStudents();
 
         System.out.print("Enter the student number to update grade: ");
         int index = Integer.parseInt(reader.readLine()) - 1;
 
         if (index < 0 || index >= studentCount) {
             System.out.println("Invalid student number.");
             return;
         }
 
         System.out.print("Enter the new grade for " + studentNames[index] + ": ");
         studentGrades[index] = Integer.parseInt(reader.readLine());
 
         System.out.println("Grade updated successfully!");
     }
 
     /**
      * Records an absence for a specific student.
      *
      * @param reader BufferedReader for user input
      * @throws IOException If an I/O error occurs
      */
     static void recordAbsence(BufferedReader reader) throws IOException {
         if (studentCount == 0) {
             System.out.println("No students to record absences for.");
             return;
         }
 
         listStudents();
 
         System.out.print("Enter the student number to record an absence: ");
         int index = Integer.parseInt(reader.readLine()) - 1;
 
         if (index < 0 || index >= studentCount) {
             System.out.println("Invalid student number.");
             return;
         }
 
         studentAbsences[index]++;
 
         System.out.println("Absence recorded for " + studentNames[index] + ". Total absences: " + studentAbsences[index]);
     }
 
     /**
      * Removes a student and shifts subsequent students to fill the gap.
      *
      * @param reader BufferedReader for user input
      * @throws IOException If an I/O error occurs
      */
     static void removeStudent(BufferedReader reader) throws IOException {
         if (studentCount == 0) {
             System.out.println("No students to remove.");
             return;
         }
 
         listStudents();
 
         System.out.print("Enter the student number to remove: ");
         int index = Integer.parseInt(reader.readLine()) - 1;
 
         if (index < 0 || index >= studentCount) {
             System.out.println("Invalid student number.");
             return;
         }
 
         System.out.println("Removing " + studentNames[index] + "...");
 
         // Shift each element to overwrite the removed student
         for (int i = index; i < studentCount - 1; i++) {
             studentNames[i] = studentNames[i + 1];
             studentGrades[i] = studentGrades[i + 1];
             studentAges[i] = studentAges[i + 1];
             studentAbsences[i] = studentAbsences[i + 1];
         }
 
         studentCount--;
 
         System.out.println("Student removed successfully.");
     }
 }
 