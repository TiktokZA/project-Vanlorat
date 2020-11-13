/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamevanlorat;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author TiktokZa
 */
public class Startgame extends JPanel{
    int xBase=0;
    int speed=0;
    
    
    public JButton BStart = new JButton("START");
    public JButton BExit  = new JButton("EXIT");
    JComboBox skillp1=new JComboBox(new String[]{"HEAL","SPEED"});
    JComboBox skillp2=new JComboBox(new String[]{"HEAL","SPEED"});
    JComboBox map=new JComboBox(new String[]{"Light","Dark"});
    Startgame(){
        time.start();
        setLayout(null);
        BExit.setBounds(370, 280, 150,50);
        BExit.setFont(new Font("Courier",Font.BOLD,20));
        add(BExit);
        BStart.setBounds(370,200,150,50);
        BStart.setFont(new Font("Courier",Font.BOLD,20));

        add(BStart);
        skillp1.setBounds(690, 285, 80, 20);
        skillp2.setBounds(690, 315, 80, 20);
        add(skillp1);
        add(skillp2);
        map.setBounds(690, 345, 80, 20);
        add(map);
        
    }
    Thread time =new Thread(){
        public void run(){
            while(true){
                
                repaint();

                try {
                    Thread.sleep(5); // milliseconds
                }catch (InterruptedException ex) { }
            }

        }     
    };
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        //backgroud
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        //road
        g.setColor(Color.GRAY);
        g.fillRect(0, getHeight()-80, getWidth(), 50);
        g.setColor(Color.WHITE);
        g.fillRect(100, getHeight()-55, 15, 3);
        g.fillRect(200, getHeight()-55, 15, 3);
        g.fillRect(300, getHeight()-55, 15, 3);
        g.fillRect(400, getHeight()-55, 15, 3);
        g.fillRect(500, getHeight()-55, 15, 3);
        g.fillRect(600, getHeight()-55, 15, 3);
        g.fillRect(700, getHeight()-55, 15, 3);
        //car
        if(xBase>getWidth()){
            xBase=-20;
        }else{
            xBase++;
        }
        g.setColor(Color.BLACK);
        g.fillOval(xBase+10, getHeight()-10-50, 10, 10);
        g.fillOval(xBase+30, getHeight()-10-50, 10, 10);
        g.setColor(Color.GREEN);
        g.fillRect(xBase, getHeight()-20-50, 50, 10);

        g.setColor(Color.RED);
        Polygon polygon=new Polygon();
        polygon.addPoint(xBase+10, getHeight()-20-50);
        polygon.addPoint(xBase+20, getHeight()-30-50);
        polygon.addPoint(xBase+30, getHeight()-30-50);
        polygon.addPoint(xBase+40, getHeight()-20-50);
        g.fillPolygon(polygon);
        //hotel
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(50, 100, 150, 280);
        g.setColor(Color.WHITE);
        g.fillRect(70, 120, 15, 15);
        g.fillRect(105, 120, 15, 15);
        g.fillRect(140, 120, 15, 15);
        g.fillRect(175, 120, 15, 15);
        
        g.fillRect(70, 155, 15, 15);
        g.fillRect(105, 155, 15, 15);
        g.fillRect(140, 155, 15, 15);
        g.fillRect(175, 155, 15, 15);
        
        g.fillRect(70, 190, 15, 15);
        g.fillRect(105, 190, 15, 15);
        g.fillRect(140, 190, 15, 15);
        g.fillRect(175, 190, 15, 15);
        
        g.fillRect(70, 225, 15, 15);
        g.fillRect(105, 225, 15, 15);
        g.fillRect(140, 225, 15, 15);
        g.fillRect(175, 225, 15, 15);
        
        g.fillRect(70, 260, 15, 15);
        g.fillRect(105, 260, 15, 15);
        g.fillRect(140, 260, 15, 15);
        g.fillRect(175, 260, 15, 15);
        
        g.setColor(Color.orange);
        g.fillRect(150, 320, 40, 60);
        g.setColor(Color.BLACK);
        g.drawRect(50, 100, 150, 280);
        g.drawRect(70, 120, 15, 15);
        g.drawRect(105, 120, 15, 15);
        g.drawRect(140, 120, 15, 15);
        g.drawRect(175, 120, 15, 15);
        g.drawRect(70, 155, 15, 15);
        g.drawRect(105, 155, 15, 15);
        g.drawRect(140, 155, 15, 15);
        g.drawRect(175, 155, 15, 15);
        g.drawRect(70, 190, 15, 15);
        g.drawRect(105, 190, 15, 15);
        g.drawRect(140, 190, 15, 15);
        g.drawRect(175, 190, 15, 15);
        g.drawRect(70, 225, 15, 15);
        g.drawRect(105, 225, 15, 15);
        g.drawRect(140, 225, 15, 15);
        g.drawRect(175, 225, 15, 15);
        g.drawRect(70, 260, 15, 15);
        g.drawRect(105, 260, 15, 15);
        g.drawRect(140, 260, 15, 15);
        g.drawRect(175, 260, 15, 15);
        g.drawRect(150, 320, 40, 60);
        //moon
        g.setColor(Color.YELLOW);
        g.fillOval(600,50, 80, 80);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(580,50, 80, 80);
        //star
        g.setColor(Color.YELLOW);
        int[] x={20,455,745,795,695,62,71,100,465,300,256,669,426,358,519,629,788,333,444,222};
        int[] y={15,45,25,15,25,45,25,15,45,25,15,45,25,45,45,15,15,25,45,15};
        for(int i=0;i<20;i++){
            if(i%2==0){
                g.fillOval(x[i], y[i], 1, 1);
            }else{
                g.fillOval(x[i], y[i], 2, 2);
            }
        }
        g.setColor(Color.red);
        g.setFont(new Font("Monospaced",Font.BOLD,40));
//        g.drawString("VANLORAT", 50, 80);
        g.setColor(Color.ORANGE);
        g.drawString("VANLORAT", 48, 80);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier",Font.BOLD,15));
        g.drawString("!! Please Select Skill !!", 620, 270);
        g.drawString("P1 :", 650, 300);
        g.drawString("P2 :", 650, 330);
        g.drawString("MAP :", 650, 360);
    }
}
