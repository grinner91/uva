import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zaman on 04/02/16.
 *
 * 10815 - Andy's First Dictionary
 *
 *https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1756
 *
 */


 class Main_10815_AndyFirstDictionary {


    public  static void main(String[] args)
    {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer tokenizer;
        String line, str;
        SortedSet<String> dictionary = new TreeSet<String>();

        while(scanner.hasNextLine()) {
      
            line = scanner.nextLine();
            if(null == line) break;
            if (line.isEmpty()) continue;
               
            int len = line.length();
            char[] letters = line.toLowerCase().toCharArray();
            char alphabet;

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < len; i++) {

                alphabet = letters[i];

                if (alphabet >= 'a' && alphabet <= 'z') {
                    stringBuilder.append(alphabet);
                } else {

                    if (stringBuilder.length() > 0) {
                        dictionary.add(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                }
            }
            //for last word
            if (stringBuilder.length() > 0) {
                dictionary.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }

        StringBuilder   stringBuilder = new StringBuilder();
        Iterator<String> it = dictionary.iterator();

        while(it.hasNext())
        {
            str = it.next();
            stringBuilder.append(str+"\n");
        }
        System.out.print(stringBuilder.toString());
    }
}

/*


Input

this"is"a"really"long"word
good100cats
good22dogs

Output

a
cats
dogs
good
is
long
really
this
word



Sample Input


Adventures in Disneyland
Two blondes were going to Disneyland when they came to a fork in the
road. The sign read: "Disneyland Left."
So they went home.


Sample Output


a
adventures
blondes
came
disneyland
fork
going
home
in
left
read
road
sign
so
the
they
to
two
went
were
when

 */
