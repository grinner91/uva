import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zaman on 11/01/16.
 *
 * 489 - Hangman Judge
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=430
 *
 */

class Main_489_HangmanJudge {

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input,guess;
        int round,wrong;

        while(true)
        {
            input = reader.readLine();
            round = Integer.parseInt(input);
            if(-1 == round) break;

            input = reader.readLine();
            guess = reader.readLine();

            wrong = 0;
            int len = guess.length();
            for(int i=0; i < len && input.length() > 0 ; i++)
            {
                char ch = guess.charAt(i);
                if(input.contains(ch+"")) {
                    input = input.replace(ch + "", "");
                }
                else wrong++;
            }

            StringBuilder strbuilder = new StringBuilder();
            strbuilder.append("Round " + round + "\n");

            if(wrong >= 7) strbuilder.append("You lose.");
            else if (wrong < 7 && input.length() ==0) strbuilder.append("You win.");
            else if(wrong < 7 && input.length() > 0) strbuilder.append("You chickened out.");

            System.out.println(strbuilder.toString());
        }



    }
}


/*

Sample Input

1
cheese
chese
2
cheese
abcdefg
3
cheese
abcdefgij
-1

Sample Output

Round 1
You win.
Round 2
You chickened out.
Round 3
You lose.

 */
