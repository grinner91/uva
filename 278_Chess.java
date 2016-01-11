import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by zaman on 11/01/16.
 *
 * 278 - Chess
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=214
 *
 */

class Main_278_Chess {
//r, k, Q, K, meaning respectively the chesspieces Rook, Knight, Queen or King


    public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int testCases = Integer.parseInt(reader.readLine());
    String input;
        StringTokenizer tokenizer;
        String ch;
        int row=0, col=0;

        while(testCases-- > 0)
        {
            input = reader.readLine();

            tokenizer = new StringTokenizer(input);

            ch = tokenizer.nextToken();
            row = Integer.parseInt(tokenizer.nextToken());
            col = Integer.parseInt(tokenizer.nextToken());

            if(ch.equals("r") || ch.equals("Q")) System.out.println(Math.min(row,col));
            else if(ch.equals("K")) System.out.println( ((row+1) / 2) * ((col+1)/2));
            else if(ch.equals("k")) System.out.println( ((row*col)/2));

        }
    }
}


/*


Sample Input

2
r 6 7
k 8 8

Sample Output

6
32

 */
