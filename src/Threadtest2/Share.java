/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threadtest2;

/**
 *
 * @author Admin
 */
public class Share {
    int rad;
    int total;

    public Share() {
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }
    
    ///
    public void sum(int a){
         total+=a;
    }
    //
    public boolean check(){
        if (total<=1000) return true;
        else return false;
    }
}
