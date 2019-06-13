
package l201906;

/**
 * @author lanshan
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int[] num = new int[digits.length + 1];
        int out = 1;
        int i, j;
        for (i = digits.length - 1, j = num.length - 1; i >= 0 && j >= 0; i--, j--) {
            if (digits[i] + out == 10) {
                out = 1;
                num[j] = 0;
            } else {
                num[j] = digits[i] + out;
                out = 0;
            }
        }
        if (out == 1) {
            num[j--] = 1;
        }
        if (j < 0) {
            return num;
        } else {
            System.arraycopy(num, 1, digits, 0, digits.length);
            return digits;
        }

    }

}
