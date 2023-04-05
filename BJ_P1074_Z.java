package d0405;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P1074_Z {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		//배열 크기n
		int n = Integer.parseInt(st.nextToken());
		//찾을 수의 행 r, 열c
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		//어느 4분면에 속하는지....계속 반복
		//1 사분면마다 2^(n-1)*2^(n-1)개 있음.
		
		//2의 제곱 수 저장
		int[] val = new int[16];
		for(int i=0;)
	}
	
	//몇 분면인지 찾기
	private static void wh() {
		
	}
	//누적된 순번 계산하기
	private static void cal() {
		
	}

}
