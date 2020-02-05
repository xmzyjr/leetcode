package l202002;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if ((wordList == null || wordList.size() == 0)) {
            return 0;
        }
        int endWordIndex = wordList.lastIndexOf(endWord);
        if (endWordIndex == -1) {
            return 0;
        }
        int mapSize = wordList.size();
        int[][] map = new int[mapSize + 1][mapSize + 1];
        boolean firstLine = buildMapFirstLineData(map, beginWord, wordList);
        if (!firstLine) {
            return 0;
        }
        buildMapOtherLineData(map, wordList, beginWord);
        printMap(map);
        findShortestWay(map);
        printMap(map);
        return map[0][endWordIndex + 1];
    }

    void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.printf("%11d ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 两个字符串只相差一个字符
     */
    boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!result) {
                    result = true;
                } else {
                    return false;
                }
            }
        }
        return result;
    }

    boolean buildMapFirstLineData(int[][] map, String beginWord, List<String> wordList) {
        boolean result = false;
        map[0][0] = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            if (check(beginWord, wordList.get(i))) {
                map[0][i + 1] = 1;
                map[i + 1][0] = 1;
                result = true;
            } else {
                map[0][i + 1] = Integer.MAX_VALUE;
                map[i + 1][0] = Integer.MAX_VALUE;
            }
        }
        return result;
    }

    void buildMapOtherLineData(int[][] map, List<String> wordList, String beginWord) {
        List<String> temp = new ArrayList<>(wordList);
        temp.add(0, beginWord);
        for (int i = 1; i < temp.size(); i++) {
            for (int j = 0; j < temp.size(); j++) {
                if (i == j) {
                    map[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (map[i][j] == 0) {
                    if (check(temp.get(i), temp.get(j))) {
                        map[i][j] = 1;
                        map[j][i] = 1;
                    } else {
                        map[i][j] = Integer.MAX_VALUE;
                        map[j][i] = Integer.MAX_VALUE;
                    }
                }
            }
        }
    }

    void findShortestWay(int[][] map) {
        Queue<Integer> ready = new ArrayDeque<>();
        Set<Integer> done = new HashSet<>();
        int targetIndex = 0;
        done.add(targetIndex);
        for (int i = 0; i < map.length; i++) {
            if (map[0][i] != Integer.MAX_VALUE) {
                ready.add(i);
            }
        }
        while (!ready.isEmpty()) {
            Integer target = ready.poll();
            while (done.contains(target) && !ready.isEmpty()) {
                target = ready.poll();
            }
            if (done.contains(target)) {
                break;
            }
            for (int i = 0; i < map.length; i++) {
                if (done.contains(i) || map[target][i] == Integer.MAX_VALUE) {
                    continue;
                }
                ready.add(i);
                if (map[targetIndex][target] + map[target][i] < map[targetIndex][i]) {
                    map[targetIndex][i] = map[targetIndex][target] + map[target][i];
                    printMap(map);
                }
            }
            done.add(target);
        }
    }

    /**
     * "hit"
     * "cog"
     * ["hot","dot","dog","lot","log","cog"]
     */
    public static void main(String[] args) {
        LeetCode127 l = new LeetCode127();
        l.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

}
