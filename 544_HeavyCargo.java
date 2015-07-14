/**	 
	 * 544 - Heavy Cargo
	 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=485 
	 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;


class Main_544_HeavyCargo {

	
	public static void main(String[] args) {
		final int INF = Integer.MIN_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);

		Map<String, Integer> cities;
		String line, start, end;
		int numVertexes, numEdges, load, testCase=0,source, dest;
		int[][] graph;

		while(true)
		{
			testCase++;

			numVertexes = sc.nextInt();
			numEdges = sc.nextInt();

			if(numVertexes ==0 ) break;

			cities =  new Hashtable<String, Integer>(numVertexes);
			graph = new int[numVertexes+1][numVertexes+1];

			for(int i=0; i < numVertexes; i++)
				for( int j=i; j < numVertexes; j++)
					graph[i][j] = graph[j][i] = INF;
			
			//skip empty line
			sc.nextLine();
			
			for(int i=0; i<numEdges; i++)
			{
				line = sc.nextLine();

				start = line.split(" ")[0];
				end = line.split(" ")[1];
				load = Integer.parseInt(line.split(" ")[2]);
				
				if(! cities.containsKey(start)) cities.put(start, cities.size());
				
				if(! cities.containsKey(end)) cities.put(end, cities.size());
				
				graph[cities.get(start)][cities.get(end)] = load;	
				graph[cities.get(end)][cities.get(start)] = load;
			}


			line = sc.nextLine();

			source = cities.get( line.split(" ")[0]);
			dest = cities.get(line.split(" ")[1]);

			///Floyd-Warshall - MaxiMin			
			for(int k=0; k < numVertexes; k++)
				for(int i=0; i < numVertexes; i++)
					for(int j=0; j < numVertexes; j++)
					{
						if(graph[i][k] != INF && graph[k][j] != INF)
						{
							graph[i][j] = Math.max(graph[i][j], Math.min(graph[i][k], graph[k][j]));
						}
					}

			System.out.printf("Scenario #%d%n",testCase);
			System.out.printf("%d tons%n%n",graph[source][dest]);
		}

	}

}


/*

Sample Input 

4 3
Karlsruhe Stuttgart 100
Stuttgart Ulm 80
Ulm Muenchen 120
Karlsruhe Muenchen
5 5
Karlsruhe Stuttgart 100
Stuttgart Ulm 80
Ulm Muenchen 120
Karlsruhe Hamburg 220
Hamburg Muenchen 170
Muenchen Karlsruhe
0 0
Sample Output 

Scenario #1
80 tons

Scenario #2
170 tons



 * 
 * */
