package d0405;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_P1629_���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		//��� �� a
		int a = Integer.parseInt(st.nextToken());
		//���� �� b
		int b = Integer.parseInt(st.nextToken());
		//���� c
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(mul(a, b, c));
	}
	
	private static long mul(int a, int b, int c) {
		if(b==1)
			return a %c;
		if(b%2 !=0) {
			long k = mul(a, b-1, c);
			return k * a %c;
		}
			
		else {
			long k = mul(a, b/2, c);
			return k * k %c;
		}
			
	}

}
