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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottomRec(root,res,0);
        return res;
        
    }
    
    private void levelOrderBottomRec(TreeNode root, List<List<Integer>> res, int level){
        if(root == null)
            return;
        if(res.size()== level)
            res.add(0,new ArrayList<>());
        res.get(res.size()-level-1).add(root.val);
        levelOrderBottomRec(root.left,res,level+1);
        levelOrderBottomRec(root.right,res,level+1);
    }
}