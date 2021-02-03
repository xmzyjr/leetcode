package feture.ms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lanshan
 */
public class M0808 {
    /**
     *有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
     *
     * 示例1:
     *
     *  输入：S = "qqe"
     *  输出：["eqq","qeq","qqe"]
     * 示例2:
     *
     *  输入：S = "ab"
     *  输出：["ab", "ba"]
     * 提示:
     *
     * 字符都是英文字母。
     * 字符串长度在[1, 9]之间。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        Set<String> res = new HashSet<>();
        find(chars, res, 0);
        return res.toArray(new String[0]);
    }

    private void find(char[] target, Set<String> res, int index) {
        if (index == target.length) {
            res.add(String.valueOf(target));
            return;
        }
        for (int i = 0; i < target.length; i++) {
            if (target[i] != target[index] || i == index) {
                swap(target, index, i);
                find(target, res, index + 1);
                swap(target, index, i);
            }
        }
    }

    private void swap(char[] target, int i, int j) {
        char temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }

    public static void main(String[] args) {
        M0808 m = new M0808();
        System.out.println(Arrays.toString(m.permutation("qqe")));
        System.out.println(Arrays.toString(m.permutation("ab")));
        System.out.println(Arrays.toString(m.permutation("abcd")));
    }
}
