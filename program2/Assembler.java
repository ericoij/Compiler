import java.io.FileReader;

public class Assembler{

   public FileReader fr;
   public BufferedReader br;
   public FileWriter fw;
   public BufferedWriter bw;
   
   public String buffer, bufferCopy, adres, token, token1 , token2, token3, token4;
   
   public StringTokenizer strtok;
   
   public Pass_1 p1 = new Pass_1(this);
   public Pass_2 p2 = new Pass_2(this);
   
   public static void main(String[] args)
   {
      Assembler app = new Assembler();
   }
   
   public Assembler ()
   {
   p1.pass_one();
   p2.pass_two();
   }