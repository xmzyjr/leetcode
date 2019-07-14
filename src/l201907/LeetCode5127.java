
package l201907;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lanshan
 */
public class LeetCode5127 {

    /**
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] num = new int[1001];
        Set<Integer> num2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        for (int i : arr1) {
            num[i]++;
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (num[arr2[i]] != 0) {
                while (num[arr2[i]] != 0) {
                    result[index++] = arr2[i];
                    num[arr2[i]]--;
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                while (num[i] != 0) {
                    result[index++] = i;
                    num[i]--;
                }
            }
        }
        return result;
    }
}
