package feture.dp.mid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lanshan
 */
public class LeetCode638 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price==null || special == null || needs == null || price.size() == 0 || special.size() == 0|| needs.size() == 0)
            return 0;
        Integer[] integers = needs.toArray(new Integer[0]);
        checkZero(price, integers);
        return find(price, special, integers);
    }

    private void checkZero(List<Integer> price, Integer[] integers) {
        for (int i = 0; i < price.size(); i++) {
            if (price.get(i) == 0)
                integers[i] = 0;
        }
    }


    private int find(List<Integer> price, List<List<Integer>> special, Integer[] num) {
        if (isDone(num)) {
            return 0;
        }
        List<List<Integer>> newSpecial = specialList(special, num);
        if (newSpecial.size() == 0) {
            return getSum(price, num);
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> integers : newSpecial) {
            min = Math.min(min, find(price, special, getOther(num, integers)) + integers.get(integers.size() - 1));
        }
        return min;
    }

    private boolean isDone(Integer[] num) {
        int sum = 0;
        for (int i : num) {
            sum |= i;
        }
        return sum == 0;
    }
    
    private List<List<Integer>> specialList(List<List<Integer>> special, Integer[] num) {
        return special.stream().filter(i -> {
            for (int j = 0; j < num.length; j++) {
                if (num[j] - i.get(j) < 0)
                    return false;
            }
            return true;
        }).collect(Collectors.toList());
    }
    
    private int getSum(List<Integer> price, Integer[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i] * price.get(i);
        }
        return sum;
    }
    
    private Integer[] getOther(Integer[] num, List<Integer> special) {
        Integer[] other = Arrays.copyOf(num, num.length);
        for (int i = 0; i < other.length; i++) {
            other[i] -= special.get(i);
        }
        return other;
    }

    public static void main(String[] args) {
        LeetCode638 l = new LeetCode638();
        List<Integer> integers = Arrays.asList(3, 0, 5);
        List<Integer> integers1 = Arrays.asList(1, 2, 10);
        List<List<Integer>> lists = Arrays.asList(integers, integers1);
        System.out.println(l.shoppingOffers(Arrays.asList(2, 5), lists, Arrays.asList(3, 2)));
    }

}
