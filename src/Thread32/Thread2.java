/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread32;

import java.util.Random;

public class Thread2 extends Thread{
    Share share;
    Random random;
    public Thread2(Share share) {
        this.share = share;
    }
    @Override
    public void run() { 
        while(share.isCheck()==true){
            if(share.isCheck()==false) break;
            random = new Random();
            int rad = random.nextInt(50)-50;
            share.sum(rad);  
        }   
    }
}
