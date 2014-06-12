public class Identifier{

   public String name;
   public int address;
   public Compiler C;
   public Identifier(Compiler C)
   {
      this.C = C;
   }

  
   public Identifier(String nam, int addr)
   {
      name = nam;
      address = addr;
   
   
   
   }
   public void variables(int i)
   {
      if (C.scn.tokens[i] != null)
      {   
         if (C.scn.tokens[0].lexeme.equals("var"))
         {
            if (C.scn.tokens[i].lexeme.equals(","))
               return ;
            if (C.scn.tokens[i].lexeme.equals(";"))
               return;
            if (C.scn.tokens[i].lexeme.equals("var"))
               return;
            if (!Character.isLowerCase(C.scn.tokens[i].lexeme.charAt(0)))
               return;
            for (int n=1 ; n  <= C.scn.tokens[i].lexeme.length() - 1; n++)
            {
               if (!Character.isLowerCase(C.scn.tokens[i].lexeme.charAt(n)) && !Character.isDigit(C.scn.tokens[i].lexeme.charAt(n)))
                  return;
            }
         C.scn.tokens[i].attribute = "iden";
         C.ident[C.idenNum]= new Identifier(C.scn.tokens[i].lexeme, C.dataAddress);
         C.dataAddress++;
         C.idenNum++;
         //System.out.println("identifier!!!!!!! No. " + C.idenNum);
         
         }
      }
    }
       public void idnt(int i)
      {
         for (int n=0; n<= C.idenNum -1; n++)
         {
            if (C.ident[n].name.equals(C.scn.tokens[i].lexeme))
               {
               C.scn.tokens[i].attribute = "iden";
               C.scn.tokens[i].address = C.ident[n].address;
               //System.out.println(C.ident[n].name + "    address: " + C.ident[n].address);
               return;
               }
            else   
               C.scn.tokens[i].attribute = "error";
         }  
      
      }
      
            
      
      
      /*public static void idnt()
      {
         for (int n=0; n<= C.scn.IdentifierNo -1; n++)
         {
            if (identifiers[n].name.equals(C.scn.tokens[k].lexeme))
               {
               C.scn.tokens[k].attribute = "iden";
               C.scn.tokens[k].address = Identifiers[n].address;
               }
            else   
               C.scn.token[k].attribute = "error";
         }  
      
      }
   */
}