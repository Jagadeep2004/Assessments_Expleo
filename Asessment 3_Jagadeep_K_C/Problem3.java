package Assessment03;

import java.util.Scanner;

abstract class BankTransactionException extends Exception {
    
    private int errorCode;

    public BankTransactionException(String message, int errorCode) {
        super(message);   
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

class InsufficientFundsException extends BankTransactionException {
    
    private double shortfall;

    public InsufficientFundsException(String message, int errorCode, double shortfall) {
        super(message, errorCode);
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}

class InvalidAccountException extends BankTransactionException {
    
    private String accountId;

    public InvalidAccountException(String message, int errorCode, String accountId) {
        super(message, errorCode);
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}

class TransactionLimitException extends BankTransactionException {
    
    private double limit;

    public TransactionLimitException(String message, int errorCode, double limit) {
        super(message, errorCode);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}

class TransactionValidator {

     static void validateTransaction(String accountId, double balance,
                                           double amount, double dailyLimit)
            throws BankTransactionException {

        
        if (accountId.isEmpty()) {
            throw new InvalidAccountException("Invalid account ID", 101, accountId);
        }

        
        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException("Insufficient funds", 102, shortfall);
        }

        
        if (amount > dailyLimit) {
            throw new TransactionLimitException("Transaction limit exceeded", 103, dailyLimit);
        }

        System.out.println("Transaction successful!");
    }
}



public class Problem3 {
		public static void main(String[] args)  {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Account Id : ");
			String accountId=sc.nextLine();
			
			System.out.print("Balance : ");
			double balance =sc.nextDouble();
			
			System.out.print("Amount : ");
			double amount=sc.nextDouble();
			
			System.out.print("Daily Limit : ");
			double dailyLimit=sc.nextDouble();
			
			TransactionValidator tv = new TransactionValidator();
			try {
				tv.validateTransaction(accountId, balance, amount, dailyLimit);
			} catch (BankTransactionException e) {
				e.printStackTrace();
			}
			
		}
}
