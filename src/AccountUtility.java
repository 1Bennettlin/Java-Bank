

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class AccountUtility {
    
    public static ArrayList<Account> accountList;
    
    public static void readAccountFile() throws FileNotFoundException, IOException{
        FileReader in = new FileReader("accounts.txt");
        BufferedReader br = new BufferedReader(in);
        String line;
        StringTokenizer st;
        
        accountList = new ArrayList<Account>();
        
        Account temp;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            //tokenize the line
            int accountNum = Integer.parseInt(st.nextToken("<>"));
            String date = st.nextToken("<>");
            String name = st.nextToken("<>");
            double balance = Double.parseDouble(st.nextToken("<>"));
            temp = new CheckingAccount(accountNum, date, name, balance);
            accountList.add(temp);
        }
    }
    
    public static void printToFile() throws FileNotFoundException, IOException {
        FileWriter in = new FileWriter("accounts.txt");
        BufferedWriter bw = new BufferedWriter(in);
        String content="";
        for(int i=0;i<accountList.size();i++){
            content += Integer.toString(accountList.get(i).getAccountNum())+"<>"+accountList.get(i).getDate()+ "<>" + accountList.get(i).getName()+"<>"+Double.toString(accountList.get(i).getBalance())+"\n";
        }
        bw.write(content);
        bw.close();
    }
    
}
