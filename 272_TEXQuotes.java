//272 - TEX Quotes
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=208
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


 class Main272 {
	
	public static void main(String[] args)  {		
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb;
		int len;
		
		try {
			while(true)
			{			

				sb = new StringBuilder(br.readLine());

				len = sb.length();

				for(int i=0; i<len && i>=0;i++)
				{

					i = sb.toString().indexOf('"', i);
					if(i>=0)
					{
						sb.deleteCharAt(i);
						sb.insert(i, "``");

						i = sb.toString().indexOf('"', i+1);
						sb.deleteCharAt(i);
						sb.insert(i, "''");						
					};			
				}	

				System.out.println(sb.toString());

			} 
		} catch (IOException e) {			
		}	
	}
}
