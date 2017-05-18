//Accepted
import java.util.Scanner;

class Node{
	int indegree;
	int data;
	Node next;
	
	public	Node(int data){
		this.data = data;
		indegree = 0;
		next = null;

	}
}


class Main_11686_Pickupsticks_LinkedList_Accepted {

	public static void main(String[] args) {
		int N,M;
		Scanner sc = new Scanner(System.in);

		while(true){
			N = sc.nextInt();
			M = sc.nextInt();
			if(0 == N && 0 == M) break;

			Node[] nodes = new Node[N+2];
			for(int i= 1; i <= N; i++)
				nodes[i] = new Node(i);

			Node current;
			int u,v;
			for(int i=1; i <= M; i++){

				u = sc.nextInt();
				v = sc.nextInt();

				current =	nodes[u];
				while(current.next != null) 
					current = current.next;
				current.next = new Node(v);
				nodes[v].indegree += 1;					
			}

			int[] orderedNodes = new int[N+2];
			int count = 1;
			boolean isZeroIndegFound;
			while(true){
				isZeroIndegFound = false;
				for(int i=1; i <= N; i++){
					current = nodes[i];
					if(current.indegree == 0){
						isZeroIndegFound = true;
						current.indegree = -1;
						orderedNodes[count++] = i;						
						current = nodes[i].next;
						while(current != null){
							nodes[current.data].indegree -= 1;
							current = current.next;
						}
					}
				}
				if(!isZeroIndegFound) break;
			}

			if(N+1 == count){
				for(int i=1; i<=N; i++)
					System.out.println(orderedNodes[i]);

			}
			else
			{
				System.out.println("IMPOSSIBLE");
			}
		}
	}

}

/*
 Sample Input
3 2
1 2
2 3
0 0
Sample Output
123


 */
