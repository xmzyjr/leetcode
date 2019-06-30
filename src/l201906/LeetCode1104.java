
package l201906;

import java.util.Arrays;

/**
 * @author lanshan
 *         60
 *         4
 *         [15,18,15,12]
 */
public class LeetCode1104 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] num = new int[num_people];
        int sum = 0;
        for (int i = 1, index = 0; sum < candies; i++) {
            int index1 = (index++) % num_people;
            num[index1] += i;
            sum += i;
            if (sum > candies) {
                sum -= i;
                num[index1] -= i;
                num[index1] += (candies - sum);
                sum = candies;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode1104 l = new LeetCode1104();
        System.out.println(Arrays.toString(l.distributeCandies(60, 4)));
    }
}
