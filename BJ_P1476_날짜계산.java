package d0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_P1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//e, s, m
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> eq = new LinkedList<Integer>();
		Queue<Integer> sq = new LinkedList<>();
		Queue<Integer> mq = new LinkedList<>();
		
		for(int i=1; i<=15; i++) {
			eq.add(i);
		}
		for(int i=1; i<=28; i++) {
			sq.add(i);
		}
		for(int i=1; i<=19; i++) {
			mq.add(i);
		}
		int k=1;
		while(true) {
			int a = eq.poll();
			int b = sq.poll();
			int c = mq.poll();
			if(a==e && b==s && c==m) break;
			k++;
			eq.add(a);
			sq.add(b);
			mq.add(c);
		}
		
		System.out.println(k);
	}

}
