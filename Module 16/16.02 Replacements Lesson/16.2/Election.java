import java.util.List;
import java.util.ArrayList;

/**
 * An election, which is simply a list of candidates.
 *
 * @author Anika Jallipalli
 * @version 3/12/2020
 */
public class Election
{
    /**
     * The candidates in this election.
     */
    private ArrayList<Candidate> candidates;

    /**
     * Creates an empty election.
     */
    public Election()
    {
        candidates = new ArrayList<Candidate>();
    }

    /**
     * Creates a deep copy of the given election.
     *
     * @param e an election
     */
    public Election(Election e)
    {
        // make a new list
        candidates = new ArrayList<Candidate>();

        // make a copy of each candidate in e and add it to our list
        // (this would be a little easier if Candidate also had a copy
        // constructor)
        for (Candidate c : e.candidates)
            {
                candidates.add(new Candidate(c.getName(), c.countVotes()));
            }
    }

    /**
     * Adds one vote for the given candidate.  If the candidate isn't already
     * in this election then it is added.
     *
     * @param n the name of a candidate
     */
    public void addVote(String n)
    {
        // make a candidate with 1 vote that we can add
        Candidate c = new Candidate(n, 1);

        // but before we add it, check to see if it is already there
        // (note that by writing Candidate.equals(Object) we can use indexOf
        // to do the sequential search for us)
        int pos = candidates.indexOf(c);

        if (pos == -1)
            {
                // not there -- go ahead and add
                candidates.add(c);
            }
        else
            {
                // already there -- add a vote to the existing candidate
                candidates.get(pos).addVote();
            }
    }

    /**
     * Returns the name of the candidate with the most votes.  Ties are broken
     * arbitrarily.
     *
     * @return the name of the candidate with the most votes
     */
    public String findWinner()
    {
        // initialize accumulator
        int maxVotes = Integer.MIN_VALUE;
        
        // and create reference to remember best candidate seen so far
        // (so leader is the name of the leading candidate seen so far
        // and maxVotes is the number of votes for the leader)
        String leader = null;

        // loop over all candidates
        for (Candidate c : candidates)
            {
                // compare votes with max so far
                if (c.countVotes() > maxVotes)
                    {
                        // remember new leader
                        leader = c.getName();
                        maxVotes = c.countVotes();
                    }
            }

        return leader;
    }

    /**
     * Returns a list of the names of the candidate with the most votes.
     * arbitrarily.
     *
     * @return the list of names of the candidates with the most votes
     */
    public List<String> findWinners()
    {
        // initialize accumulator
        int maxVotes = Integer.MIN_VALUE;
        
        // and create reference to remember best candidate seen so far
        // (so leader is the leading candidate seen so far and maxVotes
        // is the number of votes for the leader)
        List<String> leaders = new ArrayList<String>();

        // loop over all candidates
        for (Candidate c : candidates)
            {
                // compare votes with max so far
                if (c.countVotes() > maxVotes)
                    {
                        // new leader -- forget old leaders, who are now losers
                        leaders.clear();

                        // remember new leader
                        leaders.add(c.getName());
                        maxVotes = c.countVotes();
                    }
                else if (c.countVotes() == maxVotes)
                    {
                        // tie -- add to leaders
                        leaders.add(c.getName());
                    }
            }

        return leaders;
    }
}