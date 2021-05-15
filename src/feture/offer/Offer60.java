package feture.offer;

/**
 * @author lanshan
 */
public class Offer60 {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     *
     *  
     *
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * 示例 2:
     *
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
     *  
     *
     * 限制：
     *
     * 1 <= n <= 11
     */
    int[] num;
    int N;
    public double[] dicesProbability(int n) {
        num = new int[6 * n - n+1];
        N = n;
        find(n, 0);
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        double[] t = new double[6 * n - n+1];
        for (int i = 0; i < num.length; i++) {
            t[i] = num[i] * 1.0 / sum;
        }
        return t;
    }

    private void find(int numIndex, int sum) {
        if (numIndex == 0) {
            num[sum-N]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            find(numIndex - 1, i + sum);
        }
    }

    public static void main(String[] args) {
        Offer60 o = new Offer60();
        o.dicesProbability(1);
    }
}
