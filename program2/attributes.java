public class attributes
{
   
   public Compiler C;
   //public Scanner S;   
      
   public attributes(Compiler C)
   {
      this.C = C;
   }
   
   
   public Token attributes(Token temp)//had to pass token to method, why???
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
         temp.attribute = "num"; 
      //else if (tempStr.equals("var"))//needs to be else if!!
         //variables();
      //else 
         //C.ident[].idnt();
            //temp.attribute = "iden";
      return temp;
   }
         

   public boolean isInteger(String s) {
      try { 
         Integer.parseInt(s); 
      } 
      catch(NumberFormatException e) { 
         return false; 
      }
    // only got here if we didn't return false
      return true;
   }
   /*public void variables()
   {
      try 
      {
         if (C.scn.tokens[0].lexeme.equals("var"))
         {
            if (C.scn.tokens[C.scn.i].lexeme.equals(","))
               return ;
            if (C.scn.tokens[C.scn.i].lexeme.equals(";"))
               return;
            if (C.scn.tokens[C.scn.i].lexeme.equals("var"))
               return;
            if (!Character.isLowerCase(C.scn.tokens[C.scn.i].lexeme.charAt(0)))
               return;
            for (int n=1 ; n  <= C.scn.tokens[C.scn.i].lexeme.length() - 1; n++)
            {
               if (!Character.isLowerCase(C.scn.tokens[C.scn.i].lexeme.charAt(n)) && !Character.isDigit(C.scn.tokens[C.scn.i].lexeme.charAt(n)))
                  return;
            }
            C.scn.tokens[C.scn.i].attribute = "idnt";
            C.ident[C.idenNum]= new Identifier(C.scn.tokens[C.scn.i].lexeme, C.dataAddress);
            C.dataAddress++;
            C.idenNum++;
         }   
         
      }
      catch(NullPointerException npe){}
   }
   
   
   /*public void idnt()
   {
      try
      {  
         System.out.println(C.idenNum); 
         for (int n=0; n< C.idenNum; n++)//C.idenNum
         {
            System.out.println(C.ident[n].name + C.scn.tokens[C.scn.i].lexeme);
            
            if (C.ident[n].name.equals(C.scn.tokens[C.scn.i].lexeme))
            {
               C.scn.tokens[C.scn.i].attribute = "iden";
               C.scn.tokens[C.scn.i].address = C.ident[n].address;
               return;
            }
            //else   
               //C.scn.tokens[C.scn.i].attribute = "error";
         }  
         C.scn.tokens[C.scn.i].attribute = "error";
      }
      catch(NullPointerException npe){}
   }*/
      

}