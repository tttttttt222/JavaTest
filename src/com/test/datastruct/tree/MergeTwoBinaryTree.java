package com.test.datastruct.tree;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/11/22
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTwoBinaryTree {




	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		// 先合并根节点
		TreeNode root = new TreeNode((t1 == null ? 0 : t1.getVal()) + (t2 == null ? 0 : t2.getVal()));
		// 再递归合并左右子树
		root.setLeft(mergeTrees(t1 == null ? null : t1.getLeft(), t2 == null ? null : t2.getLeft()));
		root.setRight(mergeTrees(t1 == null ? null : t1.getRight(), t2 == null ? null : t2.getRight()));
		return root;
	}

}
