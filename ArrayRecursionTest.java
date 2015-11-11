package ArrayRecursion;

/**
 *
 * @author Paola Jiron
 */
import java.util.Random;

class ArrayRecursion
{

    // instance var's

    private int[] list;		// array of ints
    private int count = 0;		// number of elements used
    private Random r;

    /**
     * Create an ArrayRecursion object. Create an array with between 10 and 15
     * elements, and fill it with random positive 2-digit ints
     */
    public ArrayRecursion()
    {
        r = new Random();
        count = r.nextInt(6) + 10;
        list = new int[count];

        for (int i = 0; i < count; i++)
        {
            list[i] = r.nextInt(90) + 10;
        }
    }

    /*
     * Return the list as a string
     * @return a string containing all ints stored in list
     */
    public String toString()
    {
        String out = "";
        for (int i = 0; i < count; i++)
        {
            out += list[i] + "  ";
        }
        return out + "\n";
    }

    /**
     * Reverse the order of the values stored in the list. (called by client to
     * reverse list using first algorithm)
     */
    public void reverse()
    {
        reverseRecurse(list, 0, count);
    }

    /**
     * Recursive "helper" method to reverse the values stored in the list
     * (called by public method reverse1()). Uses the first list reversal
     * algorithm.
     * @param list An array of int.
     * @param start The first element on the array.
     * @param count The size of the array.
     */
    private void reverseRecurse(int[] list, int start, int count)
    {
            // recursively swap values on the list until the center
        // of the list is reached ( basis case )

        if (start < count)
        {
                // values being swapped are first with last and last with first

            int temp = list[start];
            list[start] = list[count - 1];
            list[count - 1] = temp;

            // recursive call
            reverseRecurse(list, start + 1, count - 1);
        }

    }

    /*
     * Return the largest value in the array.
     * @return the largest value in the array
     */
    public int getIndexOfLargest()
    {
        return recursiveGetIndexOfLargest(list, count);
    }

    /**
     * Recursive "helper" method to return largest value in the array (called by
     * public method getLargest()).
     * @param list An array of int.
     * @param count The size of the array.
     * @return The index of the largest value in the array.
     */
    private int recursiveGetIndexOfLargest(int[] list, int count)
    {
            // basis case, if only one element, return its index ( zero )

        if (count == 1)
        {
            return 0;
        }
        else
        {
                // position of largest value in the array 
            // excluding the last element

            int largest = recursiveGetIndexOfLargest(list, count - 1);

                // compare largest yet with last element
            if (list[largest] < list[count - 1])
            {
                return count - 1;   // last element is largest
            }
            else
            {
                return largest;    // largest in the list
            }

        }
    }

    /*
     * Sort the array in ascending order using the selection sort
     */
    public void sort()
    {
        recursiveSort(list, count);
    }

    /**
     * Recursive "helper" method to sort the array (called by public method
     * sort())
     * @param list AN array of int.
     * @param count The size of the array.
     */
    private void recursiveSort(int[] list, int count)
    {
            // current position of largest value on the list

        int largest = recursiveGetIndexOfLargest(list, count);

            // if there is more than one element on the list
        if (count > 1)
        {
                // swap position of last element with the largest value 

            int temp = list[count - 1];
            list[count - 1] = list[largest];
            list[largest] = temp;

                // recursive call to sort the rest of the list
            recursiveSort(list, count - 1);
        }
    }

}

/**
 * A test class for the ArrayRecursion class
 */
public class ArrayRecursionTest
{

    public static void main(String[] args)
    {
        ArrayRecursion list = new ArrayRecursion();

        System.out.println("\nOriginal:  " + list);
        list.reverse();
        System.out.println("\nReversed:    " + list);
        System.out.println("Largest value is at index: " + list.getIndexOfLargest());
        list.sort();
        System.out.println("\nSorted:    " + list);
    }
}
