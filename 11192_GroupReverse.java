/**
 * Created by zaman on 19/02/16.
 *
 * 11192 - Group Reverse
 *
 */

import java.util.Scanner;

class Main_11192_GroupReverse {


    public  static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int group, len;
        String input, sentence;

        while(true)
        {
            input = scanner.nextLine();

            group = Integer.parseInt(input.split(" ")[0]);
            if(group == 0) break;

            sentence = input.split(" ")[1];

            len = sentence.length() / group;

            StringBuilder sb;
            StringBuilder revStr = new StringBuilder();

            for(int i=0; i < sentence.length(); i+=len)
            {
                sb = new StringBuilder(sentence.substring(i, i+len));

                revStr.append(sb.reverse());
            }

            System.out.println(revStr.toString());

        }

    }
}

/*


Sample Input

3 ABCEHSHSH
5 FA0ETASINAHGRI0NATWON0QA0NARI0
0


Sample Output
CBASHEHSH
ATE0AFGHANISTAN0IRAQ0NOW0IRAN0


 */
