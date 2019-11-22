package com.test.datastruct.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/11/22
 */
public class FindSecondMinimumValue {


	public static void main(String[] args) {
		TreeOperate treeOperate = new TreeOperate();
		TreeNode treeNode = treeOperate.createRandom(4);
		treeOperate.PreOrderTraversal(treeNode);
//		TreeNode treeNode = new TreeNode(2);
		int secondMinimumValue = new FindSecondMinimumValue().findSecondMinimumValue(treeNode);
		System.out.println("------------------------");
		System.out.println(secondMinimumValue);
	}

	List<Integer> arr = new ArrayList<Integer>();

	public int findSecondMinimumValue(TreeNode root) {
		traversal(root);
		Collections.sort(arr);
		if(arr.size() <= 1){
			return -1;
		}
		int fistv = arr.get(0);
		int pos = 0;
		boolean flag = true;
		for (int i =0;i<arr.size(); i++) {
			if(arr.get(i) != fistv){
				flag = false;
				pos = i;
				break;
			}
		}
		if(flag){
          return -1;
		}
		return arr.get(pos);
	}


	private void traversal(TreeNode root) {
		if (root == null) {
			return;
		}
		arr.add(root.getVal());
		traversal(root.getLeft());
		traversal(root.getRight());
	}


}
