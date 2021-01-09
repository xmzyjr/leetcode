package feture.ms;

import java.util.Arrays;

/**
 * @author lanshan
 */
public class M1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        M1601 m = new M1601();
        System.out.println(Arrays.toString(m.swapNumbers(new int[] {1, 2})));
    }
}
