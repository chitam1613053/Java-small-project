/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tonghop;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Student implements Serializable{
    String rollno;

    public Student(String rollno) {
        this.rollno = rollno;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
    public static boolean checkrollno(String rollno){
        String pattern = "[CTN][0-9]{4}[G-M][V]?[0-9]{4}";
        return Pattern.matches(pattern, rollno);
    }
    
}
