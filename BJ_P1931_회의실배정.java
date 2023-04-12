package d0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_P1931_회의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//회의 수 n 반복
		int n = Integer.parseInt(st.nextToken());
		
		int max_t = 0;
		int[][] meet = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			meet[i][0] = Integer.parseInt(st.nextToken());
			meet[i][1] = Integer.parseInt(st.nextToken());
			if(meet[i][1]>max_t) max_t = meet[i][1];
		}
		
		//시작 순서대로 만들기
		Arrays.sort(meet, (o1, o2) -> o1[0]-o2[0]);
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0);
		for(int i=1; i<n; i++) {
			if(meet[list.peekLast()][1]>meet[i][1]) {
				int a = meet[list.peekLast()][0];
				int b = meet[list.peekLast()][1];
				int c = b-a;
				int a1 = meet[i][0];
				int b1 = meet[i][1];
				int c1 = b1-a1;
				if(c>c1) {
					list.poll();
					list.add(i);
				}
			}
			if( meet[list.peekLast()][1]<=meet[i][0])
				list.add(i);
		}
		
		System.out.println(list.size());
		
	}

}
