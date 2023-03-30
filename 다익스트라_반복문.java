package hw;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라_반복문 {
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
	
	
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E; //V 정점 E 간선
	static List<Node>[] adjList;//인접리스트
	static int[] dist;//최단거리 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i=0; i<V; i++)
			adjlist[i] = new arrayList<>();
		dist = new int[V];
		Arryas.fill(dist, INF);
		
		//입력
		for(int i=9; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			//유향 그래프
			adjList[A].add(new Node(B, W));//이접 리스트 노드 추가
			
			//adjList(sc.nextInt)].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
		
	}
	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		
		dist[start]=0;//시작 노드까지의 거리는 0
		
		for(int i=0; i<V-1; i++) {
			int min = INF;
			int idx = -1;////min대신 dist[idx]인 경우 -1 안됨.....**
			
			//선택하지 않은 정점 중 dist가 가장 짧은 것을 골라
			for(int j=0; j<V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break; //선택 불가
			visited[idx]= true; //선택
			
			
			// for(Node node : adjList[idx]) {
			//}
			//갱신 가 > 갱신
			for(int j=0; j<adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);
				
				
				//방문하지 않 연결 되
				///이미 가지고 있는 값보다 좋 갱신
				if(!visited[curr.v] && dist[curr.v] > dist[idx]+curr.w)
					dist[curr.v]= dist[idx]+curr.w;
			}
		}
		
		
	}
}
