package dev.m3s.programming2.homework3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Student extends Person {

    private int currentYear = LocalDate.now().getYear();
    
    private int id;
    private int startYear = currentYear;                       //2000 < startYear < 2024
    private int graduationYear;
    private List<Degree> degrees = new ArrayList<Degree>();

    

    
    public Student(String lname, String fname) {

        super(lname, fname);
        this.id = getRandomId(1, 100);
        degrees.add(new Degree());
        degrees.add(new Degree());
        degrees.add(new Degree());
    }

    
    public int getId() {
        
        return this.id;
    }

    public void setId(final int id) {

        if (id >= ConstantValues.MIN_STUDENT_ID && id <= ConstantValues.MAX_STUDENT_ID)
            this.id = id;
    }
    
    

    public int getStartYear() {

        return this.startYear;
    }

    public void setStartYear(final int startYear) {

        if (2000 < startYear && startYear <= currentYear) {
            this.startYear = startYear;
        }
    }

    public int getGraduationYear() {

        return this.graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {

        if (canGraduate() && graduationYear >= startYear && graduationYear <= currentYear) {
            this.graduationYear = graduationYear;
            return "Ok";
        } else if (graduationYear <= 2000 || graduationYear >= currentYear) {
            return "Check graduation year";
        } else {
            return "Check amount of required credits";
        } 
    }

    public void setDegreeTitle(final int i, String dName) {
   
        if (0 <= i && i < 3 && dName != null)
            degrees.get(i).setDegreeTitle(dName);
        
    }

    public boolean addCourse(final int i, StudentCourse course) {

        if (i >= 0 && i < 3 && course != null) {
            boolean status = degrees.get(i).addStudentCourse(course);
            return status;
        } else {
            return false;
        }
    }

    public int addCourses(final int i, List<StudentCourse> courses) {

        int count = 0;
        
        if (courses != null) {
            for (int j = 0; j < courses.size(); j++) {
                boolean status = addCourse(i, courses.get(j));
                if (status)
                    count += 1;
            }
    }
        return count;  
    }

    public void printCourses() {

        for (int i = 0; i <= 2; i++)
            degrees.get(i).printCourses();
    }

    public void printDegrees() {
        
        for (int i = 0; i <= 2; i++)
            System.out.println(degrees.get(i).toString());
    }

    public void setTitleOfThesis(final int i, String title) {

        if (0 <= i && i < 3 && title != null)
            degrees.get(i).setTitleOfThesis(title);
    }

    public boolean hasGraduated() {

        if (setGraduationYear(graduationYear) == "Ok") {
            return true;
        } else {
            return false;
        }
    }

    private boolean canGraduate() {

        if (degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS && 
            degrees.get(0).getCreditsByType(1) >= ConstantValues.BACHELOR_MANDATORY &&
            degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS &&
            degrees.get(1).getCreditsByType(1) >= ConstantValues.MASTER_MANDATORY) {
            return true;
        } else {
            return false;
        }
    }

    public int getStudyYears() {

        int studyYears;

        if (hasGraduated() && graduationYear > 0) {
            studyYears = graduationYear - startYear;
        } else {
            studyYears = currentYear - startYear;
        }

        return studyYears;
    }
    
    @Override
    String getIdString() {

        return "Student id: " + getId();
    }

    private String printStatus() {

        if (hasGraduated()) {
            return "The student has graduated in " + graduationYear;
        } else {
            return "The student has not graduated, yet";
        }
    }

    private String printStudyYears() {

        if (hasGraduated()) {
            return " (studies lasted for " + getStudyYears() + " years)";
        } else {
            return " (studies have lasted for " + getStudyYears() + " years)";
        }
    } 

    private double calculateGPA(int degree) {

        double gpa = 0.0;
        double sum = 0.0;
        double count = 0.0;
        
        if (degree == 2) {
            for (int i = 0; i < degrees.size(); i++) {
                sum += degrees.get(i).getGPA(2).get(0);
                count += degrees.get(i).getGPA(2).get(1);
            }
            if (count > 0.0) {
                gpa = sum / count;
                gpa = Degree.roundNum(gpa);
            }  
        } else {
            gpa = degrees.get(degree).getGPA(2).get(2);
        }
        return  gpa;
    }

    private double calculateCredits(int degree) {

        double credits = 0.0;

        if (degree == 2) {
            for (int i = 0; i < degrees.size(); i++) {
                credits += degrees.get(i).getCredits();
            }
        } else {
            credits = degrees.get(degree).getCredits();
        }
        return credits;
    }

    @Override
    public String toString() {

        return getIdString() + "\n" + 
        "       First name: " + getFirstName() + ", Last name: " + getLastName() + "\n" +
        "       Date of birth: \"" + getBirthDate() + "\"\n" +
        "       Status: " + printStatus() + "\n" + 
        "       Start year: " + startYear + printStudyYears() + "\n" +
        "       Total credits: " + calculateCredits(2) + " (GPA = " + calculateGPA(2) + ")" + "\n" +
        "       Bachelor Credits: " + calculateCredits(0) + "\n" +
        "               Total bachelor credits completed (" + calculateCredits(0) + "/" +
                                                            ConstantValues.BACHELOR_CREDITS + ")" + "\n" +
        "               GPA of Bachelor studies: " + calculateGPA(0) + "\n" + 
        "               Title Of BSc Thesis: \"" + degrees.get(0).getTitleOfThesis() + "\"\n" +
        "       MasterCredits: " + calculateCredits(1) + "\n" +
        "               Total master's credits completed (" + calculateCredits(1) + "/" +
                                                            ConstantValues.MASTER_CREDITS + ")" + "\n" +
        "               GPA of Master studies: " + calculateGPA(1) + "\n" + 
        "               TitleOfMasterCredits: \"" + degrees.get(1).getTitleOfThesis() + "\"\n";
    }
}
