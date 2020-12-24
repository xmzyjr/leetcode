package feture.trie;

/**
 * @author lanshan
 */
public class LeetCode208 {

    /**
     * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
     *
     * 示例:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // 返回 true
     * trie.search("app");     // 返回 false
     * trie.startsWith("app"); // 返回 true
     * trie.insert("app");
     * trie.search("app");     // 返回 true
     * 说明:
     *
     * 你可以假设所有的输入都是由小写字母 a-z 构成的。
     * 保证所有输入均为非空字符串。
     */
    class Trie {

        class TreeNode {

            TreeNode[] treeNodes = new TreeNode[26];

            boolean isLeaf;
        }

        private final TreeNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TreeNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0)
                return;
            char[] chars = word.toCharArray();
            TreeNode tempRoot = root;
            for (char aChar : chars) {
                if (tempRoot.treeNodes[aChar - 'a'] == null) {
                    tempRoot.treeNodes[aChar - 'a'] = new TreeNode();
                }
                tempRoot = tempRoot.treeNodes[aChar - 'a'];
            }
            tempRoot.isLeaf = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null || word.length() == 0)
                return false;
            char[] chars = word.toCharArray();
            TreeNode tempRoot = root;
            for (char aChar : chars) {
                if (tempRoot.treeNodes[aChar - 'a'] == null)
                    return false;
                tempRoot = tempRoot.treeNodes[aChar - 'a'];
            }
            return tempRoot.isLeaf;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0)
                return false;
            char[] chars = prefix.toCharArray();
            TreeNode tempRoot = root;
            for (char aChar : chars) {
                if (tempRoot.treeNodes[aChar - 'a'] == null)
                    return false;
                tempRoot = tempRoot.treeNodes[aChar - 'a'];
            }
            return true;
        }
    }

}
