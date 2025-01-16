package dev.m3s.programming2.homework3;

import java.time.LocalDate;

public class StudentCourse {


    private Course course;
    private int gradeNum;
    private int yearCompleted = 0;
    private int currentYear = LocalDate.now().getYear();

    public StudentCourse() {

    }

    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }
    

    public Course getCourse() {

        return this.course;
    }

    public void setCourse(Course course) {

        this.course = course;
    }

    public int getGradeNum() {
        
        return this.gradeNum;
    }
    
    protected void setGrade(int gradeNum) {

        if (checkGradeValidity(gradeNum)) {
            this.gradeNum = gradeNum;
            if (yearCompleted == 0)
                yearCompleted = currentYear;
        }
    }

    private boolean checkGradeValidity(final int gradeNum) {

        if (!course.isNumericGrade()) {
            if (gradeNum == 65 || gradeNum == 97 || gradeNum == 70 || gradeNum == 102)
                return true;
            else
                return false;
        } else {
            if (gradeNum >= 0 && gradeNum <= 5)
                return true;
            else
                return false;
        }
    }

    public boolean isPassed() {

        if (gradeNum == 0 || gradeNum == 70 || gradeNum == 102)
            return false;
        else
            return true;
    }

    public int getYear() {

        return this.yearCompleted;
    }

    public void setYear(final int year) {

        if (year > 2000 && year <= currentYear)
            this.yearCompleted = year;
    }
    @Override
    public String toString() {

        if (!course.isNumericGrade()) {

            if (gradeNum == 65 || gradeNum == 97)
                return getCourse() + " Year: " + getYear() + ", Grade: " + ConstantValues.GRADE_ACCEPTED + ".]";
            else if (gradeNum == 70 || gradeNum == 102)
                return getCourse() + " Year: " + getYear() + ", Grade: " + ConstantValues.GRADE_FAILED + ".]";
            else
                return getCourse() + " Year: " + getYear() + ", Grade: Not graded" + ".]";
            

        } else {

            if (gradeNum == 0)
                return getCourse() + " Year: " + getYear() + ", Grade: Not graded" + ".]";
            else
                return getCourse() + " Year: " + getYear() + ", Grade: " + gradeNum + ".]";
        }
        
    }
}
