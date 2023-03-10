/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tonghop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Thread3 extends Thread{
    Share share;

    public Thread3(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        FileOutputStream fis = null;
        try {
            fis = new FileOutputStream("unvalid.txt");
            while(share.isAlive()){
            synchronized (share) {
                share.notifyAll();
                while (share.currentThread !=3&&share.isAlive()){
                    try {
                        share.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int length = share.getUnvalidrollno().size();
                String unvalid = share.getUnvalidrollno().get(length-1);
                System.out.println("Unvalid RollNo"+unvalid);
                String line = "\n"+unvalid;
                byte[] write = line.getBytes();
                fis.write(write);
                
                share.setCurrentThread(1);
                share.notifyAll();
                
            }
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
