/**
 * Created by zaman on 09/02/16.
 *
 * 10282 - Babelfish
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1223
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

class Main_10282_Babelfish {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        TreeMap<String, String> dictionary = new TreeMap<String,String>();
        String key, val, line;

            while (scanner.hasNextLine())
            //while(true)
            {
                line = scanner.nextLine();
                if(null == line || line.isEmpty()) break;
                key = line.split(" ")[1];
                val = line.split(" ")[0];

                dictionary.put(key.trim(),val);
            }

            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine())
            //while(true)
            {
                line = scanner.nextLine();
                if(null == line || line.isEmpty()) break;

                val = null;
                val = dictionary.get(line.trim());

                if(null == val ) stringBuilder.append("eh\n");
                else stringBuilder.append(val+"\n");
            }

        System.out.print(stringBuilder.toString());

    }

}

/*


Sample Input

dog ogday
cat atcay
pig igpay
froot ootfray
loops oopslay

atcay
ittenkay
oopslay


Sample Output
cat
eh
loops


 */
