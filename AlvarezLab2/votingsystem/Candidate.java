package Alvarez_Lab2.votingsystem;
//todo comment
import Alvarez_Lab2.exceptions.MinimumAgeException;

public class Candidate extends Person{
    private int voteCount = 0;

    Candidate(int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException {
        super(age, gender, firstName, lastName, politicalParty);
        if (age < 25){
            throw new MinimumAgeException("Candidate's age cannot be less than 25");
        }
    }

    public int getVoteCount() {return voteCount;}
    public void incrementVoteCount() {voteCount++;}

    /**
     * Determines name and political party
     * @return first name and last name and political party
     */
    @Override //might not be necessary in VS Code
    public String getFullName(){
        if(super.politicalParty.equals("Democrat")){
            return(super.firstName + " " + super.lastName + " -D");
        }
        else if(super.politicalParty.equals("Republican")){
            return(super.firstName + " " + super.lastName + " -R");
        }
        else if(super.politicalParty.equals("Non-Affiliate")){
            return(super.firstName + " " + super.lastName + " -NA");
        }
        else{
            return(super.firstName + " " + super.lastName);
        }
    }
}
