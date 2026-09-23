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
    public boolean isBalanced(TreeNode root) {
        int a = f(root);
        return ff(root);
    }
    public boolean ff(TreeNode root){
        if(root==null)
            return true;
        int l = 0;
        int r = 0;
        if(root.left!=null)
            l = root.left.val;
        if(root.right!=null)
            r = root.right.val;
        if(Math.abs(l-r)>1)
            return false;
        if(!ff(root.left))
            return false;
        if(!ff(root.right))
            return false;
        return true;
    }
    public int f(TreeNode r){
        if(r==null){
            return 0;
        }
        int a = f(r.left);
        int b = f(r.right);
        r.val = 1 + Math.max(a,b);
        return r.val;
    }
}