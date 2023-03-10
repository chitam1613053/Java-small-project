/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread36;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Thread2 extends Thread {
    Information inf;

    public Thread2(Information inf) {
        this.inf = inf;
    }

    @Override
    public void run() {
        synchronized (inf) {
            for (int i = 0; i < 5; i++) {
                System.out.println(inf.getAddresslist()[i]);
                inf.notifyAll();
                try {
                    inf.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }
    }    
}
