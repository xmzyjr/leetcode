package feture.game.l0530;

/**
 * @author lanshan
 */
public class Leetcode5772 {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return find(firstWord) + find(secondWord) == find(targetWord);
    }

    private int find(String str) {
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum = sum * 10 + (aChar - 'a');
        }
        return sum;
    }

    public static void main(String[] args) {
        Leetcode5772 l = new Leetcode5772();
        System.out.println(l.isSumEqual("acb", "cba", "cdb"));
        System.out.println(l.isSumEqual("aaa", "a", "aab"));
    }
}
