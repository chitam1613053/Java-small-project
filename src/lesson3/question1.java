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
public class question1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nhap so phan tu cua mang");
        int N = Integer.parseInt(scan.nextLine());
        int [] array = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.format("Nhap phan tu thu %d:",i+1);
            array[i] = Integer.parseInt(scan.nextLine());          
        }
        for (int i : array) {
            System.out.print(i+"  ");           
        }
        int tem;
        ///
                 for (int i = 0; i < N-1; i++) {
             for (int j = 0; j < N-1; j++) {
                 if(array[j]>array[j+1]){
                 tem = array[j];
                 array[j]=array[j+1];
                 array[j+1]=tem;               
                 }              
             }  
         }
        System.out.println("");
        for (int i : array) {
            System.out.print(i+"  ");
        }
        ///
        int count=0;
        for (int i = 0; i < N; i++) {
            if(array[i]%2==1)
                count++;
            
        }
         for (int i = 0; i < count; i++) {
             for (int j = 0; j < N-1; j++) {
                 if(array[j]%2==1){
                 tem = array[j+1];
                 array[j+1]=array[j];
                 array[j]=tem;               
                 }              
             }  
         }
         System.out.println("");
          for (int i : array) {
            System.out.print(i+"  ");}      
    }
    
}
