// pass 1

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;


public class Pass_1
{
   private int type, offset, labelNo = 0;
   public String[] labelName= new String[20];
   public String[] labelAddress= new String[20];
   private Assembler A;
   
   public Pass_1(Assembler A) {this.A = A;}
   
   public void pass_one()
   {
      try{A.fr = new FileReader("program.asm");
      A.br = new BufferedReader(A.fr);
      A.fw = new FileWriter("program.aux" , false);
      A.bw = new BufferedWriter(A.fw);
      
      A.buffer = A.br.readline();
      while (A.buffer!= null)
      {
         A.strtok = new StringTokenizer(A.buffer, ";");//for comments
         if (A.strtok.hasMoreTokens())
            //for empty lines
      
      
      A.token = A.strtok.nextToken();
      A.bufferCopy = A.token;
      if (A.token.indexOf(":")>= 0)
         {
            A.strtok = new StringTokenizer(A.token, ": ");
            A.token = A.strtok.nextToken();
            if (A.token.equals("ORG"))//....
               org();
            else //...
               label();
         }
      else
      {
      A.strtok = new StringTokenizer (A.bufferCopy , ", ");
      if (A.strtok.hasMoreTokens())
         A.token1 =  A.strtok.nextToken();
      if (A.strtok.hasMoreTokens())
         A.token2 =  A.strtok.nextToken();
      if (A.strtok.hasMoreTokens())
         A.token3 =  A.strtok.nextToken();
      
      if (A.token1.equals("ADD"))
         type_2("10", 2);
      if (A.token1.equals("ADI"))
         type_2("11" , 2);
      if (A.token1.equals("SUB"))
         type_2("12" , 2);
      if (A.token1.equals("SUI"))
         type_2("13" , 2);
      if (A.token1.equals("AND"))
         type_2("20" , 2);   
      if (A.token1.equals("ANI"))
         type_2("21" , 2);
      if (A.token1.equals("OR"))
         type_2("22" , 2); 
      if (A.token1.equals("ORI"))
         type_2("23" , 2);   
      if (A.token1.equals("XOR"))
         type_2("24" , 2);  
      if (A.token1.equals("XRI"))
         type_2("25" , 2);
      if (A.token1.equals("CMA"))
         type_2("26" , 2);         //....... for each 
      }
      A.buffer = A.br.readLine();
      
      }
   A.br.close();
   A.bw.close();
   }catch(IOException ioe){}
   }
   
   public void org();
   {
      labelName[labelNo] = A.token1;
      A.address = A.strtok.nextToken();
      while (A.address.length() < 4) {A.address = "0" + A.address;}
      A.address = A.address.toUpperCase();
      labelAddress[labelNo] = A.address;
      try{A.bw.write(String.format("\n%s:\n", labelName[labelNo]));   }
      catch (IOException ioe){}
      labelNo++;
   }
   
   public void label()
   {
      labelName[labelNo] = A.token;
      labelAddress[labelNo] = A.address;
      try{A.bw.write(String.format("\n%s:\n", labelName[labelNo]));   }
      catch (IOException ioe){}
      labelNo++;
   
   }
   
  /* public void add()
   {
     // A.token1 = "10";
      //try {A.bw.write(String.format("%-4s: %-16s; %s\n", A.address, A.token1, A.bufferCopy));}
      //catch(IOException ioe){}
      //A.address = Integer.toHexString(Integer.parseInt(A.address,16) + 1 ).toUpperCase();
      type_2("10", 2);

   }
   
   public void adi()//same for sui, and, or, xor, ani, ori, xri, with different A.token1 (opcode) 
   {
    /* A.token1 = "11";
     offset = 2;
     try{A.bw.write(String.format("%-4s: %-16s %-24s; %s\n", A.address, A.token1, A.token2, A.bufferCopy))
     catch(IOException ioe){}
   address + 2;
   type_2("11" , 2);
   
   }
   
   public void sui()
   {
     A.token1 = "12";//double check this
     offset = 2;
     try{A.bw.write(String.format("%-4s: %-16s; %s\n", A.address, A.token1, A.token2, A.bufferCopy))
     catch(IOException ioe){}
   
   
   }*/
   
   public void type_1(String opcode, int offset)
      {
         A.token1 = opcode;
      try {A.bw.write(String.format("%-4s: %-16s; %s\n", A.address, A.token1, A.bufferCopy));}
      catch(IOException ioe){}
      A.address = Integer.toHexString(Integer.parseInt(A.address,16) + offset ).toUpperCase();
      
         //A.address = A.address +offset;
      }
   
   public void type_2(String opcode , int offset)
      {
       A.token1 = opcode;
      try{A.bw.write(String.format("%-4s: %-16s %-24s; %s\n", A.address, A.token1, A.token2, A.bufferCopy));}
     catch(IOException ioe){}
   A.address = Integer.toHexString(Integer.parseInt(A.address,16) + offset ).toUpperCase();
      
      }
   public void type_3(String opcode, int offset)
      {
          A.token1 = opcode;
         try{A.bw.write(String.format("%-4s: %-16s %-24s; %s\n", A.address, A.token1, A.token3, A.bufferCopy));}
     catch(IOException ioe){}

      
      A.address = Integer.toHexString(Integer.parseInt(A.address,16) + offset ).toUpperCase();      }
      
      public void type_4(String opcode, int offset)
      {
          A.token1 = opcode;
         try{A.bw.write(String.format("%-4s: %-16s %-24s %-32s; %s\n", A.address, A.token1, A.token2, A.token3, A.bufferCopy));}
     catch(IOException ioe){}

      A.address =Integer.toHexString(Integer.parseInt(A.address,16) + offset ).toUpperCase();      
      }
} 