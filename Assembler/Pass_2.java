//pass-2
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.StringTokenizer;


public class Pass_2
{

private Assembler A;

public Pass_2(Assembler A){this.A = A;}

public void Pass_two()
{
try{
   A.fr = new FileReader("program.aux");
   A.br = new BufferedReader(A.fr);
   A.fw = new FileWriter("program.hex", false);
   A.bw = new BufferedWriter(A.fw);
   
   A.buffer = A.br.readLine();
   while (A.buffer != null)
   {
      A.bufferCopy = "";
      A.strtok = new StringTokenizer(A.buffer, ";");   
      if (A.strtok.hasMoreTokens())
         A.buffer = A.strtok.nextToken();
      if (A.strtok.hasMoreTokens())
         A.bufferCopy = A.strtok.nextToken();
      A.strtok = new StringTokenizer(A.buffer, " ");
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
      
      for(int k=0 ; k<= A.P1.labelNo-1 ; k++) //A.P1.labelNo - 1; k++)
         {
         System.out.println("lablename = " + A.P1.labelName[k]);
         System.out.println("token3 = " +A.token3);
         //if (A.token3!= null)
         if (A.P1.labelName[k].equals(A.token3))
           //if (A.token2.equals("AR" || "SP")) 
            {
              //if (Integer.valueOf(A.token3, 16) > FFF)
              {
            try{
            A.bw.write(String.format("%-4s %-16s %-24s %-32s; %s\n", A.token1 , A.token2 , A.P1.labelAddress[k].substring(0,2) ,
             A.P1.labelAddress[k].substring(2) , A.bufferCopy ));
            }catch (IOException ioe) {}
            break;
            } 
                     
         }
          //write the original line (token1,2,3,4)
           else   
              try{
            if (A.token3.length() > 2)
            A.bw.write(String.format("%-4s %-16s %-24s %-32s; %s\n", A.token1 , A.token2 ,A.token3.substring(0,2) ,A.token3.substring(2) , A.bufferCopy));
            else
            A.bw.write(String.format("%-4s %-16s %-24s %-32s; %s\n", A.token1 , A.token2 ,A.token3 ,A.token4, A.bufferCopy));
            }catch (IOException ioe) {}
         A.buffer = A.br.readLine();    
   }
   }
A.bw.close();   
}catch(IOException ioe){}





}
}