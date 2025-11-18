package Alvarez_Lab2.votingsystem;

/**
*@author jorgeandresalvarez
*2/13/2025
*An abstract class to describe a general person
*/
public abstract class Person {
    private int age;
    private char gender;
    protected String firstName;
    protected String lastName;
    protected String politicalParty;

    /**
     * Create a person - Constructor
     * @param age - person's age
     * @param gender
     * @param firstName
     * @param lastName
     * @param politicalParty
     */
    
    public Person(int age, char gender, String firstName, String lastName, String politicalParty){
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.politicalParty = politicalParty;
    }

    public int getage(){
        return age;
    }

    public char getGender(){
        return gender;
    }

    public abstract String getFullName();
}

