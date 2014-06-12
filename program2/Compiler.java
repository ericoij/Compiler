import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;

public class Compiler
{
   public FileReader fr;
   public FileWriter fw, irw, acw;
   public BufferedReader br;
   public BufferedWriter bw, irb, acb;
   public String buffer;
   private int statementNo = 1;
   public Scanner scn = new Scanner(this);
   public hasError err = new hasError(this);
   public Parser P = new Parser(this);
   public AssemblyCode A = new AssemblyCode(this);
   public Identifier[] ident = new Identifier[2000];
   public IOException io;
   public int mainCo = 0;
   public int idenNum=0;
   public int dataAddress =0;
   public int newIdenNum = 0;
   public int procNum = 0 , procAdd = 1500;
   public Procedure[] pro = new Procedure[50];
   public IRCode IR = new IRCode(this); 
   public String[] labels = new String[50];
   
   public Compiler()
   {
      System.out.println("compiler....\n");
      for (int i = 0; i < 50; i++)
         ident[i] = new Identifier(this);
      for (int i = 0; i < 50; i++)
         pro[i] = new Procedure(this);
      for (int i = 0; i < 50; i++)
         labels[i] = "L" + i;
      mainCo =0;
      try
      {
         fr = new FileReader("program.sl");
         br = new BufferedReader(fr);
         fw = new FileWriter("program.tok");
         bw = new BufferedWriter(fw);
         irw = new FileWriter("IRCode.prg");
         irb = new BufferedWriter(irw);
         acw = new FileWriter("assemblyCode.prg");
         acb = new BufferedWriter(acw);
         //IRfr = new FileReader("IRCode.prg");
         //IRbr = new BufferedReader(IRfr);

         
                  
         while ((buffer = br.readLine()) != null)
         {
            System.out.print("Statement " + statementNo + ": " + buffer+ "\n");
            bw.write("Statement " + statementNo + ":" + buffer+ "\n");
            statementNo++;
            scn.Scanner();
            bw.write(err.hasErrors());//error call
            P.Parser();
            System.out.print("-----------------------------------\n"); 
            bw.write("----------------------------------------\n");
            
         }
         br.close();
         bw.close();
         irb.close();
         acb.close();
         acw.close();
         irw.close();
      }
      catch(FileNotFoundException fnf){}
      catch(IOException ioe){}
      try{
      for (int i = 0 ; i < idenNum ; i++)
         System.out.println(ident[i].name);
         }catch(NullPointerException npe){}
      System.out.println("End of Program");
      System.exit(0);
   
   
   }

   public static void main(String[] args)
   {
      Compiler app = new Compiler();  
   
   
   }

  /* public String hasErrors()
   {
      String errorMess = "";
      int para = 0, brac = 0, curl = 0 ,count=0; 
      //check main method
      if (scn.tokens[0]!=null)
         if (scn.tokens[0].lexeme.equals( "main"))
         {
           mainCo++;
           if (!scn.tokens[1].lexeme.equals("(") && !scn.tokens[2].equals(")") && mainCo!=1 && scn.tokens[3] != null)
               errorMess = errorMess + "the main method is not valid\n";
         }
         
      
      for (int i =0 ; scn.tokens[i]!=null ; i++)
      {         
         if (scn.tokens[i].lexeme.equals( "("))
            para++;
         else if (scn.tokens[i].lexeme.equals(")"))
            para--;
         else if (scn.tokens[i].lexeme.equals("["))
            brac++;
         else if (scn.tokens[i].lexeme.equals("]"))
            brac--;
         else if (scn.tokens[i].lexeme.equals("{"))
            curl++;
         else if (scn.tokens[i].lexeme.equals("}"))
            curl--;
         else if (scn.tokens[i].lexeme.equals(";"))
           { if (curl != 1)
               if (scn.tokens[i+1]!=null)
                  errorMess = errorMess +  "there is something after your semicolon at token# " + count +"... ;+. please fix\n";
            }
         if (scn.tokens[i].lexeme.equals(":="))
            {
            if (!scn.tokens[i-1].attribute.equals("iden"))
               errorMess = errorMess +  "Limproper use of the assnOp at token# " + i+ "\n";
            if (scn.tokens[i + 1].attribute.equals("oper") || scn.tokens[i + 1].attribute.equals("digit") || scn.tokens[i + 1].attribute.equals("iden"))
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
   }*/









}