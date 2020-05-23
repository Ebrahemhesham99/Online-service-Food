package sw2_project;

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

    
 public boolean addCustomer(customer customer){
        String name = "'" + customer.getUsername() + "'";
        String password = "'" + customer.getPassword() + "'";
        String gender = "'" + customer.getGender() + "'";
        int age = customer.getAge();
        String phone = "'" + customer.getPhone_no() + "'";
        String email = "'" + customer.getEmail() + "'";

        int id ;

        try {
            query = "INSERT INTO cst(cst_gender,cst_age,cst_email,cst_phone_no,cst_password,cst_username) VALUES(" +
                    gender + "," + age + "," + email + "," + phone + "," + password + "," + name + ")";
            statement.execute(query);
            return true;

        }catch (Exception ex){
            System.out.println(ex);
        }

        return false;
    }
    
    
    
    
    
    }
    
    
   
    
    













