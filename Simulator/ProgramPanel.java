//Program Panel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;

public class ProgramPanel extends JPanel
   {
      private Simulator S;      
      public JLabel intstructionLabel;
   
      public ProgramPanel(Simulator S)
         {
            super();
            this.S = S;
            
            setLayout(new GridLayout(3,1));
            setBackground(Color.RED);
            add (new JLabel());
            intstructionLabel = new JLabel("", JLabel.CENTER);
            add (intstructionLabel);
            add (new JLabel());

         
         
         
         
         }
      
       
   
   }