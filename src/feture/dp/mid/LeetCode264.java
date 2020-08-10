package feture.dp.mid;

/**
 * @author lanshan
 */
public class LeetCode264 {
    
    public int nthUglyNumber(int n) {
        if (n <= 1)
            return n;
        int[] res = new int[n];
        res[0] = 1;
        int index = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        while (index < n) {
            res[index] = getMin(res[index1] * 2, res[index2] * 3, res[index3] * 5);
            while (res[index1] * 2 <= res[index])
                index1++;
            while (res[index2] * 3 <= res[index])
                index2++;
            while (res[index3] * 5 <= res[index])
                index3++;
            index++;
        }
        return res[n-1];
    }

    int getMin(int k1, int k2, int k3) {
        int temp = Math.min(k1, k2);
        temp = Math.min(temp, k3);
        return temp;
    }

    public static void main(String[] args) {
        LeetCode264 l = new LeetCode264();
        l.nthUglyNumber(1500);
    }
}
