/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.test;


import java.util.ArrayList;
import java.util.List;
import  restaurant.test.DBmanager;

/**
 *
 * @author DELL
 */
public class customer {
    
     private String username;
    private String password;
    private String email;
    private String phone_no;
    private String gender;
    private int age;
    private int ID;
    
     private DBmanager dbManager = DBmanager.createInstance();
     private static customer instance;
     
     public static customer getInstance(){
     if(instance==null){
     instance= new customer();
     }
         return instance;
     
     }

    private  customer(){}
    
    
    
}

    
    
    

