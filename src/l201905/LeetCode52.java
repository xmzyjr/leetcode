package l201905;

/**
 * @author lanshan
 */
public class LeetCode52 {
    static int count = 0;
    public int totalNQueens(int n) {
        count = 0;
        int[][] nums = new int[n][n];
        doSolve(nums, 0);
        return count;
    }

    public void doSolve(int[][] nums, int index) {
        if (index == nums.length) {
            count++;
            return;
        }
        for (int i = 0; i < nums[index].length; i++) {
            if (check(nums, index, i)) {
                nums[index][i] = 1;
                doSolve(nums, index + 1);
                nums[index][i] = 0;
            }
        }
    }

    public boolean check(int[][] nums, int i, int j) {
        int len = nums[i].length;
        // check x
        for (int k = 0; k < len; k++) {
            if (nums[i][k] == 1) {
                return false;
            }
        }
        // check y
        for (int k = 0; k < len; k++) {
            if (nums[k][j] == 1) {
                return false;
            }
        }
        // check -x -y
        for (int x = i, y = j; x >= 0 && y >= 0; --x, --y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        // check +x +y
        for (int x = i, y = j; x < len && y < len; ++x, ++y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        // check +x -y
        for (int x = i, y = j; x < len && y >= 0; ++x, --y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        // check -x +y
        for (int x = i, y = j; x >= 0 && y < len; --x, ++y) {
            if (nums[x][y] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode52 l = new LeetCode52();
        System.out.println(l.totalNQueens(4));
    }
}
