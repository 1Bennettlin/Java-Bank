//Bennett Lin    CIS304   MA     FINAL PROJECT

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CheckingAccount extends Account{
    
    CheckingAccount(int accountNum, String date, String name, double balance){
        super(accountNum, date, name, balance);
    }
    
    public int transferTo(Account account, double transferAmt){
        
            
            for(int i=0;i<AccountUtility.accountList.size();i++){
                if(AccountApp.selectedAccount == AccountUtility.accountList.get(i).getAccountNum()){
                    if(transferAmt> AccountUtility.accountList.get(i).getBalance())
                        return -2;
                    else if(AccountUtility.accountList.get(i).getBalance() < AccountConstants.CHECKING_BALANCE_THRESHOLD){
                        if(transferAmt+AccountConstants.TRANSFER_FEE>AccountUtility.accountList.get(i).getBalance())
                            return -1;
                        else{
                            AccountUtility.accountList.get(i).setBalance(AccountUtility.accountList.get(i).getBalance()-transferAmt- AccountConstants.TRANSFER_FEE);
                            account.setBalance(account.getBalance()+transferAmt);
                            try {
                                AccountUtility.printToFile();
                            } catch (IOException ex) {
                                Logger.getLogger(AccountApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            return 1;
                        }
                    }
                    else if(AccountUtility.accountList.get(i).getBalance()>= AccountConstants.CHECKING_BALANCE_THRESHOLD){
                        AccountUtility.accountList.get(i).setBalance(AccountUtility.accountList.get(i).getBalance()-transferAmt);
                        account.setBalance(account.getBalance()+transferAmt);
                        try {
                            AccountUtility.printToFile();
                        } catch (IOException ex) {
                            Logger.getLogger(AccountApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return 2;
                    }
                    break;
                }
            }
            return 0;
    }

}
