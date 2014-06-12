//IR Code
import java.io.IOException;

public class IRCode
{
   public int startIndex , endIndex;
   private Compiler C;
   
   public String irCode; 
   public int labelNo;
   
   private int relIndex;
 
   public IRCode(Compiler C)
   {
   this.C = C;
   }

   public void newIden()
      {
      irCode = "";
      String tempIden = "";
         endIndex = C.P.tokInd;
         for (int n = endIndex; n >= 0 ; n--)
            if ( C.scn.tokens[n].lexeme.equals("(") && C.scn.tokens[n].lexeme.equals(":="))
               {
               startIndex = n+1;
               //break;
               n = 0;
               }
         for (int j = C.P.tokInd   ;  j!= startIndex  && j != -1 ; j--)
            tempIden = C.scn.tokens[j].lexeme + tempIden;
         C.ident[C.idenNum]= new Identifier("nIden" + C.newIdenNum, C.dataAddress);
         System.out.println(C.ident[C.idenNum].name);
         
         irCode = C.ident[C.idenNum].name + " := "+ tempIden+ '\n';
         
         try{
         C.irb.write(irCode);
         }
         catch(IOException ioe){}
         
         C.scn.tokens[startIndex].lexeme = C.ident[C.idenNum].name;
         C.scn.tokens[startIndex].attribute = "iden";
         C.scn.tokens[startIndex].address = C.ident[C.idenNum].address;
         
         for (int i = startIndex +1 ; i<=endIndex ; i++)
            {
               C.scn.tokens[i].lexeme = "";
               C.scn.tokens[i].attribute = "";
               //C.scn.tokens[i].address = "";
            }
        
         C.dataAddress++;
         C.idenNum++;
         C.newIdenNum++;
      }

      public void assignmentStmt()
      {
         endIndex = C.P.tokInd;
         
         for (int n = endIndex ; n>=0 ; n--)
            if(C.scn.tokens[n].lexeme.equals(":="))
               startIndex = n;   
   
         irCode = "";
         
         for (int n = startIndex ; n <= endIndex ; n++ )
            irCode = irCode + C.scn.tokens[n].lexeme;

         try{
         C.irb.write(irCode);
         }
         catch(IOException ioe){}



      }


   public void ifStart(){
        //labels[labelNo] = "L" + Integer.toString(labelNo);
        irCode = "";
        endIndex= C.P.tokInd;
        for(int n= endIndex; n>=0; n--)
            if(C.scn.tokens[n].attribute.equals("relOp")){
                relIndex=n;
                break;
                }
        for(int n= relIndex; n>= 0; n--)
            if(C.scn.tokens[n].lexeme.equals("if")){
                startIndex = n;
                irCode= "if ";
                //break;
                n=-1;
                }
                
                        
        for(int n= startIndex + 1; n<= relIndex+1; n++)
            irCode= irCode + C.scn.tokens[n].lexeme;
            if(C.scn.tokens[relIndex].lexeme.equals(">="))
                irCode= irCode + "<";
            if(C.scn.tokens[relIndex].lexeme.equals("=="))
                irCode= irCode + "<>";
            if(C.scn.tokens[relIndex].lexeme.equals("<>"))
                irCode= irCode + "==";
            if(C.scn.tokens[relIndex].lexeme.equals("<"))
                irCode= irCode + ">=";
        for(int n= relIndex+1; n<=startIndex-1;n--)
            irCode= irCode + C.scn.tokens[n].lexeme;
        irCode= irCode + "goto " + C.labels[labelNo] + '\n' ;
        
        try{
         C.irb.write(irCode);
         }
         catch(IOException ioe){}
        //labelNo ++;    
    }
    
    public void ifEnd(){
        irCode = "";
        irCode= C.labels[labelNo];
        try{
         C.irb.write(irCode);
         }
         catch(IOException ioe){}
         labelNo++;
    }
    
      public void whileStart() 
      {
         endIndex= C.P.tokInd;
         for(int n= endIndex; n>= 0; n--)
             if(C.scn.tokens[n].lexeme.equals (":="))
              startIndex = n-1;
   irCode= "";
   for(int n= startIndex; n<= endIndex; n++)
       irCode= irCode + C.scn.tokens[n].lexeme;
   for(int n= relIndex; n>= 0; n--)
            if(C.scn.tokens[n].lexeme.equals("while")){
                startIndex = n;
                irCode= "while";
                //break;
                n = -1;
                }
    
   //fw = new FileWriter("Program.ir");
   //bw = new BufferedWriter(fw);
   //n = startIndex + 2;
    }











}