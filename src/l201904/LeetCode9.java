package l201904;

/**
 * @author lanshan
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int sum = 0;
        int temp = x;
        while (temp != 0) {
            sum *= 10;
            sum += (temp % 10);
            temp /= 10;
        }
        return sum == x;
    }

    public static void main(String[] args) {
        LeetCode9 l = new LeetCode9();
        System.out.println(l.isPalindrome(121));
    }
}
