/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tonghop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Share {
    List<Student> validrollno;
    List<String> unvalidrollno;
    int currentThread ;
    boolean alive;

    public Share() {
        validrollno = new ArrayList<>();
        unvalidrollno = new ArrayList<>();
        currentThread=1;
        alive = true;
    }

    public List<Student> getValidrollno() {
        return validrollno;
    }

    public void setValidrollno(List<Student> validrollno) {
        this.validrollno = validrollno;
    }

    public List<String> getUnvalidrollno() {
        return unvalidrollno;
    }

    public void setUnvalidrollno(List<String> unvalidrollno) {
        this.unvalidrollno = unvalidrollno;
    }

    public int getCurrentThread() {
        return currentThread;
    }

    public void setCurrentThread(int currentThread) {
        this.currentThread = currentThread;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
}
