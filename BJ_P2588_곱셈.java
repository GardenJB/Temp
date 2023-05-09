import java.util.Scanner;

public class BJ_P2588_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		String b = sc.next();
		
		int sum=0;
		for(int i=b.length()-1; i>=0; i--) {
			int c = (int) (b.charAt(i)-'0');
			System.out.println(c*a);
			if(i==b.length()-1) sum+=c*a;
			//**10의 n제곱
			else sum+=c*a*Math.pow(10, b.length()-1-i);
			
		}
		System.out.println(sum);
		
		
		
	}

}
