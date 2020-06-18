package l202004;

import java.util.Arrays;

/**
 * @author lanshan
 * 
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 *
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer16 {
    
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        // start 在左，end 在右
        if (start1[0] > end1[0]) {
            int[] temp = start1;
            start1 = end1;
            end1 = temp;
        }
        if (start2[0] > end2[0]) {
            int[] temp = start2;
            start2 = end2;
            end2 = temp;
        }
        boolean tan = false;
        // k,b
        Double k1 = null;
        if (end1[0] - start1[0] != 0) {
            k1 = (end1[1] - start1[1]) * 1.0 / (end1[0] - start1[0]);
        }
        Double k2 = null;
        if (end2[0] - start2[0] != 0) {
            k2 = (end2[1] - start2[1]) * 1.0 / (end2[0] - start2[0]);
        }
        if (k1 == null && k2 == null) {
            k1 = k2 = 0.0;
            tan = true;
        } else if (k1 == null){
            return getTanAns(start2, end2, start1, end1);
        } else if (k2 == null) {
            return getTanAns(start1, end1, start2, end2);
        }
        double b1 = start1[1] - k1 * start1[0];
        double b2 = start2[1] - k2 * start2[0];
        // k1!=k2
        if (!k1.equals(k2)) {
            double px = (b2 - b1) / (k1 - k2);
            double py = k1 * px + b1;
            if (isIn(start1, end1, start2, end2, px, py)) {
                return new double[] { px, py };
            }
            return new double[] {};
        }
        // k1=k2,b1!=b2
        if ((end2[1] - start2[1])*(end1[0] - start1[0]) == (end1[1] - start1[1])*(end2[0] - start2[0])) {
            if (b1 != b2 && !tan) {
                return new double[]{};
            } else {
                boolean s1 = isIn2(start1, start2, end2);
                boolean e1 = isIn2(end1, start2, end2);
                boolean s2 = isIn2(start2, start1, end1);
                boolean e2 = isIn2(end2, start1, end1);
                if (!s1 && !e1 && !s2 && !e2) {
                    return new double[]{};
                }
                double[] ans = null;
                ans = getAns(s1, ans, start1);
                ans = getAns(e1, ans, end1);
                ans = getAns(s2, ans, start2);
                ans = getAns(e2, ans, end2);
                if (ans == null) {
                    return new double[]{};
                }
                return ans;
            }
        }
        return new double[]{};
    }
    
    public boolean isIn(int[] start1, int[] end1, int[] start2, int[] end2, double x, double y) {
        return check(x, start1[0], end1[0]) && check(x, start2[0], end2[0]) && check(y, start1[1], end1[1])
                && check(y, start2[1], end2[1]);
    }
    
    public boolean check(double p, int s, int end) {
        return (p >= s && p <= end) || (p >= end && p <= s);
    }

    public boolean isIn2(int[] p, int[] s, int[] e) {
        return check(p[0], s[0], e[0]) && check(p[1], s[1], e[1]);
    }

    public double[] getAns(boolean check, double[] ans, int[] point) {
        if (check) {
            if (ans == null) {
                ans = new double[2];
                ans[0] = point[0];
                ans[1] = point[1];
            } else {
                if (point[0] < ans[0]) {
                    ans[0] = point[0];
                    ans[1] = point[1];
                } else if (point[0] == ans[0]) {
                    if (point[1] < ans[1]) {
                        ans[1] = point[1];
                    }
                }
            }
        }
        return ans;
    }
    
    public double[] getTanAns(int[] s, int[] e, int[] origin1, int[] origin2) {
        if (s[0]==origin1[0]) {
            return new double[] {s[0], s[1]};
        }
        if (e[0]==origin1[0]) {
            return new double[] {e[0], e[1]};
        }
        if (isIn2(s, origin1, origin2)) {
            return new double[] {s[0], s[1]};
        }
        if (isIn2(e, origin1, origin2)) {
            return new double[] {e[0], e[1]};
        }
        return new double[]{};
    }

    public static void main(String[] args) {
        Offer16 offer16 = new Offer16();
        System.out.println(Arrays.toString(offer16.intersection(new int[] {1, 0}, new int[] {1, 1}, new int[] {-1, 0}, new int[] {3, 2})));
    }
}
