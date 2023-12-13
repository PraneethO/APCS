package Projects;
// i want the math grade of the student to be stored

// and theese are teh functions I want.

// constructor takes in a string to assign it to name and makes the grade 0/0

// addToGrade which takes in two parameters, numerator, denominator
// getGrade which returns the grade
// compareTo which compares the grade of Student with another Student
// toString which prints out the studen's name and their grade

public class Student implements Comparable<Student> {
    private int currentNum;
    private int currentDenom;
    private String name;

    public void addToGrade(int n, int d) {
        this.currentNum = this.currentNum + n;
        this.currentDenom = this.currentDenom + d;
    }

    public double getGrade() {
        return ((double) this.currentNum) / (this.currentDenom);
    }

    public int compareTo(Student o) {
        return (int) (this.getGrade() - o.getGrade());
    }

    public String toString() {
        return this.name + this.getGrade();
    }
}
