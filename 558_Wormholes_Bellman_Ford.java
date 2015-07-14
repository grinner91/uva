//558 - Wormholes
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=499
//Bellman Ford algorithm

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Edge
{
	public int u;
	public int v;
	public int w;
	public Edge(int source, int target, int weight)
	{
		this.u = source;
		this.v= target;
		this.w =weight;
	}
}

class BellmanFord
{
	public final int INFINITY=Integer.MAX_VALUE;
	private int mNumOfVertexes, mSource, mDestination;
	private int mDistances[];
	private	ArrayList<Edge> mEdges;
	private boolean mHasNegativeCycle;
	
		
	public BellmanFord(int numofvertexes, ArrayList<Edge> edges)
	{
		this.mNumOfVertexes = numofvertexes;		
		this.mEdges = edges;
	}
	
	public int costSourceToDest(int src, int dest)
	{
		bfAlgorithm(src,dest);
				
		return mDistances[dest];			 
	}

	public boolean hasNegativeCycle(int src, int dest)
	{
				
		bfAlgorithm(src,dest);
		
		return mHasNegativeCycle;
	}

	private void bfAlgorithm(int src, int dest)
	{
		
		mSource = src;
		mDestination = dest;
		
		int numvrtx = mNumOfVertexes;
		
		mDistances = new int[numvrtx+1];		
		for(int i=0;i<=numvrtx;i++)
			mDistances[i]=INFINITY;

		mDistances[mSource] = 0;
		mHasNegativeCycle=false;
		for(int level=1; level<=numvrtx; level++)
		{
			for(Edge edg:mEdges)
			{
				if(mDistances[edg.u]+ edg.w < mDistances[edg.v])
				{
					mDistances[edg.v] = mDistances[edg.u]+ edg.w;

					if(level==numvrtx) 
						mHasNegativeCycle=true;
				}
			}
		}		
	}

}

class Main_Wormholes_558_BellmanFord_Accepted {	

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner(br);

		int testCase = sc.nextInt();
		int numofvertexes, numofedges, source, target, weight;
		
		ArrayList<Edge> edges;		
		BellmanFord blmnfrd;
		
		for(int tc=1; tc<=testCase; tc++)
		{
			numofvertexes = sc.nextInt();
			numofedges = sc.nextInt();

			edges = new ArrayList<Edge>();				

			for(int i=1;i<=numofedges;i++)
			{
				source = sc.nextInt();
				target = sc.nextInt();
				weight= sc.nextInt();
				edges.add(new Edge(source,target,weight));			
			}
			
			blmnfrd = new BellmanFord(numofvertexes, edges);
			
			if(blmnfrd.hasNegativeCycle(0, numofvertexes-1)) 
				System.out.println("possible");
			else 
				System.out.println("not possible");

		}
		System.out.flush();
		sc.close();
		sc=null;
	}

}
