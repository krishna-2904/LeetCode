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
        List<List<Integer>> list = new ArrayList<>();
        int a = h(root);
        for(int i = 0;i<a;i++){
            list.add(new ArrayList<>());
        }
        f(list,a-1,root);
        return list;
    }
    public int h(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return 1;
        }
        if(root.left==null)
            return 1 + h(root.right);
        if(root.right==null)
            return 1 + h(root.left);
        return 1 + Math.max(h(root.left),h(root.right));
    }
    public void f(List<List<Integer>> l,int i,TreeNode root){
        if(root==null)
            return;
        l.get(i).add(root.val);
        f(l,i-1,root.left);
        f(l,i-1,root.right);
    }
}