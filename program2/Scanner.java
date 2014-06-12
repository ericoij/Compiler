//CS 409 
//Oij
//Eric
//0584206
//2/3/2014
//HW #1
//Tokenizer
import java.util.StringTokenizer;
import java.io.IOException;

public class Scanner
{
	//private static String buffer = "if y>=0 then x:=2;//comments", buffer1, buffer2;
   public StringTokenizer strtok, spacetok;
   public Token[] tokens= new Token[50];
   public Token tempToken;
   public Compiler C;
   public Scanner(Compiler C)
   {
      this.C = C;
   }

   public attributes att = new attributes(C);  
   public int tokenNo; 
   public int i;
  
   
      
   public void Scanner()
   {
     
     //Token[] tokens= new Token[50];
      //strtok = new StringTokenizer(C.buffer, "//"); //Strips off comments
      //int i = 0;
      //if (strtok.hasMoreTokens())
         //C.buffer = strtok.nextToken();
     // while (strtok.hasMoreTokens())
      {
      //C.buffer = strtok.nextToken();
   	C.buffer = commenter(C.buffer);
      	
      C.buffer = split(C.buffer, ">=");  // inserts spaces around relOps, turn into array of strings to split
      C.buffer = split(C.buffer, "==");
      C.buffer = split(C.buffer, "<");
      C.buffer = split(C.buffer, "<>");
      C.buffer = split(C.buffer, "(");
      C.buffer = split(C.buffer, ")");
      C.buffer = split(C.buffer, "{");
      C.buffer = split(C.buffer, "}");
      C.buffer = split(C.buffer, "+");
      C.buffer = split(C.buffer, "-");
      C.buffer = split(C.buffer, ",");
      C.buffer = split(C.buffer, ";");
      C.buffer = split(C.buffer, "/");
      C.buffer = split(C.buffer, ":=");
      }   		
      spacetok = new StringTokenizer(C.buffer, " ");
      int i =0;
      while (spacetok.hasMoreTokens())
         {
         tokens[i]=new Token(spacetok.nextToken(),"",0);//(tempToken);
         C.ident[C.idenNum].variables(i);//could not do without passing i to it, why?
         C.ident[C.idenNum].idnt(i);
         C.pro[C.procNum].proc(i);
         C.pro[C.procNum].Proced(i);
         tokens[i]=att.attributes(tokens[i]);
         System.out.println("Token " + i + ": " + tokens[i].lexeme+"    attribute:" +tokens[i].attribute );
         try{
         C.bw.write("Token " + i + ": " + tokens[i].lexeme+ "    attribute:" +tokens[i].attribute + "    Address: "+ tokens[i].address +"\n");
         }catch (IOException io){}
         i++;
         }
         tokenNo = i;
        while(i<50)
            {
            tokens[i] = null;
            i++;
            }
      //System.out.println(C.buffer);
   }
		
   public String split(String buff, String delim) // for loop for array[]
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
     
   public String commenter(String stringIn)
   {
      String stringOut;
      if (stringIn.indexOf("//")!=-1)
         {
            //int commentIndex = stringIn.indexOf("//");
            stringOut = stringIn.substring(0 , stringIn.indexOf("//")); 
         }
      else
         stringOut = stringIn;
      return stringOut;
   }  
      /*public Token attributes(Token temp)
      {
         String tempStr = temp.lexeme;
         
         if (tempStr.equals( "+")) 
            temp.attribute = "oper";
         else if (tempStr.equals( "-")) 
            temp.attribute = "oper";
         else if (tempStr.equals( "main") ||tempStr.equals ( "end") || tempStr.equals("var") || tempStr.equals("proc") || tempStr.equals("do") ||
            tempStr.equals("if") || tempStr.equals("while") || tempStr.equals( "then") || tempStr.equals( "call")) 
            temp.attribute = "rsWrd";
         else if (tempStr.equals(":=")) 
            temp.attribute = "assnOp";
         else if (tempStr.equals(">=") || tempStr.equals("==")|| tempStr.equals("<")|| tempStr.equals( "<>" )) 
            temp.attribute = "relOp";
         else if (tempStr.equals("(") || tempStr.equals(")") ||tempStr.equals("{") ||tempStr.equals("}") ||tempStr.equals(";") || tempStr.equals("\"")|| tempStr.equals(",")) 
            temp.attribute = "spcChr";
         else if (isInteger(tempStr))
            temp.attribute = "digit"; 
         else 
            temp.attribute = "iden";
         return temp;
      }
   public boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    }
    // only got here if we didn't return false
    return true;
}*/
}
