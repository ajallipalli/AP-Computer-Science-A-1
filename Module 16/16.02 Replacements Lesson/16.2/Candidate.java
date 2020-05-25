/**
 * A candidate in an election.
 *
 * @author Anika Jallipalli
 * @version 3/12/2020
 */
public class Candidate
{
    /**
     * This candidate's name.
     */
    private String name;

    /**
     * This candidate's vote count.
     */
    private int votes;

    /**
     * Creates a new candidate with the given name and 0 votes.
     *
     * @param n a string
     */
    public Candidate(String n)
    {
        this(n, 0);
    }

    /**
     * Creates a new candidate with the given name and vote count.
     *
     * @param n a string
     * @param v a nonnegative integer
     */
    public Candidate(String n, int v)
    {
        name = n;
        votes = v;
    }

    /**
     * Returns the name of this candidate
     *
     * @return the name of this candidate
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the number of votes for this candidate.
     *
     * @return the number of votes for this candidate
     */
    public int countVotes()
    {
        return votes;
    }

    /**
     * Adds one vote for this candidate.
     */
    public void addVote()
    {
        votes++;
    }

    /**
     * Determines if this candidate is the same as the given object.
     * A candidate is equal only to other candidates with the same name
     * (vote count is irrelevant).
     *
     * @param c a candidate
     * @return true if and only if this candidate and c have the same name
     */
    public boolean equals(Object o)
    {
        if (o instanceof Candidate)
            {
                return equals((Candidate)o);
            }
        else
            {
                return false;
            }
    }

    /**
     * Determines if this candidate is the same as the given candidate.
     * "is the same as" only considers the name.
     *
     * @param c a candidate
     * @return true if and only if this candidate and c have the same name
     */
    public boolean equals(Candidate c)
    {
        return name.equals(c.name);
    }

    /**
     * Returns a printable representation of this candidate.
     *
     * @return a printable representation of this candidate
     */
    public String toString()
    {
        return name + " " + votes;
    }
}