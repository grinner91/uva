import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by zaman on 11/01/16.
 *
 * 11559 - Event Planning
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2595
 *
 *
 *
 */
class Main_11559_EventPlanning {


    public  static void main(String[] args) throws  Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer tokenizer;

        while(true) {

            input = reader.readLine();
            if( null == input || input.isEmpty()) break;

            int participants, budget, hotels, weeks, price, bed;


            tokenizer = new StringTokenizer(input);
            participants = Integer.parseInt(tokenizer.nextToken());
            budget = Integer.parseInt(tokenizer.nextToken());
            hotels = Integer.parseInt(tokenizer.nextToken());
            weeks = Integer.parseInt(tokenizer.nextToken());


            int totalCost = Integer.MAX_VALUE, currentCost;

            for(int h=0; h < hotels; h++)
            {
                input = reader.readLine();
                price = Integer.parseInt(input);

                input = reader.readLine(); //beds in weeks
                tokenizer = new StringTokenizer(input);

                currentCost = price * participants;
                if(currentCost > budget) continue;

                for(int b=0; b < weeks; b++) {

                     bed = Integer.parseInt(tokenizer.nextToken());

                    if(participants <= bed && currentCost < totalCost)
                                totalCost = currentCost;
                }
            }

            if(totalCost == Integer.MAX_VALUE) System.out.println("stay home");
            else System.out.println(totalCost);

        }




    }

}


/*


SampleInput
3 1000 2 3
200
0 2 2
300
27 3 20
5 2000 2 4
300
4 3 0 4
450
7 8 0 13



SampleOutput
900
stay home

 */
