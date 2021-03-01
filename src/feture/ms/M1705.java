package feture.ms;

import java.util.*;

/**
 * @author lanshan
 */
public class M1705 {
    /**
     * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
     *
     * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
     *
     * 示例 1:
     *
     * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
     *
     * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
     * 示例 2:
     *
     * 输入: ["A","A"]
     *
     * 输出: []
     * 提示：
     *
     * array.length <= 100000
     */

    Integer length;
    Integer resLeft;
    Integer resRight;
    Set<String> numSet;
    Integer[][] temp;
    public String[] findLongestSubarray(String[] array) {
        if (array == null || array.length == 0) {
            return new String[0];
        }
        length = 0;
        temp = new Integer[array.length + 1][array.length + 1];
        numSet = new HashSet<>();
        for (String s : array) {
            if (check(s)) {
                numSet.add(s);
            }
        }
        find(array, 0, 0, numSet.contains(array[0]) ? -1 : 1);
        if (resLeft == null) {
            return new String[0];
        }
        return Arrays.copyOfRange(array, resLeft, resRight + 1);
    }

    private int find(String[] array, int left, int right, int count) {
        if (right == array.length || left > right)
            return -1;
        if (temp[left][right] != null) {
            return temp[left][right];
        }
        int t = -1;
        int len = right - left + 1;
        if (count == 0 && len >= length) {
            if (length == len) {
                if (left < resLeft) {
                    resLeft = left;
                    resRight = right;
                }
            } else {
                length = len;
                resLeft = left;
                resRight = right;
            }
            t = len;
        }
        int leftL = find(array, left, right + 1, getCount(array, count, right + 1, true));
        int rightL = find(array, left + 1, right, getCount(array, count, left, false));
        temp[left][right] = Math.max(Math.max(leftL, rightL), t);
        return temp[left][right];
    }

    // 非数字 + 1，数字减 1
    private int getCount(String[] array, int count, int index, boolean plus) {
        if (index == array.length)
            return count;
        if (plus) {
            if (numSet.contains(array[index])) {
                return count - 1;
            } else {
                return count + 1;
            }
        } else {
            if (numSet.contains(array[index])) {
                return count + 1;
            } else {
                return count - 1;
            }
        }
    }

    private boolean check(String s) {
        for (char c : s.toCharArray()) {
            if (!(c <= '9' && c >= '0'))
                return false;
        }
        return true;
    }

    public String[] findLongestSubarray2(String[] array) {
        if (array == null || array.length == 0) {
            return new String[0];
        }
        int start = 0;
        int end = 0;
        Map<Integer, Integer> sumIndex = new HashMap<>();
        int preSum = 0;
        sumIndex.put(0, -1);
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            String s = array[i];
            preSum += check(s) ? 1 : -1;
            Integer index = sumIndex.get(preSum);
            if (index == null) {
                sumIndex.put(preSum, i);
            } else {
                if (i - index > end - start) {
                    end = i;
                    start = index;
                }
            }
        }
        return Arrays.copyOfRange(array, start+1, end + 1);
    }

    public static void main(String[] args) {
        M1705 m = new M1705();
//        System.out.println(Arrays.toString(m.findLongestSubarray(new String[] { "A", "1", "B", "C", "D", "2", "3", "4",
//                "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M" })));
        System.out.println(Arrays.toString(m.findLongestSubarray2(new String[] { "42", "10", "O", "t", "y", "p", "g",
                "B", "96", "H", "5", "v", "P", "52", "25", "96", "b", "L", "Y", "z", "d", "52", "3", "v", "71", "J",
                "A", "0", "v", "51", "E", "k", "H", "96", "21", "W", "59", "I", "V", "s", "59", "w", "X", "33", "29",
                "H", "32", "51", "f", "i", "58", "56", "66", "90", "F", "10", "93", "53", "85", "28", "78", "d", "67",
                "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75",
                "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M" })));
    }
}
