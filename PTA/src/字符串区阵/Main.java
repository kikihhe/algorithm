package 字符串区阵;

import java.util.Scanner;

public class Main {
	private static char[] answer = "LANQIAO".toCharArray();
	private static int n = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = 8;
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] =  scanner.next().toCharArray();
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = process(arr, i, j, 0);
			}
		}
		System.out.println(result);
		
	}
	private static int process(char[][] arr, int i, int j, int index) {
		if(i < 0 || i >= n || j < 0 || j >= n) {
			return 0;
		}
		if (index == 7) return 1;
		int count = 0;
		if(arr[i][j] == answer[index]) {
			count = count + process(arr, i - 1, j, index + 1)
						  + process(arr, i + 1, j, index + 1)
						  + process(arr, i, j - 1, index + 1)
						  + process(arr, i, j + 1, index + 1)
						  + process(arr, i - 1, j - 1, index + 1)
						  + process(arr, i - 1, j + 1, index + 1)
						  + process(arr, i + 1, j - 1, index + 1)
						  + process(arr, i + 1, j + 1, index + 1);
		} else {
			return 0;
		}
		return count;
		
	}
}
