package interview.prep;

/**
 * Created by Adunuthula on 4/27/2014.
 */
public class PrintWords {

    private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pkr", "stuv", "wxyz"};
    public static void printWordsUtil(int[] input, int current, char[] output) {
        if (current == input.length) {
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < map[input[current]].length(); i++) {
            output[current] = map[input[current]].charAt(i);
            printWordsUtil(input, current+1, output);
            if (input[current] == 0 || input[current] == 1)
                return;
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 4};
        char[] output = new char[3];
        printWordsUtil(input, 0, output);
    }
}
