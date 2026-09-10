import java.util.*;
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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode roo){
        if(roo == null){
            return 0;
        }

        int leftdia = height(roo.left);
        int rightdia =height(roo.right);
        diameter = Math.max(diameter,leftdia+rightdia);
        return Math.max(leftdia,rightdia)+1;
    }
}