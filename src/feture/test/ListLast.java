package feture.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanshan
 */
public class ListLast {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.getClass());
        int size = list.size();
        list.add(size, 5);
        System.out.println(list);
    }
}
