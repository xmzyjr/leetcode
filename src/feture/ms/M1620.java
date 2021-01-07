
package feture.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class M1620 {

    int[] numIndex = new int[] { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };

    public List<String> getValidT9Words(String num, String[] words) {
        if (num == null || num.length() == 0 || words == null || words.length == 0)
            return new ArrayList<>();
        char[] numChar = num.toCharArray();
        int[] numInt = new int[numChar.length];
        for (int i = 0; i < numChar.length; i++) {
            numInt[i] = numChar[i] - '0';
        }
        List<String> res = new ArrayList<>(words.length);
        for (String word : words) {
            char[] chars = word.toCharArray();
            int i;
            for (i = 0; i < chars.length; i++) {
                if (numInt[i] != numIndex[chars[i] - 'a'])
                    break;
            }
            if (i == chars.length)
                res.add(word);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println('2'-'0');
    }
}
