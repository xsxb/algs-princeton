import edu.princeton.cs.algs4.StdRandom;

public class Percolation{
	
	static int n;
	static int T;
	static int[][] grid; //0->closed; 1->open
	static int size;

	//init n-by-n grid, all sites blocked
	public Percolation(int n) {
		grid = new int[n][n];
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=n; j++) {
				grid[i][j] = 0;
			}
		}
	}

	//open site (row, col)
	public void open(int row, int col) {
		grid[row][col] = 1;
	}

	//is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		if (0 <= row || row > n  || 0 <= col || col > n) {
			throw new IllegalArgumentException();
		}	
		return (grid[row][col] == 1) ? true : false;
	}

	//is the site (row, col) full?
	public boolean isFull(int row, int col) {
		return false;
	}

	//return number of open sites
	public int numberOfOpenSites() {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (grid[i][j] == 1) { count++; }
			}
		}
		return count;
	}

	//Now will it percolate? That is the question
	public boolean percolates() {
		return false;
	}

	//Returns n by n matrix grid[n][n]
	private static int[][] initGrid(int n) {
		grid = new int[n][n];
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=n; j++) {
				grid[i][j] = 0;
			}
		}
		return grid;
	}

	//test client
	public static void main(String[] args) {
		
		n = Integer.parseInt(args[0]);
		T = Integer.parseInt(args[1]);

		if (n <= 0 || T <= 0) {
			throw new IllegalArgumentException();
		}

		size = n*n;
		grid = initGrid(n);
		//open sites n times before checking, because can't percolate at < n
		for (int i = 0; i < n; i++) {
			int row = StdRandom.uniformInt(1, n);
			int column = StdRandom.uniformInt(1, n);
			open(row, column);
		}
		
		//open sites until percolates
		while (!percolates()) {
			int row = StdRandom.uniformInt(1, n);
			int column = StdRandom.uniformInt(1, n);
			open(row, column);
		}
	}
}
