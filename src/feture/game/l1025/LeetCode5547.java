package feture.game.l1025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode5547 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            if (l[i] > r[i]) {
                res.add(false);
                continue;
            }
            int length = r[i] - l[i] + 1;
            int[] num = new int[length];
            for (int j = l[i], k = 0; j <= r[i]; j++,k++) {
                num[k] = nums[j];
            }
            Arrays.sort(num);
            res.add(check(num));
        }
        return res;
    }
    
    private boolean check(int[] num) {
        int temp = num[1] - num[0];
        for (int i = 2; i < num.length; i++) {
            int temp1 = num[i] - num[i - 1];
            if (temp1 != temp)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode5547 l = new LeetCode5547();
        System.out.println(l.checkArithmeticSubarrays(new int[] {4, 6, 5, 9, 3, 7}, new int[] {0, 0, 2}, new int[] {2, 3, 5}));
    }
}
