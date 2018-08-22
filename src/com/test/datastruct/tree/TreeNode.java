package com.test.datastruct.tree;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/8/21
 */
public class TreeNode {

    private int data;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }



}
