package feture.game.l1122;

/**
 * @author lanshan
 */
public class LeetCode5605 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = getWords(word1);
        String s2 = getWords(word2);
        return s1.equals(s2);
    }

    private String getWords(String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode5605 l = new LeetCode5605();
        System.out.println(l.arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "bc"}));
        System.out.println(l.arrayStringsAreEqual(new String[] {"a", "cb"}, new String[] {"a", "bc"}));
        System.out.println(l.arrayStringsAreEqual(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}));
    }
}
