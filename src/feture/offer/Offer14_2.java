package feture.offer;

/**
 * @author lanshan
 */
public class Offer14_2 {

    private static final int mod = 1000000007;
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1; 
        }
        long res = 1;
        while (n > 4) {
            res = (res * 3) % mod;
            n -= 3;
        }
        res = (res * n) % mod;
        return (int) res;
    }

    public static void main(String[] args) {
        Offer14_2 o = new Offer14_2();
        System.out.println(o.cuttingRope(10));
    }
}
