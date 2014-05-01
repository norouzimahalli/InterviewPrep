package interview.prep;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Adunuthula on 4/30/2014.
 * Find the mix/max in a list with the the minimum number of comparisons.
 * Number of comparisons = 3 * (n-1)/2
 */
public class MinMax {

    public static void printMinMax(List<Integer> list) {

        if (list == null || list.isEmpty())
            throw new IllegalArgumentException();

        int minValue = list.get(0);
        int maxValue = minValue;

        list.remove(0);

        while (!list.isEmpty()) {

            int min, max;
            int left = list.get(0);
            int right = list.get(list.size()-1);

            if (left < right) {
                min = left;
                max = right;
            } else {
                min = right;
                max = left;
            }

            minValue = (min < minValue)? min: minValue;
            maxValue = (max > maxValue)? max:maxValue;

            list.remove(0);
            if (!list.isEmpty()) list.remove(list.size()-1);
        }

        System.out.println("Min = " + minValue + " Max = " + maxValue);
    }

    public static void main(String[] args) {
        int[] input = {1};

        List<Integer> list= new LinkedList<Integer>();
        for(int val: input)
            list.add(val);

        printMinMax(list);
    }

}
