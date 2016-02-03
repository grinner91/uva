import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by zaman on 02/02/16.
 *
 * 490 - Rotating Sentences
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=431
 *
 */

class Main_490_RotatingSentences {


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        ArrayList<String> sentences = new ArrayList<String>();
        String str;
        int max = 0;
        while(sc.hasNextLine())
        {
            str = sc.nextLine();
            if(null == str || str.isEmpty()) break;

            max = max < str.length() ? str.length(): max;
            sentences.add(str);
        }

        Collections.reverse(sentences);

        int len = sentences.size();

        StringBuilder builder = new StringBuilder();
        for(int col=0; col < max; col++)
        {
            if( col > 0) builder.append("\n");

            for(int row = 0; row < len; row++)
            {
                if( col < sentences.get(row).length() )
                     builder.append(sentences.get(row).charAt(col));
                else
                    builder.append(" ");
            }

        }

        System.out.println(builder.toString());
    }
}


/*

Sample Input

Rene Decartes once said, test
"I think, therefore I am.


Sample Output

"R
Ie
 n
te
h
iD
ne
kc
,a
 r
tt
he
es
r
eo
fn
oc
re
e
 s
Ia
 i
ad
m,
.
"


 */
