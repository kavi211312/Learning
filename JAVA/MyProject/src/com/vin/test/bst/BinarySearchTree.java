package com.vin.test.bst;

public class BinarySearchTree {
	private BinarySearchTreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public boolean search(int value) {
		if (this.root == null) {
			return false;
		}
		BinarySearchTreeNode current = this.root;
		while (current != null) {

			if (value < current.getData()) {
				current = current.getLeft();
			} else if (value > current.getData()) {
				current = current.getRight();
			} else if (value == current.getData()) {
				return true;
			}
		}
		return false;
	}

	public void insert(int value) {
		if (this.root == null) {
			this.root = new BinarySearchTreeNode(value);
			return;
		}
		BinarySearchTreeNode current = this.root;
		BinarySearchTreeNode parent = null;
		while (current != null) {
			parent = current;
			if (value < current.getData()) {
				current = current.getLeft();
			} else if (value > current.getData()) {
				current = current.getRight();
			}
		}
		if (value < parent.getData()) {
			parent.setLeft(new BinarySearchTreeNode(value));
		} else {
			parent.setRight(new BinarySearchTreeNode(value));
		}
	}

	public boolean delete(BinarySearchTreeNode root, int value) {
		if (root == null) {
			return false;
		}
		BinarySearchTreeNode current = root;
		BinarySearchTreeNode parent = current;
		BinarySearchTreeNode searchNode = null;
		while (current != null) {
			if (value == current.getData()) {
				searchNode = current;
				break;
			}
			parent = current;
			if (value < current.getData()) {
				current = current.getLeft();
			} else if (value > current.getData()) {
				current = current.getRight();
			}
		}

		if (searchNode == null) {
			return false;
		}
		// if no child i.e leaf
		if (searchNode.getLeft() == null && searchNode.getRight() == null) {

			if (searchNode == root) {
				root = null;
			} else if (value < parent.getData()) {
				parent.setLeft(null);
			} else if (value > parent.getData()) {
				parent.setRight(null);
			}
		}
		// if one child
		if (searchNode.getLeft() == null) {
			if (searchNode == root) {
				root = searchNode.getRight();
			} else if (value < parent.getData()) {
				parent.setLeft(searchNode.getRight());
			} else {
				parent.setRight(searchNode.getRight());
			}
		} else if (searchNode.getRight() == null) {
			if (searchNode == root) {
				root = searchNode.getLeft();
			}else if(value< parent.getData()){
				parent.setLeft(searchNode.getLeft());
			}else{
				parent.setRight(searchNode.getLeft());
			}
		}

		// if two children
		if(searchNode.getLeft() != null && searchNode.getRight() != null ){
			BinarySearchTreeNode temp = getMinimumFromRight(searchNode);
			temp.setLeft(searchNode.getLeft());
			temp.setRight(searchNode.getRight());
			if( searchNode == root ){
				root = temp;
			}else if( temp.getData() < parent.getData()){
				parent.setLeft(temp);
			}else{
				parent.setRight(temp);
			}
			//delete( temp.getRight(), temp.getData() );
		}
		return true;
	}
	

	private BinarySearchTreeNode getMinimumFromRight(BinarySearchTreeNode nartode){
		
		BinarySearchTreeNode root = nartode.getRight();
		BinarySearchTreeNode minNode = root.getLeft();
		if( minNode == null ){
			minNode = root;
			nartode.setRight(minNode.getRight());
			return minNode;
		}
		while(minNode.getLeft() != null){
			root = minNode;
			minNode = minNode.getLeft();
		}
		root.setLeft(minNode.getRight());
		return minNode;
	}
}
