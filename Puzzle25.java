//package puzzle25;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Devendra
 */
public class Puzzle25 extends JFrame implements ActionListener{

   
    public static void main(String[] args) {
        Puzzle25 world=new Puzzle25();
        world.setVisible(true);
    }
    JPanel p;
    JButton [][]cell=new JButton[5][5];
    Random count=new Random(24);
    Integer []num=new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    
  
    public Puzzle25() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
      p=new JPanel();
      p.setLayout(new GridLayout(5,5));
      p.setSize(500,500);
      p.setBounds(50, 50,500,500);
      add(p);
      
    /*  for (int i = 0; i <25; i++){
        num[i]=i+1;
      }*/
       Collections.shuffle(Arrays.asList(num));
        int inc=0;
        for (int i = 0; i <5; i++) {
             for (int j = 0; j < 5; j++){
                 cell[i][j]=new JButton();
                 cell[i][j].setBackground(new Color(120,150, 210));
                  p.add(cell[i][j]);
                   if(i==3 && j==2)
                   { cell[i][j].setText(" ");
                     cell[i][j].setBackground(Color.yellow);
                       continue;
                   }
                  //cell[i][j].setText(""+(count.nextInt(25)+1));
                   cell[i][j].setText(""+(num[inc]));inc++;
                  cell[i][j].addActionListener(this);
                
           }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
       
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(ae.getSource()==cell[i][j])                { 
                    {
                   try{
                    if( i!=0  && cell[i-1][j].getText()==" "  )
                    {cell[i-1][j].setText(""+cell[i][j].getText());
                     cell[i-1][j].setBackground(new Color(120,150, 210));
                    cell[i][j].setText(" ");
                    cell[i][j].setBackground(Color.yellow);
                    
                   } 
                   
                   else if(i!=4 && cell[i+1][j].getText()==" " )
                   {cell[i+1][j].setText(""+cell[i][j].getText());
                    cell[i+1][j].setBackground(new Color(120,150, 210));
                    cell[i][j].setText(" ");
                    cell[i][j].setBackground(Color.yellow);
                   } 
                    
                   else  if(j!=0 && cell[i][j-1].getText()==" " )
                   {cell[i][j-1].setText(""+cell[i][j].getText());
                    cell[i][j-1].setBackground(new Color(120,150, 210));
                    cell[i][j].setText(" ");
                    cell[i][j].setBackground(Color.yellow);
                   } 
                     
                   else if(j!=4 && cell[i][j+1].getText()==" ")
                   {cell[i][j+1].setText(""+cell[i][j].getText());
                    cell[i][j+1].setBackground(new Color(120,150, 210));
                    cell[i][j].setText(" ");
                    cell[i][j].setBackground(Color.yellow);
                   } 
                   
                   }catch(Exception e){}
               
                    }
                }
            }
        }
       }
    
    
    
    
}
