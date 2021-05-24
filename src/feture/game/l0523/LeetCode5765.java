package feture.game.l0523;

/**
 * @author lanshan
 */
public class LeetCode5765 {
    
    int min;
    int max;
    Boolean[] map;
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chars = s.toCharArray();
        if (chars[chars.length-1] == '1')
            return false;
        min = minJump;
        max = maxJump;
        map = new Boolean[chars.length + 1];
        return find(chars, 0);
    }
    
    private boolean find(char[] chars, int index) {
        if (index == chars.length - 1) {
            return true;
        }
        if (map[index] != null) {
            return map[index];
        }
        int minIndex = index + min;
        int maxIndex = Math.min(index + max, chars.length - 1);
        if (minIndex <= chars.length-1 && maxIndex >= chars.length - 1) {
            return true;
        }
        boolean res = false;
        for (int i = maxIndex; i >= minIndex; i--) {
            if (chars[i] == '0') {
                res = find(chars, i);
                if (res)
                    break;
            }
        }
        map[index] = res;
        return res;
    }

    /**
     * "01101110"
     * 2
     * 3
     *
     * "00111010"
     * 3
     * 5
     */
    public static void main(String[] args) {
        LeetCode5765 l = new LeetCode5765();
        System.out.println(l.canReach("00111010", 3, 5));
    }
}
