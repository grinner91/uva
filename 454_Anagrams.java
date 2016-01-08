import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by zaman on 07/01/16.
 *
 * 454 - Anagrams
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=395
 *
 */

class Main_454_Anagrams {

    public  static boolean isAnagram(String str1, String str2)
    {
        char[] letters1 = str1.replace(" ","").toCharArray();
        char[] letters2 = str2.replace(" ","").toCharArray();

        Arrays.sort(letters1);
        Arrays.sort(letters2);

       return (new String(letters1)).equals(new String(letters2));
    }


    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        br.readLine().trim();

       ArrayList<String> phrases;
        String str, modified;
        char[] chars;

        while(tc-- > 0)
        {
            phrases = new ArrayList<String>();

            while(true) {
                str = br.readLine();
                if (null == str || str.isEmpty()) break;

                phrases.add(str);
            }

            Collections.sort(phrases);

            StringBuilder sb = new StringBuilder();
            String phrase,letters1, anagram;
            int len = phrases.size();

            for(int i= 0; i < len; i++)
            {
                phrase = phrases.get(i);

                for (int j = i + 1; j < len; j++) {

                    anagram = phrases.get(j);
                    if (isAnagram(phrase, anagram)) {
                        sb.append(phrase + " = " + anagram + "\n");
                    }
                }
            }

            if( tc > 0 ) sb.append("\n");

            System.out.print(sb.toString());
        }
    }
}


/*

Sample Input

1

carthorse
horse
horse cart
i do not know u
ok i now donut
orchestra


Sample Output

carthorse = horse cart
carthorse = orchestra
horse cart = orchestra
i do not know u = ok i now donut


 */
