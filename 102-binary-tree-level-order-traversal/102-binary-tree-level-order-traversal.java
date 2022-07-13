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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> row = new ArrayList<>();
        while(q.size()>1){
            TreeNode temp = q.poll();
            if(temp==null){
                res.add(row);
                if(q.peek() != null){
                    q.add(null);
                    row = new ArrayList<>();
                }
            }
            else{
                row.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        if(row.size()>0)
            res.add(row);
        return res;
    }
}