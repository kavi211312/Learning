package com.vin.test.avl;

public class AVLTree {
	private AVLTreeNode root;

	public AVLTree() {
		this.root = null;
	}

	public void insert(int data) {
		if (this.root == null) {
			this.root = new AVLTreeNode(data, null);
			return;
		}
		// Search for the position where the data can be inserted
		AVLTreeNode temp = null;
		;
		AVLTreeNode current = this.root;
		while (current != null) {
			temp = current;
			if (data < current.getData()) {
				current = current.getLeft();
			} else if (data > current.getData()) {
				current = current.getRight();
			}
		}
		// Now temp is the node for which the new node has to be inserted
		if (data < temp.getData()) {
			temp.setLeft(new AVLTreeNode(data, temp));
		} else {
			temp.setRight(new AVLTreeNode(data, temp));
		}
		rebalance(temp);
	}

	public boolean delete(AVLTreeNode node) {
		return true;
	}

	public boolean search(int value) {
		return true;
	}

	private void rebalance(AVLTreeNode node) {
		int balance = node.getBalance();
		if (balance == -2) {
			if (node.getLeft().getBalance() == -1) {
				RR(node);
			} else {
				LR(node);
			}
		} else if (balance == 2) {
			if (node.getRight().getBalance() == -1) {
				RL(node);
			} else {
				LL(node);
			}
		}
	}

	private void LL(AVLTreeNode node) {
		AVLTreeNode right = node.getRight();
		AVLTreeNode parent = node.getParent();

		right.setLeft(node);
		node.setRight(right.getLeft());
		if (node != this.root) {
			if (parent.getData() < right.getData()) {
				parent.setRight(right);
			} else {
				parent.setLeft(right);
			}
		} else {
			right.setParent(null);
			this.root = right;
		}
	}

	private void LR(AVLTreeNode node) {
		this.LL(node.getLeft());
		this.RR(node);
	}

	private void RR(AVLTreeNode node) {
		AVLTreeNode left = node.getLeft();
		AVLTreeNode parent = node.getParent();
		left.setRight(node);
		node.setLeft(left.getRight());
		if (this.root != node) {
			if(parent.getData() < left.getData()){
				parent.setRight(left);
			}else{
				parent.setLeft(left);
			}
		}else{
			left.setParent(null);
			this.root = left;
		}
	}

	private void RL(AVLTreeNode node) {
		this.RR(node.getRight());
		this.LL(node);
	}

}
