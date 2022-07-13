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
    //int max =0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideViewRec(root, res, 0);
        return res;
        
    }
    
    private void rightSideViewRec(TreeNode root, List<Integer> res, int level){
        if(root == null)
            return;
        if(res.size() == level){
            res.add(root.val);
        }
        rightSideViewRec(root.right, res, level+1);
        rightSideViewRec(root.left, res, level+1);
    }
}