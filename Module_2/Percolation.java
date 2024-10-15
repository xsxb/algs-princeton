import edu.princeton.cs.algs4.StdRandom;

//TODO: Keep track of trees and tree sizes
//	Move main to PercolationStats

public class Percolation{
	
	static int n;		//Grid size
	static int[][] grid; 	//Matrix of sites/nodes: 0->closed; 1->open; 2->full
	static int size;	//n*n
	static int p;		//Site vacancy probability
	int[][] gridId;		//Root IDs of sites/nodes
	int[][] treeSize;	//Size of connected component tree structure

	//Initialize n-by-n grid, all sites blocked
	public Percolation(int n) {
		grid = new int[n][n];
		gridId = new int[n][n];
		
		grid[0][0] = 1;		//Virtual top node
		grid[n+1][n+1] = 1;	//Virtual bottom node
		gridId[0][0] = 0;
		gridId[n+1][n+1] = n+1;


		int id = 1;
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=n; j++) {
				grid[i][j] = 0;
				gridId[i][j] = id;
				id++;
			}
		}
	}

	//Open site (row, col)
	public void open(int row, int col) {
		grid[row][col] = 1;
	}

	//Is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		//Error handling
		if (0 <= row || row > n  || 0 <= col || col > n) {
			throw new IllegalArgumentException();
		}	
		return (grid[row][col] == 1) ? true : false;
	}

	//Is the site (row, col) full?
	public boolean isFull(int row, int col) {
		//Error handling
		if (0 <= row || row > n  || 0 <= col || col > n) {
			throw new IllegalArgumentException();
		}	
		return (grid[row][col] == 1) ? true : false;
	}

	//Returns number of open sites
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

	//Returns a 4 row array value[row,col]: top, left, right, bottom neighbour
	private int[][] getNeighbours(int row, int col) {
		int[][] neighbours = {
			{ grid[row-1][col], row-1, col },
			{ grid[row][col-1], row, col-1 },
			{ grid[row][col+1], row, col+1 }, 
			{ grid[row+1][col], row+1, col }
		};
		return neighbours;
	}

	private void union(int[] source, int[] dest) {}

	//Connect trees
	private void connect(int row, int col) {
		int[][] neighbours = getNeighbours(row, col);
		for (int i = 0; i < neighbours.length; i++) {
			if (neighbours[i][0]==1) {
				int y = neighbours[i][1];
				int x = neighbours[i][2];
				int[] source = new int[2];
				int[] dest = new int[2]; 
				if (treeSize[row][col] > treeSize[y][x]) {
				}
				union(source, dest);
			}
		}
	}

	//Test client
	public static void main(String[] args) {
		
		//Read arguments
		n = Integer.parseInt(args[0]);
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
	
		//TODO: Move below code to PercolationStats
		//Init percolation object
		Percolation percolation = new Percolation(n);
		grid = percolation.grid;
		size = n*n;

		//Open sites n times before checking, because can't percolate at T < n
		for (int i = 0; i < n; i++) {
			int row = StdRandom.uniformInt(1, n);
			int column = StdRandom.uniformInt(1, n);
			percolation.open(row, column);
		}
		
		//Open sites until percolates
		while (!percolation.percolates()) {
			int row = StdRandom.uniformInt(1, n);
			int column = StdRandom.uniformInt(1, n);
			percolation.open(row, column);
			//percolation.connect(row, column);
		}
	}
}
