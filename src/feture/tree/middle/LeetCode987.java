package feture.tree.middle;

import java.util.*;

/**
 * @author lanshan
 */
public class LeetCode987 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    private static int zeroIndex = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        zeroIndex = 0;
        List<List<Integer>> result = new ArrayList<>();
        find(root, 0, result);
        return result;
    }
    
    private void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (level < 0 && zeroIndex + level < 0) {
            result.add(0, new ArrayList<>());
            zeroIndex++;
        } else if (level >= 0 && level >= result.size() - zeroIndex) {
            result.add(new ArrayList<>());
        }
        List<Integer> temp = result.get(zeroIndex + level);
        if (temp.size() == 0) {
            temp.add(root.val);
        } else {
            add2List(root, temp);
        }

        find(root.left, level - 1, result);
        find(root.right, level + 1, result);
    }

    private void add2List(TreeNode root, List<Integer> temp) {
        int i;
        for (i = 0; i < temp.size(); i++) {
            if (root.val <= temp.get(i)) {
                temp.add(i, root.val);
                break;
            }
        }
        if (temp.size() == i) {
            temp.add(root.val);
        }
    }

    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        int zeroIndex = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> map = new HashMap<>(16);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer level = indexQueue.poll();
                assert poll != null;
                assert level != null;
                if (level < 0 && zeroIndex + level < 0) {
                    result.add(0, new ArrayList<>());
                    zeroIndex++;
                } else if (level >= 0 && level >= result.size() - zeroIndex) {
                    result.add(new ArrayList<>());
                }
                save2Map(map, level, poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    indexQueue.add(level - 1);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    indexQueue.offer(level + 1);
                }
            }
            putMapList2Result(result, map, zeroIndex);
        }

        return result;
    }

    private void save2Map(Map<Integer, List<Integer>> map, int level, int value) {
        List<Integer> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
            list.add(value);
            map.put(level, list);
        } else {
            putSortList(list, value);
        }
    }

    private void putSortList(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>value) {
                list.add(i, value);
                return;
            }
        }
        list.add(value);
    }

    private void putMapList2Result(List<List<Integer>> result, Map<Integer, List<Integer>> map, int zeroIndex) {
        map.forEach((k,v)-> result.get(zeroIndex+k).addAll(v));
    }
}
