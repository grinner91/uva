/**
	 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2827
	 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class Main_11727_CostCutting_Accepted {

	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);

		int testCases = sc.nextInt();
		SortedSet<Integer> set = new TreeSet<Integer>();;

		for(int tc=1; tc<=testCases; tc++)
		{
			set.clear();
			set.add(sc.nextInt());
			set.add(sc.nextInt());
			set.add(sc.nextInt());

			set.remove(set.first());

			System.out.printf("Case %d: %d\n",tc, set.first());
		}
		System.out.flush();
		sc.close();
		sc=null;
	}

}
