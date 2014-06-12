//Assembly Code

import java.io.IOException;

public class AssemblyCode
{
   private Compiler C;
   private String assemCode;
   private int m;
   public AssemblyCode(Compiler C){this.C = C;}
   private String mainFlag = "ON";
   private int relIndex;

   public void newStmt()
      {
         m = C.IR.startIndex + 1;
         newExpr();
         for (int i = C.IR.startIndex +1 ; i<=C.IR.endIndex ; i++)
            {
               C.scn.tokens[i].lexeme = "";
               C.scn.tokens[i].attribute = "";
               C.scn.tokens[i].address = 0;
            } 
      
      }

   public void newExpr()
      {
         m= C.IR.startIndex ;// must cover addition of numbers, identifiers and subtraction of numbers, identifiers
         assemCode = "MVI A , 0\n";
         try{
            C.acb.write(assemCode);
         }catch(IOException ioe){}
         // write to file IRCode
         if (C.scn.tokens[m].attribute.equals("iden"))
            addIden(m);
         if (C.scn.tokens[m].attribute.equals("num"))
            addNum(m);   
         for (int n = C.IR.startIndex + 1; n < C.IR.endIndex ; n++)
            {
               if (C.scn.tokens[n].lexeme.equals("+") && C.scn.tokens[n].attribute.equals("iden"))
                  addIden(n);
               if (C.scn.tokens[n].lexeme.equals("-") && C.scn.tokens[n].attribute.equals("iden"))
                  subIden(n);
               if (C.scn.tokens[n].lexeme.equals("+") && C.scn.tokens[n].attribute.equals("num"))
                  addNum(n);
               if (C.scn.tokens[n].lexeme.equals("+") && C.scn.tokens[n].attribute.equals("num"))
                  subNum(n);            
               n++;//adds 2 to n
            }
         assemCode = "LXI AR , " + Integer.toString(C.scn.tokens[C.IR.startIndex].address)+ '\n';
         try{
         C.acb.write(assemCode);
         assemCode = "MOV M , A\n";
         //write to file
         C.acb.write(assemCode);
         }catch(IOException ioe){}
      }
      
   
   public void addIden(int q)
      {
         try
         {
         assemCode = "LXI AR ," + Integer.toString(C.scn.tokens[q].address) + '\n';
         //write to file IRCode
         C.acb.write(assemCode); 
         assemCode = "ADD M , A\n";
         C.acb.write(assemCode);
         }
         catch (IOException ioe) {}
      
      
      }

   public void subIden(int q)
      {
         try
         {
         assemCode = "LXI AR ," + Integer.toString(C.scn.tokens[q].address) + '\n';
         //write to file IRCode 
         C.acb.write(assemCode);
         assemCode = "SUB M , A" + '\n';
         C.acb.write(assemCode);
         }
         catch (IOException ioe) {}
      
      
      }
   
   //addNum , subNum
      public void addNum(int q)
      {
         try
         {
         //assemCode = "MVI A , 0"+ '\n';
         //write to file IRCode 
         C.acb.write(assemCode);
         assemCode = "ADI " + C.scn.tokens[q].lexeme + '\n';
         C.acb.write(assemCode);
         }
         catch (IOException ioe) {}
      
      
      }

      public void subNum(int q)
      {
         try
         {
         //assemCode = "MVI A , 0"+ '\n';
         //write to file IRCode 
         C.irb.write(assemCode);
         assemCode = "SUI " +C.scn.tokens[q].lexeme+ '\n';
         C.acb.write(assemCode);
         }
         catch (IOException ioe) {}
      
      
      }

   public void assignmentStmt()
      {
         newExpr();
         
         for (int i = C.IR.startIndex +1 ; i<=C.IR.endIndex ; i++)
            {
               C.scn.tokens[i].lexeme = "";
               C.scn.tokens[i].attribute = "";
               C.scn.tokens[i].address = 0;
            }

   
   
   
      }
   public void relExpr()
   {
      assemCode = "MVI A, 00 dude" + '\n';
      
      if (C.scn.tokens[C.IR.startIndex].attribute.equals("iden"))
         addIden(C.IR.startIndex);
      if (C.scn.tokens[C.IR.startIndex].attribute.equals("num"))
         addNum(C.IR.startIndex);
      for (int n = C.IR.startIndex ; n <= C.IR.endIndex ; n++)
         if (C.scn.tokens[n].lexeme.equals("+") && C.scn.tokens[n+1].attribute.equals("iden"))
            {addIden(n);//
            n++;}
         else if (C.scn.tokens[n].lexeme.equals("-") && C.scn.tokens[n+1].attribute.equals("iden"))
            {subIden(n);//
            n++;}
         else if (C.scn.tokens[n].lexeme.equals("+") && C.scn.tokens[n+1].attribute.equals("num"))
            {addNum(n);//
            n++;}
         else if (C.scn.tokens[n].lexeme.equals("-") && C.scn.tokens[n+1].attribute.equals("num"))
            {subNum(n);//
            n++;}
   
       assemCode = "LXI AR , " + C.scn.tokens[C.IR.startIndex].address + '\n';
       assemCode = "SUB M , A\n";
       relIndex = C.IR.startIndex + 1;
       
       if (C.scn.tokens[relIndex].lexeme.equals(">="))
         assemCode = "JL \n";
       assemCode= "LXI AR "+ C.scn.tokens[C.IR.startIndex].address + '\n';
       assemCode= "SUB M \n";
       if(C.scn.tokens[relIndex].lexeme.equals(">=")) 
         assemCode= "JL";
       if(C.scn.tokens[relIndex].lexeme.equals("==")) 
         assemCode= "JNZ";
       if(C.scn.tokens[relIndex].lexeme.equals("<")) 
         assemCode= "JGE";
       if(C.scn.tokens[relIndex].lexeme.equals("<>")) 
         assemCode= "JZ";
       
         
   try
         {
         C.acb.write(assemCode);
         }
         catch (IOException ioe) {}

   
   
   //LXI AR , [x]
   //CMP M or SUB M
   // both give A - x
   // if < JGE
   // if >= JL
   // if == JNZ
   // if <> JZ
   
   }
      public void ifStart()
      {
           relExpr();
        for(int n= C.IR.startIndex; n <= C.IR.endIndex; n++){
           C.scn.tokens[n].lexeme= "";
           C.scn.tokens[n].attribute="";
           C.scn.tokens[n].address= 0;
        } 
        C.IR.labelNo++;
    }
      
      public void ifEnd()
      {
        assemCode= C.labels[C.IR.labelNo];
      }
      
      public void WhileStart() 
      {
       int n= C.IR.startIndex +2;
       relExpr();
   for(n=C.IR.startIndex; n<= C.IR.endIndex; n++)
       C.scn.tokens[n].lexeme="";
       C.scn.tokens[n].attribute="";
       C.scn.tokens[n].address=0;
   }
   
   
   public void call()
      {
        assemCode= C.scn.tokens[0].lexeme.toUpperCase();
        try {
            C.acb.write(assemCode);
        } catch (IOException ex) {}
        //fw = new FileWriter("Program.asm");
	//bw = new BufferedWriter(fw);
        assemCode= C.scn.tokens[1].lexeme.toUpperCase();
        try {
            C.acb.write(assemCode);
            //bw = new BufferedWriter(fw);
            //bw = new BufferedWriter(fw);
        } catch (IOException ex) {}
        
     }
     
     public void start() {
       try{
        assemCode = "ORG: " + 1000 + '\n';   // PM program memory = 1000
        C.acb.write(assemCode);
        //fw = new FileWriter("Program.asm");
	//bw = new BufferedWriter(fw);
        assemCode = "JMP L0\n";
        C.acb.write(assemCode);
        //fw = new FileWriter("Program.asm");
	//bw = new BufferedWriter(fw);
        assemCode = "L0:" + (1000+10)+ '\n';
        C.acb.write(assemCode);
        //fw = new FileWriter("Program.asm");
	//bw = new BufferedWriter(fw);
        mainFlag = "OFF";
        }catch (IOException ioe){}
        C.IR.labelNo++;
    }
    
    public void end(){
        if(mainFlag.equals("OFF")){
            assemCode= "HLT\n";
            
            mainFlag= "ON";
        }
        else assemCode= "RET";
         try {
                C.acb.write(assemCode);
            } catch (IOException ioe) {}
    }
}



/*
 else if ((x = parse.indexOf("if relexp then")) >= 0){
              parse = parse.substring(0,x) + "ifStart ";
              length = length-2;
               C.IR.ifStart();
               C.AC.ifStart();
          }
          else if ((x = parse.indexOf("ifStart stmt")) >= 0){
              parse = parse.substring(0,x) + "ifstmt ";
              length = length-1;
               C.IR.ifEnd();
               C.AC.ifEnd();
               
          }
          else if ((x = parse.indexOf("while relexp do")) >= 0){
              parse = parse.substring(0,x) + "whileStart ";
              length = length-2;
          }
          else if ((x = parse.indexOf("whileStart stmt")) >= 0){
              parse = parse.substring(0,x) + "whilestmt ";
              length = length-1;
               //C.IR.whileStart();
               //C.AC.whileStart();
          }
          else if ( (x = parse.indexOf("asstmt")) >= 0 || (x= parse.indexOf("ifstmt"))>=0 || (x= parse.indexOf("whilestmt"))>=0 || (x= parse.indexOf("spclstmt"))>=0 ){
              parse = parse.substring(0,x) + "stmt ";
          }
          else if ((x = parse.indexOf("stmt stmt")) >= 0){
              parse = parse.substring(0,x) + "stmt ";
              length = length-1;
          }
          else if ((x = parse.indexOf("{ stmt }")) >= 0){
              parse = parse.substring(0,x) + "stmt ";
              length = length-2;
          }
          else
              loop = false;
      }
      
      if(parse.equals ("call prnam")){
        parse= "spclstmt";
        length= length - 1;
        C.AC.call();
      }
      if(parse.equals ("main()")){
        parse= "spclstmt";
        length= length - 2;
          try {
              C.AC.start();
          } catch (IOException ex) {
              Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      if(parse.equals ("end")){
        parse= "spclstmt";
        C.AC.end();
      }
      
       System.out.println("parse reduce() = "+parse+ "-- length:"+length);       
    }
    public void clearParse(){
        parse = "";
    }

*/
