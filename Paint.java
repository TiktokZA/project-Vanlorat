/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamevanlorat;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 *
 * @author TiktokZa
 */
public class Paint extends JPanel implements ActionListener {
    int state ;
    Character player1 = new Character(200);
    Character player2 = new Character(600);
    Clocktime clo=new Clocktime(1,30);
    JButton Bcon=new JButton("Continus");
    boolean checkdie=false;
    JButton Bpause=new JButton("Pause/Play");
    boolean checkpause=false;
    int x_dropgun=(int)(Math.random() * 870);
    int y_dropgun=450;
    int bullet=0;
    boolean getgun=false;
    boolean drop=false;
    boolean ammu=false;
    boolean Ko=false;
    boolean Draw=false;
    boolean fuck=true;
    
    File sound =new File("state1.wav");
    File sound1 =new File("state2.wav");
    File sound2 =new File("endgame.wav");
    File sound3 =new File("box.wav");

    File sound5 =new File("shoot.wav");
    Clip clip;
    Clip clip1;
    Clip clip2;
    Clip clip3;

    Clip clip5;
 
//    Timer clock=new Timer(1000,new Clock());
    Thread regame =new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(1);
                }catch(Exception e){e.printStackTrace();}
                if(!fuck){
                    
                    if(player1.round>=3){
                        state=3;
                        bbb();
                        clo.min=1;
                        clo.sec=30;
                        player1.HP=250;
                        player1.CP=0;
                        player1.setx=200;
                        player1.standright = 1;
                        player1.die=false;
                        player2.die=false;
                        player2.HP=250;
                        player2.CP=0;
                        player2.standleft = 1;
                        player2.setx=600;
                        aaa();
                        
                        
//                        System.out.println("State:"+state);
                        gun.resume();
                        dropGun.resume();
                        
                        
                        
                        action1.resume();
                        action2.resume();
                        clock.resume();
                        Ko=false;
                        Draw=false;
                        fuck=true;
                        
                    }
                    else if(player2.round>=3){
                        state=4;
                        bbb();
                        clo.min=1;
                        clo.sec=30;
                        player1.HP=250;
                        player1.CP=0;
                        player1.setx=200;
                        player1.standright = 1;
                        player1.die=false;
                        player2.die=false;
                        player2.HP=250;
                        player2.CP=0;
                        player2.standleft = 1;
                        player2.setx=600;
//                        aaa();
                        
                        
//                        System.out.println("State:"+state);
                        gun.resume();
                        dropGun.resume();
                        
                        
                        
                        action1.resume();
                        action2.resume();
                        clock.resume();
                        Ko=false;
                        Draw=false;
                        fuck=true;
                        
                    }
                    else{
                        
                        state=(int)(Math.random() * 2)+1;
                        if(state==1){
                            clip1.stop();
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                            
                        }else if(state==2){
                            clip.stop();
                            clip1.loop(Clip.LOOP_CONTINUOUSLY);
                        }
                        clo.min=1;
                        clo.sec=30;
                        player1.HP=250;
                        player1.CP=0;
                        player1.setx=200;
                        player1.standright = 1;
                        player1.die=false;
                        player2.die=false;
                        player2.HP=250;
                        player2.CP=0;
                        player2.standleft = 1;
                        player2.setx=600;
                        aaa();
                        
                        
//                        System.out.println("State:"+state);
                        gun.resume();
                        dropGun.resume();
                        
                        
                        
                        action1.resume();
                        action2.resume();
                        clock.resume();
                        Ko=false;
                        Draw=false;
                        fuck=true;
                    }
                }
            }

        }
        
    });
    Thread Skillp1=new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(1);
                }catch(Exception e){e.printStackTrace();}
                if(player1.useskill){
                    if(player1.nskill==1){
                        for(int i=0;i<3;i++){
                            if(player1.HP>=210){
                                player1.HP=250;
                            }else{
                                player1.HP+=40;
                            }
                            try{
                                Thread.sleep(1000);
                            }catch(Exception e){e.printStackTrace();}
                        }
                    }else if(player1.nskill==2){
                        for(int i=0;i<5;i++){
                            player1.speedskill=50;
                            try{
                                Thread.sleep(1000);
                            }catch(Exception e){e.printStackTrace();}
                        }
                        player1.speedskill=100;
                    }
                    player1.useskill=false;
                }
            }
        }
        
    });
    Thread Skillp2=new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(1);
                }catch(Exception e){e.printStackTrace();}
                if(player2.useskill){
                    if(player2.nskill==1){
                        for(int i=0;i<3;i++){
                            if(player2.HP>=210){
                                player2.HP=250;
                            }else{
                                player2.HP+=40;
                            }
                            try{
                                Thread.sleep(1000);
                            }catch(Exception e){e.printStackTrace();}
                        }
                    }else if(player2.nskill==2){
                        for(int i=0;i<5;i++){
                            player2.speedskill=50;
                            try{
                                Thread.sleep(1000);
                            }catch(Exception e){e.printStackTrace();}
                        }
                        player2.speedskill=100;
                    }
                    player2.useskill=false;
                }
            }
        }
        
    });
    
    Thread checkHP =new Thread(new Runnable(){
        @Override
        public void run() {
            
            while(true){
                try{
                    Thread.sleep(10);
                }catch(Exception e){e.printStackTrace();}
                if(fuck){
                    
                    if(player1.die){
                        
                        player2.round++;
                        System.out.println(player2.round);
                        Ko=true;
                        ccc();
                        
                        try{
                            Thread.sleep(2000);
                        }catch(Exception e){e.printStackTrace();}
                        gun.suspend();
                        dropGun.suspend();
                        
                        action1.suspend();
                        action2.suspend();
                        clock.suspend();
                        drop=false;
                        fuck=false;

                    }
                    else if(player2.die){
                        
                        player1.round++;
                        System.out.println(player1.round);
                        ccc();
                        Ko=true;
                        
                        try{
                            Thread.sleep(2000);
                        }catch(Exception e){e.printStackTrace();}
                        gun.suspend();
                        dropGun.suspend();
                        
                        action1.suspend();
                        action2.suspend();
                        clock.suspend();
                        drop=false;
                        fuck=false;
                    }
                    else if(clo.min<=0&&clo.sec<=0){
                        Draw=true;
                        
                        ccc();
                        try{
                            Thread.sleep(2000);
                        }catch(Exception e){e.printStackTrace();}
                        gun.suspend();
                        dropGun.suspend();
                        
                        action1.suspend();
                        action2.suspend();
                        clock.suspend();
                        drop=false;
                        fuck=false;
                    }
                }
            }
        }
        
    });
    Thread action2 =new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(player2.speedskill);
                }catch(Exception e){e.printStackTrace();}
                player2.standright();
                player2.standleft();
                player2.moveright();
                player2.moveleft();
                player2.PunchR();
                player2.PunchL();
                player2.JumpL();
                player2.JumpR();
                player2.DeadLeft();
                repaint();
            }
        }
        
    });
    Thread action1 =new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(player1.speedskill);
                }catch(Exception e){e.printStackTrace();}
                
//                player1.count=0;
                player1.standright();
                player1.standleft();
                player1.moveright();
                player1.moveleft();
                player1.PunchR();
                player1.PunchL();
                player1.JumpL();
                player1.JumpR();
                player1.DeadLeft();
                repaint();
            }
        }
        
    });
    Thread gun=new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(1);
                }catch(Exception e){e.printStackTrace();}
                if(player1.shotgunL){
                    bullet=player1.setx;
                    ammu=true;
                    while(ammu){
                        try{
                            Thread.sleep(5);
                        }catch(Exception e){e.printStackTrace();}
                        bullet--;
                        repaint();
                        int dist=(int) Math.sqrt(Math.pow((player2.setx)-(bullet+5), 2)+Math.pow(player2.sety-y_dropgun, 2));
                        System.out.println(dist);
                        if(dist<=51){
                            player2.HP-=150;
                            player2.setx-=15;
                            ammu=false;
                            if(player2.HP<=0){
                                player2.die=true;
                                player2.dead=1;
                            }
                        }
                        if(bullet<=0){
                            ammu=false;
                        }
                    }
                    player1.shotgunL=false;
                    player1.hasgun=false;
                }
                if(player1.shotgunR){
                    bullet=player1.setx+(player1.radius*2);
                    ammu=true;
                    while(ammu){
                        try{
                            Thread.sleep(5);
                        }catch(Exception e){e.printStackTrace();}
                        bullet++;
                        repaint();
                        int dist=(int) Math.sqrt(Math.pow((player2.setx+(player2.radius*2))-bullet, 2)+Math.pow(player2.sety-y_dropgun, 2));
                        if(dist<=51){
                            player2.HP-=150;
                            player2.setx+=15;
                            bullet=0;
                            ammu=false;
                            if(player2.HP<=0){
                                player2.die=true;
                                player2.dead=1;
                            }
                        }
                        if(bullet>=890){
                            ammu=false;
                            bullet=0;
                        }
                    }
                    player1.shotgunR=false;
                    player1.hasgun=false;
                }
                if(player2.shotgunL){
                    bullet=player2.setx;
                    ammu=true;
                    while(ammu){
                        try{
                            Thread.sleep(5);
                        }catch(Exception e){e.printStackTrace();}
                        bullet--;
                        repaint();
                        int dist=(int) Math.sqrt(Math.pow((player1.setx)-(bullet+5), 2)+Math.pow(player1.sety-y_dropgun, 2));
                        System.out.println(dist);
                        if(dist<=51){
                            player1.HP-=150;
                            player1.setx-=15;
                            ammu=false;
                            if(player1.HP<=0){
                                player1.die=true;
                                player1.dead=1;
                                
                            }
                        }
                        if(bullet<=0){
                            ammu=false;
                        }
                    }
                    player2.shotgunL=false;
                    player2.hasgun=false;
                }
                if(player2.shotgunR){
                    bullet=player2.setx+(player2.radius*2);
                    ammu=true;
                    while(ammu){
                        try{
                            Thread.sleep(5);
                        }catch(Exception e){e.printStackTrace();}
                        bullet++;
                        repaint();
                        int dist=(int) Math.sqrt(Math.pow((player1.setx+(player1.radius*2))-bullet, 2)+Math.pow(player1.sety-y_dropgun, 2));
                        if(dist<=51){
                            player1.HP-=150;
                            player1.setx+=15;
                            bullet=0;
                            ammu=false;
                            if(player1.HP<=0){
                                player1.die=true;
                                player1.dead=1;
                                
                            }
                        }

                        if(bullet>=890){
                            ammu=false;
                            
                        }
                    }
                    player2.shotgunR=false;
                    player2.hasgun=false;
                }
            }
        }
        
    });
    
    Thread clock =new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){e.printStackTrace();}
                if(clo.min>0||clo.sec>0){
                    clo.process();
                    
//                    System.out.println(clo.min+" "+clo.sec);
                }
                else{
                    clo.stop();
                    
                }
                
                
            }
        } 
    });
    Thread dropGun=new Thread(new Runnable(){
        @Override
        public void run() {
            while(true){
                try{
                    Thread.sleep(10000);
                }catch(Exception e){e.printStackTrace();}
                x_dropgun=(int)(Math.random() * 870);
                drop=true;
                player1.hasgun=false;
                player2.hasgun=false;
            }
        }
        
    });
    keyListenerp2 k2=new keyListenerp2();
    keyListenerp1 k1=new keyListenerp1();
    Paint() {
        try {
           // Open an audio input stream.
           AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
           AudioInputStream audioIn1 = AudioSystem.getAudioInputStream(sound1);
           AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(sound2);
           
           AudioInputStream audioIn3 = AudioSystem.getAudioInputStream(sound3);
           AudioInputStream audioIn5 = AudioSystem.getAudioInputStream(sound5);
           // Get a sound clip resource.
           clip = AudioSystem.getClip();
           clip1 = AudioSystem.getClip();
           clip2 = AudioSystem.getClip();
           clip3 = AudioSystem.getClip();
           
           clip5 = AudioSystem.getClip();
           // Open audio clip and load samples from the audio input stream.
           clip.open(audioIn);
           clip1.open(audioIn1);
           clip2.open(audioIn2);
           clip3.open(audioIn2);
           
           clip5.open(audioIn2);
           
           
        } catch (UnsupportedAudioFileException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } catch (LineUnavailableException e) {
           e.printStackTrace();
        }
        this.setFocusable(true);
        this.setLayout(null);
        clock.start();
        action1.start();
        action2.start();
//        action.start();
        Skillp1.start();
        Skillp2.start();
        dropGun.start();
        gun.start();
        checkHP.start();
        regame.start();
        Bpause.addActionListener(this);

        Bpause.setBounds(getWidth()+690, getHeight()+500, 150, 50);
        Bpause.setFont(new Font("Monospaced",Font.BOLD,10));
        add(Bpause);
        addKeyListener(k1);
        addKeyListener(k2);
        //setP1
        player1.sety=player1.setY;
        player1.setx=200;
        player1.standright = 1;
        //setP2
        player2.sety=player2.setY;
        player2.standleft = 1;
        player2.setx=600;
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Bpause){
            if(checkpause){
                
                requestFocusInWindow();
                gun.resume();
                dropGun.resume();
                checkHP.resume();
                
                Skillp1.resume();
                Skillp2.resume();
                action1.resume();
                action2.resume();
                clock.resume();
                checkpause=false;
            }else{
                
                requestFocusInWindow();
                gun.suspend();
                dropGun.suspend();
                checkHP.suspend();
                Skillp1.suspend();
                Skillp2.suspend();
                action1.suspend();
                action2.suspend();
                clock.suspend();
                checkpause=true;
            }
        }
    }
    class keyListenerp2 implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player2.moveright = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                player2.moveleft = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (player2.standright == 1 || player2.standright == 2) {
                    player2.jumpright = 1;
                } else if (player2.standleft == 1 || player2.standleft == 2) {
                    player2.jumpleft = 1;
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_NUMPAD9){
                if(player2.hasgun){
                    clip5.loop(Clip.LOOP_CONTINUOUSLY);
                    if(player2.standright == 1 || player2.standright == 2){
                        player2.shotgunR=true;
                        player2.hasgun=false;
                        
                    }else if(player2.standleft == 1 || player2.standleft == 2){
                        player2.shotgunL=true;
                        player2.hasgun=false;
                    }
                }else{
                    if(player2.standright == 1 || player2.standright == 2){
                        int dist=(int) Math.sqrt(Math.pow(x_dropgun-(player2.setx+(player2.radius*2)), 2)+Math.pow(y_dropgun-player2.sety, 2));
                        System.out.println(dist);
                        if(dist<51){
                            player2.hasgun=true;
                            drop=false;
                        }
                    }else if(player2.standleft == 1 || player2.standleft == 2){
                        int dist=(int) Math.sqrt(Math.pow((player2.setx)-(x_dropgun+15), 2)+Math.pow(player2.sety-y_dropgun, 2));
                        System.out.println(dist);
                        if(dist<51){
                            player2.hasgun=true;
                            drop=false;
                        }
                    }
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_NUMPAD8){
                if(player2.CP==200){
                    player2.useskill=true;
                    player2.CP=0;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                clip3.loop(Clip.LOOP_CONTINUOUSLY);
                if (player2.standright == 1 || player2.standright == 2) {
                    player2.punchright = 1;
                    int dist=(int) Math.sqrt(Math.pow(player1.setx-(player2.setx+(player2.radius*2)), 2)+Math.pow(player1.sety-player2.sety, 2));
                    System.out.println(dist);
                    if(dist<18){
                        player1.HP-=10;
                        player1.setx+=15;
                        
                        if(player2.CP<=200){
                            player2.CP+=40;
                        }if(player2.CP>200){
                            player2.CP=200;
                        }
                        if(player1.HP<=0){
                            player1.die=true;
                            player1.dead=1;
                            
                        }
                    }
                } else if (player2.standleft == 1 || player2.standleft == 2) {
                    player2.punchleft = 1;
                    int dist=(int) Math.sqrt(Math.pow((player1.setx+player1.radius*2)-player2.setx, 2)+Math.pow(player1.sety-player2.sety, 2));
                    System.out.println(dist);
                    if(dist<18){
                        player1.HP-=10;
                        player1.setx-=15;
                        
                        if(player2.CP<=200){
                            player2.CP+=40;
                        }if(player2.CP>200){
                            player2.CP=200;
                        }
                        if(player1.HP<=0){
                            
                            player1.die=true;
                            player1.dead=1;
                            
                        }
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            clip3.stop();
            clip5.stop();
        }
        
    }
    class keyListenerp1 implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                player1.moveleft = 1;
                
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                player1.moveright = 1;

            }
            if(e.getKeyCode()==KeyEvent.VK_P){
                if(player1.hasgun){
                    clip5.loop(Clip.LOOP_CONTINUOUSLY);
                    if(player1.standright == 1 || player1.standright == 2){
                        player1.shotgunR=true;
                        player1.hasgun=false;
                        
                    }else if(player1.standleft == 1 || player1.standleft == 2){
                        player1.shotgunL=true;
                        player1.hasgun=false;
                    }
                }else{
                    if(player1.standright == 1 || player1.standright == 2){
                        int dist=(int) Math.sqrt(Math.pow((player1.setx+(player1.radius*2))-x_dropgun, 2)+Math.pow(player1.sety-y_dropgun, 2));
                        System.out.println(dist);
                        if(dist<51){
                            player1.hasgun=true;
                            drop=false;
                        }
                    }else if(player1.standleft == 1 || player1.standleft == 2){
                        int dist=(int) Math.sqrt(Math.pow((player1.setx)-(x_dropgun+15), 2)+Math.pow(player1.sety-y_dropgun, 2));
                        System.out.println(dist);
                        if(dist<51){
                            player1.hasgun=true;
                            drop=false;
                        }
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_I) {
                
                clip3.loop(Clip.LOOP_CONTINUOUSLY);
                if (player1.standright == 1 || player1.standright == 2) {
                    player1.punchright = 1;
                    int dist=(int) Math.sqrt(Math.pow((player1.setx+(player1.radius*2))-player2.setx, 2)+Math.pow(player1.sety-player2.sety, 2));
                    System.out.println(dist);
                    if(dist<18){
                        player2.HP-=10;
                        player2.setx+=15;
                        if(player1.CP<=200){
                            player1.CP+=40;
                        }if(player1.CP>200){
                            player1.CP=200;
                        }
                        if(player2.HP<=0){
                            player2.die=true;
                            player2.dead=1;
                           
                        }
                    }
                } else if (player1.standleft == 1 || player1.standleft == 2) {
                    player1.punchleft = 1;
                    int dist=(int) Math.sqrt(Math.pow((player1.setx)-(player2.setx+(player2.radius*2)), 2)+Math.pow(player1.sety-player2.sety, 2));
                    System.out.println(dist);
                    if(dist<18){
                        player2.HP-=10;
                        player2.setx-=15;
                        if(player1.CP<=200){
                            player1.CP+=40;
                        }if(player1.CP>200){
                            player1.CP=200;
                        }
                        if(player2.HP<=0){
                            player2.die=true;
                            player2.dead=1;
                           
                        }
                    }
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_O){
                if(player1.CP==200){
                    player1.useskill=true;
                    player1.CP=0;
                }          
            }
            if (e.getKeyCode()==KeyEvent.VK_W) {
                if (player1.standright == 1 || player1.standright == 2) {
                    player1.jumpright = 1;
                } else if (player1.standleft == 1 || player1.standleft == 2) {
                    player1.jumpleft = 1;
                }
            }
            

        }

        @Override
        public void keyReleased(KeyEvent e) {
            clip3.stop();
            clip5.stop();
        }
    }
    void ccc(){
        this.removeKeyListener(k1);
        this.removeKeyListener(k2);
    }
    void aaa(){
        
        this.addKeyListener(k2);
        this.addKeyListener(k1);
    }
    void bbb(){
        this.remove(Bpause);
        clip2.start();
        clip.stop();
        clip1.stop();
    }
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        if(state==4){
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.red);
            g.setFont(new Font("Serif",Font.BOLD,50));
            g.drawString("PLAYER 2 iS winner", 280, 250);
            g.setFont(new Font("Serif",Font.BOLD,25));
            g.drawString("PLAYER 1 iS Losser", 290, 300);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Serif",Font.BOLD,50));
            g.drawString("PLAYER 2 iS winner", 279, 250);
            g.setFont(new Font("Serif",Font.BOLD,25));
            g.drawString("PLAYER 1 iS Losser", 289, 300);
        }
        if(state==3){
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.red);
            g.setFont(new Font("Serif",Font.BOLD,50));
            g.drawString("PLAYER 1 iS winner", 280, 250);
            g.setFont(new Font("Serif",Font.BOLD,25));
            g.drawString("PLAYER 2 iS Losser", 290, 300);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Serif",Font.BOLD,50));
            g.drawString("PLAYER 1 iS winner", 279, 250);
            g.setFont(new Font("Serif",Font.BOLD,25));
            g.drawString("PLAYER 2 iS Losser", 289, 300);
        }
        if(state==2){
            //map 2
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight()); 
            g.setColor(Color.GRAY);
            g.fillRect(0, getHeight()-150+35, getWidth(), 200);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, getHeight()-150+30, getWidth(), 40);
            g.setColor(Color.BLACK);
//            g.drawLine(0, getHeight()-150+65, getWidth(), getHeight()-150+65);
//            g.drawLine(0, getHeight()-150+64, getWidth(), getHeight()-150+64);
        //        g.drawLine(0, getHeight()-200+67, getWidth(), getHeight()-200+67);


            int[] x1={getWidth()-740,getWidth()-590,getWidth()-440};
            int[] y1={getHeight()-150+40,getHeight()-450+40,getHeight()-150+40};
            int[] x2={getWidth()-460,getWidth()-310,getWidth()-160};
            int[] y2={getHeight()-150+40,getHeight()-500+40,getHeight()-150+40};


            g.setColor(Color.GREEN);
            g.fillPolygon(x1, y1, x1.length);
            g.fillPolygon(x2, y2, x2.length);
            g.setColor(Color.BLACK);
            g.drawPolyline(x1, y1, x1.length);
            g.drawPolyline(x2, y2, x2.length);
            g.setColor(Color.YELLOW);
            g.fillOval(700, 100, 50*2, 50*2);
            g.setColor(Color.DARK_GRAY);
            g.fillOval(670, 100, 50*2, 50*2);
            g.setColor(Color.YELLOW);
            int[] x={20,455,745,795,695,62,71,100,465,300,256,669,426,358,519,629,788,333,444,222};
            int[] y={100,95,115,105,95,115,95,100,105,100,115,95,105,100,115,105,115,95,95,115};
            for(int i=0;i<20;i++){
                if(i%2==0){
                    g.fillOval(x[i], y[i], 1, 1);
                }else{
                    g.fillOval(x[i], y[i], 2, 2);
                }
            }
            //Clock
            g.setColor(Color.WHITE);
            FontMetrics fm = g.getFontMetrics();
            int stringWidth = fm.stringWidth(Integer.toString(clo.min)+" : "+Integer.toString(clo.sec));
            int stringAscent = fm.getAscent();
            int xCoordinate = getWidth() / 2 - stringWidth / 2;
            int yCoordinate = 50;
            Font font =new Font("Californian FB", Font.BOLD, 30);
            g.setFont(font);
            g.drawString(Integer.toString(clo.min)+" : "+Integer.toString(clo.sec), xCoordinate, yCoordinate);


            if (player1.setx > getWidth()-30) {
                player1.setx = getWidth()-30;
            }
            if (player1.setx < 5) {
                player1.setx = 5;
            }
            if (player2.setx > getWidth()-30) {
                player2.setx = getWidth()-30;
            }
            if (player2.setx < 5) {
                player2.setx = 5;
            }
            if(player1.sety>=getHeight()-150+65){
                player1.sety=getHeight()-150;
            }
            if(player2.sety>=getHeight()-150+65){
                player2.sety=getHeight()-150;
            }

            player1.setY=getHeight()-150;
            player2.setY=getHeight()-150;

            g.setColor(Color.BLACK);

            //PLAYER1
            g.setColor(Color.WHITE);
            FontMetrics fm1 = g.getFontMetrics();
            int stringWidth1 = fm1.stringWidth("PLAYER1");
            int stringAscent1 = fm1.getAscent();
            int xCoordinate1 = 20;
            int yCoordinate1 = 50;
            Font font1 =new Font("Californian FB", Font.BOLD, 20);
            g.setFont(font1);
            g.drawString("PLAYER1", xCoordinate1, yCoordinate1);
            int temp=stringWidth1-10;
            for(int i=0;i<player1.round;i++){
                g.setColor(Color.PINK);
                g.fillOval(temp+=25, yCoordinate1+15, 20, 20);
            }
            temp=stringWidth1-10;
            for(int i=0;i<3;i++){
                g.setColor(Color.WHITE);
                g.drawOval(temp+=25, yCoordinate1+15, 20, 20);
            }
            if(player1.hasgun){
                g.setColor(Color.WHITE);
                g.setFont(new Font("Californian FB",Font.BOLD,10));
                g.drawString("you have a gun!!", xCoordinate1, yCoordinate1+20);
            }
            //HP
            g.setColor(Color.GREEN);
            g.fillRect(stringWidth1-10, 40, player1.HP, 5);
            g.setColor(Color.WHITE);
            g.drawRect(stringWidth1-10, 40, 250, 5);
            //CP
            g.setColor(Color.BLUE);
            g.fillRect(stringWidth1-10, 46, player1.CP, 5);
            g.setColor(Color.WHITE);
            g.drawRect(stringWidth1-10, 46, 200, 5);

            //head
            g.setColor(Color.BLACK);
            g.drawOval(player1.setx, player1.sety, player1.radius * 2, player1.radius * 2);
            g.setColor(Color.WHITE);
            g.fillOval(player1.setx+1, player1.sety+1, (player1.radius-1) * 2, (player1.radius-1) * 2-1);
            g.setColor(Color.BLACK);
            //Body
            g.drawLine(player1.setx + player1.radius, player1.sety + player1.radius * 2, player1.setx + player1.radius+player1.d, player1.sety + player1.radius + 35+player1.dy);
            //legleft
            g.drawLine(player1.setx + player1.radius+player1.d, player1.sety + player1.radius + player1.q, player1.setx + player1.radius + player1.w, player1.sety + player1.radius + 35 + player1.e);
            g.drawLine(player1.setx + player1.radius + player1.w, player1.sety + player1.radius + 35 + player1.e, player1.setx + player1.radius + player1.r, player1.sety + player1.radius + player1.t);
            //legright
            g.drawLine(player1.setx + player1.radius+player1.d, player1.sety + player1.radius + player1.q1, player1.setx + player1.radius + player1.w1, player1.sety + player1.radius + 35 + player1.e1);
            g.drawLine(player1.setx + player1.radius + player1.w1, player1.sety + player1.radius + 35 + player1.e1, player1.setx + player1.radius + player1.r1, player1.sety + player1.radius + player1.t1);
            //armleft
            g.drawLine(player1.setx + player1.radius+player1.nx, player1.sety + player1.radius + player1.i, player1.setx + player1.radius + player1.j, player1.sety + player1.radius + player1.k);
            g.drawLine(player1.setx + player1.radius + player1.j, player1.sety + player1.radius + player1.k, player1.setx + player1.radius + player1.a, player1.sety + player1.radius + player1.x);
            g.setColor(Color.RED);
            g.fillOval(player1.setx + player1.radius + (player1.a - 5), player1.sety + player1.radius + (player1.x - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);
            //armright
            g.drawLine(player1.setx + player1.radius+player1.nx, player1.sety + player1.radius + player1.z, player1.setx + player1.radius + player1.c, player1.sety + player1.radius + player1.v);
            g.drawLine(player1.setx + player1.radius + player1.c, player1.sety + player1.radius + player1.v, player1.setx + player1.radius + player1.b, player1.sety + player1.radius + player1.n);
            g.setColor(Color.RED);
            g.fillOval(player1.setx + player1.radius + (player1.b - 5), player1.sety + player1.radius + (player1.n - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);


            //PLAYER2
            g.setColor(Color.WHITE);
            FontMetrics fm2 = g.getFontMetrics();
            int stringWidth2 = fm1.stringWidth("PLAYER2");
            int stringAscent2 = fm1.getAscent();
            int xCoordinate2 = getWidth()- stringWidth2+30 ;
            int yCoordinate2 = 50;
            Font font2 =new Font("Californian FB", Font.BOLD, 20);
            g.setFont(font2);
            g.drawString("PLAYER2", xCoordinate2, yCoordinate2);
            int temp2=xCoordinate2-250;
            for(int i=0;i<player2.round;i++){
                g.setColor(Color.PINK);
                g.fillOval(temp2+=25, yCoordinate2+15, 20, 20);
            }
            temp2=xCoordinate2-250;
            for(int i=0;i<3;i++){
                g.setColor(Color.WHITE);
                g.drawOval(temp2+=25, yCoordinate2+15, 20, 20);
            }
            if(player2.hasgun){
                g.setColor(Color.WHITE);
                g.setFont(new Font("Californian FB",Font.BOLD,10));
                g.drawString("you have a gun!!", xCoordinate2, yCoordinate2+20);
            }
            //HP
            g.setColor(Color.GREEN);
            g.fillRect(xCoordinate2-250, 40, player2.HP, 5);
            g.setColor(Color.WHITE);
            g.drawRect(xCoordinate2-250, 40, 250, 5);
            //CP
            g.setColor(Color.BLUE);
            g.fillRect(xCoordinate2-250, 46, player2.CP, 5);
            g.setColor(Color.WHITE);
            g.drawRect(xCoordinate2-250, 46, 200, 5);
            //head
            g.setColor(Color.BLACK);
            g.drawOval(player2.setx, player2.sety, player2.radius * 2, player2.radius * 2);
            g.setColor(Color.WHITE);
            g.fillOval(player2.setx+1, player2.sety+1, (player2.radius-1) * 2, (player2.radius-1) * 2-1);
            g.setColor(Color.BLACK);

            //Body
            g.drawLine(player2.setx + player2.radius, player2.sety + player2.radius * 2, player2.setx + player2.radius+player2.d, player2.sety + player2.radius + 35+player2.dy);
            //legleft
            g.drawLine(player2.setx + player2.radius+player2.d, player2.sety + player2.radius + player2.q, player2.setx + player2.radius + player2.w, player2.sety + player2.radius + 35 + player2.e);
            g.drawLine(player2.setx + player2.radius + player2.w, player2.sety + player2.radius + 35 + player2.e, player2.setx + player2.radius + player2.r, player2.sety + player2.radius + player2.t);
            //legright
            g.drawLine(player2.setx + player2.radius+player2.d, player2.sety + player2.radius + player2.q1, player2.setx + player2.radius + player2.w1, player2.sety + player2.radius + 35 + player2.e1);
            g.drawLine(player2.setx + player2.radius + player2.w1, player2.sety + player2.radius + 35 + player2.e1, player2.setx + player2.radius + player2.r1, player2.sety + player1.radius + player2.t1);
            //armleft
            g.drawLine(player2.setx + player2.radius+player2.nx, player2.sety + player2.radius + player2.i, player2.setx + player2.radius + player2.j, player2.sety + player2.radius + player2.k);
            g.drawLine(player2.setx + player2.radius + player2.j, player2.sety + player2.radius + player2.k, player2.setx + player2.radius + player2.a, player2.sety + player2.radius + player2.x);
            g.setColor(Color.BLUE);
            g.fillOval(player2.setx + player2.radius + (player2.a - 5), player2.sety + player2.radius + (player2.x - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);
            //armright
            g.drawLine(player2.setx + player2.radius+player2.nx, player2.sety + player2.radius + player2.z, player2.setx + player2.radius + player2.c, player2.sety + player2.radius + player2.v);
            g.drawLine(player2.setx + player2.radius + player2.c, player2.sety + player2.radius + player2.v, player2.setx + player2.radius + player2.b, player2.sety + player2.radius + player2.n);
            g.setColor(Color.BLUE);
            g.fillOval(player2.setx + player2.radius + (player2.b - 5), player2.sety + player2.radius + (player2.n - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);
            //dropgun
            if(drop){
                g.setColor(Color.BLACK);
                g.fillRect(x_dropgun, y_dropgun, 5, 10);
                g.fillRect(x_dropgun, y_dropgun, 15, 5);
                g.setColor(Color.WHITE);
                g.fillRect(x_dropgun+7, y_dropgun, 4, 3);
                g.fillRect(x_dropgun+15, y_dropgun, 3, 2);
            }
            //gun
            if(ammu){
                g.setColor(Color.BLACK);
                g.fillOval(bullet, y_dropgun-20, 10, 10);
            }
            if(Ko){
                g.setColor(Color.red);
                g.setFont(new Font("Serif",Font.BOLD,100));
                g.drawString("K.O.", 350, 250);
            }
            if(Draw){
                g.setColor(Color.BLUE);
                g.setFont(new Font("Serif",Font.BOLD,100));
                g.drawString("DRAW", 350, 250);
            }
        }
        
        
        
        if(state==1){
        //map 1
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight()); 
            g.setColor(Color.GRAY);
            g.fillRect(0, getHeight()-150+30, getWidth(), 200);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, getHeight()-150+30, getWidth(), 40);
            g.setColor(Color.BLACK);
//            g.drawLine(0, getHeight()-150+65, getWidth(), getHeight()-150+65);
//            g.drawLine(0, getHeight()-150+64, getWidth(), getHeight()-150+64);
        //        g.drawLine(0, getHeight()-200+67, getWidth(), getHeight()-200+67);


            int[] x1={getWidth()-740,getWidth()-590,getWidth()-440};
            int[] y1={getHeight()-150+40,getHeight()-450+40,getHeight()-150+40};
            int[] x2={getWidth()-460,getWidth()-310,getWidth()-160};
            int[] y2={getHeight()-150+40,getHeight()-500+40,getHeight()-150+40};


            g.setColor(Color.GREEN);
            g.fillPolygon(x1, y1, x1.length);
            g.fillPolygon(x2, y2, x2.length);
            g.setColor(Color.BLACK);
            g.drawPolyline(x1, y1, x1.length);
            g.drawPolyline(x2, y2, x2.length);
            g.setColor(Color.YELLOW);
            g.fillOval(80, 100, 50*2, 50*2);
            int[][] x={{120,130,140},{120,130,140},{77,60,77},{183,200,183},{80,80,100},{180,180,160},{80,80,100},{180,180,160}};
            int[][] y={{97,80,97},{203,220,203},{140,150,160},{140,150,160},{120,100,100},{120,100,100},{180,200,200},{180,200,200}};
            for(int i=0;i<8;i++){
                g.fillPolygon(x[i], y[i], x[i].length);
            }
            //Clock
            g.setColor(Color.BLACK);
            FontMetrics fm = g.getFontMetrics();
            int stringWidth = fm.stringWidth(Integer.toString(clo.min)+" : "+Integer.toString(clo.sec));
            int stringAscent = fm.getAscent();
            int xCoordinate = getWidth() / 2 - stringWidth / 2;
            int yCoordinate = 50;
            Font font =new Font("Californian FB", Font.BOLD, 30);
            g.setFont(font);
            g.drawString(Integer.toString(clo.min)+" : "+Integer.toString(clo.sec), xCoordinate, yCoordinate);


            if (player1.setx > getWidth()-30) {
                player1.setx = getWidth()-30;
            }
            if (player1.setx < 5) {
                player1.setx = 5;
            }
            if (player2.setx > getWidth()-30) {
                player2.setx = getWidth()-30;
            }
            if (player2.setx < 5) {
                player2.setx = 5;
            }
            if(player1.sety>=getHeight()-150+65){
                player1.sety=getHeight()-150;
            }
            if(player2.sety>=getHeight()-150+65){
                player2.sety=getHeight()-150;
            }

            player1.setY=getHeight()-150;
            player2.setY=getHeight()-150;

            g.setColor(Color.BLACK);

            //PLAYER1
            g.setColor(Color.BLACK);
            FontMetrics fm1 = g.getFontMetrics();
            int stringWidth1 = fm1.stringWidth("PLAYER1");
            int stringAscent1 = fm1.getAscent();
            int xCoordinate1 = 20;
            int yCoordinate1 = 50;
            Font font1 =new Font("Californian FB", Font.BOLD, 20);
            g.setFont(font1);
            g.drawString("PLAYER1", xCoordinate1, yCoordinate1);
            int temp=stringWidth1-10;
            for(int i=0;i<player1.round;i++){
                g.setColor(Color.PINK);
                g.fillOval(temp+=25, yCoordinate1+15, 20, 20);
            }
            temp=stringWidth1-10;
            for(int i=0;i<3;i++){
                g.setColor(Color.BLACK);
                g.drawOval(temp+=25, yCoordinate1+15, 20, 20);
            }
            if(player1.hasgun){
                g.setColor(Color.BLACK);
                g.setFont(new Font("Californian FB",Font.BOLD,10));
                g.drawString("you have a gun!!", xCoordinate1, yCoordinate1+20);
            }
            //HP
            g.setColor(Color.GREEN);
            g.fillRect(stringWidth1-10, 40, player1.HP, 5);
            g.setColor(Color.BLACK);
            g.drawRect(stringWidth1-10, 40, 250, 5);
            //CP
            g.setColor(Color.BLUE);
            g.fillRect(stringWidth1-10, 46, player1.CP, 5);
            g.setColor(Color.BLACK);
            g.drawRect(stringWidth1-10, 46, 200, 5);

            //head
            g.drawOval(player1.setx, player1.sety, player1.radius * 2, player1.radius * 2);
            g.setColor(Color.WHITE);
            g.fillOval(player1.setx+1, player1.sety+1, (player1.radius-1) * 2, (player1.radius-1) * 2-1);
            g.setColor(Color.BLACK);
            //Body
            g.drawLine(player1.setx + player1.radius, player1.sety + player1.radius * 2, player1.setx + player1.radius+player1.d, player1.sety + player1.radius + 35+player1.dy);
            //legleft
            g.drawLine(player1.setx + player1.radius+player1.d, player1.sety + player1.radius + player1.q, player1.setx + player1.radius + player1.w, player1.sety + player1.radius + 35 + player1.e);
            g.drawLine(player1.setx + player1.radius + player1.w, player1.sety + player1.radius + 35 + player1.e, player1.setx + player1.radius + player1.r, player1.sety + player1.radius + player1.t);
            //legright
            g.drawLine(player1.setx + player1.radius+player1.d, player1.sety + player1.radius + player1.q1, player1.setx + player1.radius + player1.w1, player1.sety + player1.radius + 35 + player1.e1);
            g.drawLine(player1.setx + player1.radius + player1.w1, player1.sety + player1.radius + 35 + player1.e1, player1.setx + player1.radius + player1.r1, player1.sety + player1.radius + player1.t1);
            //armleft
            g.drawLine(player1.setx + player1.radius+player1.nx, player1.sety + player1.radius + player1.i, player1.setx + player1.radius + player1.j, player1.sety + player1.radius + player1.k);
            g.drawLine(player1.setx + player1.radius + player1.j, player1.sety + player1.radius + player1.k, player1.setx + player1.radius + player1.a, player1.sety + player1.radius + player1.x);
            g.setColor(Color.RED);
            g.fillOval(player1.setx + player1.radius + (player1.a - 5), player1.sety + player1.radius + (player1.x - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);
            //armright
            g.drawLine(player1.setx + player1.radius+player1.nx, player1.sety + player1.radius + player1.z, player1.setx + player1.radius + player1.c, player1.sety + player1.radius + player1.v);
            g.drawLine(player1.setx + player1.radius + player1.c, player1.sety + player1.radius + player1.v, player1.setx + player1.radius + player1.b, player1.sety + player1.radius + player1.n);
            g.setColor(Color.RED);
            g.fillOval(player1.setx + player1.radius + (player1.b - 5), player1.sety + player1.radius + (player1.n - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);


            //PLAYER2
            g.setColor(Color.BLACK);
            FontMetrics fm2 = g.getFontMetrics();
            int stringWidth2 = fm1.stringWidth("PLAYER2");
            int stringAscent2 = fm1.getAscent();
            int xCoordinate2 = getWidth()- stringWidth2+30 ;
            int yCoordinate2 = 50;
            Font font2 =new Font("Californian FB", Font.BOLD, 20);
            g.setFont(font2);
            g.drawString("PLAYER2", xCoordinate2, yCoordinate2);
            int temp2=xCoordinate2-250;
            for(int i=0;i<player2.round;i++){
                g.setColor(Color.PINK);
                g.fillOval(temp2+=25, yCoordinate2+15, 20, 20);
            }
            temp2=xCoordinate2-250;
            for(int i=0;i<3;i++){
                g.setColor(Color.BLACK);
                g.drawOval(temp2+=25, yCoordinate2+15, 20, 20);
            }
            if(player2.hasgun){
                g.setColor(Color.BLACK);
                g.setFont(new Font("Californian FB",Font.BOLD,10));
                g.drawString("you have a gun!!", xCoordinate2, yCoordinate2+20);
            }
            //HP
            g.setColor(Color.GREEN);
            g.fillRect(xCoordinate2-250, 40, player2.HP, 5);
            g.setColor(Color.BLACK);
            g.drawRect(xCoordinate2-250, 40, 250, 5);
            //CP
            g.setColor(Color.BLUE);
            g.fillRect(xCoordinate2-250, 46, player2.CP, 5);
            g.setColor(Color.BLACK);
            g.drawRect(xCoordinate2-250, 46, 200, 5);
            //head
            g.drawOval(player2.setx, player2.sety, player2.radius * 2, player2.radius * 2);
            g.setColor(Color.WHITE);
            g.fillOval(player2.setx+1, player2.sety+1, (player2.radius-1) * 2, (player2.radius-1) * 2-1);
            g.setColor(Color.BLACK);

            //Body
            g.drawLine(player2.setx + player2.radius, player2.sety + player2.radius * 2, player2.setx + player2.radius+player2.d, player2.sety + player2.radius + 35+player2.dy);
            //legleft
            g.drawLine(player2.setx + player2.radius+player2.d, player2.sety + player2.radius + player2.q, player2.setx + player2.radius + player2.w, player2.sety + player2.radius + 35 + player2.e);
            g.drawLine(player2.setx + player2.radius + player2.w, player2.sety + player2.radius + 35 + player2.e, player2.setx + player2.radius + player2.r, player2.sety + player2.radius + player2.t);
            //legright
            g.drawLine(player2.setx + player2.radius+player2.d, player2.sety + player2.radius + player2.q1, player2.setx + player2.radius + player2.w1, player2.sety + player2.radius + 35 + player2.e1);
            g.drawLine(player2.setx + player2.radius + player2.w1, player2.sety + player2.radius + 35 + player2.e1, player2.setx + player2.radius + player2.r1, player2.sety + player1.radius + player2.t1);
            //armleft
            g.drawLine(player2.setx + player2.radius+player2.nx, player2.sety + player2.radius + player2.i, player2.setx + player2.radius + player2.j, player2.sety + player2.radius + player2.k);
            g.drawLine(player2.setx + player2.radius + player2.j, player2.sety + player2.radius + player2.k, player2.setx + player2.radius + player2.a, player2.sety + player2.radius + player2.x);
            g.setColor(Color.BLUE);
            g.fillOval(player2.setx + player2.radius + (player2.a - 5), player2.sety + player2.radius + (player2.x - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);
            //armright
            g.drawLine(player2.setx + player2.radius+player2.nx, player2.sety + player2.radius + player2.z, player2.setx + player2.radius + player2.c, player2.sety + player2.radius + player2.v);
            g.drawLine(player2.setx + player2.radius + player2.c, player2.sety + player2.radius + player2.v, player2.setx + player2.radius + player2.b, player2.sety + player2.radius + player2.n);
            g.setColor(Color.BLUE);
            g.fillOval(player2.setx + player2.radius + (player2.b - 5), player2.sety + player2.radius + (player2.n - 5), 4 * 2, 4 * 2);
            g.setColor(Color.BLACK);
            //dropgun
            if(drop){
                g.setColor(Color.BLACK);
                g.fillRect(x_dropgun, y_dropgun, 5, 10);
                g.fillRect(x_dropgun, y_dropgun, 15, 5);
                g.setColor(Color.WHITE);
                g.fillRect(x_dropgun+7, y_dropgun, 4, 3);
                g.fillRect(x_dropgun+15, y_dropgun, 3, 2);
            }
            //gun
            if(ammu){
                g.setColor(Color.BLACK);
                g.fillOval(bullet, y_dropgun-20, 10, 10);
            }
            if(Ko){
                g.setColor(Color.red);
                g.setFont(new Font("Serif",Font.BOLD,100));
                g.drawString("K.O.", 350, 250);
            }
            if(Draw){
                g.setColor(Color.BLUE);
                g.setFont(new Font("Serif",Font.BOLD,100));
                g.drawString("DRAW", 350, 250);
            }
        }
        
    }
}
