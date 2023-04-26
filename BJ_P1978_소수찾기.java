import java.util.Scanner;

public class BJ_P1978_소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt=0;
		for(int i=0; i<n; i++) {
			int k = sc.nextInt();
			if(k==1) continue;
			else {
				for(int j=2; j<=k; j++) {
					if(j==k) cnt++;
					if(k%j==0) break;
				}
			}
				
		}
		System.out.println(cnt);
	}

}
