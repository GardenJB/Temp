package hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_P1267_작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//test case 반복
		for(int tc=1; tc<=10; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+ " ");
			//정점의 수 v, 간선의 수 e
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			//진입 수
			int[] in = new int[v+1];
			int[][] map = new int[e][2];
			for(int i=0; i<e; i++) {
				int fr = sc.nextInt();
				int to = sc.nextInt();
				map[i][0] = fr;
				map[i][1] = to;
				
				in[to]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			//시작점
			for(int i=1; i<v+1; i++) {
				if(in[i]==0) q.add(i);
			}
			
			while(!q.isEmpty()) {
				int k = q.poll();
				sb.append(k+" ");
				for(int i=0; i<e; i++) {
					if(map[i][0]==k) {
						in[map[i][1]]--;
						if(in[map[i][1]]==0) q.add(map[i][1]);
					}
				}
			}
			System.out.println(sb);
		}
		sc.close();
	}
}
