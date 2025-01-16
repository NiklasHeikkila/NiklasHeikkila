package dev.m3s.programming2.homework3;


public class Course {
    

    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;      
    private Character courseBase = ' ';        //'A', 'P' or 'S'
    private int courseType;         //0 = Optional, 1 = Mandatory

    private int period;             //1 - 5
    private double credits;         //MIN_CREDITS <= credits <= MAX_COURSE_CREDITS
    private boolean numericGrade;   //true = has numeric grading, false = has not


    public Course() {

    }

    public Course(String name, final int code, Character courseBase, final int type, 
                    final int period, final double credits, boolean numericGrade) {
        
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
        }
    
    public Course(Course course) {

        setName(course.getName());
        this.courseCode = course.getCourseCode();
        this.courseBase = course.getCourseBase();
        setCourseType(course.getCourseType());
        setPeriod(course.getPeriod());
        setCredits(course.getCredits());
        setNumericGrade(course.isNumericGrade());
    }


    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        if (name != null && !name.isEmpty())
            this.name = name;
    }

    public String getCourseTypeString() {

        if (courseType == 0)
            return "Optional";
        else
            return "Mandatory";
    }

    public int getCourseType() {

        return this.courseType;
    }

    public void setCourseType(final int type) {

        if (type == 0 || type == 1)
            this.courseType = type;
    }

    public String getCourseCode() {

        return this.courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {

        courseBase = Character.toUpperCase(courseBase);

        if (courseCode > 0 && courseCode < 1000000 && (courseBase == 'A' || courseBase == 'P' || courseBase == 'S')) {
            this.courseCode = String.format("%d%c", courseCode, courseBase);
            this.courseBase = courseBase;
        }
    }

    /* 
    public boolean checkCourseBase(Character courseBase) {

        if 
            return true;
        else
            return false;
    }
    
    */
    public Character getCourseBase() {

        return this.courseBase;
    }

    public int getPeriod() {

        return this.period;
    }

    public void setPeriod(final int period) {

        if (period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD)
            this.period = period;
    }

    public double getCredits() {

        return this.credits;
    }

    private void setCredits(final double credits) {

        if (credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS)
            this.credits = credits;
    }

    public boolean isNumericGrade() {

        return this.numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {

        this.numericGrade = numericGrade;
    }

    @Override
    public String toString() {

        return "[" + courseCode + " (" + credits + "0 cr), \"" + name + "\". " + getCourseTypeString() + ", period: " + period + ".]"; 
    }


    
}
