package l201704;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 2: a,b,c
     * 3: d,e,f
     * 4: g,h,i
     * 5: j,k,l
     * 6: m,n,o
     * 7: p,q,r,s
     * 8: t,u,v
     * 9: w,x,y,z
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        char[] chars = digits.toCharArray();
        //        List<List<Character>> list = new ArrayList<>();
        //        for (char aChar : chars) {
        //            List<Character> characters = map.get(aChar);
        //            if (characters != null) {
        //                list.add(characters);
        //            }
        //        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        list(map, chars, 0, sb, list);
        return list;
    }

    public void list(Map<Character, List<Character>> map, char[] chars, int index, StringBuilder sb,
                     List<String> list) {
        if (index == chars.length) {
            list.add(sb.toString());
            return;
        }
        List<Character> characters = map.get(chars[index]);
        for (int i = 0; i < characters.size(); i++) {
            sb.append(characters.get(i));
            list(map, chars, index + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode17 l = new LeetCode17();
        System.out.println(l.letterCombinations("23"));
    }
}
