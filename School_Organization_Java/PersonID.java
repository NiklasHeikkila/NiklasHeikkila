package dev.m3s.programming2.homework3;

import java.time.Year;

public class PersonID {
    
    private String birthDate = ConstantValues.NO_BIRTHDATE;


    public String getBirthDate() {

        return this.birthDate;
    }

    public String setPersonId(final String personId) {

        char centuryCharacter = ' ';
        String century = null;
        String dd = null;
        String mm = null;
        String yyyy = null;
        String date = null;
        
        if (checkPersonIDNumber(personId)) {

            centuryCharacter = personId.charAt(6);
            century = getCentury(centuryCharacter);
            dd = personId.substring(0, 2);
            mm = personId.substring(2, 4);
            yyyy = century + personId.substring(4, 6);
            date = dd + "." + mm + "." + yyyy;
        
            if (checkBirthdate(date)) {
                if (checkValidCharacter(personId)) {
                    birthDate = date;
                    return "Ok";
                } else {
                    return ConstantValues.INCORRECT_CHECKMARK;
                }
            } else {
                return ConstantValues.INVALID_BIRTHDAY;
            }
        } else {
            return ConstantValues.INVALID_BIRTHDAY;
        }
    }

    private boolean checkPersonIDNumber(final String personId) {

        if (personId != null) {
            int length = personId.length();
            char centuryCharacter = personId.charAt(6);

            if (length == 11) {

                if(centuryCharacter == '+' || centuryCharacter == '-' || centuryCharacter == 'A') {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkLeapYear(int year) {

        return Year.isLeap(year);
    }

    private boolean checkValidCharacter(final String personId) {

        String character = Character.toString(personId.charAt(10));     //control character in given person id
        int number = Integer.parseInt(personId.substring(0, 6) +
                                    personId.substring(7, 10));

        int remainder = number % 31;
        String controlChar = " ";
        
        if (remainder <= 9) {
            controlChar = Integer.toString(remainder);
        } else if (remainder >= 10 && remainder <= 15) {
            controlChar = Integer.toHexString(remainder).toUpperCase(); //using hex decimals
        } else {
            switch (remainder) {
                case 16: controlChar = "H";
                    break;
                case 17: controlChar = "J";
                    break;
                case 18: controlChar = "K";
                    break;
                case 19: controlChar = "L";
                    break;
                case 20: controlChar = "M";
                    break;
                case 21: controlChar = "N";
                    break;
                case 22: controlChar = "P";
                    break;
                case 23: controlChar = "R";
                    break;
                case 24: controlChar = "S";
                    break;
                case 25: controlChar = "T";
                    break;
                case 26: controlChar = "U";
                    break;
                case 27: controlChar = "V";
                    break;
                case 28: controlChar = "W";
                    break;
                case 29: controlChar = "X";
                    break;
                case 30: controlChar = "Y";
                    break;
                default:
                    break;
            }
        }
        
        if(character.equals(controlChar)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkBirthdate(final String date) {

        String[] parts = date.replace(".", ":").split(":");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        int lastDay = 0;
        int febLastday = 0;

        if(checkLeapYear(year))
            febLastday = 29;
        else
            febLastday = 28;
        
        if(day < 1 || day > 31 || month < 1 || month > 12 || year < 0) {
            return false;
        } else {
            switch (month) {
                case 1: lastDay = 31;
                    break;
                case 2: lastDay = febLastday;
                    break;
                case 3: lastDay = 31;
                    break;
                case 4: lastDay = 30;
                    break;
                case 5: lastDay = 31;
                    break;
                case 6: lastDay = 30;
                    break;
                case 7: lastDay = 31;
                    break;
                case 8: lastDay = 31;
                    break;
                case 9: lastDay = 30;
                    break;
                case 10: lastDay = 31;
                    break;
                case 11: lastDay = 30;
                    break;
                case 12: lastDay = 31;
                    break;
                default:
                    break;
            }
        }

        if(day > lastDay) {
            return false;
        } else {       
            return true;    //date is ok
        }
    }

    private String getCentury(char centuryCharacter) {
        String century = null;

        switch (centuryCharacter) {
                        case '+': century = "18";
                            break;
                        case '-': century = "19";
                            break;
                        case 'A': century = "20";
                            break;
                        default:
                            break;
                    }

        return century;
    }
}
