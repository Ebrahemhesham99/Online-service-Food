/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.test;

public class admin {
   
     private DBmanager dbManager = DBmanager.createInstance();
     private static admin instance;
     
     public static admin getInstance(){
     if(instance==null){
     instance= new admin();
     }
         return instance;
     
     }
     
    
      
      public boolean update_menu(String name,String price,String  id){
    
    
      return dbManager.update_item(name, price, id);
    
    
    }
      
      public boolean add_item(String name , String price){
      
      
     return dbManager.add_item(name, price);
      
      
      
      }
      
      public boolean delete_item(String name){
      
      
      return dbManager.del_item(name);
      
      }
    
    
}
