import javax.swing.tree.TreeNode;

/**
 * @Shootingmemory
 * @create 2025-03-25-16:55
 */
//平衡二叉树
public class Main {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }else{
                return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
            }
        }
        public int height(TreeNode root){
            if(root==null){
                return 0;
            }else{
                return Math.max(height(root.left),height(root.right))+1;
            }
        }
    }
}