// Java Programming Assignment 10.9
// Test Modified Course class
// Written by 121220130

public class TestCourse {
    public static void main(String[] args) {
        Course java = new Course("Java Programming");
        java.addStudent("Alice");
        java.addStudent("Bob");
        java.addStudent("Charles");
        String [] list = java.getStudents();
        for (int i = 0; i < java.getNumberOfStudents(); ++i) {
            System.out.print(list[i] + '\n');
        }
        java.dropStudent("Bob");
        list = java.getStudents();
        for (int i = 0; i < java.getNumberOfStudents(); ++i) {
            System.out.print(list[i] + '\n');
        }
    }
}
