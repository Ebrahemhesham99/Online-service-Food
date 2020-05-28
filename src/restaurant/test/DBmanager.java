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

    
    public String getItemPrice(String nameٍ){
        String price = null;
        String temp = "'" + nameٍ + "'";
        try{
            query = "SELECT item_price FROM items where item_name =" + temp;
            resultSet = statement.executeQuery(query);
            while (resultSet.next())
                price = resultSet.getString("item_price");
                 
        }catch (Exception e) {
            System.out.println(e);
        }
        return price;
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
 
 
 public boolean add_item(String name, String price){
    
      String it_name = "'" +name + "'";
        String it_price = "'" + price+ "'";
    
    
    try{
    query = "insert into items(item_name,item_price) values ("+it_name+","+it_price+")";
     statement.execute(query);
   return true;
    
    }
    catch(Exception e){
    System.out.println(e);
    }
    
    return false;
    
  }

      public boolean checkEmail(String email){
        String temp = "'"+email+"'";
        try {
            String em = null;
            query = "SELECT cst_email FROM cst WHERE cst_email = " + temp;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                em = resultSet.getString("cst_email");
                System.out.println(em);
            }

            if (em != null)
                return true;

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
public String getItemName(int item_code){
        String name = null;
        try{
            query = "SELECT item_name FROM items where item_id = " + item_code;
            resultSet = statement.executeQuery(query);
            while (resultSet.next())
                name = resultSet.getString("item_name");
        }catch (Exception e) {
            System.out.println(e);
        }
        return name;
    }

    public int getCSTID(String email, String password){
        String temp_email = "'" + email + "'";
        String temp_pass = "'" + password + "'";
        int id = 0;
        try {
            query = "SELECT cst_id FROM cst WHERE cst_email = " + temp_email  +  "&& cst_password = " + temp_pass;

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                 id = Integer.parseInt(resultSet.getString("cst_id"));
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }

    
    public ArrayList<String> findCST(int id){
        ArrayList<String> customer = new ArrayList<>();
        try{
            query = "SELECT * FROM cst WHERE cst_id  = " + id ;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String  username = resultSet.getString("cst_username");
                String password = resultSet.getString("cst_password");
                String gender = resultSet.getString("cst_gender");
                String age = resultSet.getString("cst_age");
                String email = resultSet.getString("cst_email");
                String phone_no = resultSet.getString("cst_phone_no");

                customer.add(username);
                customer.add(password);
                customer.add(gender);
                customer.add(age);
                customer.add(email);
                customer.add(phone_no);
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return customer;
    }
   public boolean update_cst_profile(String username, String password, String email, String phone_no, String gender, int age, int id){
    String name_t = "'" + username + "'";
        String password_t = "'" + password + "'";
        String gender_t = "'" + gender+ "'";
        int age_t = age;
        String phone_t = "'" + phone_no + "'";
        String email_t = "'" + email + "'";
    try{
     query = "UPDATE cst SET cst_gender ="+gender_t+",cst_age="+age_t+",cst_email="+email_t+",cst_phone_no= "+phone_t+",cst_password="+password_t+",cst_username="+name_t+
" WHERE cst_id=" + id;
     System.out.println(query);
        statement.execute(query);
        return true;
     }catch (Exception e) {
            System.out.println(e);
        }
        return false;   
    
 
   }
    public boolean del_item(String name){
   
   String it_name = "'" +name + "'";
   try{
    query = "delete from items where item_name= "+it_name;
     statement.execute(query);
   return true;
    
    }
    catch(Exception e){
    System.out.println(e);
    }
    
    return false;  
   
   } 
    public String getItemId(String nameٍ){
        String id =null ;
        String temp = "'" + nameٍ + "'";
        try{
            query = "SELECT item_price FROM items where item_name =" + temp;
            resultSet = statement.executeQuery(query);
            while (resultSet.next())
                id = resultSet.getString("item_id");
                 
        }catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
     public List<Item> getMenu()
    {
     List<Item> menu = new ArrayList<>();
   
     try {
         query = "SELECT * FROM items ";
         resultSet = statement.executeQuery(query);
         while (resultSet.next())
         {
             menu.add(new Item( resultSet.getString("item_name"),
                     resultSet.getString("item_price")));
         }
     }catch (Exception e){
         System.out.println(e);
     }
      System.out.println(menu.size());
        return menu;
    }
    
     public boolean update_item(String item_name , String item_price, String id){
        String it_name = "'" + item_name + "'";
        String it_price = "'" + item_price+ "'";
        String it_id = "'" + id + "'";

        
        
    try{
    query = "update items set item_name ="+it_name+", item_price="+it_price+" where item_id ="+ it_id;
     statement.execute(query);
   return true;
    
    }
    catch(Exception e){
    System.out.println(e);
    }
    
    return false;
    
    
    
    
    }
    
    }
    
    
   
    
    
   
    
    













