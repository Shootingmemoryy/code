import javax.swing.tree.TreeNode;

/**
 * @Shootingmemory
 * @create 2025-03-23-13:38
 */
public class Main {
    public static void main(String[] args) {

    }
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
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return 1+Math.max(left,right);
        }
    }
}