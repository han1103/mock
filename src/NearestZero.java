import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/interview/2/
*/
public class NearestZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = new int[][] { {0,0,0}, {0,1,0}, {0,0,0} };		
		//int[][] matrix = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] matrix = new int[][] {{0},{0},{0},{0},{0}};
		//int[][] matrix = new int[][] {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};		
		int[][] result = new NearestZero().updateMatrix(matrix);

		for (int[] row : result) {
			for (int num : row)
				System.out.print(num + " ");
			System.out.println();
		}
	}

	boolean[][] visited;
	int dimX;
	int dimY;
	
	class Coordinate {
		int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;			
		}
	}
	
	//BFS from (i,j)
	void calculate(int[][] result, int[][] matrix, int i, int j) {
		if(matrix[i][j] == 0) {
			result[i][j]=0;			
			return;
		}
		int depth = -1;
		List<Coordinate> border = new LinkedList<>();
		border.add(new Coordinate(i, j));
				
		while(!border.isEmpty()) {
			depth++;
			List<Coordinate> nextBorder = new LinkedList<>();
			for(Coordinate coordinate : border) {
				if(matrix[coordinate.x][coordinate.y]==0) {
					result[i][j]=depth;
					return;
				}				
				int x = coordinate.x;
				int y = coordinate.y;
				if(x>0 && !visited[x-1][y])
					nextBorder.add(new Coordinate(x-1, y));
				if(x<dimX-1 && !visited[x+1][y])
					nextBorder.add(new Coordinate(x+1, y));
				if(y>0 && !visited[x][y-1])
					nextBorder.add(new Coordinate(x, y-1));
				if(y<dimY-1 && !visited[x][y+1])
					nextBorder.add(new Coordinate(x, y+1));									
			}
			border = nextBorder;
		}
		
	}
	
	void clearVisited() {
		for(int i=0; i<dimX; i++)
			for(int j=0; j<dimY; j++)
				visited[i][j]=false;
	}
	
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null)
			return null;
		dimX = matrix.length;
		if (dimX == 0)
			return matrix;
		if(matrix[0]==null)
			return matrix;
		dimY = matrix[0].length;

		int[][] result = new int[dimX][];
		for (int i = 0; i < dimX; i++) {
			result[i] = new int[dimY];
			for (int j = 0; j < dimY; j++)
				result[i][j] = -1;
		}

		visited = new boolean[dimX][];
		for(int k=0; k<dimX; k++)
			visited[k] = new boolean[dimY];
		
		for (int i = 0; i < dimX; i++)
			for (int j = 0; j < dimY; j++) {
				clearVisited();
				calculate(result, matrix, i, j);
			}

		return result;
	}
}
