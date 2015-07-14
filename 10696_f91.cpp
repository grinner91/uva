#include <stdio.h>

///10696 - f91
//http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=18&page=show_problem&problem=1637
//Sample input
//
//500
//91
//0
//Sample output
//
//f91(500) = 490
//f91(91) = 91

long f91(long n)
{
	
	if(n>=101) 
		return n - 10;

	if(n<=100) 
		return f91(f91(n+11));
	
}

int mainf91()
{
	long num;

	while(true)
	{
		scanf("%ld",&num);
		if(num == 0) break;
		
		printf("f91(%d) = %ld\n", num, f91(num));
	}

}
