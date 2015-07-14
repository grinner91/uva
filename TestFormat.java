import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;


public class TestFormat {
    
    public static void main(String[] args) {
//      long n = 461012;
//      System.out.format("%d%n", n);      //  -->  "461012"
//      System.out.format("%08d%n", n);    //  -->  "00461012"
//      System.out.format("%+8d%n", n);    //  -->  " +461012"
//      System.out.format("%,8d%n", n);    // -->  " 461,012"
//      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
//      
      double pi =11.9299999; //Math.PI;
          
     DecimalFormat df = new DecimalFormat(".00");
     df.setRoundingMode(RoundingMode.FLOOR);
       
     System.out.println(df.format(pi));
//      
//
//      System.out.format("%f%n", pi);       // -->  "3.141593"
 //    System.out.format("%.3f%n", df.format(pi) );     // -->  "3.142"
//      System.out.format("%10.3f%n", pi);   // -->  "     3.142"
//      System.out.format("%-10.3f%n", pi);  // -->  "3.142"
//      System.out.format(Locale.FRANCE,"%-10.4f%n%n", pi); // -->  "3,1416"
//
//      Calendar c = Calendar.getInstance();
//      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
//
//      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
//
//      System.out.format("%tD%n", c);    // -->  "05/29/06"
//      
//      
//      System.out.println( "Columns:" );
//      System.out.println( "0123456789012345678901234567890123456789\n" );
//      System.out.printf( "%10s%10d%10c%10f\n\n", "hello", 7, 'a', 1.23 );
//      System.out.printf( "%-10s%-2d%-10c%-10f\n", "hello", 7, 'a', 1.23 );
//      //System.out.printf( "%-d\n",  7 );
      
    }
}
