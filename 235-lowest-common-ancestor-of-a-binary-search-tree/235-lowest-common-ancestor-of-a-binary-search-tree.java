/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(p.val > q.val){
           TreeNode temp = p;
            p=q;
            q=temp;
        }
        if(root.val == p.val || q.val == root.val)
            return root;
        if(root.val > p.val && q.val > root.val)
            return root;
        if(root.val > p.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
        
    }
}