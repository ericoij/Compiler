import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.StringTokenizer;

public class Assembler{

   public FileReader fr;
   public BufferedReader br;
   public FileWriter fw;
   public BufferedWriter bw;
   
   public String buffer, bufferCopy, address, token, token1 , token2, token3, token4;
   
   public StringTokenizer strtok;
   
   public Pass_1 P1 = new Pass_1(this);
   public Pass_2 P2 = new Pass_2(this);
   
   public static void main(String[] args)
   {
      Assembler app = new Assembler();
   }
   
   public Assembler ()
   {
   P1.pass_one();
   P2.Pass_two();
   }
   
   }