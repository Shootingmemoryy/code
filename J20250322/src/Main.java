import javax.swing.tree.TreeNode;

/**
 * @Shootingmemory
 * @create 2025-03-22-16:09
 */
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
    public static void main(String[] args) {

    }
    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }
        public int dfs(TreeNode root, int prevSum){
            if(root==null){
                return 0;
            }
            int sum=prevSum*10+root.val;
            if (root.left == null && root.right == null) {
                return sum;
            } else {
                return dfs(root.left, sum) + dfs(root.right, sum);
            }
        }
    }
}