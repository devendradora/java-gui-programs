//package projectile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

/**
 *
 * @author Devendra
 */
public class Projectile extends JFrame implements ActionListener,Runnable{

    public static void main(String[] args) {
       Projectile world=new Projectile();
       world.setVisible(true);
    }
    int f_width=1000,f_height=700;
    double angle=50,velocity=100; //angle in degrees ,velocity in m / sec
    JButton project=new JButton("Project");
    Rectangle ball=new Rectangle(100,550,2*10,2*10);;    
    Thread th=new Thread(this);
    JScrollBar anglescroll=new JScrollBar(JScrollBar.VERTICAL, (int) angle, 5,0,95);
    JScrollBar velscroll=new JScrollBar(JScrollBar.VERTICAL, (int)velocity, 5,0,145);
    JLabel veldisp=new JLabel();
    JLabel angdisp=new JLabel();
    public Projectile() {
        setTitle("Projectile");
        setSize(f_width,f_height);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 150, 100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        project.setBounds(400,60,100,25);
        add(project);
        
        project.addActionListener(this);
         
        anglescroll.setBounds(820,50, 25,500);
        add(anglescroll);
        angdisp.setBounds(800,10, 200,50);
        add(angdisp);
        angdisp.setText(" Angle :"+angle);
        velscroll.setBounds(920,50, 25,500);
        add(velscroll);
        veldisp.setBounds(890,10, 200,50);
        add(veldisp);
        veldisp.setText("Velocity :"+velocity);
        
        anglescroll.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                angle=anglescroll.getValue();
                  angdisp.setText(" Angle :"+angle);
            }
        });
       
        velscroll.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                velocity=velscroll.getValue();
               veldisp.setText("Velocity :"+velocity);
            }
        }); 
       
    }
    
      
    
     private void projectBall() {
            //double radianAngle=angle*Math.PI/180;
            double radianAngle=Math.toRadians(angle);
            double t=0;        
            //double vix=velocity*Math.cos(radianAngle);
           // double viy=velocity*Math.sin(radianAngle)-9.81*t;
            //double totaltime=2*(viy/9.81);
            
            double sx=0,sy=0;
            double vx=0,vy=0;
            
            //int num_of_steps=40;
           // double timeincrement=(totaltime/num_of_steps);
            double timeincrement=.08;
             while(sy>=0){
                  vx=velocity*Math.cos(radianAngle);
                  vy=velocity*Math.sin(radianAngle)-9.81*t;
                try {
                    th.sleep(50);
                } catch (InterruptedException ex) {
                   
                }
                sx=vx*t; // hor acceleation is zero
                sy=vy*t+(0.5*(-9.81)*t*t);
               // vy=Math.sqrt(vy*vy+2*(-9.81)*sy);
                t+=timeincrement;
                
              ball.x=100+(int) sx; 
              ball.y=550+(int) sy;
              System.out.println("x: "+ball.x+" y :"+ball.y+"t :"+t);
                 if(sy>=0)
                 repaint();
            }
           
     }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        g.drawLine(100, 600, 800, 600);
        g.setColor(Color.BLACK);
        g.fillOval(ball.x,1130-ball.y, ball.width,ball.height);
        
      
    }

    @Override
    public void run() {
            projectBall();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==project){
                ball=new Rectangle(100,550,2*10,2*10);
                th=new Thread(this);
                th.start();
                 repaint();
            }     
    }
     
     
}
