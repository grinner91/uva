//429 - Word Transformation	 0.240s/1404(6)
import java.util.Scanner;

class Main_429_WordTransformation_BFS {
	final int MaxWords = 250, MaxWordLenght = 15;
	String[] dictionary;
	String word, source, dest;
	int[] wordLens;	
	int shortestSteps, wordCount;
	int[][] graph;

	/**********BFS**************/
	int[] Q = new int [MaxWords * MaxWords * MaxWords];
	int[] cost;
	boolean[] visited;
	int front, tail;

	void enq(int n){
		Q[tail++] = n;
	}
	int deq(){
		return Q[front++];
	}

	void reset(){
		visited = new boolean[MaxWords];
		cost = new int[MaxWords];
		front = tail = 0;
		for(int i = 0; i < MaxWords; i++)
			cost[i] = -1;
	}

	void bfsWordTransformation(int src, int target)
	{
		shortestSteps = -1;
		if(src == -1 || target == -1) return;		

		reset();		
		visited[src] = true;
		cost[src] = 0;
		enq(src);

		while(front != tail){

			int u = deq();
			if(u == target) break;

			for(int v = 0; v < wordCount; v++){
				if(u == v || visited[v] == true || graph[u][v] == 0) continue;
				if(graph[u][v] == 1 && (cost[v] == -1 || cost[u] + 1 < cost[v])){
					enq(v);
					visited[v] = true;
					cost[v] = cost[u] + 1;
				}
			}
		}

		shortestSteps = cost[target];
	}

	/*************************/	
	void initValues(){
		dictionary = new String[MaxWords];
		wordLens = new int[MaxWords];
		graph = new int[MaxWords][MaxWords];

	}

	void setPath(String w1, String w2){	

		int len1 =  w1.length(), len2 = w2.length();

		if(len1 != len2) return;

		int count = 0;	

		for(int i = 0; i < len2; i++){
			if(w1.charAt(i) != w2.charAt(i)){
				count++;
			}
		}	

		if(count == 1)
		{
			int u = getWordNodeIndex(w1);
			int v = getWordNodeIndex(w2);
			if(u == -1 || v==-1) return;
			
			graph[u][v] = 1;
			graph[v][u] = 1;
		}

	}

	int getWordNodeIndex(String word){

		for(int i = 0; i < wordCount; i++){			
			if(word.equalsIgnoreCase(dictionary[i]))
				return i;
		}

		return -1;
	}

	public void solve(){
		try {
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();		

		sc.nextLine();
		sc.nextLine();

		for(int tc = 0; tc < testCases; tc++){	

			initValues();

			wordCount = 0;
			while(true){				
				word = sc.nextLine().trim();
				if(word.equalsIgnoreCase("*")) break;

				dictionary[wordCount] = word;
				wordLens[wordCount] = word.length();
				wordCount++;
			}			

			for(int i = 0; i < wordCount -1; i++){
				for(int j = i+1; j < wordCount; j++){	
					setPath(dictionary[i], dictionary[j]);				
				}
			}

			//sc.nextLine();
			//sc.nextLine();

			while(true) {
				String str = sc.nextLine().trim();
				if(str == null || str.isEmpty()) break;

				source = str.split(" ")[0].trim();
				dest =  str.split(" ")[1].trim();

				shortestSteps = -1;				
				bfsWordTransformation(getWordNodeIndex(source),getWordNodeIndex(dest));

				if(shortestSteps > 0 )
					System.out.println( new String(source) + " " + new String(dest) + " " +  shortestSteps);
				else 
					System.out.println( new String(source) + " " + new String(dest) + " " +  shortestSteps);				
			}
			System.out.println();
		}

		}catch(Exception e){
			
		}
	}
	public static void main(String[] args) {
		(new Main_429_WordTransformation_BFS()).solve();

	}

}

/*
2

aa
bb
ac
 *
aa ac

aa
ab
bb
 *
aa bb


output

aa ac 1

aa bb 2



Sample Input
4

dip
lip
mad
map
maple
may
pad
pip
pod
pop
sap
sip
slice
slick
spice
stick
stock
 *
spice stock
may pod

dip
lip
mad
map
mapl
maple
may
pad
pip
pod
pop
sap
sip
slice
slick
spice
stick
stock
 *
spice slick
may mad
map maple
maple map
map map

mapl
maple
mba
mbal
mbale
mbple
 *
mba mapl

map
mapl
maple
mba
mbal
mbale
mbp
mbple
 *
mba mapl



Sample Output

spice stock 4
may pod 3

spice slick 2
may mad 1
map maple -1
maple map -1
map map 0

mba mapl -1

mba mapl -1



 */
