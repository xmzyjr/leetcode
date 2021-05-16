package feture.offer;

/**
 * @author lanshan
 */
public class Offer66 {

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     *
     *  
     *
     * 示例:
     *
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]

     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] temp = new int[a.length];
        for (int i = temp.length - 1; i >= 0; i--) {
            if (i == temp.length - 1) {
                temp[i] = 1;
            } else {
                temp[i] = a[i + 1] * temp[i + 1];
            }
        }
        int left = a[0];
        for (int i = 1; i < temp.length; i++) {
            temp[i] = left * temp[i];
            left *= a[i];
        }
        return temp;
    }
}
