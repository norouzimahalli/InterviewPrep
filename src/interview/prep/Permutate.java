package interview.prep;

/**
 * Created by Adunuthula on 4/27/2014.
 */
public class Permutate {

    public static void swap(char[] input, int a, int b) {
        char tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public static void print(char[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        System.out.println();
    }

    public void permutate(char[] input, int start, int end) {
        if (start == end) {
            print(input);
            return;
        }

        for (int i = start; i < end; i++) {
            System.out.println("Swapping " + input[start] + " " + input[i]);
            swap(input, start, i);
            permutate(input, i+1, end);
            System.out.println("Backtracking " + input[start] + " " + input[i]);
            swap(input, start, i);
        }
    }

    public static void main(String[] args) {
        char[] input = {'A', 'B', 'C'};
        Permutate p = new Permutate();
        p.permutate(input, 0, input.length);
    }
}
