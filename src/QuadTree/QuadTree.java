package QuadTree;

import java.util.*;
import java.io.*;

public class QuadTree {
	
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int Num = Integer.parseInt(bf.readLine());
		
		arr = new int[Num][Num];
		
		for(int i = 0; i < Num; i++) {
			String st = bf.readLine();
			for(int j = 0; j < Num; j++) {
				arr[i][j] = st.charAt(j) - '0';
			}
		}
		
		recur(0, 0, Num);
		
	}
	
	public static void recur(int left, int right, int N) {
		
		if(par(left, right, N)) {
			if(arr[left][right] == 0) {
				System.out.print(0);
			}
			else System.out.print(1);
			return;
		}
		
		int size = N / 2;
		System.out.print("(");
		recur(left, right, size);
		recur(left, right + size, size);
		recur(left + size, right, size);
		
		recur(left + size, right + size, size);
		System.out.print(")");
		
	}
	
	public static boolean par(int left, int right, int N) {
		
		int no = arr[left][right];
		
		for(int i = left; i < left + N; i++) {
			for(int j = right; j < right + N; j++) {
				if(arr[i][j] != no) return false;
			}
		}
		return true;
	}

}
