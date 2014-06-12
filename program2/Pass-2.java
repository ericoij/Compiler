//pass-2
import java....

public class Pass_2
{

private Assembler A;

public Pass_2(Assembler A){this.A = A}


try{
   A.fr = new FileReader("program.aux");
   A.br = new BufferedReader(A.fr);
   A.fw = new FileWriter("program.hex", false);
   A.bw = new BufferedWriter(A.fw);
   
   A.buffer = A.br.readLine();
   while (A.buffer != null)
   {
      A.bufferCopy = "";
      A.strtok = new StringTokenizer(A.buffer, ";")   
      if (A.strtok.hasMoreTokens())
         A.buffer = A.strtok.nextToken();
      if (A.strtok.hasMoreTokens())
         A.bufferCopy = A.strtok.nextToken();
      A.strtok = new StringTokenizer(A.buffer, " ")
      A.token1= "";
      A.token2= "";
      A.token3= "";
      A.token4= "";
      if (A.strtok.hasMoreTokens())
         A.token1 = A.strtok.nextToken();
      if (A.strtok.hasMoreTokens())
         A.token2 = A.strtok.nextToken();
      if (A.strtok.hasMoreTokens())
         A.token3 = A.strtok.nextToken();
      if (A.strtok.hasMoreTokens())
         A.token4 = A.strtok.nextToken();
      
      for(int k=0 ; k<= A.P1.labelNo - 1; k++)
         {
         if (A.P1.labelName[k].equals(A.token3)
            {
            try{
            A.bw.write(%.............., A.token1 , A.token2 , A.P1.labelAddress.substring(0,2) ,
             A.P1.labelAddress.substring(2) , ";" + A.bufferCopy);
            }catch (IOException ioe) {}
            break;
            }
         else 
            {//write the original line (token1,2,3,4)
               
            
            
            }
          }  
   }






}