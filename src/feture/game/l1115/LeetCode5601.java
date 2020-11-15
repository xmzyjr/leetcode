package feture.game.l1115;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode5601 {
    private final String[] res;

    private int index;
    public LeetCode5601(int n) {
        res = new String[n + 1];
        index = 1;
    }

    public List<String> insert(int id, String value) {
        res[id] = value;
        List<String> result = new ArrayList<>();
        if (id != index) {
            return result;
        }
        int i;
        for (i = index; i < res.length; i++) {
            if (res[i] == null) {
                break;
            }
            result.add(res[i]);
        }
        index = i;
        return result;
    }
}
