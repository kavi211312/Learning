package com.vin.test.courseera.dynamicconnectivity;

public class Percolation {

	private boolean[] grid;
	private int length;
	private WeightedQuickUnionFind algo;

	public Percolation(int n) {// Create N X N grid with all sites blocked
		if (n <= 0) {
			throw new IllegalStateException();
		}
		grid = new boolean[n * n];
		algo = new WeightedQuickUnionFind(n * n);
		length = n;
	}

	public void open(int row, int col) {// Open site if its not opened already
		if (!(row > 0 && row <= length && col > 0 && col <= length)) {
			throw new IllegalStateException();
		}
		int index = findIndex(row, col);

		if (!grid[index]) {
			grid[index] = true;
		}
		int nextIndex = 0;
		// find out whether the surrounding sites are opened, if opened make
		// union of it
		// index of next element in the row
		if (col < length) {// for next element
			nextIndex = findIndex(row, col + 1);
			if (isOpen(row, col + 1)) {
				algo.union(index, nextIndex);
			}
		}
		// for previous element
		if (col > 1) {
			nextIndex = findIndex(row, col - 1);
			if (isOpen(row, col - 1)) {
				algo.union(index, nextIndex);
			}
		}
		if (row > 1) {// a row above the element
			nextIndex = findIndex(row - 1, col);
			if (isOpen(row - 1, col)) {
				algo.union(index, nextIndex);
			}
		}
		if (row < length) {// row below the element
			nextIndex = findIndex(row + 1, col);
			if (isOpen(row + 1, col)) {
				algo.union(index, nextIndex);
			}
		}

	}

	private int findIndex(int row, int col) {
		if (row > 1) {
			row = (row - 1) * length;
		} else {
			row -= 1;
		}

		int index = row + col;

		index -= 1;
		return index;
	}

	public boolean isOpen(int row, int col) {// is site at (row,col) open?
		if (!(row > 0 && row <= length && col > 0 && col <= length)) {
			throw new IllegalStateException();
		}
		int index = findIndex(row, col);
		return grid[index];
	}

	public boolean isFull(int row, int col) {// is site at ( row, col) full?
		if (!(row > 0 && row <= length && col > 0 && col <= length)) {
			throw new IllegalStateException();
		}
		int index = findIndex(row, col);
		return algo.connected(index, 0);
		//return true;
	}

	public int numberOfOpenSites() {// returns number of open sites
		int count = 0;
		for (boolean item : grid) {
			if (item) {
				count++;
			}
		}
		return count;
	}

	public boolean percolates() {// Does the system percolate

		int bottom = length * length - length;
		for (int i = 0; i < length; i++) {
			bottom = length * length - length;
			for (; bottom < length * length; bottom++) {
				if (algo.connected(i, bottom)) {
					return true;
				}
			}
		}
		return false;
	}

	
}