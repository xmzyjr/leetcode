package feture.ms;

/**
 * @author lanshan
 */
public class M0503 {
    /**
     * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
     *
     * 示例 1：
     *
     * 输入: num = 1775(11011101111)
     * 输出: 8
     * 示例 2：
     *
     * 输入: num = 7(0111)
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-bits-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reverseBits(int num) {
        if (num == 0)
            return 1;
        String s = Integer.toBinaryString(num);
        int[] bit = new int[32];
        int[] leftBit = new int[32];
        int[] rightBit = new int[32];
        int index = 31, sIndex = s.length()-1;
        while (sIndex>=0) {
            bit[index--] = s.charAt(sIndex--) - '0';
        }
        
        for (int i = 0; i < bit.length; i++) {
            if (i == 0)
                leftBit[i] = bit[i];
            else if (bit[i] == 1)
                leftBit[i] = bit[i] + leftBit[i - 1];
        }

        for (int i = bit.length - 1; i >= 0; i--) {
            if (i == bit.length - 1)
                rightBit[i] = bit[i];
            else if (bit[i] == 1)
                rightBit[i] = bit[i] + rightBit[i + 1];
        }
        int max = -1;
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] == 0) {
                int left = i -1>=0?leftBit[i-1]:0;
                int right = i + 1 < bit.length ? rightBit[i + 1] : 0;
                max = Math.max(max, left + right + 1);
            } else {
                max = Math.max(Math.max(leftBit[i], rightBit[i]), max); 
            }
        }
        return max;
    }

    public static void main(String[] args) {
        M0503 m = new M0503();
        System.out.println(m.reverseBits(2147483647));
        System.out.println(Integer.toBinaryString(2147483647));
    }
}
