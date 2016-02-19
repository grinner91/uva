/**
 * Created by zaman on 19/02/16.\
 *
 *  484 - The Department of Redundancy Department
 *
 *  https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=425
 *
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.TreeMap;

 class Main_484_TheDepartmentRedundancy {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num, i=0;
        TreeMap<Integer, Integer> integers = new TreeMap<Integer,Integer>();
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        while(scanner.hasNextInt())
        {
            num = scanner.nextInt();

            if(integers.containsKey(num))
                integers.put( num, integers.get(num) + 1);
            else {
                integers.put(num, 1);
                integerList.add(num);
            }

        }

        for(int j = 0; j < integerList.size(); j++)
        {
            System.out.println(integerList.get(j) + " " + integers.get(integerList.get(j)));
        }

    }
}

/*

Sample Input

3 1 2 2 1 3 5 3 3 2


Sample Output

3 4
1 2
2 3
5 1


 */
