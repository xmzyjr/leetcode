package feture.binary.search.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode1237 {
    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        int f(int x, int y);
    }

    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i <= 1000; i++) {
                int left = 1, right = 1000;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int num = customfunction.f(i, mid);
                    if (num == z) {
                        List<Integer> re = new ArrayList<>();
                        re.add(i);
                        re.add(mid);
                        res.add(re);
                        break;
                    } else if (num < z) {
                        left = mid+1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return res;
        }
    }
}
