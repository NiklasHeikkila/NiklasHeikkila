package dev.m3s.programming2.homework3;

import java.util.Random;

abstract class Person {
    
    private final Random random = new Random();
    private PersonID personId = new PersonID();

    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NO_BIRTHDATE;


    public Person(String lname, String fname) {

        setFirstName(fname);
        setLastName(lname);
        
    }


    public String getFirstName() {
    
        return firstName;
    }


    public void setFirstName(String firstName) {
        
        if (firstName != null)
            this.firstName = firstName;
    }


    public String getLastName() {
    
        return lastName;
    }


    public void setLastName(String lastName) {
    
        if (lastName != null)
            this.lastName = lastName;
    }


    public String getBirthDate() {
    
        return this.birthDate;
    }


    public String setBirthDate(String personID) {
        
        if (personID != null && personId.setPersonId(personID).equals("Ok")) {
            personId.setPersonId(personID);
            this.birthDate = personId.getBirthDate();
            return this.birthDate;
        } else {
            return "No change";
        }
        }

    protected int getRandomId(final int min, final int max) {

        int id = random.nextInt(max - min);
        id += min;

        return id;
    }

    abstract String getIdString();
}
