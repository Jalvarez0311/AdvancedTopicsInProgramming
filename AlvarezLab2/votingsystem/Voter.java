package Alvarez_Lab2.votingsystem;

import Alvarez_Lab2.exceptions.MinimumAgeException;

public class Voter extends Person{
    private int voterID;
    private boolean voted = false;

    Voter(int voterID, int age, char gender, String firstName, String lastName, String politicalParty) throws MinimumAgeException
    {
        super(age, gender, firstName, lastName, politicalParty);
        if(age < 18)
        {
            throw new MinimumAgeException("Voter's age cannot be less than 18.");
        }
        this.voterID = voterID;
    }

    public int getVoterID()
    {
        return voterID;
    }

    public boolean hasVoted()
    {
        return voted;
    }

    public void voted()
    {
        voted = true;
    }

    @Override
    public String getFullName()
    {
        return super.firstName + " " + super.lastName;
    }
}
