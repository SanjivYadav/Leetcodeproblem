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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        largestValuesRec(root,res,0);
        return res;
        
    }
    
    private void largestValuesRec(TreeNode root, List<Integer> res, int level){
        if(root == null)
            return;
        if(res.size() == level){
            res.add(Integer.MIN_VALUE);
            
        }
        if(res.get(level)<root.val)
            res.set(level,root.val);
        
        largestValuesRec(root.left,res,level+1);
        largestValuesRec(root.right, res, level+1);
    }
}