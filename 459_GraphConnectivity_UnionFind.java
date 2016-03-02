/**
 * Created by zaman on 29/02/16.
 *
 * 459 - Graph Connectivity
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=400
 *
 */

import java.util.Scanner;

class Main_459_GraphConnectivity_UnionFind {
    int[] parent;
    int[] rank;
    int maxNode, numSets;

    private void initSet()
    {
        for(int i =1; i <=maxNode; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int findSet(int x)
    {
        if(parent[x] == x) return  x;
        else return findSet(parent[x]);
    }

    private void unionSet(int x, int y)
    {
        int xRoot = findSet(x);
        int yRoot = findSet(y);

        if(xRoot == yRoot) return;

        numSets--;
        if(rank[xRoot] < rank[yRoot])
        {
            parent[xRoot] = yRoot;
        }
        else if(rank[xRoot] > rank[yRoot])
        {
            parent[yRoot] = xRoot;
        }
        else
        {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }

    }

    public  void solve()
    {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine().trim());
        scanner.nextLine();
        String line;

        for(int tc =0; tc < testCases; tc++)
        {
            line = scanner.nextLine().trim();
            maxNode = (line.toCharArray()[0] - 'A') + 1;
            numSets = maxNode;
            parent = new int[maxNode+1];
            rank = new int[maxNode+1];

            initSet();

           int u,v;
            while(scanner.hasNextLine())
             {
                line = scanner.nextLine();
                if(null == line || line.isEmpty()) break;

                line   = line.trim();
                 u = (line.charAt(0) - 'A') + 1;
                 v = (line.charAt(1) - 'A') + 1 ;
                unionSet(u,v);
             }

            int subGraphCount = numSets;
//            for(int i = 1; i <= maxNode; i++)
//            {
//                if(parent[i] == i) subGraphCount++;
//            }

            if(tc > 0) System.out.println();

            System.out.println(subGraphCount);
        }
    }

    public static void main(String[] args)
    {
        (new Main_459_GraphConnectivity_UnionFind()).solve();
    }
}

/*

Sample Input

7

E
AB
CE
DB
EC

G
AB
CE
DB
EC
EF
GG

Z
AC
AD
AE
AI
AL
AM
AN
AO
AQ
AS
AV
AW
AX
AY
BF
BH
BJ
BK
BL
BM
BN
BO
BP
BQ
BR
BU
BV
BW
BY
CE
CG
CI
CJ
CM
CP
CT
CU
CV
CY
DF
DG
DJ
DK
DL
DM
DN
DO
DQ
DV
DX
EF
EH
EK
EL
EM
EN
EO
ER
ES
ET
EU
EY
EZ
FG
FH
FI
FJ
FM
FN
FO
FP
FR
FU
FW
FY
FZ
GH
GL
GM
GP
GQ
GR
GS
GZ
HI
HJ
HK
HL
HQ
HR
HS
HV
HW
HY
IK
IM
IO
IP
IR
IU
IV
IX
IY
IZ
JK
JL
JM
JN
JR
JW
KM
KO
KP
KR
KS
KX
KY
KZ
LO
LP
LQ
LR
LY
MN
MO
MP
MR
MT
MU
MV
MX
MZ
NP
NR
NT
NV
NY
OQ
OV
OW
OX
PR
PS
PT
PV
PW
PX
PY
PZ
QR
QT
QV
QY
RT
RU
RW
RY
RZ
ST
SV
SZ
TX
TY
TZ
UW
UY
UZ
VW
WZ
XY
XZ

E
AE
EC
CB
BD

F
AB
BC
CA
DE
EF
FD

Z

C
AB



Sample Output

2

3

1

1

2

26

2



 */
