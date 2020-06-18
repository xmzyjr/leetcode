package l202003;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode126 {

    public static List<String> temp;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        temp = new ArrayList<>();
        if ((wordList == null || wordList.size() == 0)) {
            return new ArrayList<>();
        }
        int endWordIndex = wordList.lastIndexOf(endWord);
        if (endWordIndex == -1) {
            return new ArrayList<>();
        }
        int mapSize = wordList.size();
        int[][] map = new int[mapSize + 1][mapSize + 1];
        boolean firstLine = buildMapFirstLineData(map, beginWord, wordList);
        if (!firstLine) {
            return new ArrayList<>();
        }
        buildMapOtherLineData(map, wordList, beginWord);
//        printMap(map);
        List<List<String>> result = new ArrayList<>();
        List<String> newWordList = new ArrayList<>(wordList);
        newWordList.add(0, beginWord);
        findAllPath(map, "", new HashSet<>(), 0, endWordIndex, newWordList);
        if (temp.size() != 0) {
            for (String indexMember : temp) {
                String[] split = indexMember.split(",");
                List<String> path = new ArrayList<>();
                for (String s : split) {
                    if ("".equals(s))
                        continue;
                    int index = Integer.parseInt(s);
                    path.add(wordList.get(index - 1));
                }
                path.add(0, beginWord);
                result.add(path);
            }
        }
        return result;
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
    
    void findAllPath(int[][] map, String indexMember, Set<String> read,
                     int nowIndex, int endWordIndex, List<String> newWordList) {
        if (nowIndex != endWordIndex + 1) {
            read.add(newWordList.get(nowIndex));
        } else {
            if (temp.size() == 0) {
                temp.add(indexMember);
            } else {
                int length1 = indexMember.split(",").length;
                int length2 = temp.get(0).split(",").length;
                if (length1 < length2) {
                    temp = new ArrayList<>();
                    temp.add(indexMember);
                } else if (length1 == length2) {
                    temp.add(indexMember);
                }
            }
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[nowIndex][i] != Integer.MAX_VALUE) {
                if (read.contains(newWordList.get(i))) {
                    continue;
                }
                findAllPath(map, indexMember +","+ i, read, i, endWordIndex, newWordList);

            }
        }
        read.remove(newWordList.get(nowIndex));
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

    /**
     * "kiss"
     * "tusk"
     * ["miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss"]
     *
     * [["kiss","diss","disk","dusk","tusk"],["kiss","miss","muss","musk","tusk"]]
     * 0934->1,10,4,5
     */
    public static void main(String[] args) {
        LeetCode126 leetCode126 = new LeetCode126();
        List<List<String>> ladders = leetCode126.findLadders("kiss", "tusk",
                Arrays.asList("miss", "dusk", "kiss", "musk", "tusk", "diss", "disk", "sang", "ties", "muss"));
        System.out.println(ladders);
    }
}
