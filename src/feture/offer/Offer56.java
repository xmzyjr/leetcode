package feture.offer;

/**
 * @author lanshan
 */
public class Offer56 {

    public int[] singleNumbers(int[] nums) {
        int t = 0;
        for (int num : nums) {
            t ^= num;
        }
        int i = 1;
        while ((t & i) == 0) {
            i = i << 1;
        }
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & i) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}
