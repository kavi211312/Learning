package com.vin.test.avl;

public class AVLTreeNode {
	private int data;
	private AVLTreeNode right;
	private AVLTreeNode parent;
	private AVLTreeNode left;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AVLTreeNode getRight() {
		return right;
	}

	public void setRight(AVLTreeNode right) {
		this.right = right;
	}

	public AVLTreeNode getLeft() {
		return left;
	}

	public void setLeft(AVLTreeNode left) {
		this.left = left;
	}

	public AVLTreeNode getParent() {
		return parent;
	}

	public void setParent(AVLTreeNode parent) {
		this.parent = parent;
	}

}
