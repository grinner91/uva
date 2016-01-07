import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by zaman on 15/12/15.
 *
 * 10945 - Mother bear
 *https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1886
 *
 */

class Main_10945_Motherbear {

    public  static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sbuilder;

        while(true)
        {
            input = br.readLine().trim();

            if( input.equalsIgnoreCase("DONE")) break;

            input = input.replace(" ","").replace(".","").replace(",","").replace("!","").replace("?","");

            sbuilder = new StringBuilder(input);

            if(input.equalsIgnoreCase(sbuilder.reverse().toString()))
                System.out.println("You won't be eaten!");
            else
                System.out.println("Uh oh..");

        }
    }
}


/*


SampleInput

Madam, Im adam!
Roma tibi subito motibus ibit amor.
Me so hungry!
Si nummi immunis
DONE


SampleOutput

You won't be eaten!
You won't be eaten!
Uh oh..
You won't be eaten!


 */
