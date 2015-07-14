//929 - Number Maze
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=870
// Time: 1.715 sec 

#include<stdio.h>
#include<vector>
#include<queue>

using namespace std;

#define INF 1e9

const int adjR[4] = {-1,  0, 1, 0};
const int adjC[4] = { 0, -1, 0, 1};

typedef pair<int,int> ii;
typedef pair<int,ii> iii;
typedef vector<int> vi;

vector<vi> weight;
int row, col, r, c, i, d, newr, newc;

int dijkstra()
{
	priority_queue<iii,vector<iii>,greater<iii>> pq;
	vector<vi> dist;

	dist.clear();
	vi rowInit(col,INF);
	dist.assign(row,rowInit);

	//source dist 
	dist[0][0] = weight[0][0];

	pq.push( iii( dist[0][0], ii(0,0) ) );

	while(!pq.empty())
	{
		iii u = pq.top();
		pq.pop();
		r = u.second.first;
		c = u.second.second;
		d = u.first;
		
		for(i=0; i<4; i++)
		{
			newr = r + adjR[i];
			newc= c + adjC[i];

			if(newr >= 0 && newr < row && newc >= 0 && newc < col)
			{
				if(d + weight[newr][newc] < dist[newr][newc])
				{
					 dist[newr][newc] = d + weight[newr][newc];
					 pq.push( iii(dist[newr][newc], ii(newr,newc) ) );
				}
			}
		}
	}

	return dist[row-1][col-1];
}

int main929()
{
	int testcase, w;

	scanf("%d",&testcase);

	while(testcase--)
	{
		scanf("%d",&row);
		scanf("%d",&col);

		weight.clear();

		for(r=0; r < row; r++)
		{
			vi rowdata;
			for(c=0; c < col; c++)
			{
				scanf("%d",&w);
				rowdata.push_back(w);
			}
			weight.push_back(rowdata);
		}
		printf("%d\n",	dijkstra());
	}
	
	return 0;
}
