/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThreadTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
     Sharedata sharedata = new Sharedata();
     ThreadRamdom t1 = new ThreadRamdom(sharedata);
     ThreadBP t2 = new ThreadBP(sharedata);
     
     t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     t2.start();
        
    }
}
