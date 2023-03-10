/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tonghop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Thread2 extends Thread{
    Share share;

    public Thread2(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        while (share.isAlive()){
            synchronized (share) {
                share.notifyAll();
                while (share.currentThread !=2&&share.isAlive()){
                    try {
                        share.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int length1 = share.validrollno.size();
                if(length1>0){
                Student std = share.validrollno.get(length1-1);
                System.out.println("welcom student has rollno: "+std.getRollno());
                System.out.println("valid collection has length: "+ length1);
                ///////
                FileOutputStream fos = null;
                ObjectOutputStream oos =null;
                try {
                    fos = new FileOutputStream(std.getRollno()+".dat");
                    oos = new ObjectOutputStream(fos) ;
                    oos.writeObject(std);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if (fos!=null ){
                        try {
                            fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (oos !=null){
                        try {
                            oos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }}
               share.setCurrentThread(1);
               share.notifyAll();

                
            }
        }               
     
        
    }
        
    
}
