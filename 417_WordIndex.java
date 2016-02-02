import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by zaman on 29/01/16.
 *
 * 417 - Word Index
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=358
 *
 */

class Main_417_WordIndex {

    TreeMap<String,Integer> dictionary = new TreeMap<String,Integer>();

    void generateWords() {

        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        //a
        for (int i = 0; i < 26; i++)
            dictionary.put(alphabets[i] + "", dictionary.size() + 1);

        //ab
        for (int i = 0; i < 26; i++)
            for (int j = i + 1; j < 26; j++)
                dictionary.put(alphabets[i] + "" + alphabets[j] + "", dictionary.size() + 1);


        //abc
        for (int i = 0; i < 26; i++)
            for (int j = i + 1; j < 26; j++)
                for (int k = j + 1; k < 26; k++)
                    dictionary.put(alphabets[i] + "" + alphabets[j] + "" + alphabets[k] + "", dictionary.size() + 1);

        //abcd
        for (int i = 0; i < 26; i++)
            for (int j = i + 1; j < 26; j++)
                for (int k = j + 1; k < 26; k++)
                    for (int p = k + 1; p < 26; p++)
                        dictionary.put(alphabets[i] + "" + alphabets[j] + "" + alphabets[k] + "" + alphabets[p] + "", dictionary.size() + 1);

        //abcde
        for (int i = 0; i < 26; i++)
            for (int j = i + 1; j < 26; j++)
                for (int k = j + 1; k < 26; k++)
                    for (int p = k + 1; p < 26; p++)
                        for (int q = p + 1; q < 26; q++)
                            dictionary.put(alphabets[i] + "" + alphabets[j] + "" + alphabets[k] + "" + alphabets[p] + "" + alphabets[q] + "", dictionary.size() + 1);


    }


    public  void solve()
    {

        generateWords();

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        while(sc.hasNext())
        {
            Integer index = dictionary.get(sc.nextLine().trim());

            if(null == index)  index = 0;

            System.out.println(index);
        }
    }


    public static void main(String[] args) {

        new Main_417_WordIndex().solve();
    }

}


/*


Sample Input

z
a
cat
vwxyz


Sample Output

26
1
0
83681

 */
