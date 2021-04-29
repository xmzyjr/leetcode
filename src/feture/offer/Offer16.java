package feture.offer;

/**
 * @author lanshan
 */
public class Offer16 {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / (x * find(x, -n - 1));
        }
        return find(x, n);
    }

    public double find(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return find(x * x, n >> 1);
        } else {
            return find(x, n - 1) * x;
        }
    }

    /**
     * 1.00000
     * -2147483648
     */
    public static void main(String[] args) {
        Offer16 o = new Offer16();
        System.out.println(o.myPow(2, 10));
        System.out.println(o.myPow(2.1, 3));
        System.out.println(o.myPow(2, -2));
        System.out.println(o.myPow(1, -2147483648));
    }
}
