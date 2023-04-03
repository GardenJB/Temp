package hw;

import java.util.Scanner;
import java.util.Stack;

public class SW_P1267_�۾�����_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case �ݺ�
		for(int tc=1; tc<=10; tc++) {
			
			//���� �� v, ���� �� e
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			//���� ���� ����
			Stack<Integer> st = new Stack<>();
			//���� ����
			Stack<Integer> temp = new Stack<>();
			//Ȯ�� �迭
			boolean[] ch = new boolean[v+1];
			//���� ��
			int[] in = new int[v+1];
			int[][] map = new int[e][2];
			for(int i=0; i<e; i++) {
				map[i][0]= sc.nextInt();
				map[i][1] = sc.nextInt();
				
				in[map[i][1]]++;
				
			}
			
			for(int i=1; i<=v; i++) {
				if(in[i]==0) {
					st.add(i);
					ch[i]=true;
				}
			}
			
			while(!st.isEmpty()) {
				int k = st.pop();
				for(int i=0; i<e; i++) {
					if(map[i][0]==k && !ch[map[i][1]]) {
						in[map[i][1]]--;
						if(in[map[i][1]]==0) {
							st.add(map[i][1]);
							ch[map[i][1]]=true;
						}
					}
				}
				temp.add(k);
			}
			System.out.print("#"+tc+" ");
			Stack<Integer> ans = new Stack<>();
			while(!temp.isEmpty()) {
				ans.add(temp.pop());
			}
			while(!ans.isEmpty()) {
				System.out.print(ans.pop()+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
