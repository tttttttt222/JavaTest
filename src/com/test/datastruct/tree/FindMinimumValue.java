package com.test.datastruct.tree;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/11/22
 */
public class FindMinimumValue {


	public static void main(String[] args) {
		TreeOperate treeOperate = new TreeOperate();
		TreeNode treeNode = treeOperate.createRandom(4);
		treeOperate.PreOrderTraversal(treeNode);
		int secondMinimumValue = new FindMinimumValue().findMinimumValue(treeNode);
		System.out.println("--------------------------------------------");
		System.out.println(secondMinimumValue);
	}


	public int findMinimumValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int minVal = min(findMinimumValue(root.getLeft()), findMinimumValue(root.getRight()));
		if (root.getVal() < minVal) {
			return root.getVal();
		} else {
			if (minVal != -1) {
				return minVal;
			} else {
				return root.getVal();
			}
		}
	}


	public int min(int i, int j) {
		if (i == -1 && j == -1) {
			return -1;
		}
		if (i < -1) {
			return j;
		}
		if (j < -1) {
			return i;
		}

		return i < j ? i : j;
	}

}
