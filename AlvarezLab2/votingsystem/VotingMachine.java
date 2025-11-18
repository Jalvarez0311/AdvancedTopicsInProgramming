package Alvarez_Lab2.votingsystem;
import Alvarez_Lab2.exceptions.MissingCandidatesException;
import Alvarez_Lab2.exceptions.CandidateNotFoundException;
import java.util.ArrayList;

public class VotingMachine{
    private ArrayList<Candidate> candidates;

    public VotingMachine(ArrayList<Candidate> candidates) throws MissingCandidatesException{
        if (candidates == null || candidates.isEmpty()){
            throw new MissingCandidatesException("The candidate list cannot be null or empty.");
        }
        this.candidates = candidates;
    }

    public void vote(Voter v, Candidate c) throws CandidateNotFoundException{
        if (v.hasVoted()){
            System.out.println(v.getFullName() + " has already voted.");
            return;
        }

        boolean candidateExists = false;
        for (Candidate candidate : candidates){
            if (candidate.getFullName().equals(c.getFullName())){
                candidate.incrementVoteCount();
                v.voted();
                candidateExists = true;
                break;
            }
        }

        if (!candidateExists){
            throw new CandidateNotFoundException("Candidate does not exist in the candidates collection.");
        }
    }

    public void tally(){
        Candidate winner = candidates.get(0);
        System.out.println("Vote Tally:");
        for (Candidate candidate : candidates)
        {
            if (candidate.getVoteCount() > winner.getVoteCount())
            {
                winner = candidate;
            }
        }
        System.out.println(winner.getFullName() + " won with " + winner.getVoteCount() + " votes.");
    }
}
