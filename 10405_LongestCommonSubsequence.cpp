//10405 - Longest Common Subsequence
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1346

#include <stdio.h>
#include <string>
#include <iostream>

using namespace std;

#define MAX 1000
#define max(a,b) ( (a)<(b) ? (b):(a))

string s1, s2;
int lcs[MAX+1][MAX+1];

int main10405()
{
	int len1, len2;
	while(getline(cin,s1))
	{		
		getline(cin,s2);
		len1 = s1.size();
		len2 = s2.size();

		for(int i=1; i <= len1; i++)
			for(int j=1; j <= len2; j++)
			{
				if(s1[i-1] == s2[j-1])
					lcs[i][j] = lcs[i-1][j-1] + 1;
				else
					lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
			}

			printf("%d\n",lcs[len1][len2]);
	}
	return 0;
}
