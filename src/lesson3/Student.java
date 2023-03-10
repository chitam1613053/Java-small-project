/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lesson3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student {
    String RollNo, name, email;
    int age;
    enum Sex {male,female};
    Sex sex;
    Scanner scan = new Scanner(System.in);
    public Student() {
    }
    
    public Student(String RollNo, String name, String email, int age) {
        this.RollNo = RollNo;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.RollNo = RollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void input(){
        System.out.println(" Enter student RollNo:");
        RollNo = scan.nextLine();
        System.out.println("Enter student name");
        name = scan.nextLine();
        System.out.println("Enter student email");
        email = scan.nextLine();
        System.out.println("Enter student age");
        age = Integer.parseInt(scan.nextLine());
        System.out.println("which sex of student??");
        System.out.println("1. Male\n2. Female");
        int a= Integer.parseInt(scan.nextLine());
        if (a==1){
            sex =sex.male;    
        }else sex= sex.female;
    }

    @Override
    public String toString() {
        return  "RollNo=" + RollNo + ", name=" + name + ", email=" + email + ", age=" + age + ", sex=" + sex  ;
        
        
    }
    public void display(){
        System.out.println(toString());
    }
    
    
}
