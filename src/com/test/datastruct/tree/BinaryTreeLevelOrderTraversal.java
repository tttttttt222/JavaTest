package com.test.datastruct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/11/29
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeOperate treeOperate = new TreeOperate();
		TreeNode root = treeOperate.createRandom(4);
		treeOperate.PreOrderTraversal(root);
		List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal().levelOrder(root);
		System.out.println(lists);
	}


	public List<List<Integer>> list = new ArrayList<List<Integer>>();

	public void helper(TreeNode node, int level) {

		if(node == null){
			return;
		}

		if(list.size() == level){
             list.add(new ArrayList<Integer>());
		}

		list.get(level).add(node.getVal());

		helper(node.getLeft(),level + 1);
		helper(node.getRight(),level + 1);
	}


	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null){
			return list;
		}

		helper(root,0);

		return list;
	}


}
