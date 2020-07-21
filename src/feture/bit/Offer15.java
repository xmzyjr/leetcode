package feture.bit;

/**
 * @author lanshan
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0) {
            n &= (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Offer15 o = new Offer15();
        System.out.println(o.hammingWeight(-3));
    }
}
