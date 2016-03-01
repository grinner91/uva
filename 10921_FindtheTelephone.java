/**
 * Created by zaman on 01/03/16.
 *
 * 10921 - Find the Telephone
 *
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1862
 *
 */

import java.util.Scanner;
import java.util.TreeMap;

 class Main_10921_FindtheTelephone {

     /*

     Letters Number
ABC 2
DEF 3
GHI 4
JKL 5
MNO 6
PQRS 7
TUV 8
WXYZ 9

      */

     private static void prepareData(TreeMap<String,String> map)
     {
         map.put("A","2");map.put("B","2");map.put("C","2");
         map.put("D","3");map.put("E","3");map.put("F","3");
         map.put("G","4");map.put("H","4");map.put("I","4");
         map.put("J","5");map.put("K","5");map.put("L","5");
         map.put("M","6");map.put("N","6");map.put("O","6");
         map.put("P","7");map.put("Q","7");map.put("R","7");map.put("S","7");
         map.put("T","8");map.put("U","8");map.put("V","8");
         map.put("W","9");map.put("X","9");map.put("Y","9");map.put("Z","9");
     }


    public static void main(String[] args)
    {
        TreeMap<String,String> map = new TreeMap<String,String>();
        prepareData(map);

        Scanner scanner = new Scanner(System.in);
        String line, key;
        StringBuilder strbuilder;
        int len;

        while(scanner.hasNextLine())
        {
            line = scanner.nextLine().trim();
            len = line.length();

            strbuilder = new StringBuilder();
            for(int i =0 ; i < len; i++)
            {
                key = "" + line.charAt(i);
                if(key.equals("1") || key.equals("0") || key.equals("-"))
                    strbuilder.append(key);
                else
                    strbuilder.append(map.get(key));
            }

            System.out.println(strbuilder.toString());

        }

    }

}

/*

Sample Input
1-HOME-SWEET-HOME
MY-MISERABLE-JOB


Sample Output

1-4663-79338-4663
69-647372253-562


 */
