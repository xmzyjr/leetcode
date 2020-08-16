package feture.dp.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class LeetCode1105 {

    Map<String, Integer> map;
    public int minHeightShelves(int[][] books, int shelf_width) {
        if (books == null || books.length == 0)
            return 0;
        if (books.length == 1)
            return books[0][1];
        map = new HashMap<>();
        return find(books, shelf_width, 0, shelf_width, 0);
    }

    /**
     * @param curWidth 当前剩余宽度
     */
    private int find(int[][] books, int maxWidth, int index, int curWidth, int curMaxHeight) {
        String key = index + "_" + curWidth + "_" + curMaxHeight;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (index == books.length) {
            map.put(key, curMaxHeight);
            return curMaxHeight;
        }
        if (books[index][0] > curWidth) {
            int value = find(books, maxWidth, index, maxWidth, 0) + curMaxHeight;
            map.put(key, value);
            return value;
        }
        if (curWidth == maxWidth) {
            int value = find(books, maxWidth, index + 1, curWidth - books[index][0],
                    Math.max(curMaxHeight, books[index][1]));
            map.put(key, value);
            return value;
        }
        int value = Math.min(
                find(books, maxWidth, index + 1, curWidth - books[index][0],
                        Math.max(curMaxHeight, books[index][1])),
                find(books, maxWidth, index, maxWidth, 0) + curMaxHeight);
        map.put(key, value);
        return value;
    }

    public static void main(String[] args) {
        LeetCode1105 l = new LeetCode1105();
        System.out.println(l.minHeightShelves(new int[][] {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4));
    }
}
