package Alvarez_Lab2.votingsystem;

import Alvarez_Lab2.exceptions.CandidateNotFoundException;
import Alvarez_Lab2.exceptions.MinimumAgeException;
import Alvarez_Lab2.exceptions.MissingCandidatesException;

import java.util.ArrayList;

public class Election{
    public static void main(String[] args) throws
            MinimumAgeException, MissingCandidatesException, CandidateNotFoundException
    {
        Candidate c1 = null;
        Candidate c2 = null;
        Candidate c3 = null;
        Voter v1 = null;
        Voter v2 = null;
        Voter v3 = null;
        Voter v4 = null;

        try
        {
            c1 = new Candidate(40, 'M', "Ronald", "Dump", "Republican");
            c2 = new Candidate(30, 'F', "Camilla", "Farris", "Democrat");
            c3 = new Candidate(25, 'F', "Milan", "Husk", "Non-Affiliate");
            v1 = new Voter(1,18, 'M', "Harry", "Tubman","Democrat");
            v2 = new Voter(2,20, 'F', "Kimberly", "Hardashian","Republican");
            v3 = new Voter(3,25, 'F', "Serendipity", "Steele","Non-Affiliate");
            v4 = new Voter(4,29, 'M', "Jonathan", "Stall","Democrat");
        }
        catch (MinimumAgeException e)
        {
            System.out.println(e.getMessage());
        }

        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        candidates.add(c1);
        candidates.add(c2);
        candidates.add(c3);
        try
        {
            VotingMachine vm = new VotingMachine(candidates);
            vm.vote(v1,c1);
            vm.vote(v3,c3);
            vm.vote(v4,c1);
            vm.vote(v2,c2);
            vm.tally();
        }
        catch (CandidateNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (MissingCandidatesException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
