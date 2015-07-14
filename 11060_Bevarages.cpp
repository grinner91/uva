//11060 - Beverages
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2001

//solution - Topological Sort

#include <stdio.h>
#include <iostream>
#include <map>
#include <vector>
#include <queue>
#include <string>
//#include <conio.h>

using namespace std;

typedef pair<string, int> namval;
typedef pair<int,string> valnam;
typedef vector<int> vi;

struct compareval
{
	bool operator()(const int& a, const int& b) 
	{
		return a > b;
	}
};


int main11060()
{
	int vertex, edge,tc=0;
	string str, start, end;

	while(scanf("%d", &vertex)==1)
	{
		map<string,int> name_value;
		map<int, string> value_name;

		for(int i=0; i < vertex; i++)
		{
			cin>>str;			
			name_value.insert(namval(str, i));
			value_name.insert(valnam(i, str));
		}

		scanf("%d", &edge);
		vector<vi> adjList;
		adjList.assign(vertex,vi());

		vi indegree = vi(vertex);
		indegree.assign(vertex,0);


		for(int i=0; i < edge; i++)
		{
			cin >> start;
			cin >> end;

			int u = name_value.find(start)->second;
			int v = name_value.find(end)->second;

			adjList.at(u).push_back(v);
			indegree[v] +=1;
		}

		priority_queue<int, vector<int>, compareval> pq;
				
		for(int i=0; i < vertex; i++)
		{
			if(indegree[i] == 0)
			{
					pq.push(i);
			}
		}

		vi order = vi();
	
		while(!pq.empty())
		{
			int u = pq.top(); pq.pop();
			order.push_back(u);

			for(int i=0; i < adjList[u].size(); i++)
			{
				 int v = adjList[u][i];
			 	 indegree[v]--;
				 if(indegree[v]==0 )
						 pq.push(v);
			}
		}

		printf("Case #%d: Dilbert should drink beverages in this order: %s",++tc, value_name[order[0]].data() );
		for(int i = 1; i < order.size(); i++)
		{
			printf(" %s",  value_name[order[i]].data());
		}
		printf(".\n\n");
	}
	//getch();
return 0;
}

//
/*



http://uva.onlinejudge.org/external/110/11060.html

Sample Input

3
vodka
wine
beer
2
wine vodka
beer wine

5
wine
beer
rum
apple-juice
cachaca
6
beer cachaca
apple-juice beer
apple-juice rum
beer rum
beer wine
wine cachaca

10
cachaca
rum
apple-juice
tequila
whiskey
wine
vodka
beer
martini
gin
11
beer whiskey
apple-juice gin
rum cachaca
vodka tequila
apple-juice martini
rum gin
wine whiskey
apple-juice beer
beer rum
wine vodka
beer tequila

Sample Output

Case #1: Dilbert should drink beverages in this order: beer wine vodka.

Case #2: Dilbert should drink beverages in this order: apple-juice beer wine rum cachaca.

Case #3: Dilbert should drink beverages in this order: apple-juice wine vodka beer rum cachaca tequila whiskey martini gin.


*/


