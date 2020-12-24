package feture.ms;

import java.util.*;

/**
 * @author lanshan
 */
public class M1725 {
    /**
     * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。
     * 不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
     *
     * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
     *
     * 示例 1:
     *
     * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
     * 输出:
     * [
     *    "this",
     *    "real",
     *    "hard"
     * ]
     * 示例 2:
     *
     * 输入: ["aa"]
     * 输出: ["aa","aa"]
     * 说明：
     *
     * words.length <= 1000
     * words[i].length <= 100
     * 数据保证单词足够随机
     *
     */
    class TreeNode {
        TreeNode[] child = new TreeNode[26];
        boolean isLeaf;
    }

    TreeNode root;
    Map<Integer, Set<String>> map;
    List<String> res;
    int maxArea;
    public String[] maxRectangle(String[] words) {
        if (words == null || words.length == 0)
            return new String[0];
        buildTrie(words);
        buildLengthMap(words);
        res = new ArrayList<>();
        maxArea = 0;
        List<String> path = new ArrayList<>();
        for (Integer key : map.keySet()) {
            path.clear();
            dfs(map.get(key), path, key);
        }
        return res.toArray(new String[0]);
    }

    private void dfs(Set<String> words, List<String> path, Integer key) {
        if (words.size() * key <= maxArea)
            return;
        if (path.size() > key)
            return;
        for (String word : words) {
            path.add(word);
            int valid = isValid(path, key);
            if (valid != 0) {
                if (valid == 1) {
                    int area = key * path.size();
                    if (area > maxArea) {
                        maxArea = area;
                        res = new ArrayList<>(path);
                    }
                }
                dfs(words, path, key);
            }
            path.remove(path.size() - 1);
        }
    }

    private int isValid(List<String> path, Integer keyLength) {
        int result = 0;
        for (int i = 0; i < keyLength; i++) {
            TreeNode temp = root;
            for (int j = 0; j < path.size(); j++) {
                int index = path.get(j).charAt(i) - 'a';
                if (temp.child[index] == null) {
                    return 0;
                }
                temp = temp.child[index];
            }
            if (!temp.isLeaf)
                result = 2;
        }
        return result == 2 ? 2 : 1;
    }
    
    private void buildLengthMap(String[] words) {
        map = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            Set<String> wordSet = map.getOrDefault(length, new HashSet<>());
            wordSet.add(word);
            map.put(length, wordSet);
        }
    }

    private void buildTrie(String[] words) {
        root = new TreeNode();
        for (String word : words) {
            char[] chars = word.toCharArray();
            TreeNode temp = root;
            for (char aChar : chars) {
                if (temp.child[aChar - 'a'] == null)
                    temp.child[aChar - 'a'] = new TreeNode();
                temp = temp.child[aChar - 'a'];
            }
            temp.isLeaf = true;
        }
    }

    public static void main(String[] args) {
        M1725 m = new M1725();
        System.out.println(Arrays.toString(m.maxRectangle(new String[] {"this", "real", "hard", "trh", "hea", "iar", "sld"})));
    }
}
