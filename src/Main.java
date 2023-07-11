import java.util.Scanner;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String exceptionMessage) {
        super(exceptionMessage);
        //System.out.println(exceptionMessage);
    }
}

class InsufficientException extends Exception {
    public InsufficientException(String exceptionMessage) {
        super(exceptionMessage);

    }
}
class AtmException{
     private double balance ;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void depositAmount(double amount, AtmException atmException)  {
        try{
            if(amount < 0){
                throw new InvalidAmountException("Amount entered is negative.");
            }
            balance += amount;
            System.out.println("Balance is " + atmException.getBalance());
        }
        catch (InvalidAmountException invalidAmountException){
            System.out.println(invalidAmountException.getMessage());
        }

    }

    public void withdrawAmount(double withdraw, AtmException atmException) {
        try{
            if(withdraw < 0){
                throw new InvalidAmountException("Amount entered is negative.");
            }

            if(withdraw > balance){
                throw new InsufficientException("Low balance.");
            }
            balance -= withdraw;
            System.out.println("Balance is " + atmException.getBalance());
        }
        catch (InvalidAmountException | InsufficientException invalidAmountException){
            System.out.println(invalidAmountException.getMessage());
        }

    }

    public double displayBalance(AtmException user){
        return user.getBalance();
    }
}


public class Main {
    public static void main(String[] args) {
        AtmException user = new AtmException();
        user.setBalance(2000);
        int input;
        do{
            System.out.println("Enter 1 to deposit and 2 to withdraw and 3 to display balance and 4 to exit : ");
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            switch(input){
                case 1 : {
                    System.out.println("Enter the amount to deposit : ");
                    double amount = sc.nextDouble();
                    user.depositAmount(amount, user);
                    break;
                }
                case 2 : {
                    System.out.println("Enter the amount to withdraw : ");
                    double amount = sc.nextDouble();
                    user.withdrawAmount(amount, user);
                    break;
                }
                case 3 :{
                    System.out.println("Balance is : "+ user.displayBalance(user));
                    break;
                }
                case 4 :{
                    System.out.println("Thank you for using our atm");
                    break;
                }
                default:{
                    System.out.println("Enter a valid input");
                }

            }
        }while (input != 4);
    }
}