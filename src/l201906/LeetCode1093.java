
package l201906;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class LeetCode1093 {

    private class Entry {

        int count;

        int number;

        public Entry(int count, int number) {
            this.count = count;
            this.number = number;
        }
    }

    public double[] sampleStats(int[] count) {
        double[] result = new double[5];
        // min,max,ave,zhong,zong
        double min = -1, max = 0, ave = 0, zhong, zong = 0;
        int countMax = 0;
        int countNum = 0;
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {

                if (min == -1) {
                    min = i;
                }

                max = i;

                if (count[i] > countMax) {
                    countMax = count[i];
                    zong = i;
                }

                countNum += count[i];
                ave += count[i] * i;

                list.add(new Entry(count[i], i));
            }
        }
        ave = ave * 1.0 / countNum;

        result[0] = min;
        result[1] = max;
        result[2] = ave;
        result[3] = get(list);
        result[4] = zong;
        return result;
    }

    public double get(List<Entry> list) {
        int count = list.stream().mapToInt(i -> i.count).sum();
        int count1 = count / 2;
        if (count % 2 == 0) {
            int count2 = 0;
            for (int i = 0; i < list.size(); i++) {
                Entry entry = list.get(i);
                count2 += entry.count;
                if (count2 == count1) {
                    return (entry.number + list.get(i + 1).number) * 1.0 / 2;
                } else if (count2 > count1) {
                    return entry.number;
                }
            }
        } else {
            int count2 = 0;
            for (int i = 0; i < list.size(); i++) {
                Entry entry = list.get(i);
                count2 += entry.count;
                if (count2 == count1) {
                    return list.get(i + 1).number;
                } else if (count2 > count1) {
                    return entry.number;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode1093 l = new LeetCode1093();
        l.sampleStats(new int[] {0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }
}
