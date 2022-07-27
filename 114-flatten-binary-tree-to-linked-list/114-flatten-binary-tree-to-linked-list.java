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
    public void flatten(TreeNode root) {
        flattenRec(root);
        
    }
    private TreeNode flattenRec(TreeNode root){
        if(root == null)
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null){
            TreeNode curr = left;
            while(curr.right != null)
            {
                curr = curr.right;
            }
            curr.right = right;
            root.right = left;
            root.left = null;
        }
        flattenRec(root.right);
        return root;
    }
}