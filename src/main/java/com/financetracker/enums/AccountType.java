package main.java.com.financetracker.enums;

public enum AccountType {
    CHECKING("Checking Account"),
    SAVINGS("Savings Account"),
    CREDIT_CARD("Credit Card"),
    INVESTMENT("Investment Account"),
    LOAN("Loan Account");

    public final String displayName;

    AccountType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
