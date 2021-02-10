package feture.ms;

import java.util.*;

/**
 * @author lanshan
 */
public class M1717 {
    /**
     * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，
     * 根据smalls中的每一个较短字符串，对big进行搜索。
     * 输出smalls中的字符串在big里出现的所有位置positions，
     * 其中positions[i]为smalls[i]出现的所有位置。
     *
     * 示例：
     *
     * 输入：
     * big = "mississippi"
     * smalls = ["is","ppi","hi","sis","i","ssippi"]
     * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
     * 提示：
     *
     * 0 <= len(big) <= 1000
     * 0 <= len(smalls[i]) <= 1000
     * smalls的总字符数不会超过 100000。
     * 你可以认为smalls中没有重复字符串。
     * 所有出现的字符均为英文小写字母。
     */
    public static class Node{
        Node[] child = new Node[26];
        boolean isEnd;
        Map<Integer, String> wordList;
    }
    public int[][] multiSearch(String big, String[] smalls) {
        if (smalls == null || smalls.length == 0)
            return new int[0][0];
        if (big == null || big.length() == 0)
            return new int[smalls.length][0];
        Node head = new Node();
        buildTree(smalls, head);
        Map<String, List<Integer>> res = new HashMap<>(smalls.length);
        char[] bigList = big.toCharArray();
        for (int i = 0; i < bigList.length; i++) {
            Node temp = head;
            for (int j = i; j < bigList.length; j++) {
                int index = bigList[j] - 'a';
                if (temp.child[index] == null)
                    break;
                if (temp.child[index].isEnd) {
                    String target = temp.child[index].wordList.get(j - i + 1);
                    res.computeIfAbsent(target, k -> new ArrayList<>()).add(i);
                }
                temp = temp.child[index];
            }
        }
        int[][] re = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> num = res.get(smalls[i]);
            re[i] = num == null ? new int[0] : num.stream().mapToInt(Integer::intValue).toArray();
        }
        return re;
    }



    private void buildTree(String[] smalls, Node head) {
        for (String small : smalls) {
            char[] chars = small.toCharArray();
            Node temp = head;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (temp.child[index] == null) {
                    Node t = new Node();
                    temp.child[index] = t;
                    temp = t;
                } else {
                    temp = temp.child[index];
                }
                if (i == chars.length - 1) {
                    temp.isEnd = true;
                    Map<Integer, String> map = temp.wordList == null ? new HashMap<>() : temp.wordList;
                    map.put(chars.length, small);
                    temp.wordList = map;
                }
            }
        }
    }

    public static void main(String[] args) {
        M1717 m = new M1717();
        System.out.println(Arrays.deepToString(m.multiSearch("mississippi", new String[] {"is", "ppi", "hi", "sis", "i", "ssippi"})));
    }
}
