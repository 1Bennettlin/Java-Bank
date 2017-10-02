//Bennett Lin  

import javax.swing.JOptionPane;


public abstract class Account {
    
    public int accountNum;
    public String date;
    public String name;
    public double balance;

    public abstract int transferTo(Account account, double amount);
    
    public  boolean deposit(double deposit){
        for(int i=0;i<AccountUtility.accountList.size();i++){
                if(AccountApp.selectedAccount == AccountUtility.accountList.get(i).getAccountNum()){
                    AccountUtility.accountList.get(i).setBalance(deposit + AccountUtility.accountList.get(i).getBalance());
                    try{
                        AccountUtility.printToFile();
                    }catch(Exception e){
                        System.out.println("File printing error");
                        return false;
                    }
                }
            }
        return true;
    } 
    
    public  boolean withdraw(double withdrawl){
        for(int i=0;i<AccountUtility.accountList.size();i++){
            if( AccountApp.selectedAccount == AccountUtility.accountList.get(i).getAccountNum()){
                if(withdrawl<=AccountUtility.accountList.get(i).getBalance()){
                    AccountUtility.accountList.get(i).setBalance(AccountUtility.accountList.get(i).getBalance()-withdrawl);
                    try{
                        AccountUtility.printToFile();
                    }catch(Exception e){
                        System.out.println("File printing error");
                    }
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Withdrawal amount is greater than balance", "Invalid withdrawal.", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return true;
    }
    
    
    public Account(int accountNum, String date, String name, double balance) {
        this.accountNum = accountNum;
        this.date = date;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
