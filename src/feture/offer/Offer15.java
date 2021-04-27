package feture.offer;

/**
 * @author lanshan
 */
public class Offer15 {
    public int hammingWeight(int n) {
        if (n == 0)
            return 0;
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}
