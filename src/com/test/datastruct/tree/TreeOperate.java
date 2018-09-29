package com.test.datastruct.tree;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/8/21
 */
public class TreeOperate {


    public TreeNode create(int data) {
        TreeNode treeNode = new TreeNode(data);
        if (treeNode.getVal() < 0) {
            return null;
        } else {
            treeNode.setLeft(create(data - 1));
            treeNode.setRight(create(data - 1));
        }
        return treeNode;
    }


    public void PreOrderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.getVal());
            PreOrderTraversal(treeNode.getLeft());
            PreOrderTraversal(treeNode.getRight());
        }
    }


    public void depthFirstSearch(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            System.out.println(peek.getVal());
            TreeNode node = stack.pop();
            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
            }
        }
    }



    public void breadthFirstSearch(TreeNode treeNode) {
        ArrayDeque <TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.peek();
            System.out.println(peek.getVal());
            TreeNode node = queue.poll();
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if(node.getRight() != null){
                queue.add(node.getRight());
            }

        }
    }


    public static void main(String[] args) {
        TreeOperate treeOperate = new TreeOperate();
        TreeNode treeNode = treeOperate.create(2);
//        treeOperate.PreOrderTraversal(treeNode);
//        treeOperate.depthFirstSearch(treeNode);
        treeOperate.breadthFirstSearch(treeNode);
    }

}
