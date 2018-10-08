package com.test.datastruct.tree;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/29 Construct Binary Tree from Preorder and Inorder Traversal
 * preorder=[3,9,20,15,7] inorder = [9,3,15,20,7]
 */
public class ConstructBinaryTreeStack {


    public static void main(String[] args) {
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        TreeNode treeNode = new ConstructBinaryTreeStack().buildTree(a, b);

        TreeOperate treeOperate = new TreeOperate();
        treeOperate.PreOrderTraversal(treeNode);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        if (preorder.length != inorder.length) {
            return null;
        }

        return new TreeNode(1);
    }

    //0 left 1 right
    private int pos(int data, int node, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == data) {
                return 1;
            }

            if (inorder[i] == node) {
                return 0;
            }
        }
        return -1;
    }


}
