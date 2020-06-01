/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




public class Order {
    private DBManager dbManager = DBManager.createInstance();

    public double[] getCard() {
        return card;
    }

    public void setCard(double[] card) {
        this.card = card;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Order.i = i;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
    private double card[]= new double [10];
    private String reciept[][]= new String [10][2];
    static int i=0;

    public String[][] getReciept() {
        return reciept;
    }
    private double sum;
    public void addToCard(String itemName , int amount )
    {  
        double total_price = 0.0;
        try{
        int x ; // get price from db
            x = Integer.parseInt(dbManager.getItemPrice(itemName));
        sum = amount * x;
        total_price += sum; 
        card[i]=total_price;
        reciept[i][0]=itemName; // get item name from db
        reciept[i][1]=String.valueOf(amount);
        i++;
       // r.addTrans(itemCode, total_price);
        }
        catch(NumberFormatException e)
        {
            System.out.print("Number format exception");
        }
        
    }  
   
}
