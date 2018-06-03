package com.vin.test.avl;

public class AVLTreeNode {
	
	private int data;
	private AVLTreeNode right;
	private AVLTreeNode parent;
	private AVLTreeNode left;

	public AVLTreeNode(int data,AVLTreeNode parent){
		this.parent = parent;
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public int getData() {
		return data;
	}
	private void setAsParent(AVLTreeNode child){
		if(child!=null){
			child.setParent(this);
		}
	}
	public void setData(int data) {
		this.data = data;
	}

	public AVLTreeNode getRight() {
		return right;
	}

	public void setRight(AVLTreeNode right) {
		this.setAsParent(right);
		this.right = right;
		
	}

	public AVLTreeNode getLeft() {
		return left;
	}

	public void setLeft(AVLTreeNode left) {
		this.setAsParent(left);
		this.left = left;
	}

	public AVLTreeNode getParent() {
		return parent;
	}

	public void setParent(AVLTreeNode parent) {
		this.parent = parent;
	}
	
	public int getBalance(){
		if(this.left != null && this.right != null){
			return this.right.getHeight()- this.left.getHeight();
		}else if( this.left != null){
			return 0- this.left.getHeight();
		}else if(this.right != null){
			return this.right.getHeight();
		}else{
			return 0;
		}
	}
	public int getHeight(){
		if( this.left != null && this.right != null){
			return 1+ Math.max(this.left.getHeight(), this.right.getHeight());
		}else if(this.left != null){
			return 1+ this.left.getHeight();
		}else if(this.right != null){
			return 1+ this.right.getHeight();
		}else {
			return 1;
		}
	}
}
