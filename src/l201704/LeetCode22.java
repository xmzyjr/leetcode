
package l201704;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        get(n - 1, n, "(", list);
        return list;
    }

    public void get(int index1, int index2, String str, List<String> list) {
        if (index1 < 0 || index2 < 0 || index1 > index2) {
            return;
        }
        if (index1 == 0 && index2 == 0) {
            list.add(str);
            return;
        }
        get(index1 - 1, index2, str + "(", list);
        get(index1, index2 - 1, str + ")", list);
    }

    public static void main(String[] args) {

    }
}
