package 单子1;

import java.util.*;

public class MazeMaker {
	
	private static String[] maze = new String[21]; 
	
	public static void main(String[] args) {
		makeMaze();
		showMaze();
	}
	
	public static String[] makeMaze() {
		for(int i = 0; i < maze.length; i++) {
			maze[i] = "XXXXXXXXXXXXXXXXXXXXX";
		}
		makePath(1,1);
		maze[1] = maze[1].substring(0,1) + "S" + maze[1].substring(2);
		maze[maze.length-2] = maze[maze.length-2].substring(0, maze[0].length()-2) + "F" + maze[maze.length-2].substring(maze[0].length()-1);
		//showMaze();
		return maze;
	}
	
	private static void showMaze() {
		for(int i = 0; i < maze.length; i++) {
			System.out.println(maze[i]);
		}
	}
	
	private static void makePath(int x, int y) {
		maze[y] = maze[y].substring(0, x) + " " + maze[y].substring(x+1); 
		ArrayList<Integer> dir = new ArrayList<Integer>();
		dir.add(0);dir.add(1);dir.add(2);dir.add(3);
		Collections.shuffle(dir);
		while(dir.size() > 0) {
			int d = dir.remove(0);
			if(d == 0 && y - 2 > 0 && maze[y-2].charAt(x) == 'X') {
				maze[y-1] = maze[y-1].substring(0, x) + " " + maze[y-1].substring(x+1);
				makePath(x, y-2);
			}
			if(d == 1 && x + 2 < maze[0].length() && maze[y].charAt(x+2) == 'X') {
				maze[y] = maze[y].substring(0, x+1) + " " + maze[y].substring(x+2);
				makePath(x+2, y);
			}
			if(d == 2 && y + 2 < maze.length && maze[y+2].charAt(x) == 'X') {
				maze[y+1] = maze[y+1].substring(0, x) + " " + maze[y+1].substring(x+1);
				makePath(x, y+2);
			}
			if(d == 3 && x - 2 > 0 && maze[y].charAt(x-2) == 'X') {
				maze[y] = maze[y].substring(0, x-1) + " " + maze[y].substring(x);
				makePath(x-2, y);
			}
		}
	}

}
