package feture.binary.search.easy;

/**
 * @author lanshan
 */
public class LeetCode278 {
   /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    
    public abstract class VersionControl {
        abstract boolean isBadVersion(int version);
    }

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n;
            while (left<=right) {
                int mid = left+(right-left)/2;
                if (isBadVersion(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        @Override
        boolean isBadVersion(int version) {
            return false;
        }
    } 
}
