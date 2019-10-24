package com.company.CutBinaryTree;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CutBst {

    TreeNode small = null;
    TreeNode big = null;
    public TreeNode[] cutBST(TreeNode root, int k) {
        processCutBst(root,k);
        return new TreeNode[]{small,big};
    }
  public void processCutBst(TreeNode root, int k) {
  
      if(root==null){
          return  ;
      }
      else {
          if(root.val<=k){
            if(small== null){
                small = new TreeNode(root.val);
            }
            else{
                insert(root.val,small);
            }
          }
          if(root.val>k){
                if(big == null){
                big = new TreeNode(root.val);
            }
            else{
                insert(root.val,big);
            }
          }
          cutBST(root.left,k);
          cutBST(root.right,k); 
      }
  }
  void insert(int key,TreeNode root) { 
       root = insertRec(root, key); 
    } 
      
    /* A recursive function to insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key) { 
  
        /* If the tree is empty, return a new node */
        if (root == null) { 
            root = new TreeNode(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.val) 
            root.left = insertRec(root.left, key); 
        else if (key > root.val) 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
    }

    public static void main(String args[]) {
        CutBst tree = new CutBst();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(11);
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(16);

        System.out.println("Level order traversal of binary tree is ");
        TreeNode[] node = tree.cutBST(root,7);
        System.out.println(tree.big.val);
    }


}


