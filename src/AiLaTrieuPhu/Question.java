/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AiLaTrieuPhu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Question implements Serializable{
    String title;
    int result;
    List<String> options = new ArrayList<>();
    
    public Question() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<String> getQuestionlist() {
        return options;
    }

    public void setQuestionlist(List<String> options) {
        this.options = options;
    }
    //
    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter question title:");
        title =scan.nextLine();
        int index=1;
        for (int i = 0; i < 4; i++) {
            System.out.format("option %d:",index);
            
            String option = scan.nextLine();
            options.add(option);
            index++;
            
        }
        System.out.println("Ket qua la:");
        result = Integer.parseInt(scan.nextLine());
    }
    
    public void showquestion(){
        System.out.println("Question: "+title);
        for (String option : options) {
            System.out.println(option);
        }
        
    }
    public boolean checkresult(int result){
        if(result==this.result){
            return true;
        }
        return false;
    }
}
