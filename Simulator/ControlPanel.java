import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ControlPanel extends JPanel
{
   private Simulator S;
   private JButton step, run, reset, quit;
   private ButtonHandler bh = new ButtonHandler();
   
   public ControlPanel(Simulator S)
   {
   super();
   this.S=S;
   
   setLayout(new GridLayout(8,1));
   setBackground(Color.GREEN);
   
   
   add( new JLabel());
   add( new JLabel());
   step = new JButton("step");
   add( step); 
   run = new JButton("run");
   add (run);
   reset = new JButton("reset");
   add (reset);
   quit = new JButton("quit");
   add (quit);
   add (new JLabel());
   add (new JLabel());
   
   quit.addActionListener(bh);
   run.addActionListener(bh);
   reset.addActionListener(bh);
   step.addActionListener(bh);
   
   }

   private class ButtonHandler implements ActionListener
   {
      
      public void actionPerformed(ActionEvent ae)
         {
            
            if (ae.getSource() == quit)
               System.exit(0);
            if (ae.getSource() == step)  
               S.stepFlag = "ON";
            //if (ae.getSource() == quit)
   
            //if (ae.getSource() == quit)
         
         }
   
   }







}