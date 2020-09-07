package feture.game.l0906;

/**
 * @author lanshan
 */
public class LeetCode5507 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                find(chars, i);
            }
        }
        return String.valueOf(chars);
    }
    
    private void find(char[] chars, int index) {
        if (index == 0)
            chars[index] = 'a';
        else 
            chars[index] = chars[index - 1];
        if (index - 1>=0 && chars[index-1] == chars[index]) {
            chars[index] = (char) (((chars[index] + 1) % 'a') + 'a');
        }
        if (index + 1 < chars.length && chars[index] == chars[index + 1]) {
            chars[index] = (char) (((chars[index] + 1) % 'a') + 'a');
        }
    }

    public static void main(String[] args) {
        LeetCode5507 l = new LeetCode5507();
        System.out.println(l.modifyString("ubv?w"));
        System.out.println(l.modifyString("?zs"));
        System.out.println(l.modifyString("j?qg??b"));
        System.out.println(l.modifyString("??yw?ipkj?"));
    }
}
