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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums,0, nums.length-1);
        
    }
    
    private TreeNode sortedArrayToBSTUtil(int[] nums, int s, int e){
        if(s>e)
            return null;
        int mid = s+(e-s)/2;
        TreeNode head = new TreeNode(nums[mid],null,null);
        head.left =sortedArrayToBSTUtil(nums, s, mid-1);
        head.right = sortedArrayToBSTUtil(nums,mid+1,e);
        return head;
    }
}