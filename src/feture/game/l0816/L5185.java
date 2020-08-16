package feture.game.l0816;

/**
 * @author lanshan
 */
public class L5185 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null || arr.length<3)
            return false;
        int[] num = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num[i] = arr[i] % 2 == 0 ? 0 : 1;
        }
        int left=0,right=2;
        int count = num[0]+num[1]+num[2];
        
        
        do{
            if (count == 3)
                return true;
            left++;
            right++;
            count -= num[left - 1];
            if (right< num.length) {
                count += num[right];
            }
        }while (right<num.length);
        return false;
    }
}
