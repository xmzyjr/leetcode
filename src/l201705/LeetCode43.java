
package l201705;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars = num1.toCharArray();
        char[] chars1 = num2.toCharArray();
        int[] num11 = change(chars);
        int[] num22 = change(chars1);
        int[] ints = mulD(num11, num22);
        return print(ints);
    }

    public static int[] change(char[] chars) {
        int[] num = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            num[i] = chars[i] - '0';
        }
        return num;
    }

    public static String print(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int anInt : ints) {
            sb.append(anInt);
        }
        return sb.toString();
    }

    /**
     * 大数加法
     */
    static int[] add(int[] num1, int[] num2) {
        List<Integer> re = new ArrayList<>();
        int index1 = num1.length - 1;
        int index2 = num2.length - 1;
        int y = 0;
        while (index1 >= 0 && index2 >= 0) {
            int sum = num1[index1--] + num2[index2--] + y;
            re.add(0, sum % 10);
            y = sum >= 10 ? 1 : 0;
        }
        while (index1 >= 0) {
            int sum = num1[index1--] + y;
            re.add(0, sum % 10);
            y = sum >= 10 ? 1 : 0;
        }
        while (index2 >= 0) {
            int sum = num2[index2--] + y;
            re.add(0, sum % 10);
            y = sum >= 10 ? 1 : 0;
        }
        if (y != 0) {
            re.add(0, y);
        }
        return re.stream().mapToInt(Integer::intValue).toArray();
    }

    static List<Integer> mul(int[] num1, int num2) {
        List<Integer> result = new ArrayList<>();
        int index1 = num1.length - 1;
        int out = 0;
        while (index1 >= 0) {
            int sum = num2 * num1[index1--] + out;
            result.add(0, sum % 10);
            out = sum >= 10 ? sum / 10 : 0;
        }
        if (out != 0) {
            result.add(0, out);
        }
        return result;
    }

    static int[] mulD(int[] num1, int[] num2) {
        int[] re = { 0 };
        int index2 = num2.length - 1;
        while (index2 >= 0) {
            List<Integer> mul = mul(num1, num2[index2]);
            int[] ints = addZero(mul, num2.length - index2 - 1);
            re = add(ints, re);
            index2--;
        }
        return re;
    }

    static int[] addZero(List<Integer> num, int count) {
        while (count-- > 0) {
            num.add(0);
        }
        return num.stream().mapToInt(Integer::intValue).toArray();
    }
}
