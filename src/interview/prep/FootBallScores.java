package interview.prep;

/**
 * Created by Adunuthula on 4/28/2014.
 */
public class FootBallScores {
    public static int points[] = {8, 6, 5, 3, 2, 1};
    public static int count = 0;

    public void compute(int[] points, int score, int curScore) {
        for (int i = points.length -1; i >= 0; i--) {
            int newScore = curScore + points[i];
            if (newScore == score) {
                count++;
                return;
            } else if (newScore > score) {
                return;
            } else {
                compute(points, score, newScore);
            }
        }
    }

    public static void main(String[] args) {
        FootBallScores f = new FootBallScores();
        f.compute(points, 15, 0);
        System.out.println("Count " + count);
    }
}
