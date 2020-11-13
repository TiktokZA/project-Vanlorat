/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamevanlorat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
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
public class Main extends JFrame implements ActionListener{


    Paint paint = new Paint();
    Startgame pstart=new Startgame();
    public JButton Bpause=new JButton("Pause/Play");
    File sound =new File("Soundstart.wav");
    Clip clip0;
    
    Main() {
        this.setResizable(false);
        pstart.BExit.addActionListener(this);
        pstart.BStart.addActionListener(this);
        try {
           // Open an audio input stream.
           
           AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
           // Get a sound clip resource.
           clip0 = AudioSystem.getClip();
           // Open audio clip and load samples from the audio input stream.
           clip0.open(audioIn);
           
           clip0.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } catch (LineUnavailableException e) {
           e.printStackTrace();
        }
        
        add(pstart);

    }
    
    public static void main(String[] dargs) {
        // TODO code application logic herew
        Main frame = new Main();
        frame.setTitle("GAMEvanlorat");
        frame.setSize(800, 500);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pstart.BStart){
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.remove(pstart);
            clip0.stop();
            this.setSize(890, 600);
            this.add(paint);
            
            paint.requestFocusInWindow();
            paint.clo.min=1;
            paint.clo.sec=30;
            if(pstart.skillp1.getSelectedItem()=="HEAL"){
                paint.player1.nskill=1;
            }
            if(pstart.skillp1.getSelectedItem()=="SPEED"){
                paint.player1.nskill=2;
            }
            if(pstart.skillp2.getSelectedItem()=="HEAL"){
                paint.player2.nskill=1;
            }
            if(pstart.skillp2.getSelectedItem()=="SPEED"){
                paint.player2.nskill=2;
            }
            if(pstart.map.getSelectedItem()=="Light"){
                paint.state=1;
                paint.clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            if(pstart.map.getSelectedItem()=="Dark"){
                paint.state=2;
                paint.clip1.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        if(e.getSource()==pstart.BExit){
            System.exit(0);
        }
        
    }
    /**
     * @param args the command line arguments
     */

}
