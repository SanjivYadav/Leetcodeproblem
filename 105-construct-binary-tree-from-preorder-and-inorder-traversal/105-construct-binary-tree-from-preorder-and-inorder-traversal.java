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
    int preIndex =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRec(preorder,inorder,0,inorder.length-1);
        
    }
    
    private TreeNode buildTreeRec(int preOrder[], int inOrder[], int inStart,int inEnd){
        if(inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preIndex++]);
        if(inStart == inEnd)
            return root;
        int inIndex = search(inOrder,inStart,inEnd,root.val);
        root.left = buildTreeRec(preOrder,inOrder,inStart,inIndex-1);
        root.right = buildTreeRec(preOrder,inOrder,inIndex+1,inEnd);
        return root;
    }
    
    private int search(int inOrder[], int start, int end, int target){
        for(int i= start; i<= end;i++){
            if(inOrder[i]==target)
                return i;
        }
        return -1;
    }
}