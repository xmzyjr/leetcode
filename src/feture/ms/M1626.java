package feture.ms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lanshan
 */
public class M1626 {

    /**
     * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
     *
     * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     *
     * 示例 1:
     *
     * 输入: "3+2*2"
     * 输出: 7
     * 示例 2:
     *
     * 输入: " 3/2 "
     * 输出: 1
     * 示例 3:
     *
     * 输入: " 3+5 / 2 "
     * 输出: 5
     */
    static Map<Character, Integer> map = new HashMap<>(4);
    static {
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
    }
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        StringBuilder num = new StringBuilder();
        Stack<String> res = new Stack<>();
        Stack<Character> opt = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                num.insert(0, chars[i]);
                continue;
            }
            if (map.containsKey(chars[i])) {
                if (num.length() != 0) {
                    res.add(num.toString());
                    num.delete(0, num.length());
                }
                boolean pushed = false;
                while (!pushed) {
                    if (opt.isEmpty() || map.get(chars[i]) >= map.get(opt.peek())) {
                        opt.push(chars[i]);
                        pushed = true;
                    } else {
                        res.push(opt.pop().toString());
                    }
                }
            }
        }
        if (num.length() != 0) {
            res.push(num.toString());
        }
        if (res.size() == 1) {
            return Integer.parseInt(res.peek());
        }
        while (!opt.isEmpty()) {
            res.push(opt.pop().toString());
        }
        return cal(res);
    }

    private int cal(Stack<String> res) {
        Stack<String> temp = new Stack<>();
        Stack<Integer> tt = new Stack<>();
        while (!res.isEmpty()) {
            temp.add(res.pop());
        }
        while (!temp.isEmpty()) {
            String pop = temp.pop();
            char c = pop.toCharArray()[0];
            if (!map.containsKey(c)) {
                tt.push(Integer.parseInt(pop));
            } else {
                Integer left = tt.pop();
                Integer right = tt.pop();
                if (c == '+') {
                    tt.push(left + right);
                } else if (c == '-') {
                    tt.push(left - right);
                } else if (c == '*') {
                    tt.push(left * right);
                } else {
                    tt.push(left / right);
                }
            }
        }
        return tt.pop();
    }

    public static void main(String[] args) {
        M1626 m = new M1626();
        System.out.println(m.calculate(" 3+5 / 2 "));
        System.out.println(m.calculate("3+2*2"));
        System.out.println(m.calculate(" 3/2 "));
        System.out.println(m.calculate("1-1+1"));
        System.out.println(m.calculate("42"));
    }
}
