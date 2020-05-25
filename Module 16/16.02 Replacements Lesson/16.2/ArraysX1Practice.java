public class ArraysX1Practice
{
    public static void main(String[] args)
    {
        // input data with matches and rows with the target as a prefixes
        String[][] routes = {{"SEA","BWI", "SEA"},
                             {"BWI"},
                             {"SEA","BWI"},
                             {"BWI","SEA"},
                             {"SEA","BWI","PVD"},
                             {"ORD","BWI", "IAH", "ORD"}};

        // Problem 6: count total number of "BWI"s
        int bwiCount = 0;
        for (int r = 0; r < routes.length; r++)
            {
                for (int c = 0; c < routes[r].length; c++)
                    {
                        if (routes[r][c].equals("BWI"))
                            {
                                bwiCount++;
                            }
                    }
            }
        System.out.println("BWI appears " + bwiCount + " times");

        // Problem 7: count rows where 1st element matches last
        int rtCount = 0;
        for (int r = 0; r < routes.length; r++)
            {
                if (routes[r][0].equals(routes[r][routes[r].length - 1]))
                    {
                        rtCount++;
                    }
            }
        System.out.println(rtCount + " rows have matching 1st and last");

        // input data with matches and rows with the target as a prefixes
        String[][] routes2 = {{"SEA","BWI"},
                             {"BWI","IAH","PDX"},
                             {"SEA","BWI"},
                             {"BWI","SEA"},
                             {"SEA","BWI","PVD"},
                             {"SEA","BWI"}};

        // tests for countMatchingRows
        System.out.println(countMatchingRows(routes2, 0)); // find matches after
        System.out.println(countMatchingRows(routes2, 2)); // find before and afte
        System.out.println(countMatchingRows(routes2, 5)); // find matches before
        System.out.println(countMatchingRows(routes2, 1)); // no matches

        // input data with nulls, empty rows, and rows that are prefixes of target
        String[][] routes3 = {{"SEA","BWI"},
                             {"BWI","IAH","PDX"},
                             null,
                             null,
                             {"SEA","BWI","PVD"},
                             {"SEA","BWI"},
                             {},
                             {},
                             {"SEA","BWI"},
                             {"SEA"}};

        System.out.println(countMatchingRows(routes3, 2)); // nulls match each other
        System.out.println(countMatchingRows(routes3, 0)); // nulls don't hurt other matches
        System.out.println(countMatchingRows(routes3, 6)); // empty rows match each other

        // exceptions
        // System.out.println(countMatchingRows(routes3, -1));
        // System.out.println(countMatchingRows(routes3, input2.length));
    }

    /**
     * Problem 8
     * Counts the number of rows in the given array that have the same
     * contents as the given row in the same order.  The given row does
     * not count as a match of itself.
     *
     * @param arr an array of strings
     * @param r the index of a row in that array
     */
    public static int countMatchingRows(String[][] arr, int r)
    {
        // make sure r is a valid row index
        if (r < 0 || r > arr.length)
            {
                throw new IllegalArgumentException("Invalid row: " + r);
            }

        // go over all other rows in the array
        int count = 0;
        for (int r2 = 0; r2 < arr.length; r2++)
            {
                // checking whether the two rows match is rather involved --
                // this is a good place to organize things in another method
                if (r != r2 && rowsMatch(arr, r, r2))
                    {
                        count++;
                    }
            }
        return count;
    }

    /**
     * Determines if the given rows in the given array have the same contents
     * in the same order.
     *
     * @param arr an array of strings
     * @param r the index of a row in that array
     * @param r2 the index of a row in that arrau
     * @return true if and only if rows r and r2 have the same
     * contents in the same order
     */

    public static boolean rowsMatch(String[][] arr, int r, int r2)
    {
        if (arr[r] == null && arr[r2] == null)
            {
                // both are null -- match
                return true;
            }
        else if (arr[r] == null || arr[r2] == null)
            {
                // one is null and the other isn't -- no match
                return false;
            }
        else if (arr[r].length != arr[r2].length)
            {
                // different lengths -- no match
                return false;
            }
        else
            {
                // search for a column where the two rows don't match
                int c = 0;
                while (c < arr[r].length && arr[r][c].equals(arr[r2][c]))
                    {
                        c++;
                    }
                
                // rows match iff we went through the loop and found no mismatch
                return (c == arr[r].length);
            }
    }


}