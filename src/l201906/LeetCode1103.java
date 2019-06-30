
package l201906;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode1103 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        List<Boolean> list1 = new LinkedList<>();
        boolean check = true;
        while (label > 0) {
            list.add(0, label);
            list1.add(0,check);
            check = !check;
            label = label >> 1;
        }
        if (list.size() < 3) {
            return list;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (!list1.get(i)) {
                    int mid = ((1 << i) + (1 << (i + 1)) - 1) >> 1;
                    int x = list.get(i);
                    list.set(i, mid - (x - mid) + 1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode1103 l = new LeetCode1103();
        System.out.println(l.pathInZigZagTree(26));
    }
}
