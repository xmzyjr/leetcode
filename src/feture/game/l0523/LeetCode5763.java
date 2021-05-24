package feture.game.l0523;

/**
 * @author lanshan
 */
public class LeetCode5763 {

    public boolean checkZeroOnes(String s) {
        int oneCount = 0;
        int zeroCount = 0;
        int maxOne = 0;
        int maxZero = 0;
        char[] chars = s.toCharArray();
        Character c = null;
        for (char aChar : chars) {
            if (c == null) {
                c = aChar;
            } else if (aChar != c) {
                maxOne = Math.max(oneCount, maxOne);
                maxZero = Math.max(maxZero, zeroCount);
                oneCount = 0;
                zeroCount = 0;
            }
            if (aChar == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }
            c = aChar;
        }
        maxOne = Math.max(oneCount, maxOne);
        maxZero = Math.max(maxZero, zeroCount);
        return maxOne > maxZero;
    }

    public static void main(String[] args) {
        LeetCode5763 l = new LeetCode5763();
        System.out.println(l.checkZeroOnes("1101"));
        System.out.println(l.checkZeroOnes("111000"));
        System.out.println(l.checkZeroOnes("110100010"));
    }

}
