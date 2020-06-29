package feture.test;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class ListLast {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        System.out.println(list.getClass());
//        int size = list.size();
//        list.add(size, 5);
//        System.out.println(list);
        int[] num = new int[9];
        num[1]= 1;
        int[] ints = Arrays.copyOf(num, 9);
        num[0] = 1;
        System.out.println(num[0]);
        System.out.println(ints[0]);

        // x & (x-1) 表示，减少二进制x 里面的最右边的1
        // 可以用作统计bit1的个数，也可以判断是否为2的n次方
        System.out.println(8&7);
        System.out.println(7&6);
        System.out.println(6&5);
    }
}
