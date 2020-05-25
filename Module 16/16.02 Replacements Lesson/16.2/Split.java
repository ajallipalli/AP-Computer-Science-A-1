import java.util.*;

/**
 * Code and test for method to split a list in half.
 *
 * @author Anika Jallipalli
 * @version 3/12/2020
 */

public class Split
{
    public static void main(String[] args)
    {
        // splitting empty list
        ArrayList<Integer> empty = new ArrayList<Integer>();
        System.out.println(split(empty));
        System.out.println(empty);

        // splitting 1-element list
        ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(1));
        System.out.println(split(one));
        System.out.println(one);

        // splitting even-sized list
        ArrayList<Integer> even = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        System.out.println(split(even));
        System.out.println(even);

        // splitting odd-sized list
        ArrayList<String> odd = new ArrayList<String>(Arrays.asList("MDT", "IAD", "BRU", "MAD", "BCN", "EWR", "BWI"));
        System.out.println(split(odd));
        System.out.println(odd);
    }

    /**
     * Removes the last half of the given list and returns the removed
     * elements on a new list.  The returned list will have the
     * removed elements in the same order that they appeared in the
     * original list.  If the original list has an odd number
     * of elements then it will retain one more element than is removed.
     *
     * @param l a list
     * @return the last half of l
     */
    private static <T> List<T> split(List<T> l)
    // none of this <T> business will be on CS202 Exam #1
    // omit the first <T> and replace the other two with
    // <String> to make this work for lists of Strings
    {
        // compute number of elements to remove from the end of l
        int numToSplit = l.size() / 2;
        
        // create a list to hold the split-off elements
        List<T> result = new LinkedList<T>();
        
        // remove numToSplit elements from end of l and add them to beginning
        // of result
        for (int i = 0; i < numToSplit; i++)
            {
                result.add(0, l.remove(l.size() - 1));
            }
        
        return result;
    }
}