package l201907;

/**
 * @author lanshan
 */
public class LeetCode5139 {
    public int tribonacci(int n) {

        int[] num = new int[38];
        num[0] = 0;
        num[1] = 1;
        num[2] = 1;
        for (int i = 3; i < num.length; i++) {
            num[i] = num[i-1]+num[i-2]+num[i-3];
        }
        return num[n];
    }
}
