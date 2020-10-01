
package feture.greedy.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import feture.util.LeetCodeUtil;

/**
 * @author lanshan
 */
public class LeetCode406 {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return new int[0][0];
        Arrays.sort(people, (o1, o2) -> {
            if (o1[1] != o2[1])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] == 0)
                continue;
            int target = people[i][0];
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (people[j][0] >= target)
                    count++;
            }
            if (count > people[i][1]) {
                int start = i - (count - people[i][1]);
                adjust(people, start, i);
            }
        }
        return people;
    }

    private void adjust(int[][] people, int start, int end) {
        int[] target = people[end];
        for (int i = end; i > start ; i--) {
            people[i] = people[i-1];
        }
        people[start] = target;
    }

    public int[][] reconstructQueue2(int[][] people) {
        // 不能缺少public，子类重写父类方法的权限修饰符至少要和父类的相等
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LeetCodeUtil.print(people);
        System.out.println();
        List<int[]> result = new ArrayList<>();
        for(int[] person : people){
            result.add(person[1], person);
        }
        int[][] res = result.toArray(new int[0][0]);
        LeetCodeUtil.print(res);
        return res;
    }

    public static void main(String[] args) {
        LeetCode406 l = new LeetCode406();
        l.reconstructQueue2(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }
}
