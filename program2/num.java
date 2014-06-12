public class num
{
   public Compiler C;
   public num(Compiler C)
   {
      this.C = C;
   }
   
   public void num()
   {
      try
      {if (Integer.valueOf(C.scn.tokens[C.scn.i].lexeme) <=127)
         C.scn.tokens[C.scn.i].attribute = "num";
      }
      catch (NumberFormatException nfe){}
   
   
   }
   public void variables()
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
         C.scn.ident[C.idenNum]= new Identifier(C.scn.tokens[C.scn.i].lexeme, C.dataAddress);
         C.dataAddress++;
         C.idenNum++;
         
         
         }
         }
      public void idnt()
      {
         for (int n=0; n<= C.idenNum -1; n++)
         {
            if (C.scn.ident[n].name.equals(C.scn.tokens[C.scn.i].lexeme))
               {
               C.scn.tokens[C.scn.i].attribute = "iden";
               C.scn.tokens[C.scn.i].address = C.scn.ident[n].address;
               }
            else   
               C.scn.tokens[C.scn.i].attribute = "error";
         }  
      
      }

   //put in scanner
   
   //C.S.identifiers[C.S.IdentifierNo]= new Identifier(C.S.tokens[k].lexeme, dataAddress);
}