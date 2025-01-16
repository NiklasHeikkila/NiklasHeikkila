package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        //courseTesti();
        //studentCourseTesti();
        //degreeTesti();
        //personIDTesti();
        //studentTesti();
        //employeeTesti();
        //designatedCourseTesti();
        assistantTeacherTesti();
        responsibleTeacherTesti();
    }

    public static void responsibleTeacherTesti() {

        ResponsibleTeacher responsibleTeacher = new ResponsibleTeacher("Meikäläinen", "Matti");

        Course course1 = new Course("Course 1", 811322, 'A', 0, 3,35.0, true);
        Course course2 = new Course("Course 2", 434522, 'S', 0, 2, 42.0, true);
        Course course3 = new Course("Course 3", 121322, 'P', 0, 1, 36.0, true);
        Course course4 = new Course("Course 4", 967873, 'P', 0, 1, 48.0, true);
        Course course5 = new Course("Course 5", 363121, 'A', 1, 1, 3.0, true);
        Course course6 = new Course("Course 6", 663142, 'A', 0, 1, 43.0, true);
        Course course7 = new Course("Course 7", 486098, 'A', 0, 1, 5.0, true);

        DesignatedCourse desigCourse1 = new DesignatedCourse(course1, false, 2022);
        DesignatedCourse desigCourse2 = new DesignatedCourse(course2, true, 2023);
        DesignatedCourse desigCourse3 = new DesignatedCourse(course3, true, 2021);
        DesignatedCourse desigCourse4 = new DesignatedCourse(course4, true, 2020);
        DesignatedCourse desigCourse5 = new DesignatedCourse(course5, false, 2022);
        DesignatedCourse desigCourse6 = new DesignatedCourse(course6, true, 2023);
        DesignatedCourse desigCourse7 = new DesignatedCourse(course7, true, 2021);

        List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();
        courses.add(desigCourse1);
        courses.add(desigCourse2);
        courses.add(desigCourse3);
        courses.add(desigCourse4);
        courses.add(desigCourse5);
        courses.add(desigCourse6);
        courses.add(desigCourse7);

        responsibleTeacher.setCourses(courses);

        System.out.println(responsibleTeacher);
    }

    public static void assistantTeacherTesti() {

        AssistantTeacher assistantTeacher = new AssistantTeacher("Meikäläinen", "Matti");

        Course course1 = new Course("Course 1", 811322, 'A', 0, 3,35.0, true);
        Course course2 = new Course("Course 2", 434522, 'S', 0, 2, 42.0, true);
        Course course3 = new Course("Course 3", 121322, 'P', 0, 1, 36.0, true);
        Course course4 = new Course("Course 4", 967873, 'P', 0, 1, 48.0, true);
        Course course5 = new Course("Course 5", 363121, 'A', 1, 1, 3.0, true);
        Course course6 = new Course("Course 6", 663142, 'A', 0, 1, 43.0, true);
        Course course7 = new Course("Course 7", 486098, 'A', 0, 1, 5.0, true);

        DesignatedCourse desigCourse1 = new DesignatedCourse(course1, true, 2022);
        DesignatedCourse desigCourse2 = new DesignatedCourse(course2, true, 2023);
        DesignatedCourse desigCourse3 = new DesignatedCourse(course3, true, 2021);
        DesignatedCourse desigCourse4 = new DesignatedCourse(course4, true, 2020);
        DesignatedCourse desigCourse5 = new DesignatedCourse(course5, true, 2022);
        DesignatedCourse desigCourse6 = new DesignatedCourse(course6, true, 2023);
        DesignatedCourse desigCourse7 = new DesignatedCourse(course7, true, 2021);

        List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();
        courses.add(desigCourse1);
        courses.add(desigCourse2);
        courses.add(desigCourse3);
        courses.add(desigCourse4);
        courses.add(desigCourse5);
        courses.add(desigCourse6);
        courses.add(desigCourse7);

        assistantTeacher.setCourses(courses);

        System.out.println(assistantTeacher);

        
    }

    public static void designatedCourseTesti() {

        Course course2 = new Course("Matematiikan PKII", 811322, 'A', 1, 3, 5.0, true);

        DesignatedCourse desigCourse = new DesignatedCourse(course2, true, 2022);

        System.out.println(desigCourse);
    }

    public static void personIDTesti() {

        PersonID personID1 = new PersonID();
        PersonID personID2 = new PersonID();

        personID1.setPersonId("170307A389R");
        String pId1 = personID1.getBirthDate();

        personID1.setPersonId("123112A1234");
        String pId2 = personID2.getBirthDate();

        System.out.println(pId1);
        System.out.println(pId2);
    }

    public static void courseTesti() {

        Course course1 = new Course();
        Course course2 = new Course("Matematiikan PKII", 811322, 'A', 1, 3, 5.0, true);
        Course course3 = new Course(course2);

        course1.setName("Ohjelmointi 2");
        course1.setCourseCode(521298, 'A');
        course1.setCourseType(0);
        course1.setPeriod(4);
        course1.setNumericGrade(false);
        
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
    }

    public static void studentCourseTesti() {

        Course course2 = new Course("Matematiikan PKII", 811322, 'A', 1, 3, 5.0, true);

        StudentCourse studentCourse1 = new StudentCourse();
        StudentCourse studentCourse2 = new StudentCourse(course2, 'F', 2020);

        studentCourse1.setCourse(course2);
        studentCourse1.setGrade(4);
        studentCourse1.setYear(2020);

        System.out.println(studentCourse1);
        System.out.println(studentCourse2);
    }


    public static void degreeTesti() {

        Course course1 = new Course("Matematiikan PKI", 811322, 'A', 1, 3, 5.0, true);
        Course course2 = new Course("Matematiikan PKII", 434522, 'S', 0, 2, 5.0, false);
        Course course3 = new Course("Ohjelmointi 2", 121322, 'P', 0, 1, 5.0, true);

        StudentCourse studentCourse1 = new StudentCourse(course1, 5, 2020);
        StudentCourse studentCourse2 = new StudentCourse(course2, 'A', 2021);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2019);

        List<StudentCourse> courses = new ArrayList<StudentCourse>();
        courses.add(studentCourse1);
        courses.add(studentCourse2);
        courses.add(studentCourse3);

        Degree degree1 = new Degree();

        //degree1.addStudentCourse(studentCourse1);
        //degree1.addStudentCourse(studentCourse2);
        degree1.addStudentCourses(courses);
        degree1.setDegreeTitle("Bachelor of science");
        degree1.setTitleOfThesis("Testing testing...");

        //System.out.println("CreditsByBase: " + degree1.getCreditsByBase('A'));
        //System.out.println("CreditsByType: " + degree1.getCreditsByType(1));
        //System.out.println("All credits: " + zdegree1.getCredits());
        System.out.println(degree1);
        //degree1.printCourses();

    }

    public static void studentTesti() {

        Course course1 = new Course("Course 1", 811322, 'A', 0, 3,35.0, true);
        Course course2 = new Course("Course 2", 434522, 'S', 0, 2, 42.0, true);
        Course course3 = new Course("Course 3", 121322, 'P', 0, 1, 36.0, true);
        Course course4 = new Course("Course 4", 967873, 'P', 0, 1, 48.0, true);
        Course course5 = new Course("Course 5", 363121, 'A', 1, 1, 3.0, true);
        Course course6 = new Course("Course 6", 663142, 'A', 0, 1, 43.0, true);
        Course course7 = new Course("Course 7", 486098, 'A', 0, 1, 5.0, true);
        

        StudentCourse studentCourse1 = new StudentCourse(course1, 3, 2017);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2021);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2008);
        StudentCourse studentCourse4 = new StudentCourse(course4, 1, 2015);
        StudentCourse studentCourse5 = new StudentCourse(course5, 4, 2009);
        StudentCourse studentCourse6 = new StudentCourse(course6, 3, 2022);
        StudentCourse studentCourse7 = new StudentCourse(course7, 2, 2002);

        List<StudentCourse> courses = new ArrayList<StudentCourse>();
        courses.add(studentCourse1);
        courses.add(studentCourse2);
        courses.add(studentCourse3);
        courses.add(studentCourse4);
        courses.add(studentCourse5);
        courses.add(studentCourse6);
        courses.add(studentCourse7);

        Student student1 = new Student("Mattila", "Matti");
        
        
        student1.setDegreeTitle(0, ConstantValues.BACHELOR_STR);
        student1.setDegreeTitle(1, ConstantValues.MASTER_STR);
        student1.setTitleOfThesis(0, "Parempi pyy pivossa kuin 10 oksalla.");
        student1.setTitleOfThesis(1, "Joka kuuseen kurkottaa, se katajaan kapsahtaa.");

        student1.addCourse(0, studentCourse1);
        student1.addCourse(0, studentCourse2);
        student1.addCourse(0, studentCourse3);
        student1.addCourse(0, studentCourse4);
        student1.addCourse(0, studentCourse5);
        student1.addCourse(1, studentCourse6);
        student1.addCourse(1, studentCourse7);

        //student1.addCourses(1, courses);
        
        student1.setStartYear(2014);
        student1.setGraduationYear(2019);
        //student1.printCourses();
        //student1.printDegrees();
        //System.out.println(student1);


        
        //System.out.println(student1.getStudyYears( ));
        System.out.println(student1);
    }

    public static void employeeTesti() {

        Employee employee1 = new Employee("Pekkala", "Pekka");

        employee1.setBirthDate("070803A6014");
        //employee1.setPayment(1135.2854);
        employee1.setStartYear(2000);

        System.out.println(employee1);
    }
}