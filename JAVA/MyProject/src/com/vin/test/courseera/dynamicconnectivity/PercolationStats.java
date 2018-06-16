package com.vin.test.courseera.dynamicconnectivity;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private double[] stats;
	public PercolationStats(int n, int t){
		if(n<=0 && t<= 0){
			throw new IllegalArgumentException();
		}
		stats = new double[t];
		for(int i=0;i<t;i++){
			Percolation p = new Percolation(n);
			int openSites = 0;

			while(!p.percolates()){
				int row = StdRandom.uniform(n)+1;
				int col = StdRandom.uniform(n)+1;
				if( ! p.isOpen(row, col)){
					p.open(row, col);
					openSites++;
				}
			}
			stats[i] = openSites/n*n;
		}
	}
	 public double mean() {
	        return StdStats.mean(stats);
	    }

	    public double stddev() {
	        return StdStats.stddev(stats);
	    }

	    public double confidenceLo() {
	        return mean() - (1.96 * stddev() / Math.sqrt(stats.length));
	    }

	    public double confidenceHi() {
	        return mean() + (1.96 * stddev() / Math.sqrt(stats.length));
	    }

	    public static void main(String[] args) {
	        int N = Integer.parseInt(args[0]);
	        int T = Integer.parseInt(args[1]);
	        PercolationStats percolationStats = new PercolationStats(N, T);
	        System.out.println("The Mean is-->" + percolationStats.mean());
	        System.out.println("The Standard Deviation is-->" + percolationStats.stddev());
	        System.out.println("The 95% confidence interval is-->" + percolationStats.confidenceLo() + ", "
	                + percolationStats.confidenceHi());
	    }
}
