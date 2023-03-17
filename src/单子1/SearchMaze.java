package 单子1;

class Untitled {
	static int[][] path = new int [21][21];
	public static void main(String[] args) {
		String[] maze = MazeMaker.makeMaze();
		for (int i = 0; i < maze.length; i++) {
			System.out.println(maze[i]);
		}
		process(1,1,1);
		
		for (int i = 0; i < 21; i++) {
			for(int j = 0;j < 21; j++){
				System.out.printf("%3d",path[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void process(int x, int y, int soFar){
		
	}
}