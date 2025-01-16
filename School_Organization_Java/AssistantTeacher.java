package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class AssistantTeacher extends Employee implements Teacher {
    

    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();


    public AssistantTeacher(String lname, String fname) {

        super(lname, fname);
    }


    @Override
    public String getEmployeeIdString() {

        return "OY_ASSISTANT_";
    }

    public String getCourses() {

        String courseString = "";
        if (courses != null) {
            for (int i = 0; i < courses.size(); i++) {
                courseString += "       " + courses.get(i).toString() + "\n";
            }
        }

        return courseString;
    }

    public void setCourses(List<DesignatedCourse> courses) {

        if (courses != null)
            this.courses = courses;
    }
    
    @Override
    public String toString() {

        return "Teacher id: " + getIdString() + "\n" +
        "       First name: " + getFirstName() + ", Last name: " + getLastName() + "\n" +
        "       Birthdate: " + getBirthDate() + "\n" +
        "       Salary: " + String.format("%.2f", calculatePayment()).replace(",", ".") + "\n" +
        "       Assistant for courses:\n" + 
        getCourses();
    }

}
