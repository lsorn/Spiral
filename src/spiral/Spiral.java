package spiral;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Spiral extends JFrame{
    public Spiral(){ 
    }
    public static void main(String[] args) {
        Spiral frame = new Spiral();
        frame.setTitle("Graphics Excercise");
        frame.setLocation(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        Panel a = new Panel();
        a.setNumberOfLoop(8);
        frame.add(a);  
    }//end of main      
}//end of spiral  
class Panel extends JPanel{
    int loop;
    //set number of loops
    public void setNumberOfLoop(int loop){this.loop = loop;}
    
    protected void paintComponent(Graphics g) {
        final int x = getWidth()/2;
        final int y = getHeight()/2;
        super.paintComponent(g);
//        (a)Draw square spiral using line function    
        
        
        for(int i = 0; i < loop; i++){
            g.drawLine( x    -10*i,  y    +10*i, (x+10)+10*i,  y    +10*i);//set of bottom lines
            g.drawLine((x+10)+10*i,  y    +10*i, (x+10)+10*i, (y-10)-10*i);//set of right hand lines
            g.drawLine((x+10)+10*i, (y-10)-10*i, (x-10)-10*i, (y-10)-10*i );//set of upper lines
            g.drawLine((x-10)-10*i, (y-10)-10*i, (x-10)-10*i, (y+10)+10*i);//set of left hand lines   
        }      
        
        
//         (b)Draw square spiral using polyline function
     
        
        int[] xx = new int[100];
        xx[0] = x;//starting point of x coordinate
        int[] yy = new int[100];
        yy[0] = yy[1] = y;//starting point of y coordinate
        //set x(coordinate)
        for(int i = 1; i <= loop; i++){
            xx[4*(i-1)+1] = xx[4*(i-1)+2] = x + 10*i;
            xx[4*(i-1)+3] = xx[4*(i-1)+4] = x - 10*i;
        }
        //set y(coordinate)
        for(int i = 1; i <= loop; i++){
            yy[4*(i-1)+2] = yy[4*(i-1)+3] = y - 10*i;
            yy[4*(i-1)+4] = yy[4*(i-1)+5] = y + 10*i;        
        }
        g.drawPolyline(xx,yy,loop*4+1);    
    
        
    } 
}//end of panel class
