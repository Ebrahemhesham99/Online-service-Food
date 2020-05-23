/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.test;


import java.util.ArrayList;
import java.util.List;
import restaurant.test.DBmanager;

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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }

    public DBmanager getDbManager() {
        return dbManager;
    }

    
private  customer(){}
    
    public boolean logIn(String email, String password){
        int id = dbManager.getCSTID(email,password);
        if(id != 0){
            ArrayList<String> object = dbManager.findCST(id);
            this.username = object.get(0);
            this.password = object.get(1);
            this.gender = object.get(2);
            this.age = Integer.parseInt(object.get(3));
            this.email = object.get(4);
            this.phone_no = object.get(5);
            this.ID = id;

            return true;
        }
        return false;
    }
    
}

    
    
    

