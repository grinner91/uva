/* Author: Mohammad Moniruzzaman */

#include <iostream>
#include <string>
#include <map>
using namespace std;

int main()
{

    int TC, paidCharsCount, lineCount;
    map<char,double> paidChars; 
    double cents;
    char ch;

    cin >> TC;
    cin.ignore();

    while(TC--)
    {
        paidCharsCount = 0;

        cin >> paidCharsCount;

        paidChars.clear();
        for(int i=0; i < paidCharsCount; i++)
        {
            cin.ignore();
            cin >> ch >> cents;
            paidChars[ch] = cents;
        }

        lineCount = 0;
        cin >> lineCount;

        string line="";
        double payment = 0.0;
        cin.ignore();

        for(int i=0; i < lineCount; i++)
        {
            line = "";
            getline(cin, line);
        
            for(int j = 0; j < line.length(); j++)
            {
                if(paidChars.count(line[j]))
                {
                    payment += paidChars.at(line[j]);
                }
            }
        }

        printf("%0.2lf$\n",(payment/100.0));
    }

    return 0;
}




/*

11340 - Newspaper
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=25&problem=2315&mosmsg=Submission+received+with+ID+15708226
Input
1
7
a 3
W 10
A 100
, 10
k 7
. 3
I 13
7
ACM International Collegiate Programming Contest (abbreviated
as ACM-ICPC or just ICPC) is an annual multi-tiered competition
among the universities of the world. The ICPC challenges students
to set ever higher standards of excellence for themselves
through competition that rewards team work, problem analysis,
and rapid software development.
From Wikipedia.

Output
3.74$


*/
