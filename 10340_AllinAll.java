import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 18/01/16.
 *
 * 10340 - All in All
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1281
 *
 */
 class Main_10340_AllinAll {

    public static  void main(String[] args)
    {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        while(scanner.hasNextLine())
        {
            String line =  scanner.nextLine();

            if(null == line || line.isEmpty()) break;

            String s = line.split(" ")[0];
            String t = line.split(" ")[1];

            int lens = s.length(), lent = t.length(), i = 0, j = 0;

            StringBuilder subseq = new StringBuilder();

            for(i = 0 ; i < lens; i++) {
                for (; j < lent; j++) {

                    if (t.indexOf(s.charAt(i), j) >= 0) {

                        j = t.indexOf(s.charAt(i), j)+1;
                        subseq.append(s.charAt(i));
                        break;
                    }

                }
            }

            if(s.equals(subseq.toString())) System.out.println("Yes");
            else  System.out.println("No");

        }

    }

}

/*


Sample Input

sequence subsequence
person compression
VERDI vivaVittorioEmanueleReDiItalia
caseDoesMatter CaseDoesMatter

Sample Output

Yes
No
Yes
No


 */
