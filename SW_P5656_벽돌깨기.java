package hw;

import java.util.Arrays;
import java.util.Scanner;

public class SW_P5656_�������� {
	
	static int[] dx = { 0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int n, w, h, min_c;
	static int[][] map, temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case �ݺ�
		int t = sc.nextInt();
		for(int tc =1; tc<=t; tc++) {
			
			//���� �� n
			n = sc.nextInt();
			//�迭 ũ�� w, h
			w = sc.nextInt();
			h = sc.nextInt();
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			min_c = Integer.MAX_VALUE;
			//���� ������
			b(0);
//			for(int i=0; i<w; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
			
			System.out.printf("#%d %d\n", tc, min_c);
		}
		sc.close();
	}
	//*******��ġ
//	temp = new int[h][w];
//	for(int i=0; i<h; i++) {
//		temp[i] = map[i].clone();
//	}
	//���� ������
	private static void b(int k) {
		
		//n�� ������ ���� ��� �� ��
		if(k==n) {
			int cnt=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(temp[i][j] !=0 )
						cnt++;
				}
			}
			min_c = min_c<cnt ? min_c : cnt;
			return;
		}
		
		boolean ch = false;
		//����� �ִ� �� ���� �� ĭ�� ġ�鼭 ��
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(temp[i][j]!=0) {
					ch = true;
					bl(i, j, temp[i][j]);
					ar();
					b(k+1);
				}
			}
		}
		if(!ch) {
			min_c=0;
			return;
		}
	}
	//��� ����
	private static void bl(int i, int j, int k) {
		//����
		temp[i][j]=0;
		//��� ĭ�� ���� ������
		for(int b=0; b<k; b++) {
			//�����¿�
			for(int a =0; a<4; a++) {
				if(i+dx[a]*b<0 || i+dx[a]*b>=h || j+dy[a]*b<0 || j+dy[a]*b>=w ) continue;
				if(temp[i+dx[a]*b][j+dy[a]*b]==0) continue;
				//��� ���� �ִ� ��� �ٽ� ����
				bl(i+dx[a]*b, j+dy[a]*b, temp[i+dx[a]*b][j+dy[a]*b]);
			}
		}
	}
	
	//����*****0�� �߰��� ������ �ȵ�
	private static void ar() {
		
		for(int j=0; j<w; j++) {
			//�Ʒ����� ���ϸ鼭 ���� ������ ä���ش�
			int idx = h-1;
			for(int i=h-1; i>=0; i--) {
				if(temp[i][j]!=0) {
					temp[idx][j]=temp[i][j];
					idx--;
				}
			}
			
			//�� ���� �ٵ��� ������ ä�� ���� �κ��� ��� 0���� �ٲٱ�
			if(idx>=0) {
				for(int i=idx; i>=0; i--) {
					temp[i][j]=0;
				}
			}
			
		}
	}

}
