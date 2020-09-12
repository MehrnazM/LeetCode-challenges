/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int totSum = 0;
    private void parSum(TreeNode node, int sum){
        if(node != null){
            sum = (sum << 1) | node.val;
            if(node.left == null && node.right == null){
                totSum += sum;
            }
            parSum(node.left,sum);
            parSum(node.right,sum);
        }
        
    }
    public int sumRootToLeaf(TreeNode root) {
        parSum(root,0);
        return totSum;
    }
}
