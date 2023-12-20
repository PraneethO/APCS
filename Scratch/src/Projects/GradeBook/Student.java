package Projects.GradeBook;

import java.text.DecimalFormat;

public class Student {
    private String name;
    private double[] pointList;
    private double grade;

    public Student(String name, double[] points, double totalPointsPossible) {
        this.name = name;

        this.pointList = new double[points.length];
        for (int i = 0; i < points.length; i++)
            this.pointList[i] = points[i];

        double sum = 0;
        for (int i = 0; i < points.length; i++)
            sum += points[i];
        this.grade = sum / totalPointsPossible;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("####.##%");
        return "Name: " + name + "\t\t\t\tGrade: " + df.format(grade);
    }

    public double[] getGrades() {
        return this.pointList;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getName() {
        return this.name;
    }
}