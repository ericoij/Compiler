// Controler

public class Controler{
   
   private Simulator S;
   private int result = 0, memLoc = 0;
   private String temp;
   
   
   public Controler(Simulator S)
   {
      this.S = S;
      
   }

   public void Controler()
   {
     
      
      if (S.P1.equals("10"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) + Integer.valueOf(S.CPU.M[Integer.parseInt(S.CPU.AR.getText())].getText(),16);
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      
      }
      if (S.P1.equals("11"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) + Integer.valueOf(S.CPU.P2.getText(),16); 
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      }
      if (S.P1.equals("12"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) - Integer.valueOf(S.CPU.M[Integer.parseInt(S.CPU.AR.getText())].getText(),16);
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      
      }
   
      if (S.P1.equals("13"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) - Integer.valueOf(S.CPU.P2.getText(),16);
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      
      }
      if (S.P1.equals("20"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) & Integer.valueOf(S.CPU.M[Integer.parseInt(S.CPU.AR.getText())].getText(),16);
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      
      }
      if (S.P1.equals("21"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) & Integer.valueOf(S.CPU.P2.getText(),16); 
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      }
      if (S.P1.equals("22"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) | Integer.valueOf(S.CPU.M[Integer.parseInt(S.CPU.AR.getText())].getText(),16);
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      
      }
      if (S.P1.equals("23"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) | Integer.valueOf(S.CPU.P2.getText(),16); 
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      }
      if (S.P1.equals("24"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) ^ Integer.valueOf(S.CPU.M[Integer.parseInt(S.CPU.AR.getText())].getText(),16);
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      
      }
      if (S.P1.equals("25"))
      {
         result = Integer.valueOf(S.CPU.A.getText(),16) ^ Integer.valueOf(S.CPU.P2.getText(),16); 
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      }
      if (S.P1.equals("25"))
      {
         result = -Integer.valueOf(S.CPU.A.getText(),16); 
         S.CPU.A.setText(("" + result).toUpperCase());
         flags();
      }

      if (S.P1.equals("30"))
      {
         
         for (int i=0; i < 16; i ++)
            if ((i)== Integer.parseInt(S.CPU.AR.getText(),16))
               temp = S.CPU.M[i].getText();
         
         S.CPU.A.setText(temp);
      }
      if (S.P1.equals("31"))
      {
         temp = S.CPU.A.getText();
         
         for (int i=0; i < 16; i ++)
            if ( (i) ==Integer.parseInt(S.CPU.AR.getText(),16))
            {
               S.CPU.M[i].setText(temp);
               result =i;
               break;
            }
               
      }
      if (S.P1.equals("34"))
      {
         S.CPU.AR.setText(S.P2 +S.P3);
         
      
      }
      
      
      //flags(); 
   
   
   }

   public void flags()
   {
      if (result == 0)
         S.CPU.F.setText("110");
      else if (result > 127)
         S.CPU.F.setText("001");
      else
         S.CPU.F.setText("010");
            
   }

   




}