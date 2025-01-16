package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;  
import java.math.RoundingMode;

public class Degree {
    

    private static final int MAX_COURSES = 50;
    private int count = 0;                          //Number of courses for this degree
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>();



    public List<StudentCourse> getCourses() {

        return this.myCourses;
    }

    public void addStudentCourses(List<StudentCourse> courses) {

        if (courses != null) {
            int length = Math.min(courses.size(), MAX_COURSES);

            for (int i = 0; i < length; i++) {
                addStudentCourse(courses.get(i));              
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course) {
        if (count < MAX_COURSES && course != null) {
            myCourses.add(course);
            count += 1;
            return true;
        } else {
            return false;
        }
    }

    public String getDegreeTitle() {

        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {

        if (degreeTitle != null)
            this.degreeTitle = degreeTitle;
    }

    public String getTitleOfThesis() {

        return titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis) {

        if (titleOfThesis != null)
            this.titleOfThesis = titleOfThesis;
    }

    public double getCreditsByBase(Character base) {

        double creditsByBase = 0.0;
        base = Character.toUpperCase(base);
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null) {
                StudentCourse course = myCourses.get(i);
                Character courseBase = Character.toUpperCase(course.getCourse().getCourseBase());
                if (isCourseCompleted(course) && base == courseBase) {
                    creditsByBase += course.getCourse().getCredits();
                }
            }
        }

        return creditsByBase;
    }

    public double getCreditsByType(final int courseType) {

        double creditsByType = 0.0;

        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null) {
                StudentCourse course = myCourses.get(i);
                int type = course.getCourse().getCourseType();

                if (isCourseCompleted(course) && type == courseType) {
                    creditsByType += course.getCourse().getCredits();
                }
            }
        }

        return creditsByType;
    }

    public double getCredits() {

        double credits = 0.0;

        for (int i = 0; i < count; i++) {
            if (isCourseCompleted(myCourses.get(i))) {
                credits += myCourses.get(i).getCourse().getCredits();
            }
        }

        return credits;
    }

    private boolean isCourseCompleted(StudentCourse c) {

        if (c != null){
            if (c.isPassed() == true)
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    public void printCourses() {

        for (int i = 0; i <= count - 1; i++)
            if (myCourses.get(i) != null)
                System.out.println(i + 1 + ". " + myCourses.get(i).toString() + "\n");
        
    }
    
    public List<Double> getGPA(int type) {

        

        double sum = 0.0;
        double count = 0.0;
        double average = 0.0;
        List<Double> values = new ArrayList<Double>();

        for (int i = 0; i < this.count; i++) {
            if (myCourses.get(i) != null) {
                StudentCourse studentCourse = myCourses.get(i);

                if (studentCourse.getCourse().isNumericGrade()) {
                    int courseType = studentCourse.getCourse().getCourseType();

                    if (type == ConstantValues.OPTIONAL || type == ConstantValues.MANDATORY) {
                        if (courseType == type) {
                            sum += studentCourse.getGradeNum();
                            count += 1;
                        }
                    } else {
                        sum += studentCourse.getGradeNum();
                        count += 1;
                    }
                }     
            }
        }
        if (count > 0)   
            average = sum / count;
        
        values.add(roundNum(sum));
        values.add(roundNum(count));
        values.add(roundNum(average));

        return values;
    }

    
    protected static double roundNum(double num) {

        double roundedNum = 0.0;

        if (num != 0.0) {
            BigDecimal bigDecimal = new BigDecimal(num);
            bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
            roundedNum = bigDecimal.doubleValue();
        }
        return roundedNum;
    }

    public String coursesToString() {

        String courseString = "";

        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null) {
                courseString += "       " + (i + 1) + ". " + myCourses.get(i).toString();
                if (i < count - 1)
                    courseString += "\n";
            }
        }
        return courseString;
    }

    @Override
    public String toString() {
        
        return "Degree [Title: \"" + getDegreeTitle() + "\" (courses: " + count + ")\n" +
                "       Thesis title: \"" + getTitleOfThesis() + "\"\n" + 
                coursesToString() + "]\n" + "GPA: " + getGPA(ConstantValues.ALL);
    }

    
}
