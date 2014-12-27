// Java Programming Assignment 10.9
// Modify class Course
// Written by 121220130

public class Course {
    private String courseName;
    private int capacity = 100;
    private String[] students = new String[capacity];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents >= capacity) {
            capacity += 100;
            String [] newStudents = new String[capacity];
            for (int i = 0; i < numberOfStudents; ++i)
                newStudents[i] = students[i];
            students = newStudents;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; ++i) {
            if (students[i] == student) {
                numberOfStudents--;
                for (int j = i; j < numberOfStudents; ++j)
                    students[j] = students[j+1];
                students[numberOfStudents] = "";
            }
        }
    }
}
