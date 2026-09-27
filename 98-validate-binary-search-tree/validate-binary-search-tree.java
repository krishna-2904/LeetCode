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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.addAll(f(root));
        for(int i = 1;i<ar.size();i++)
            if(ar.get(i)<=ar.get(i-1))
                return false;
        return true;
    }
    public ArrayList<Integer> f(TreeNode root){
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null)
            return arr;
        arr.addAll(f(root.left));
        arr.add(root.val);
        arr.addAll(f(root.right));
        return arr;
    }
}