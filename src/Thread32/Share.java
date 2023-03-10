/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread32;

/**
 *
 * @author Admin
 */
public class Share {
    int total=0;
    boolean check = true;

    public  Share() {
    }

    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }

    public synchronized boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    public synchronized void sum(int input){
        total += input;
        if(total<=-100||total>=100){
            check = false;
            System.out.println(total+" STOP");
        }else System.out.println(total);
        
    }
    
    
}
