/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public  class  DBmanager {
    private  String query;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static DBmanager instance = null;
    private String datasource_url = "jdbc:mysql://localhost:3306/food delivery" ;


    private DBmanager(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(datasource_url,"root","");
            statement = connection.createStatement();

        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }

    public static DBmanager createInstance(){
        if(instance == null)
            instance = new DBmanager();

        return instance;
    }

    
 
    
    
    
    
    
    }
    
    
   
    
    
