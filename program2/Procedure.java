public class Procedure
{
   public Compiler C;
   public String name;
   public int address;
   public Procedure(Compiler C)
   {
   this.C = C;
   }

   public Procedure(String nam, int addr)
   {
      name = nam;
      address = addr;
   }

   public void proc(int i)
   {
      if (C.scn.tokens[i] != null)
      if (!C.scn.tokens[i].attribute.equals("iden"))
      {   
         if (C.scn.tokens[0].lexeme.equals("proc"))
         {
            if (C.scn.tokens[i].lexeme.equals(","))
               return ;
            if (C.scn.tokens[i].lexeme.equals(";"))
               return;
            if (C.scn.tokens[i].lexeme.equals("proc"))
               return;
            if (!Character.isLowerCase(C.scn.tokens[i].lexeme.charAt(0)))
               return;
            for (int n=1 ; n  <= C.scn.tokens[i].lexeme.length() - 1; n++)
            {
               if (!Character.isLowerCase(C.scn.tokens[i].lexeme.charAt(n)))
                  return;
            }
         C.scn.tokens[i].attribute = "procName";
         C.pro[C.procNum]= new Procedure(C.scn.tokens[i].lexeme, C.procAdd);
         C.procAdd++;
         C.procNum++;
         //System.out.println("identifier!!!!!!! No. " + C.idenNum);
         
         }
      }
    }
   public void Proced(int i)
      {
         if (!C.scn.tokens[i].attribute.equals("iden"))
         for (int n=0; n<= C.procNum -1; n++)
         {
            if (C.pro[n].name.equals(C.scn.tokens[i].lexeme))
               {
               C.scn.tokens[i].attribute = "procName";
               C.scn.tokens[i].address = C.pro[n].address;
               //System.out.println(C.ident[n].name + "    address: " + C.ident[n].address);
               return;
               }
            else   
               C.scn.tokens[i].attribute = "error";
         }  
      
      }

   




}