import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-04-01-8:08
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        Deque<Integer> path = new LinkedList<Integer>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return ret;
        }

        public void dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            path.offerLast(root.val);
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                ret.add(new LinkedList<Integer>(path));
            }
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
            path.pollLast();
        }
    }
}