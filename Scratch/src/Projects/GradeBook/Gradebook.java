package Projects.GradeBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Gradebook {
    private Student[] studentList;
    private double[] possiblePoints;

    public Gradebook(int numStudents, int numGrades, String fileName) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File(fileName));

        this.studentList = new Student[numStudents];
        this.possiblePoints = new double[numGrades];

        inputFile.next();

        double totalPoints = 0;

        for (int i = 0; i < numGrades; i++) {
            if (inputFile.hasNextDouble()) {
                possiblePoints[i] = inputFile.nextDouble();
                totalPoints += possiblePoints[i];
            }
        }

        for (int i = 0; i < numStudents; i++) {
            String name = "";
            if (inputFile.hasNext())
                name = inputFile.next();
            double[] studentGradeList = new double[numGrades];
            for (int j = 0; j < numGrades; j++) {
                if (inputFile.hasNextDouble())
                    studentGradeList[j] = inputFile.nextDouble();
            }

            studentList[i] = new Student(name, studentGradeList, totalPoints);
        }
    }

    public double[] findAssignmentAverages() {
        double[] result = new double[possiblePoints.length];
        for (int i = 0; i < possiblePoints.length; i++) {
            double counter = 0;
            for (int j = 0; j < studentList.length; j++) {
                counter += studentList[j].getGrades()[i];
            }
            result[i] = counter / (possiblePoints[i] * studentList.length);
        }

        return result;
    }

    public double[] findStudentAverages() {
        double[] result = new double[studentList.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = studentList[i].getGrade();
        }

        return result;
    }

    public Student findTopStudent() {
        if (studentList.length == 0) {
            return null;
        }

        double counter = studentList[0].getGrade();
        Student best = studentList[0];
        for (int i = 1; i < studentList.length; i++) {
            if (studentList[i].getGrade() > counter) {
                counter = studentList[i].getGrade();
                best = studentList[i];
            }
        }

        return best;
    }

    public Student findStrugglingStudent() {
        if (studentList.length == 0) {
            return null;
        }

        double counter = studentList[0].getGrade();
        Student worst = studentList[0];
        for (int i = 1; i < studentList.length; i++) {
            if (studentList[i].getGrade() < counter) {
                counter = studentList[i].getGrade();
                worst = studentList[i];
            }
        }

        return worst;
    }

    public Student findTopStudentForAssignment(int assignmentNum) {
        if (studentList.length == 0) {
            return null;
        }

        double counter = studentList[0].getGrades()[assignmentNum];
        Student best = studentList[0];
        for (int i = 1; i < studentList.length; i++) {
            if (studentList[i].getGrades()[assignmentNum] > counter) {
                counter = studentList[i].getGrades()[assignmentNum];
                best = studentList[i];
            }
        }

        return best;
    }

    public Student findStrugglingStudentForAssignment(int assignmentNum) {
        if (studentList.length == 0) {
            return null;
        }

        double counter = studentList[0].getGrades()[assignmentNum];
        Student worst = studentList[0];
        for (int i = 1; i < studentList.length; i++) {
            if (studentList[i].getGrades()[assignmentNum] < counter) {
                counter = studentList[i].getGrades()[assignmentNum];
                worst = studentList[i];
            }
        }

        return worst;
    }

    public Student[] getStudents() {
        return studentList;
    }

    public String toString() {
        String result = "";
        DecimalFormat df = new DecimalFormat("###.00%");

        for (int i = 0; i < studentList.length; i++) {
            result += "Name: " + studentList[i].getName() + "\tGrade: " + df.format(studentList[i].getGrade()) + "\n";
        }

        return result;
    }

}
