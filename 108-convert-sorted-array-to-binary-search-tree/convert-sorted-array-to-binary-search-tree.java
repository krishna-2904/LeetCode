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
        return f(nums,0,nums.length-1);
    }
    public TreeNode f(int nums[],int i,int j){
        if(i>j)
            return null;
        if(i==j)
            return new TreeNode(nums[i]);
        int mid = (i+j)/2;
        TreeNode head = new TreeNode();
        head.val = nums[mid];
        head.left = f(nums,i,mid-1);
        head.right = f(nums,mid+1,j);
        return head;
    }
}