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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        list = f(list,l,root,targetSum);
        return list;
    }
    public List<List<Integer>> f(List<List<Integer>> list,List<Integer> l,TreeNode root,int t){
        if(root == null)
            return list;
        t = t - root.val;
        l.add(root.val);
        if(t==0 && root.left==null && root.right==null){
            list.add(new ArrayList<>(l));
            l.remove(l.size()-1);
            return list;
        }
        list = f(list,l,root.left,t);
        list = f(list,l,root.right,t);
        l.remove(l.size()-1);
        return list;        
    }
}