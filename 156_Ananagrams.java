import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by zaman on 08/01/16.
 *
 *156 - Ananagrams
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=92
 *
 */
 
class Main_156_Ananagrams {

    public  static void main(String[] args) throws  Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> modifiedWords = new ArrayList<String>();
        StringTokenizer tokenizer;
        String str, line;

        while(true)
        {
            line = reader.readLine();
            if(line.equals("#")) break;

            tokenizer = new StringTokenizer(line);

            while(tokenizer.hasMoreTokens()) {

                str = tokenizer.nextToken().trim();

                words.add(str);
            }
        }

        Collections.sort(words);

        char[] letters;

        for(String w:words) {

            letters = w.toLowerCase().toCharArray();

            Arrays.sort(letters);

            modifiedWords.add(new String(letters));
        }

        String val,wrd;

        int len = words.size();

        StringBuilder ananagrams = new StringBuilder();

        for(int index = 0; index < len; index++) {

            wrd = words.get(index);

            val = modifiedWords.get(index);

            //if not contains more anagrams
            if(modifiedWords.indexOf(val) == modifiedWords.lastIndexOf(val))
                ananagrams.append(wrd+"\n");
        }

        System.out.print(ananagrams.toString());
    }
}

/*


Sample input

ladder came tape soon leader acme RIDE lone Dreis peat
 ScAlE orb  eye  Rides dealer  NotE derail LaCeS  drIed
noel dire Disk mace Rob dries
#

Sample output

Disk
NotE
derail
drIed
eye
ladder
soon


 */
