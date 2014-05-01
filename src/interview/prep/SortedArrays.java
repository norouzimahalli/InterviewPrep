package interview.prep;

/**
 * Created by Adunuthula on 4/16/2014.
 */
public class SortedArrays {


    public int kthSortedElement(int[] array, int k) {
        int karray[] = new int[k];
        for (int idx = 0; idx < karray.length; idx++)
            karray[idx] = 0;

        for (int i = 0; i < karray.length; i++) {
            karray[i] = array[0];
            for (int j = 0; j < array.length; j++) {
                if (array[j] < karray[i]) {
                    if (i > 0 && array[j] > karray[i-1]) {
                        karray[i] = array[j];
                    } else {
                        karray[i] = array[j];
                    }
                    System.out.println("karray[" + i + "] = " + karray[i]);
                }
            }
        }

        return karray[k-1];
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 7, 6};

        SortedArrays sa = new SortedArrays();
        System.out.println(sa.kthSortedElement(array, 4));
    }
}
