//11080 - Place the Guards
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2021
//  Bipartite Graph Check

#include <stdio.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;


#define UNVISITED -1
#define WHITE 1
#define BLACK 0


int main11080()
{

	int tc, testcase, V, E;
	int u,v,x;

	cin >> testcase;

	for(int tc = 0; tc < testcase; tc++)
	{
		cin >> V;
		cin >> E;

		vector<vector<int>> graph;
		graph.assign(V,vector<int>());

		for(int i=0; i < E; i++)
		{
			cin >> u;
			cin >> v;

			if( u >= V || v >= V) continue;

			graph.at(u).push_back(v);
			graph.at(v).push_back(u);
		}

		vector<int> colors;
		colors.assign(V, UNVISITED);

		bool isBipartite = true;
		int  guards=0;

		for(int n = 0; n < V; n++)
		{
			if( ! isBipartite ) break;
			if( colors[n] != UNVISITED ) continue;
			if( graph[n].size() == 0 ) { guards++; continue; }

			int whitecount = 0, blackcount = 0;
			queue<int> q;				
			//source vertex/node
			q.push(n);
			//1 - white color, 0 - black color
			colors[n] = BLACK;
			blackcount++;

			while(!q.empty())
			{
				u = q.front(); q.pop();
				for(int i = 0; i < graph[u].size(); i++)
				{
					v = graph[u][i];
					if(colors[v] == UNVISITED)
					{
						q.push(v);
						colors[v] = ( colors[u] + 1 ) % 2;
						if(colors[v] == WHITE ) whitecount++;
						else  if(colors[v] == BLACK) blackcount++;
					}
					else if(colors[u] == colors[v])
					{
						isBipartite = false;
					}
				}				
			}

			if(isBipartite) guards += min( whitecount, blackcount );
		}

		if(isBipartite ) cout << guards << endl; 
		else cout << -1 << endl;
	}

	return 0;
}


/*

//11080 - Place the Guards

ample Input                             
5
4 2
0 1
2 3
5 5
0 1
1 2
2 3
0 4
3 4
5 3
0 1
3 2
2 1
1 0
3 0

Output for Sample 
2
-1
3
1
3




1
5 6
0 1
0 2
1 3
2 3
4 0
5 0

*/

