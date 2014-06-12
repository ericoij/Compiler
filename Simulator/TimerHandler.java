import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class TimerHandler extends JPanel implements ActionListener 
{
   //public TimerHandler(Simulator S)
   //{this.S = S;}
   
   public void actionPerformed(ActionEvent ae)
   {
      repaint();
   
   }
 public static void main(String[] args)
   {
   Simulator app = new Simulator();
   }



}