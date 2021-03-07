package feture.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class M1611 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = k; i >= 0; i--) {
            int t = shorter * i + longer * (k - i);
            if (res.isEmpty()) {
                res.add(t);
                continue;
            }
            if (t == res.get(res.size() - 1)) {
                continue;
            }
            res.add(t);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        M1611 m = new M1611();
        System.out.println(Arrays.toString(m.divingBoard(1, 2, 3)));
    }
}
