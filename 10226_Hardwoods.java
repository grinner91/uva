import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zaman on 25/11/15.
 *
 * 10226 - Hardwood Species
 *
 *
 */

class Main_10226_Hardwoods {


    public static void main (String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String str;

        br.readLine();

        for(int t=0; t < T; t++) {

            if( t > 0 ) System.out.println();

            TreeMap<String, Integer>  species = new TreeMap<String,Integer>();
            double count = 0,val=0;
            double percentage=0;
            int temp;

            while(true)
            {
                str = br.readLine();
                if(null == str) break;

                str = str.trim();
                if(str.isEmpty()) break;

                count++;
                if( species.containsKey(str))
                {
                    temp = species.get(str);
                    species.put(str,temp+1);
                }
                else species.put(str,1);
            }

            for (Map.Entry<String, Integer> kv:species.entrySet()) {

                str = kv.getKey();
                val = kv.getValue();
                percentage = val / count * 100;

                System.out.printf("%s %.4f%n", str, percentage);
            }

        }
    }
}

/*


2

Red Alder
Ash
Aspen
Basswood
Ash
Beech
Yellow Birch
Ash
Cherry
Cottonwood
Ash
Cypress
Red Elm
Gum
Hackberry
White Oak
Hickory
Pecan
Hard Maple
White Oak
Soft Maple
Red Oak
Red Oak
White Oak
Poplan
Sassafras
Sycamore
Black Walnut
Willow

Red Alder
Ash
Aspen
Basswood
Ash
Beech
Yellow Birch
Ash
Cherry
Cottonwood
Ash
Cypress
Red Elm
Gum
Hackberry
White Oak
Hickory
Pecan
Hard Maple
White Oak
Soft Maple
Red Oak
Red Oak
White Oak
Poplan
Sassafras
Sycamore
Black Walnut
Willow


//output

Ash 13.7931
Aspen 3.4483
Basswood 3.4483
Beech 3.4483
Black Walnut 3.4483
Cherry 3.4483
Cottonwood 3.4483
Cypress 3.4483
Gum 3.4483
Hackberry 3.4483
Hard Maple 3.4483
Hickory 3.4483
Pecan 3.4483
Poplan 3.4483
Red Alder 3.4483
Red Elm 3.4483
Red Oak 6.8966
Sassafras 3.4483
Soft Maple 3.4483
Sycamore 3.4483
White Oak 10.3448
Willow 3.4483
Yellow Birch 3.4483


 */
