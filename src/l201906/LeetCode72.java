
package l201906;

/**
 * @author lanshan
 */
public class LeetCode72 {

    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * 示例 1:
     * 输入: word1 = "horse", word2 = "ros"
     * 输出: 3
     * 解释:
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2:
     * 输入: word1 = "intention", word2 = "execution"
     * 输出: 5
     * 解释:
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     */
    public int minDistance(String word1, String word2) {
        char[] chars = word1.toCharArray();
        char[] chars1 = word2.toCharArray();
        int xLen = chars.length;
        int yLen = chars1.length;
        int[][] num = new int[xLen + 1][yLen + 1];
        for (int i = 0; i <= yLen; i++) {
            num[0][i] = i;
        }
        for (int i = 0; i <= xLen; i++) {
            num[i][0] = i;
        }
        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                num[i][j] = Math.min(Math.min(num[i - 1][j] + 1, num[i][j - 1] + 1),
                        num[i - 1][j - 1] + (chars[i - 1] == chars1[j - 1] ? 0 : 1));
            }
        }
        return num[xLen][yLen];

        //        return get(word1.toCharArray(), word2.toCharArray(), word1.length() - 1, word2.length() - 1);
    }

    public int get(char[] word1, char[] word2, int index1, int index2) {
        if (index1 < 0 && index2 < 0) {
            return 0;
        }
        if (index1 < 0) {
            return index2 + 1;
        }
        if (index2 < 0) {
            return index1 + 1;
        }
        int x = get(word1, word2, index1 - 1, index2) + 1;
        int y = get(word1, word2, index1, index2 - 1) + 1;
        int z = get(word1, word2, index1 - 1, index2 - 1) + (word1[index1] == word2[index2] ? 0 : 1);
        return Math.min(Math.min(x, y), z);

    }

    public static void main(String[] args) {
        LeetCode72 l = new LeetCode72();
        System.out.println(l.minDistance("123", "321"));
    }

}
