package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher {


    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();


    public ResponsibleTeacher(String lname, String fname) {

        super(lname, fname);
    }

    
    public String getEmployeeIdString() {

        return "OY_TEACHER_";
    }

    @Override
    public String getCourses() {

        String prefix;
        String courseString = "";

        if (courses != null) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).isResponsible())
                    prefix = "Responsible teacher: ";
                else
                    prefix = "Teacher: ";
                
                courseString += "       " +  prefix + courses.get(i).toString() + "\n";
            }
        }

        return courseString;
    }

    public void setCourses(List<DesignatedCourse> courses) {

        if (courses != null)
            this.courses = courses;
    }

    public String toString() {

        return "Teacher id: " + getIdString() + "\n" +
        "       First name: " + getFirstName() + ", Last name: " + getLastName() + "\n" +
        "       Birthdate: " + getBirthDate() + "\n" +
        "       Salary: " + String.format("%.2f", calculatePayment()).replace(",", ".") + "\n" +
        "       Teacher for courses:\n" + 
        getCourses();
    }
}
