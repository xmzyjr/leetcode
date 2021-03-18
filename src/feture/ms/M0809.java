package feture.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class M0809 {
    /**
     * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     */
    List<String> res;
    public List<String> generateParenthesis(int n) {
        if (n <= 0)
            return new ArrayList<>();
        res = new ArrayList<>();
        find(n, n, new StringBuilder());
        return res;
    }
    
    private void find(int left, int right, StringBuilder sb) {
        if (left < 0 || right < 0 || left > right)
            return;
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        find(left - 1, right, sb.append('('));
        sb.delete(sb.length() - 1, sb.length());
        find(left, right - 1, sb.append(')'));
        sb.delete(sb.length() - 1, sb.length());
    }

    public static void main(String[] args) {
        M0809 m = new M0809();
        System.out.println(m.generateParenthesis(3));
        System.out.println(m.generateParenthesis(4));
    }
}
