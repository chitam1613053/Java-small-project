/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread36;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
        
        Information inf = new Information();
        
        Thread1 t1 = new Thread1(inf);
      
        
        Thread2 t2 = new Thread2(inf);
        
        t1.start();
          try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
          t2.start();
        
    }
    
}
