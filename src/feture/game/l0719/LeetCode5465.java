
package feture.game.l0719;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode5465 {

    class Solution {

        private int[] res;
        public int[] countSubTrees(int n, int[][] edges, String labels) {
            if (n == 0 || edges == null || edges.length == 0 || labels == null || labels.length() == 0) {
                return new int[0];
            }
            res = new int[n];
            Map<Integer, Node> map = new HashMap<>(n);
            Arrays.sort(edges, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
            for (int[] edge : edges) {
                int father = edge[0];
                int son = edge[1];
                Node fatherNodeLike = getNode(father, map, labels);
                Node sonNodeLike = getNode(son, map, labels);
                if (fatherNodeLike.nIndex == 0) {
                    fatherNodeLike.child.add(sonNodeLike);
                    sonNodeLike.father = fatherNodeLike;
                } else {
                    if (fatherNodeLike.father != null) {
                        fatherNodeLike.child.add(sonNodeLike);
                        sonNodeLike.father = fatherNodeLike;
                    } else {
                        sonNodeLike.child.add(fatherNodeLike);
                        fatherNodeLike.father = sonNodeLike;
                    }
                }
            }
            Node root = map.get(0);
            afterRead(root);
            return res;
        }
        
        private int[] afterRead(Node root) {
            List<Node> child = root.child;
            int[] result = root.index;
            for (Node node : child) {
                result = merge(result, afterRead(node));
            }
            res[root.nIndex] = root.index[root.val - 'a'];
            return result;
        }
        
        private int[] merge(int[] i, int[] j) {
            if (i == null) {
                return j;
            }
            for (int i1 = 0; i1 < j.length; i1++) {
                i[i1] += j[i1];
            }
            return i;
        }

        
        
        private Node getNode(int i, Map<Integer, Node> map, String labels) {
            Node node = map.get(i);
            if (node != null)
                return node;
            Node n = new Node();
            n.val = labels.charAt(i);
            n.index[n.val - 'a']++;
            n.nIndex = i;
            map.put(i, n);
            return n;
        }

        class Node {
            Node father;
            
            int nIndex;

            char val;

            List<Node> child = new ArrayList<>();

            int[] index = new int[26];
        }
    }
}
