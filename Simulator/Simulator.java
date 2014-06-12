import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.StringTokenizer;


public class Simulator extends JFrame
{
   private ControlPanel CP = new ControlPanel(this);
   private ProgramPanel PP = new ProgramPanel(this);
   public CPUPanel CPU = new CPUPanel(this);
   private Controler C = new Controler(this);
   private Timer timer = new Timer(10, new TimerHandler());
   public String stepFlag;
   public FileReader fr;
   public BufferedReader br;
   public String comment, temp, buffer, P1, P2, P3, P4, PC;
   public StringTokenizer strtok;
   public Memory[] M = new Memory[50];
   public String readArray[] = new String[200];
   
   public Simulator()
   {
      super("Simulator");
      setLayout(new BorderLayout());
        add(CP    ,BorderLayout.WEST);
        add(PP    ,BorderLayout.SOUTH);
        add(CPU , BorderLayout.CENTER);
        setVisible(true);
        setSize(600 ,400);
        timer.start();
        try{
        fr = new FileReader("program.hex");
        br = new BufferedReader(fr);
        stepFlag = "ON";
       CPU.A.setText("0");
       for (int i =0 ; i<50 ; i++)
         M[i] = new Memory("","");
       buffer =  br.readLine();
       for (int i = 0 ; i <200 ; i++)
         readArray[i] = "";
       // for // read program.hex accually we have to do this!!!!!!!!!!!!!
       int j=0;
       while (buffer != null)
         {
         readArray[j] = buffer;
         buffer = br.readLine();
         j++;
         }
         j=0;
       while ( readArray[j] != null)
       {
            
            strtok = new StringTokenizer(readArray[j], ";");
            while(stepFlag.equals("ON"))
            {
            
            if (strtok.hasMoreTokens())
               {
                  temp = strtok.nextToken();
                  comment= strtok.nextToken();
                  PP.intstructionLabel.setText(comment);
               }
            if (buffer.indexOf(":")>-1)
               PC = buffer.substring(0,buffer.indexOf(":"));
            P1="";
            P2="";
            P2="";   
            strtok = new StringTokenizer(readArray[j] , " ,:;");
            if (strtok.hasMoreTokens())
                {PC = strtok.nextToken();
                  CPU.PC.setText(PC);}
            if (strtok.hasMoreTokens())
                {P1 = strtok.nextToken();
                if (!P1.equals(";"))
                  CPU.P1.setText(P1);
                else
                  CPU.P1.setText("");  }
            if (strtok.hasMoreTokens())
                {P2 = strtok.nextToken();
                if (!P2.equals(";"))
                  CPU.P2.setText(P2);
                else
                  CPU.P2.setText("");  }   
            if (strtok.hasMoreTokens())
                {P3 = strtok.nextToken();
                if(!P3.equals(";"))
                  CPU.P3.setText(P3);
                else
                  CPU.P3.setText("");  }   
                
            C.Controler();
            //tokenize with ; display in program panel
            repaint();
            stepFlag= "OFF";
            //buffer = br.readLine();
            j++;
            }
            //if (CPU.P1.nextText().indexOf("12") >=0) // ADI
        
        
        
        //buffer = br.readLine();
        }
      }catch (IOException ioe){}
   }//simulator
         /*public void flags()
         {
            if (result== 0)
               S.CPU.F.setText("001");
            else if (result > 127)
               S.CPU.F.setText("001");
            else
                S.CPU.F.setText("001");
            
         */
         




}