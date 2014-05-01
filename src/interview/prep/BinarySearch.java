package interview.prep;

/**
 * Created by Adunuthula on 4/13/2014.
 */
public class BinarySearch {

    public static boolean binarySearch(int[] array, int number) {
        int beginIndex = 0;
        int endIndex = array.length;
        int index = (beginIndex + endIndex)/2;

        while (index != beginIndex || index != endIndex) {
            index = (beginIndex + endIndex)/2;

            if (array[index] == number) {
                return true;
            } else if (array[index] < number) {
                beginIndex = index;
            } else if (array[index] > number) {
                endIndex = index;
            }
        }

        return false;
    }

    public static boolean rotatedBinarySearch(int[] array, int number, int rotatedBy) {
        int beginIndex = 0;
        int endIndex = array.length;
        int index = (beginIndex + endIndex)/2;
        int adjustedIndex = (index + rotatedBy) % array.length;

        while (index != beginIndex || index != endIndex) {
            index = (beginIndex + endIndex)/2;
            adjustedIndex = (index + rotatedBy) % array.length;

            if (array[adjustedIndex] == number) {
                return true;
            } else if (array[adjustedIndex] < number) {
                beginIndex = index;
            } else if (array[adjustedIndex] > number) {
                endIndex = index;
            }
        }

        return false;
    }
}
