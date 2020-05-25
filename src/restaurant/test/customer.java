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

 public String register(String username, String password, String email, String phone_no, String gender, int age){
        String validation = chechValidatetion(username,password,email,phone_no);

        if(!validation.equals("validate"))
            return validation;

        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_no = phone_no;
        this.gender = gender;
        this.age = age;

        if(dbManager.addCustomer(this)) {
            this.ID = dbManager.getCSTID(email,password);
            return "true";
        }
        else
            return "false";
    }
    
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
    private String passwordValidation(String userName, String password)
    {
        if (password.length() < 8) {
            return "Password should be more than 8 characters in length.";
        }
        if (password.indexOf(userName) > -1) {
            return "Password Should not be same as user name";
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars )) {
            return "Password should contain atleast one upper case alphabet";
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars )) {
            return "Password should contain atleast one lower case alphabet";
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers )) {
            return "Password should contain atleast one number.";
        }
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars )) {
            return "Password should contain atleast one special character";
        }

        this.password = password;
        return "Password is valid.";
    }
    
}

    
    
    

