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
        List<List<Integer>> list = new ArrayList<>();
        f(list,1,root);
        return list;
    }
    public void f(List<List<Integer>> l,int i,TreeNode root){
        if(root==null)
            return;
        if(l.size()>=i){
            l.get(i-1).add(root.val);
        }
        else{
            List<Integer> ll = new ArrayList<>();
            ll.add(root.val);
            l.add(new ArrayList<>(ll));
        }
        f(l,i+1,root.left);
        f(l,i+1,root.right);
    }
}