import java.util.Scanner;
import java.util.Stack;

public class BJ_P1874_스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//수 n
		int n = sc.nextInt();
		
		
		//출력 순서 수열
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		int k=0;
		int i=1;
		Stack<Integer> st = new Stack<>();
		while(true) {
			if(!st.isEmpty() && st.peek()==arr[k]) {
				st.pop();
				sb.append("-\n");
				k++;
			}else {
				st.add(i);
				i++;
				sb.append("+\n");
				if(i>n) break;
			}
		}
		
		while(!st.isEmpty()) {
			if(st.peek()==arr[k]) {
				st.pop();
				sb.append("-\n");
				k++;
			}else break;
		}
		
		if(!st.isEmpty()) {
			sb = new StringBuilder();
			sb.append("NO");
		}
		System.out.println(sb);
		
	}

}
