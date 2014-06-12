public class hasError
{
   public Compiler C;
   //public int mainCo = 0;
   public hasError(Compiler C)//, Scanner S)
   {
      this.C = C;
         //this.S = S;
   } 
  
   public String hasErrors()
   {
      String errorMess = "";
      int para = 0, brac = 0, curl = 0 ,count=0; 
      //check main method
      if (C.scn.tokens[0]!=null)
         if (C.scn.tokens[0].lexeme.equals( "main"))
         {
            C.mainCo++;
            System.out.println(C.mainCo);
            if (!C.scn.tokens[1].lexeme.equals("(") && !C.scn.tokens[2].equals(")")  && C.scn.tokens[3] != null)//mainCo != 1 is not working!!
               if ( C.mainCo != 1)
                  errorMess = errorMess + "the main method is not valid\n";
         }
         
      
      for (int i =0 ; C.scn.tokens[i]!=null ; i++)
      {         
         if (C.scn.tokens[i].lexeme.equals( "("))
            para++;
         else if (C.scn.tokens[i].lexeme.equals(")"))
            para--;
         else if (C.scn.tokens[i].lexeme.equals("["))
            brac++;
         else if (C.scn.tokens[i].lexeme.equals("]"))
            brac--;
         else if (C.scn.tokens[i].lexeme.equals("{"))
            curl++;
         else if (C.scn.tokens[i].lexeme.equals("}"))
            curl--;
         else if (C.scn.tokens[i].lexeme.equals(";"))
         { 
            if (curl != 1)
               if (C.scn.tokens[i+1]!=null)
                  errorMess = errorMess +  "there is something after your semicolon at token# " + count +"... ;+. please fix\n";
         }
         if (C.scn.tokens[i].lexeme.equals(":="))
         {
            if (!C.scn.tokens[i-1].attribute.equals("iden"))
               errorMess = errorMess +  "Limproper use of the assnOp at token# " + i+ "\n";
            if (C.scn.tokens[i + 1].attribute.equals("oper") || C.scn.tokens[i + 1].attribute.equals("term") || C.scn.tokens[i + 1].attribute.equals("iden"))
               errorMess = "";
            else   
               errorMess = errorMess +  "Rimproper use of the assnOp at token# " + i + "\n";
         }
         count++;
         
      }
      if (para !=0)  
      {
         if (para > 0)
            errorMess = errorMess +  "There are " + para + " too many left parenthises\n";
         else if (para <0)
            errorMess = errorMess +  "There are " + Math.abs(para) + " too many right parenthises\n";
      } 
      if (brac !=0)  
      {
         if (brac > 0)
            errorMess = errorMess +  "There are " + brac + " too many left parenthises\n";
         else if (brac <0)
            errorMess = errorMess +  "There are " + Math.abs(brac) + " too many right parenthises\n";
      } 
      if (curl !=0)  
      {
         if (curl > 0)
            errorMess = errorMess +  "There are " + curl + " too many left parenthises\n";
         else if (curl <0)
            errorMess = errorMess +  "There are " + Math.abs(curl) + " too many right parenthises\n";
      } 
   
      return errorMess;
   }

   
   
   
   
   
   
   
   
   
   
   
   
   
}