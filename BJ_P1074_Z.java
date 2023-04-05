//틀림....ㅜㅜ

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P1074_Z {
	
	static int n, cnt, r, c;
	static int[] val;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		//배열 크기n
		n = Integer.parseInt(st.nextToken());
		//찾을 수의 행 r, 열c
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		//어느 4분면에 속하는지....계속 반복
		//1 사분면마다 2^(n-1)*2^(n-1)개 있음.
		
		//2의 제곱 수 저장
		val = new int[16];
		val[0]=1;
		for(int i=1; i<=n; i++) {
			val[i]=val[i-1]*2;
		}
		
		cnt =0;
		wh(0, 0, n);
		
		System.out.println(cnt);
	}
	
	//몇 분면인지 찾기
	private static void wh(int x, int y, int n) {
	
		//끝점을 비교하기
		int pre_x = x+val[n-1]-1;
		int pre_y = y+val[n-1]-1;
		
		if(r<=pre_x && c<=pre_y) {
			cal(1, n, x, y);
		}else if(r<=pre_x) { 
			cal(2, n, x, y);
		}else if(c<=pre_y) { 
			cal(3, n, x, y);
		}else {
			cal(4, n, x, y);
		}
	}
	//누적된 순번 계산하기
	private static void cal(int w, int n, int x, int y) {
		if(n==1) {
			cnt+= w;
			return;
		}
		
		cnt += (w-1)*val[n-1];
		//시작점 찾아 넘기기
		switch(w) {
		case 1:
			wh(x, y, n-1);
			break;
		case 2:
			wh(x, y+val[n-1], n-1);
			break;
		case 3:
			wh(x+val[n-1], y, n-1);
			break;
		case 4 :
			wh(x+val[n-1], y+val[n-1], n-1);
			break;
		}

		
		
	}

}
