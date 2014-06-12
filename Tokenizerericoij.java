//CS 409 
//Oij
//Eric
//0584206
//2/3/2014
//HW #1
//Tokenizer
import java.util.StringTokenizer;

public class Tokenizerericoij
{
	private static String buffer = "if y>=0 then x:=2;//comments", buffer1, buffer2;
	private static StringTokenizer strtok, spacetok;
	
	public static void main(String[] args)
		{
			strtok = new StringTokenizer(buffer, "//"); //Strips off comments
			buffer = strtok.nextToken();
			
         buffer = split(buffer, ">=");  // inserts spaces around relOps
			buffer = split(buffer, "==");
         buffer = split(buffer, "<");
         buffer = split(buffer, "<>");
         buffer = split(buffer, "(");
         buffer = split(buffer, ")");
         buffer = split(buffer, "{");
         buffer = split(buffer, "}");
         buffer = split(buffer, "+");
         buffer = split(buffer, "-");
         buffer = split(buffer, ",");
         buffer = split(buffer, ";");
         buffer = split(buffer, "/");
         buffer = split(buffer, ":=");
         		
			System.out.println(buffer);
		}
		
		private static String split(String buff, String delim)
      {
         if (buff.indexOf(delim) != -1)
         {
            int buffIndex;
            String buff1, buff2;
            buffIndex = buff.indexOf(delim);
         
            buff1 = buff.substring(0,buffIndex);
            buff2 = buff.substring(buffIndex + delim.length(), buff.length());
         
            if (buff2.indexOf(delim)!= -1)
            {
               buff2 = split(buff2, delim);
            }
            buff = buff1 + " " + delim + " " +buff2;
         }
         return buff;
      }
}