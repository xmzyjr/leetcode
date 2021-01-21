package feture.ms;

/**
 * @author lanshan
 */
public class M1003 {

    /**
     * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
     * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
     *
     * 示例1:
     *
     *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
     *  输出: 8（元素5在该数组中的索引）
     * 示例2:
     *
     *  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
     *  输出：-1 （没有找到）
     * 提示:
     *
     * arr 长度范围在[1, 1000000]之间
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * 1 2 2 2 2 
     * 2 1 2 2 2
     * 2 2 1 2 2
     * 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14    target = 5
     * 1, 2, 3, 4, 5, 6, 7
     */
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return -1;
        int left = 0, right = arr.length - 1;
        Integer resIndex= null;
        while (left <= right) {
            if (arr[left] == target)
                return left;
            if (arr[right] == target) {
                resIndex = right;
            }
            int mid = left + (right - left) / 2;
            // normal
            if (arr[left] >= arr[right]) {
                if (target > arr[left] && arr[mid] < arr[left]) {
                    right = mid - 1;
                    continue;
                } else if (target < arr[right] && arr[mid] > arr[right]) {
                    left = mid + 1;
                    continue;
                }
            }
            if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
            else {
                right = mid;
                resIndex = mid;
            }
        }
        return resIndex == null ? -1 : resIndex;
    }

    /**
     * [18, 19, 22, 30, 31, 38, 38, 40, 43, 43, 45, 45, 46, 46, 48, 53, 56, 58, 62, 62, 62, 65, 71, 75, 77, 78, 81, -81, -75, -74, -74, -72, -70, -69, -69, -67, -60, -59, -56, -55, -54, -52, -52, -51, -51, -44, -41, -41, -39, -38, -34, -32, -32, -31, -31, -27, -26, -24, -24, -23, -22, -20, -18, -18, -18, -17, -16, -14, -11, -9, -8, -6, -5, -3, -1, 4, 10, 11, 11, 15, 16]
     * 53
     */
    public static void main(String[] args) {
        M1003 m = new M1003();
        System.out.println(m.search(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
        System.out.println(m.search(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 11));
        System.out.println(m.search(new int[] {1,2,2,2,2}, 1));
        System.out.println(m.search(new int[] {1,2,2,2,2}, 2));
        System.out.println(m.search(new int[] {2, 1, 2, 2, 2}, 1));
        System.out.println(m.search(new int[] {2, 1, 2, 2, 2}, 2));
        System.out.println(m.search(new int[] {2, 2, 1, 2, 2}, 1));
        System.out.println(m.search(new int[] {2, 2, 1, 2, 2}, 2));

        System.out.println(m.search(new int[] {1,2,3,4,5,6}, 7));


        System.out.println(m.search(new int[] { 18, 19, 22, 30, 31, 38, 38, 40, 43, 43, 45, 45, 46, 46, 48, 53, 56, 58,
                62, 62, 62, 65, 71, 75, 77, 78, 81, -81, -75, -74, -74, -72, -70, -69, -69, -67, -60, -59, -56, -55,
                -54, -52, -52, -51, -51, -44, -41, -41, -39, -38, -34, -32, -32, -31, -31, -27, -26, -24, -24, -23, -22,
                -20, -18, -18, -18, -17, -16, -14, -11, -9, -8, -6, -5, -3, -1, 4, 10, 11, 11, 15, 16 }, 53));

    }
}
