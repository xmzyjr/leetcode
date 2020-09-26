
package feture.greedy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode763 {

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0)
            return new ArrayList<>();
        int[] index = new int[S.length()];
        for (int i = 1; i < S.length(); i++) {
            int j = 0;
            for (; j < i; j++) {
                if (S.charAt(i) == S.charAt(j))
                    break;
            }
            if (j != i) {
                int num = index[j];
                for (int k = j; k <= i; k++) {
                    index[k] = num;
                }
            } else {
                index[i] = index[i - 1] + 1;
            }
        }
        int pre = 0;
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for (int j : index) {
            if (j == pre) {
                count++;
            } else {
                pre = j;
                res.add(count);
                count = 1;
            }
        }
        if (count != 0)
            res.add(count);
        return res;
    }

    public static void main(String[] args) {
        LeetCode763 l = new LeetCode763();
        System.out.println(l.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
