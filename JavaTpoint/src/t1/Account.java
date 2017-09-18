package t1;

public class Account {

    int accountNo;
    String accHolderName;
    float ammountTk;

    void insert(int accountNo, String accHolderName, float ammountTk) {
        this.accountNo = accountNo;
        this.accHolderName = accHolderName;
        this.ammountTk = ammountTk;
    }

    void diposit(float tk) {

        ammountTk += tk;
        System.out.println(tk + " Deposited !!");
    }

    void withdraw(float tk) {
        if (ammountTk < tk) {
            System.out.println("Insufficient balance !!");
        } else {
            ammountTk -= tk;
            System.out.println(tk + " withdrawn !!");
        }
    }

    public void checkBalance() {

        System.out.println("Current Balance: "+ammountTk);
    }

    public void displayUserInfo() {
        System.out.println("Ac Holder Name: " + accHolderName + "\nAc NO: " + accountNo
                + "\nTotal Balance: " + ammountTk);
    }

    public static void main(String[] args) {

        Account ac = new Account(), ac2 = new Account();
        ac.insert(455455, "Shawon", 1000);
        ac2.insert(54354, "Rabib", 5000);
        
        ac.displayUserInfo();
        ac.checkBalance();
        ac.diposit(500);
        ac.checkBalance();
        ac.withdraw(100);
        ac.checkBalance();
        System.out.println();
        ac2.displayUserInfo();
        ac2.checkBalance();
        ac2.diposit(500);
        ac2.checkBalance();
        ac2.withdraw(100);
        ac2.checkBalance();

    }
}
