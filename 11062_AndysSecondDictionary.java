import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by zaman on 08/02/16.
 *
 * 11062 - Andy's Second Dictionary
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2003
 *
 */


 class Main_11062_AndysSecondDictionary {

    public  static void main(String[] args)
    {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer tokenizer;
        String line, str;
        SortedSet<String> dictionary = new TreeSet<String>();
        StringBuilder stringBuilder = null;

        while(scanner.hasNextLine()) {
          //while(true) {

            line = scanner.nextLine();
            if(null == line) break;
            if (line.isEmpty()) continue;

            int len = line.length() - 1;
            char[] letters = line.toLowerCase().toCharArray();
            char alphabet;

            if( null == stringBuilder)
                stringBuilder = new StringBuilder();

            for (int i = 0; i < len; i++) {

                alphabet = letters[i];

                if ( (alphabet >= 'a' && alphabet <= 'z') || alphabet == '-' ) {
                    stringBuilder.append(alphabet);
                } else {

                    if (stringBuilder.length() > 0) {
                        dictionary.add(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                }
            }
            //for last word
              alphabet = letters[len];
            if ( alphabet != '-' && stringBuilder.length() > 0) {

                if(alphabet >= 'a' && alphabet <= 'z')
                    stringBuilder.append(alphabet);

                dictionary.add(stringBuilder.toString());
                stringBuilder = null;
            }
        }

        stringBuilder = new StringBuilder();
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

Adv-
ent-
ures
in
Dis-
ney-
land
Two blondes were go-
ing to Disney-land
when they came to a
fork in the road.
The sign read: "Dis-
neyland Left."
So they went home.



Sample Output

a
adventures
blondes
came
disney-land
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
