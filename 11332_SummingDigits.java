import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class Main_11332_SummingDigits {

	/**
	 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=25&page=show_problem&problem=2307
	 */
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);
		int num,sumOfDigits, len;
		char[] digits;

		while(true)
		{
			num = sc.nextInt();
			if(num==0) break;

			sumOfDigits = num;			
			while(true)
			{
				digits = Integer.toString(sumOfDigits).toCharArray();
				len = digits.length;
				if(len==1) break;

				sumOfDigits = 0;
				for(int i=0; i<len;i++)
					sumOfDigits += digits[i]-'0';
			}

			System.out.println(sumOfDigits);
		}
	}

}
