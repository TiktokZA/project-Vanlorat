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
class Character {
    boolean hasgun=false;
    boolean shotgunL=false;
    boolean shotgunR=false;
    int HP = 0;
    int CP = 0;
    int nskill=0;
    int speedskill=0;
    boolean useskill=false;
    boolean die=false;
    int round=0;
    int radius = 0;
    int setx = 0, sety = 0,setY,setX;
    int standright = 0;
    int standleft = 0;
    int jumpright = 0;
    int jumpleft = 0;
    int punchright = 0, punchleft = 0;
    int moveleft = 0, moveright = 0;
    int dead=0;
    int count=0;
    int x = 0, z = 0, c = 0, v = 0, b = 0, n = 0, q=0, w=0, e=0, r=0, t=0, q1=0, w1=0, e1=0, r1=0, t1=0, a=0, k=0, j=0, i=0,  d=0,dy=0,nx=0;
//    Timer time =new Timer(120,new timer());
    
    Character(int x) {
        HP = 250;
        CP = 0;
        radius = 10;
        speedskill=100;
        
    }

    void standright() {
        if (standright == 1) {
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 15;
            j = 5;
            k = 20;
            a = 15;
            x = 15;
            z = 20;
            c = 5;
            v = 25;
            b = 15;
            n = 20;
            standright = 2;
            
        } else if (standright == 2) {
            sety = setY;
            q = 35;
            d=0;
            dy=0;
            nx=0;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 17;
            j = 5;
            k = 22;
            a = 15;
            x = 17;
            z = 22;
            c = 5;
            v = 27;
            b = 15;
            n = 22;
            standright = 1;
            
        }
    }

    void standleft() {
        if (standleft == 1) {
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 15;
            j = -5;
            k = 20;
            a = -15;
            x = 15;
            z = 20;
            c = -5;
            v = 25;
            b = -15;
            n = 20;
            standleft = 2;
             
            
        } else if (standleft == 2) {
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 17;
            z = 22;
            c = -5;
            v = 27;
            b = -15;
            n = 22;
            standleft = 1;
            
        }
    }

    void moveright() {
        if (moveright == 1) {
            setx += 5;
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 10;
            e1 = 10;
            r1 = 0;
            t1 = 55;
            i = 20;
            j = -10;
            k = 10;
            a = -20;
            x = 15;
            z = 22;
            c = 5;
            v = 25;
            b = 15;
            n = 20;
            moveright=2;
            
        } else if (moveright == 2) {
            setx += 6;
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = 0;
            e = 5;
            r = 0;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 20;
            j = -10;
            k = 10;
            a = -20;
            x = 15;
            z = 20;
            c = 5;
            v = 25;
            b = 15;
            n = 20;
            standright = 0;
            standleft = 0;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 3;
            dead=0;   
        }
        else if (moveright == 3) {
            setx += 6;
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = 0;
            e = 5;
            r = 0;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 20;
            j = -10;
            k = 10;
            a = -20;
            x = 15;
            z = 20;
            c = 5;
            v = 25;
            b = 15;
            n = 20;
            standright = 1;
            standleft = 0;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 0;
            dead=0;
        }
    }

    void moveleft() {
        if (moveleft == 1) {
            setx -= 5;
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = 0;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 20;
            j = -10;
            k = 30;
            a = -20;
            x = 15;
            z = 20;
            c = 5;
            v = 15;
            b = 15;
            n = 22;
            moveleft = 2;
            
        
        } else if (moveleft == 2) {
            setx -= 6;
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 0;
            e1 = 10;
            r1 = 0;
            t1 = 55;
            i = 20;
            j = -10;
            k = 30;
            a = -20;
            x = 15;
            z = 20;
            c = 5;
            v = 15;
            b = 15;
            n = 22;
            standright = 0;
            standleft = 1;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 0;
            dead=0;
            
            
        }
    }

    void JumpL() {
        if (jumpleft == 1) {
            setx -= 30;
            sety -= 65;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 5;
            r = 2;
            t = 50;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 27;
            z = 17;
            c = 5;
            v = 22;
            b = 15;
            n = 27;
            jumpleft = 2; 
            
            
        } else if (jumpleft == 2) {
            setx -=15;
            sety -= 65;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = -3;
            r = -15;
            t = 30;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 27;
            z = 17;
            c = 5;
            v = 13;
            b = 15;
            n = 10;
            jumpleft = 3; 
            
        } else if (jumpleft == 3) {
            setx -= 10;
            sety += 65;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 5;
            r = 2;
            t = 50;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 27;
            z = 17;
            c = 5;
            v = 22;
            b = 15;
            n = 27;
            jumpleft = 4; 
            
        } else if (jumpleft == 4) {
            setx -= 10;
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 17;
            z = 22;
            c = -5;
            v = 27;
            b = -15;
            n = 22;
            standright = 0;
            standleft = 1;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 0;
            dead=0;
            
            
        }
    }

    void JumpR() {
        if (jumpright == 1) {
            setx += 20;
            sety -= 65;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 5;
            r1 = -2;
            t1 = 50;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 27;
            z = 17;
            c = 5;
            v = 22;
            b = 15;
            n = 27;
            jumpright = 2;
            
            
        } else if (jumpright == 2) {
            setx += 15;
            sety -= 65;
            
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = -3;
            r1 = 20;
            t1 = 28;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 27;
            z = 17;
            c = 5;
            v = 13;
            b = 15;
            n = 10;
            jumpright = 3;
            
        } else if (jumpright == 3) {
            setx += 10;
            sety += 65;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 5;
            r1 = -2;
            t1 = 50;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 27;
            z = 17;
            c = 5;
            v = 22;
            b = 15;
            n = 27;
            jumpright = 4;
            
        } else if (jumpright == 4) {
            setx += 5;
            sety = setY;
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 15;
            j = 5;
            k = 20;
            a = 15;
            x = 15;
            z = 20;
            c = 5;
            v = 25;
            b = 15;
            n = 20;
            standright = 1;
            standleft = 0;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 0;
            dead=0;
            
            
        }
    }

    void PunchR() {
        if (punchright == 1) {
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 15;
            j = 10;
            k = 15;
            a = 30;
            x = 15;
            z = 20;
            c = 5;
            v = 25;
            b = 12;
            n = 20;
            standright = 1;
            standleft = 0;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 0;
            dead=0;
            
            
        }
    }

    void PunchL() {
        if (punchleft == 1) {
            d=0;
            dy=0;
            nx=0;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 15;
            j = -10;
            k = 15;
            a = -30;
            x = 15;
            z = 20;
            c = -5;
            v = 25;
            b = -12;
            n = 20;
            standright = 0;
            standleft = 1;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 0;
            dead=0; 
            
            
        }
    }
    void DeadLeft(){
        if(dead==1){
            setx-=5;
            d=10;
            dy=0;
            nx=2;
            q = 35;
            w = -5;
            e = 10;
            r = -10;
            t = 55;
            q1 = 35;
            w1 = 5;
            e1 = 10;
            r1 = 10;
            t1 = 55;
            i = 17;
            j = -5;
            k = 22;
            a = -15;
            x = 27;
            z = 20;
            c = 5;
            v = 25;
            b = 12;
            n = 20;
            dead=2;
            
            
        }
        else if(dead==2){
            setx-=10;
            sety+=10;
            d=20;
            dy=-3;
            nx=5;
            q = 35-3;
            w = 5;
            e = 10;
            r = 10;
            t = 55;
            q1 = 35-3;
            w1 = 25;
            e1 = 0;
            r1 = 35;
            t1 = 35;
            i = 15;
            j = -10;
            k = 15;
            a = -20;
            x = 15;
            z = 15;
            c = 3;
            v = -10;
            b = 5;
            n = -20;
            dead=3;
             
            
        }
        else if(dead==3){
            
            sety+=40;
            d=35;
            dy=-35;
            nx=25;
            q = 0;
            w = 40;
            e = -32;
            r = 60;
            t = 5;
            q1 = 0;
            w1 = 40;
            e1 = -38;
            r1 = 50;
            t1 = 0;
            i = 0;
            j = -2;
            k = 10;
            a = -5;
            x = 17;
            z = 0;
            c = 15;
            v = -5;
            b = -3;
            n = 3;
            
            standright = 0;
            standleft = 0;
            jumpright = 0;
            jumpleft = 0;
            punchright = 0;
            punchleft = 0;
            moveleft = 0;
            moveright = 0;
            dead=0;

            
        }
    }

    

}

