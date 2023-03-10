/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threadtest2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Share share = new Share();
        
        ThreadRad t1 = new ThreadRad(share);
        Thread3 t2 = new Thread3(share);
        Thread2 t3 = new Thread2(share);
        
        /////////////////////
        t1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t2.start();
        t3.start();
    }
}
