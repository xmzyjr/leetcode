
package feture.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanshan
 */
public class M1722 {

    boolean finish;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null
                || wordList.size() == 0 || beginWord.length() != endWord.length())
            return new ArrayList<>();
        if (!wordList.contains(endWord))
            return new ArrayList<>();
        //
        List<String> newWordList = buildNewWordList(wordList, beginWord);
        //
        int size = newWordList.size();
        int[][] graph = new int[size][size];
        buildGraph(graph, newWordList);

        int start = findIndex(newWordList, beginWord);
        int end = findIndex(newWordList, endWord);
        int[] visited = new int[size];
        finish = false;
        List<Integer> result = new ArrayList<>(size);
        dfs(graph, visited, end, result, start);
        List<String> res = new ArrayList<>(result.size());
        for (Integer num : result) {
            res.add(newWordList.get(num));
        }
        return res;
    }
    
    private void dfs(int[][] graph, int[] visited, int target, List<Integer> result, int index) {
        if (finish)
            return;
        if (index == target) {
            finish = true;
            result.add(target);
            return;
        }
        visited[index] = 1;
        result.add(index);
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 0 || visited[i] == 1)
                continue;
            dfs(graph, visited, target, result, i);
            if (finish)
                return;
        }

        result.remove(result.size()-1);
    }

    private int findIndex(List<String> wordList, String s) {
        for (int i = 0; i < wordList.size(); i++) {
            if (s.equals(wordList.get(i)))
                return i;
        }
        return 0;
    }

    private List<String> buildNewWordList(List<String> wordList, String beginWord) {
        int length = beginWord.length();
        boolean beginSame = false;
        List<String> newWordList = new ArrayList<>(wordList.size());
        for (String s : wordList) {
            if (s.length() == length) {
                newWordList.add(s);
                if (s.equals(beginWord))
                    beginSame = true;
            }
        }
        if (!beginSame) {
            newWordList.add(0, beginWord);
        }
        return newWordList;
    }
    
    private void buildGraph(int[][] graph, List<String> newWordList) {
        for (int i = 0; i < newWordList.size(); i++) {
            for (int j = i; j < newWordList.size(); j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                String s1 = newWordList.get(i);
                String s2 = newWordList.get(j);
                boolean check = diffOneChar(s1, s2);
                graph[i][j] = graph[j][i] = check ? 1 : 0;
            }
        }
    }

    private boolean diffOneChar(String first, String second) {
        int length = first.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (first.charAt(i) != second.charAt(i))
                count++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        M1722 m = new M1722();
        System.out.println(m.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
