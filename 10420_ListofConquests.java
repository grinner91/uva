/**
 * Created by zaman on 29/02/16.
 *
 * 10420 - List of Conquests
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1361
 *
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main_10420_ListofConquests {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        scanner.nextLine();

        TreeMap<String,Integer> conquests = new TreeMap<String,Integer>();
        String line, country, name;

        for(int i = 0; i < num; i++)
        {
            line = scanner.nextLine().trim();

            country = line.substring(0,line.indexOf(' ')).trim();
            name = line.substring(line.indexOf(' ')+1).trim();

            if(conquests.containsKey(country))
                conquests.put(country, conquests.get(country)+1);
            else
                conquests.put(country, 1);
        }

        Map.Entry<String,Integer> entry;
       while(conquests.size()>0)
       {
           entry = conquests.pollFirstEntry();
           System.out.println( entry.getKey() + " " + entry.getValue() );
       }

    }
}

/*

Sample Input

3
Spain Donna Elvira
England Jane Doe
Spain Donna Anna


Sample Output
England 1
Spain 2


 */
