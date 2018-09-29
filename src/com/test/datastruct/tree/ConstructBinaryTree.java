package com.test.datastruct.tree;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/29 Construct Binary Tree from Preorder and Inorder Traversal
 * preorder=[3,9,20,15,7] inorder = [9,3,15,20,7]
 */
public class ConstructBinaryTree {


    public static void main(String[] args) {
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        TreeNode treeNode = new ConstructBinaryTree().buildTree(a, b);

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


        TreeNode treeNode = new TreeNode(preorder[0]);

        // 9
        for (int i = 1; i < preorder.length; i++) {
            TreeNode treeNodetmp = treeNode;
            while (treeNodetmp != null) {
                int node = preorder[i];
                switch (pos(treeNode.getVal(), node, inorder)) {
                    case 0:
                        TreeNode left = treeNodetmp.getLeft();
                        if (left == null) {
                            treeNodetmp.setLeft(new TreeNode(node));
                            treeNodetmp = null;
                        } else {
                            treeNodetmp = treeNodetmp.getLeft();
                        }

                        break;
                    case 1:
                        TreeNode right = treeNodetmp.getRight();
                        if (right == null) {
                            treeNodetmp.setRight(new TreeNode(node));
                            treeNodetmp = null;
                        } else {
                            treeNodetmp = treeNodetmp.getRight();
                        }

                        break;
                    default:
                        return null;
                }
            }
        }

        return treeNode;
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
