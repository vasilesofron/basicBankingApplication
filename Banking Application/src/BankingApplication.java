import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args){
        BankAccount bank = new BankAccount("Vasile",3);
        bank.showMenu();

    }
}


class BankAccount{
    double balance;
    int previousTransaction = 0;
    double previousTransactionValue;
    String customerName;
    int customerId;

    //Constructor
    BankAccount(String cName, int cId){
        customerName = cName;
        customerId = cId;
    }

    //function used to make the deposit
    void deposit(double amount){
        if(amount > 0){
            balance = balance + amount;
            previousTransactionValue = amount;
            previousTransaction = 1;
            System.out.println("You deposited: " +amount + "$");
            System.out.println("Your current balance is now: " + balance +"$");
        }
    }

    //function used to make the withdrawal
    void withdraw(double amount){
        if(amount > 0){
            if(amount > balance)
                System.out.println("Insufficient funds.");
            else {
                balance = balance - amount;
                previousTransactionValue = amount;
                previousTransaction = 2;
                System.out.println("You withdrew: " + amount +"$");
                System.out.println("Your current balance is now: " + balance +"$");
            }
        }
    }

    //function used to check last transaction occurred
    void getPreviousTransaction(){
        switch (previousTransaction){
            case 1:
                System.out.println("Deposited: "+ previousTransactionValue);
                break;
            case 2:
                System.out.println("Withdrawn: " + previousTransactionValue);
                break;
            default:
                System.out.println("No transaction has occurred.");
        }
    }

    void showMenu(){
        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName + " to Java International Bank!");
        System.out.println("Your ID is " + customerId + "\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("============================================================================================================");
            System.out.print("Enter an option: ");
            option = scanner.next().charAt(0);
            System.out.println("============================================================================================================");
            System.out.println('\n');
            switch (option){
                case 'A':
                    System.out.println("-----------------------------");
                    System.out.println("Balance: " + balance + "$");
                    System.out.println("-----------------------------");
                    break;
                case 'B':
                    System.out.println("-----------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    double amountDeposit = scanner.nextDouble();
                    deposit(amountDeposit);
                    System.out.println("-----------------------------");
                    System.out.println('\n');
                    break;
                case 'C':
                    System.out.println("-----------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    double amountWithdraw = scanner.nextDouble();
                    withdraw(amountWithdraw);
                    System.out.println("-----------------------------");
                    System.out.println('\n');
                    break;
                case 'D':
                    System.out.println("-----------------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------------");
                    System.out.println('\n');
                    break;
                case 'E':
                    System.out.println("Thank you for using Java International Bank!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }



        }while(option != 'E');
    }
}
