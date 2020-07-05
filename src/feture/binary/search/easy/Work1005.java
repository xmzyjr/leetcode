package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class Work1005 {
    class Solution {
        public int findString(String[] words, String s) {
            int left = 0, right = words.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int temp = mid;
                while (words[temp].equals("") && temp > left) {
                    temp--;
                }
                if (words[temp].equals(s)) {
                    return mid;
                }
                if (temp == left) {
                    left = mid + 1;
                    continue;
                }
                if (words[temp].compareTo(s)<0) {
                    left = mid +1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
