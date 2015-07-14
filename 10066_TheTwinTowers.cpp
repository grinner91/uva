//10066 - The Twin Towers
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1007
//Solution LCS

#include<stdio.h>

#define MAX 100
#define max(a,b) ((a)<(b) ? (b):(a))

int N1, N2;
int firstT[MAX+1];
int secondT[MAX+1];
int lcs[MAX+1][MAX+1];
int lcsLength, nCase;

int main10066()
{
	int i,j;

	//int firstT[MAX]={0};
	//int secondT[MAX]={0};

	while(true)
	{
		scanf("%d %d", &N1, &N2);

		if(N1 ==0 && N2==0) break;

		for(i=1; i<=N1; i++)
			scanf("%d",&firstT[i]);

		for(i=1; i<=N2; i++)
			scanf("%d",&secondT[i]);

		/*for(i=0;i <=N1; i++)
		for(j=0;j<=N2; j++)
		lcs[i][j] = 0;*/

		for(i=1; i<= N1; i++)
			for(j=1; j<= N2; j++)
			{
				if(firstT[i] == secondT[j])
				{
					lcs[i][j] = lcs[i-1][j-1] + 1;
				}
				else
				{
					lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
				}
			}

			printf("Twin Towers #%d\n",++nCase);
			printf("Number of Tiles : %d\n\n",lcs[N1][N2]);
	}
	return 0;
}
