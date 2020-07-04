package feture.binary.search.easy;

import java.util.PriorityQueue;

/**
 * @author lanshan
 */
public class LeetCode1337 {
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            if (mat == null || mat.length == 0 || k ==0)
                return new int[0];
            PriorityQueue<Node> heap = new PriorityQueue<>(mat.length, (o1, o2) -> {
                if (o1.num == o2.num) {
                    return o1.index - o2.index;
                }
                return o1.num - o2.num;
            });
            for (int i = 0; i < mat.length; i++) {
                int left = 0, right = mat[i].length-1;
                while (left<=right) {
                    int mid = left+(right-left)/2;
                    if (mat[i][mid] == 1) {
                        left = mid+1;
                    } else if (mat[i][mid] == 0) {
                        right = mid - 1;
                    }
                }
                heap.add(new Node(left, i));
            }
            int[] num = new int[k];
            for (int i = 0; i < k; i++) {
                num[i] = heap.poll().index;
            }
            return num;
        }

        class Node {
            int num;
            int index;

            public Node(int num, int index) {
                this.num = num;
                this.index = index;
            }
        }
    }
}
