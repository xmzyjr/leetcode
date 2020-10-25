package feture.game.l1025;

/**
 * @author lanshan
 */
public class LeetCode5546 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int count = releaseTimes[0];
        int temp;
        for (int i = 1; i < releaseTimes.length; i++) {
            temp = releaseTimes[i] - releaseTimes[i - 1];
            if (temp >= count) {
                if (temp == count && keysPressed.charAt(i) > res)
                    res = keysPressed.charAt(i);
                else if (temp > count)
                    res = keysPressed.charAt(i);
                count = temp;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode5546 l = new LeetCode5546();
        System.out.println(l.slowestKey(new int[] {12,23,36,46,62}, "spuda"));
    }
}
