package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n <=0) {
            return 0;
        }
        int[] num = new int[10];
        num[0] = 10;
        int sum = 9;
        int temp = 9;
        for (int i = 1; i < num.length; i++) {
            sum *= temp;
            num[i] = sum + num[i - 1];
            temp--;
        }
        if (n>=10) {
            return num[9];
        }
        return num[n-1];
    }

    public static void main(String[] args) {
        LeetCode357 l = new LeetCode357();
        System.out.println(l.countNumbersWithUniqueDigits(9));
    }
}
