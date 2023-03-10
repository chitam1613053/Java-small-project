/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread32;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Share share = new Share();
        Thread1 t1 = new Thread1(share);
        Thread2 t2 = new Thread2(share);
        
        t2.start();
        t1.start();
        
        
    }
    
}
