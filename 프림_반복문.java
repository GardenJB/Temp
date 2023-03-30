package hw;

import java.util.Scanner;

public class 프림_반복문 {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); //V : 정점의 개수, 0부터 시작 한다!
		int E = sc.nextInt(); //E : 간선의 수
		
		int[][] adjArr = new int[V][V];
		
		for(int i = 0 ; i<E; i++) {
			int A = sc.nextInt();//시작
			int B = sc.nextInt();//도착
			int W = sc.nextInt();//가중치
			
			//무향 그래프
			adjArr[A][B] = W;
			adjArr[B][A] = W;
		}//입력끝		
		
		//방문처리
		boolean[] visited = new boolean[V];
		int[] p = new int[V]; //어디서 왔는지
		int[] dist = new int[V]; //가장 작은 값
		
		//dist는 아주 큰 값으로 초기화
		for(int i=0; i<V; i++) {
			dist[i]= INF;
		}
		//Arrays.fill(dist, INF);
		
		//임의의 한점 선택
		dist[0]=0;//0번 인덱스 0번 정점
		p[0]=-1;//초기화
		
		int ans =0;
		
		//V, V-1 둘 다 돌아도 상관 없 프림 동작
		for(int i=0; i<V-1; i++) {
			//1.가장 작은 값
			int min =INF;
			int idx=-1;
			//아직 안 뽑은 값 중 선택
			for(int j=0; j<V; j++) {
				if(!visited[j] && dist[j]<min) {
					min=dist[j];
					idx=j;
				}
			}//idx = 가장 작은 값 가지고 있는 정점 뽑
			visited[idx]=true;//선택
			//ans +=dist[idx];
			
			//2. 뽑 정점 이용해서 갱신 가능하면 갱신
			//인접 행렬이니까 모든 정점을 확인 하는 것
			for(int j=0; j<V; j++) {
				if(!visited[j] && adjArr[idx][j] !=0 && dist[j]>adjArr[idx][j]) {
					dist[j]=adjArr[idx][j];
					p[j]=idx;
				}
			}
		}
		for(int i=0; i<V; i++) {
			ans +=dist[i];
		}
		System.out.println(ans);
	}
	
	
	static String input = "7 11\r\n" + 
			"0 1 32\r\n" + 
			"0 2 31\r\n" + 
			"0 5 60\r\n" + 
			"0 6 51\r\n" + 
			"1 2 21\r\n" + 
			"2 4 46\r\n" + 
			"2 6 25\r\n" + 
			"3 4 34\r\n" + 
			"3 5 18\r\n" + 
			"4 5 40\r\n" + 
			"4 6 51\r\n" + 
			"\r\n";
}
