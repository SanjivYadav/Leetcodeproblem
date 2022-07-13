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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Double> count = new ArrayList<>();
        
        averageOfLevelsRec(root, sum,count,0);
        for(int i=0;i<sum.size();i++){
            sum.set(i, (sum.get(i)/count.get(i)));
        }
        return sum;
    }
    
    private void averageOfLevelsRec(TreeNode root, List<Double> sum, List<Double> count, int level){
        if(root == null)
            return;
        if(sum.size()== level){
            sum.add(0.0);
            count.add(0.0);
        }
        sum.set(level,sum.get(level)+root.val);
        count.set(level,count.get(level)+1);
        
        averageOfLevelsRec(root.left, sum,count,level+1);
        averageOfLevelsRec(root.right, sum,count,level+1);
    }
}