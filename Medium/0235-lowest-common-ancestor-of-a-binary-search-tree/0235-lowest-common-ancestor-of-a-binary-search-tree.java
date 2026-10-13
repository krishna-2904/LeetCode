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
        int a = p.val;
        int b = q.val;
        int c = root.val;
        if((a<c && b>c) || (a>c && b<c) || a==c || b==c)
            return root;
        if(a<c && b<c)
            return lowestCommonAncestor(root.left,p,q);
        else
            return lowestCommonAncestor(root.right,p,q);
    }
}