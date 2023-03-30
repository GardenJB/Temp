package day0330_프림_다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다잌스트라_우선순위큐 {
	static class Node {
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E; //V : 정점 , E: 간선
	static List<Node>[] adjList; //인접리스트
	static int[] dist; //최단 길이를 저장할 배열
	
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i = 0 ; i<V; i++)
			adjList[i] = new ArrayList<>();
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		//입력 받기
		for(int i = 0 ; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			//유향 그래프였다.
			adjList[A].add(new Node(B, W)); //인접리스트 노드 추가
			//아래의 한줄 코드가 위의 4줄을 커버하지만 익숙치 않은 상황이라면 자제할것
//			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
	}
	
	
	private static void dijkstra(int start) {
		//우선순위 큐를 이용해서 집어 넣을 때 그냥 때려넣지 말고 
		//갱신한 값을 만들어서 새로운 노드를 집어넣어라.
		//여기를 비워놓고 말로 떼운다는것은 무슨 의미?
		//ㅎ
		
		
		
	}


	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
