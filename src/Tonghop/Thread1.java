/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tonghop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Thread1 extends Thread {
    Share share;

    public Thread1(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileReader reader = null;
        BufferedReader breader = null;
        try {
            reader = new FileReader("students.txt");
            breader = new BufferedReader(reader);
            
            String line = null;
            synchronized (share) {

            while(share.isAlive()){
                
                line = breader.readLine();
                if(line == null){
                    share.setAlive(false);
                    break;
                }
                if(Student.checkrollno(line)){
                    Student std = new Student(line);
                    share.getValidrollno().add(std);
                    share.setCurrentThread(2);
                }else{
                    share.unvalidrollno.add(line);
                    share.setCurrentThread(3);
                }
                share.notifyAll();
                share.wait();
                
                }
            
            }
            
            
        
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(breader != null){
                try {
                    breader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        
    }
    
}
