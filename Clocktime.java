/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamevanlorat;

/**
 *
 * @author TiktokZa
 */
public class Clocktime {
    int min,sec;
    Clocktime(int min,int sec){
        this.min=min;
        this.sec=sec;
    }
    void process(){
        if(this.sec>0){
            this.sec--;
        }
        else if(this.sec<=0){
            this.min--;
            this.sec=60;
        }
    }
    void stop(){
        this.sec=0;
        this.min=0;
    }
    
}
