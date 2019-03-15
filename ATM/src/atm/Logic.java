package atm;

public class Logic {
    static int count=0;
    static int ptr=0;
    static String[] h = new String[100];
    static double Balance ;
    public final String ID = "5541";
    public void withdraw(double amount)
    {
        h[count]="Withdraw :- "+amount;
        Balance -= amount;
        count+=1;
        ptr=count;
    }
    
    public void deposite(double amount)
    {
    h[count]="Deposit :- "+amount;
    Balance += amount;
    count+=1;
    ptr=count;
    }
    
    public String prev()
    {
        ptr-=1;
        return h[ptr];
    }
    
    public String next()
    {
        ptr+=1;
        return h[ptr];
    }

    public boolean valid(String number){
        return number.equals(ID);     
    }
    
}
