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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CPUPanel  extends JPanel
{

   public JLabel A, F, P1 , P2, P3, PC, AR, M1, M2, M3, M4, M5;
   public JLabel[] M = new JLabel[16];
   Border border = LineBorder.createGrayLineBorder();
   private Simulator S;
   //with all arithmatical or logical operations, fix the flags
   public CPUPanel(Simulator S)
   {
   super();
   this.S=S;
   
   setLayout(new GridLayout(5,8));
   setBackground(Color.MAGENTA);
   
   F = new JLabel();
   A = new JLabel();
   P1 = new JLabel();
   P2 = new JLabel();
   P3 = new JLabel();
   PC = new JLabel();
   AR = new JLabel();
   for (int i =0 ; i < 16 ; i++)
      M[i] = new JLabel();
   
   F.setBorder(border);
   M1 = new JLabel();
   M2 = new JLabel();
   M3 = new JLabel();
   M4 = new JLabel();
   M5 = new JLabel();
   
   add( A); // row 1
   add( F );
   add( new JLabel());
   add( new JLabel());
   add( (M[0]));
   add( new JLabel());  
   add( new JLabel("S1 = "));
   add( new JLabel());
   
   add( PC);  // row 2
   add( P1);
   add(P2);  
   add( P3);
   add( (M[1]));
   add( new JLabel());
   add( new JLabel());
   add( new JLabel());  
   
   add( new JLabel());  // row 3
   add( new JLabel());
   add( new JLabel());
   add( new JLabel());
   add((M[2]));  
   add( new JLabel());
   add( new JLabel());
   add( new JLabel());
   
   add( new JLabel()); // row 4
   add( new JLabel());  
   add( new JLabel());
   add( AR );
   add( (M[3]));
   add( new JLabel());
   add( new JLabel());  
   add( new JLabel());
   
   add( new JLabel()); // row 5
   add( new JLabel());
   add( new JLabel());
   add( new JLabel()); 
   add( (M[4]));
   add( new JLabel());
   add( new JLabel());
   add( new JLabel());
   
   
   
   }//CPUPanel
}