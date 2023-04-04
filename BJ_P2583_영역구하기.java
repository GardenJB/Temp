package hw;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_P2583_�������ϱ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//������ ���� m, n , ���簢�� �� k
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//������ �迭
		int[][] map = new int[n][m];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int a=x1; a<x2; a++) {
				for(int b=y1; b<y2; b++) {
					map[a][b]=1;		
				}
			}	
		}
		
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] ch = new boolean[n][m];
		int cnt =0;
		List<Integer> ans = new LinkedList<>();
		//bfs
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				//���� ����
				int size =0;
				//���� �߰��ϸ�
				if(map[i][j]==0 && !ch[i][j]) {
					//Ȯ��, ���� ����
					ch[i][j]=true;
					cnt++;
					size++;
					int[] temp = new int[2];
					temp[0]=i;
					temp[1]=j;
					q.add(temp);
					
					//��Ÿ
					int[] dx = {0, -1, 0, 1};
					int[] dy = {-1, 0, 1, 0};
					//Ž��
					while(!q.isEmpty()) {
						temp = q.poll();
						for(int a=0; a<4; a++) {
							int x = temp[0]+dx[a];
							int y = temp[1]+dy[a];
							if(x<0 || y<0 || x>=n || y>=m) continue;
							if(map[x][y]==0 && !ch[x][y]) {
								ch[x][y]=true;
								size++;
								int[] arr = new int[2];
								arr[0]=x;
								arr[1]=y;
								q.add(arr);
							}
						}		
					}
					ans.add(size);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(cnt);
		for(int a : ans) {
			System.out.print(a+" ");
		}
		
	}

}
