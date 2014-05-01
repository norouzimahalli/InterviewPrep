package interview.prep;

/**
 * Created by Adunuthula on 4/27/2014.
 */
public class MaxProduct {

    public int maxProduct(int n) {
        if (n <= 1 ) return 0;

        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            int value = ((i * (n-i)) > i * maxProduct(n-i)) ? i * (n - 1): i * maxProduct(n-1);

            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        MaxProduct m = new MaxProduct();
        System.out.print("Max Product of 10 is " + m.maxProduct(10));
    }
}
